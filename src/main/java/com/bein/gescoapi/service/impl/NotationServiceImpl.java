package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dto.*;
import com.bein.gescoapi.utils.Utils;
import com.bein.gescoapi.dao.*;
import com.bein.gescoapi.entities.*;
import com.bein.gescoapi.mapper.*;
import com.bein.gescoapi.service.declaration.NotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotationServiceImpl implements NotationService {

    private final EvaluationRepository evaluationRepository;
    private final ClasseRepository classeRepository;
    private final NoteRepository noteRepository;
    private final InscriptionRepository inscriptionRepository;
    private final Utils utils;

    @Override
    public List<EvaluationResponseDto> findEvaluationByIdClasseAndIdperiode(int idClasse, int idPeriode) {
        Classe classe = classeRepository.getById(idClasse);
        List<Evaluation> evaluations = evaluationRepository.findByIdniveauAndIdperiode(classe.getIdniveauclasse().getIdniveauclasse(), idPeriode);

        return evaluations.stream().map(e -> {
            EvaluationResponseDto er = EvaluationMapper.INSTANCE.fromEntityToResponse(e);
            er.setPeriode(PeriodeMapper.INSTANCE.fromEntityToResponse(e.getIdPeriode()));

            MatiereNiveauResponseDto mn = MatiereNiveauMapper.INSTANCE.fromEntityToResponse(e.getIdmatiereNiveau());
            mn.setMatiere(MatiereMapper.INSTANCE.fromEntityToResponse(e.getIdmatiereNiveau().getIdmatiere()));
            mn.setGroupematiere(GroupeMatiereMapper.INSTANCE.fromEntityToResponse(e.getIdmatiereNiveau().getIdgroupematiere()));
            mn.setNiveauclasse(NiveauClasseMapper.INSTANCE.fromEntityToResponse(e.getIdmatiereNiveau().getIdniveauclasse()));
            er.setMatiereNiveau(mn);
            return er;
        }).collect(Collectors.toList());
    }

    @Override
    public List<NoteResponseDto> getMasqueSaisi(long idEvaluation, int idClasse) {
        Evaluation evaluation = evaluationRepository.getById(idEvaluation);

        if (!Objects.isNull(evaluation)) {
            Institution institution = evaluation.getIdinstitution();
            boolean notif = (institution.isNotifGroup() && evaluation.getIdmatiereNiveau().isNotification());
            List<Note> notes = noteRepository.findAllByIdEvaluationAndIdClasse(idEvaluation, idClasse);
            if (notes.isEmpty()) {
                List<Inscription> inscriptions = inscriptionRepository.findInscriptionByIdanneescolaireAndIdclasseEleveActif(evaluation.getIdPeriode().getIdanneescolaire().getIdanneescolaire(), idClasse, evaluation.getIdinstitution().getIdinstitution(), true);
                if (!inscriptions.isEmpty()) {
                    return transformInscriptionToNote(inscriptions, evaluation, notif);
                }
            } else {
                List<Inscription> inscriptionList = inscriptionRepository.findInscriptionByIdanneescolaireAndIdclasseEleveActif(evaluation.getIdPeriode().getIdanneescolaire().getIdanneescolaire(), idClasse, evaluation.getIdinstitution().getIdinstitution(), true);
                List<Inscription> inscriptionListWithNoteExist = new ArrayList<>();
                List<NoteResponseDto> responseDtos = notes.stream().map(n -> {
                    inscriptionListWithNoteExist.add(n.getIdinscription());
                    NoteResponseDto nTemp = NoteMapper.INSTANCE.fromEntityToResponse(n);
                    InscriptionResponseDto i = InscriptionMapper.INSTANCE.fromEntityToResponse(n.getIdinscription());
                    i.setEleve(EleveMapper.INSTANCE.fromEntityToDto(n.getIdinscription().getIdeleve()));
                    nTemp.setInscription(i);
                    nTemp.setEvaluation(EvaluationMapper.INSTANCE.fromEntityToResponse(n.getIdevaluation()));
                    return nTemp;
                }).collect(Collectors.toList());

                inscriptionList.removeAll(inscriptionListWithNoteExist);
                if (!inscriptionList.isEmpty()) {
                    responseDtos.addAll(this.transformInscriptionToNote(inscriptionList, evaluation, true));
                }
                return responseDtos;
            }
        }
        return new ArrayList<>();
    }

    @Transactional
    @Override
    public void editNote(int idClasse, long idEvaluation, List<NoteRequestPayload> noteRequestPayloads) {
        if (!noteRequestPayloads.isEmpty()) {
            Classe classe = classeRepository.getById(idClasse);
            if (classe != null) {
                Evaluation evaluation = evaluationRepository.getById(idEvaluation);
                if (evaluation != null) {

                    for (NoteRequestPayload n : noteRequestPayloads) {
                        if (n.getIdnote() == 0) {

                            Inscription inscription = inscriptionRepository.getById(n.getInscription());
                            if (inscription != null && (idClasse == inscription.getIdclasse().getIdclasse())) {
                                Note noteTosave = NoteMapper.INSTANCE.fromRequestPayloadToEntity(n);
                                noteTosave.setIdnote(this.nextIdNote());
                                noteTosave.setIdinscription(inscription);
                                noteTosave.setIdevaluation(evaluation);
                                this.appreciate(evaluation.getIdinstitution().getModeAppreciation().getIdMode(), noteTosave);
                                noteRepository.save(noteTosave);
                            }
                        } else {
                            Note noteToedit = noteRepository.getById(n.getIdnote());
                            if (noteToedit != null) {
                                if (noteToedit.getIdinscription().equals(n.getInscription())) {
                                    this.appreciate(evaluation.getIdinstitution().getModeAppreciation().getIdMode(), noteToedit);
                                    noteRepository.save(noteToedit);
                                }
                            }
                        }
                    }
                    this.initMinMaxAverage(evaluation, idClasse);
                }
            }
        }
    }

    @Override
    public List<NoteResponseDto> getMarksByIdclasseAndIdevaluation(int idClasse, long idEvaluation) {
        return noteRepository.findAllByIdEvaluationAndIdClasse(idEvaluation, idClasse)
                .stream().map(n -> {
                    NoteResponseDto nTemp = NoteMapper.INSTANCE.fromEntityToResponse(n);
                    nTemp.setEvaluation(EvaluationMapper.INSTANCE.fromEntityToResponse(n.getIdevaluation()));
                    InscriptionResponseDto iDto = InscriptionMapper.INSTANCE.fromEntityToResponse(n.getIdinscription());
                    iDto.setEleve(EleveMapper.INSTANCE.fromEntityToDto(n.getIdinscription().getIdeleve()));
                    nTemp.setInscription(iDto);
                    return nTemp;
                }).collect(Collectors.toList());
    }

    @Override
    public List<NoteResponseDto> getStudentMarksBySequence(int idInscription, int idPeriode) {
        return noteRepository.findStudentMarksByPeriode(idInscription, idPeriode)
                .stream().map(n -> {
                    NoteResponseDto nr = NoteMapper.INSTANCE.fromEntityToResponse(n);
                    nr.setEvaluation(EvaluationMapper.INSTANCE.fromEntityToResponse(n.getIdevaluation()));
                    InscriptionResponseDto iDto = InscriptionMapper.INSTANCE.fromEntityToResponse(n.getIdinscription());
                    iDto.setEleve(EleveMapper.INSTANCE.fromEntityToDto(n.getIdinscription().getIdeleve()));
                    nr.setInscription(iDto);
                    return nr;
                }).collect(Collectors.toList());
    }

    private Long nextIdNote() {
        try {
            return ((noteRepository.nextIdNote()) + 1);
        } catch (Exception e) {
            return 1l;
        }
    }

    private void appreciate(int idModeAppreciation, Note n) {
        if (idModeAppreciation == 1) {
            n.setAppreciation(utils.appreciate(n.getValeur()));
        } else {
            n.setAppreciation(utils.appreciateModeClassique(n.getValeur()));
        }
    }

    private void initMinMaxAverage(Evaluation evaluation, Integer idClasse) {
        try {

            Double min = noteRepository.findMin(idClasse, evaluation.getIdevaluation());
            Double max = noteRepository.findMax(idClasse, evaluation.getIdevaluation());
            Double average = noteRepository.findAverage(idClasse, evaluation.getIdevaluation());

            if (min != null && max != null) {
                List<Note> notes = noteRepository.findAllByIdEvaluationAndIdClasse(evaluation.getIdevaluation(), idClasse);
                List<Double> rang = new ArrayList<>();

                notes.forEach(n -> {
                    try {
                        if (n.getValeur() != null) {
                            if (!rang.contains(n.getValeur())) {
                                rang.add(n.getValeur());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

                //Comparator.

                rang.sort(Comparator.reverseOrder());

                // Cr??er un tableau de m??me taille que le nombre d'objet de ArrayList
                //Double tab[] = new Double[rang.size()];

                // Transformer Le ArrayList en Tableau

                //tab= rang.toArray(tab);
                //Arrays.parallelSort( tab );

                notes.forEach(n -> {
                    n.setMin(min);
                    n.setMax(max);
                    n.setMoy(average);
                    try {
                        if (n.getValeur() != null) {
                            n.setRang((rang.indexOf(n.getValeur()) + 1));
                        }
                    } catch (Exception e) {

                    }
                    noteRepository.save(n);
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private List<NoteResponseDto> transformInscriptionToNote(List<Inscription> inscriptions, Evaluation evaluation, boolean notif) {
        return inscriptions.stream().map(i -> {
            NoteResponseDto nr = new NoteResponseDto();
            nr.setIdnote(0l);
            nr.setAppreciation("");
            nr.setMarkNotification(notif);
            nr.setNotifie(false);
            nr.setMax(0d);
            nr.setMin(0d);
            nr.setMoy(0d);

            InscriptionResponseDto iDto = InscriptionMapper.INSTANCE.fromEntityToResponse(i);
            iDto.setEleve(EleveMapper.INSTANCE.fromEntityToDto(i.getIdeleve()));

            nr.setInscription(iDto);
            nr.setEvaluation(EvaluationMapper.INSTANCE.fromEntityToResponse(evaluation));
            nr.setValeur(0d);
            return nr;
        }).collect(Collectors.toList());

    }
}

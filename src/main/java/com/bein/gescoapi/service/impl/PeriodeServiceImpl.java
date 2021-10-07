package com.bein.gescoapi.service.impl;

import com.bein.gescoapi.dao.AnneeScolaireRepository;
import com.bein.gescoapi.dao.SequenceRepository;
import com.bein.gescoapi.dao.TrimestreRepository;
import com.bein.gescoapi.service.declaration.PeriodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeriodeServiceImpl implements PeriodeService {

    private final AnneeScolaireRepository anneeScolaireRepository;
    private final SequenceRepository sequenceRepository;
    private final TrimestreRepository trimestreRepository;
}

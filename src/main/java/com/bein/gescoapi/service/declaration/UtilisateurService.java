package com.bein.gescoapi.service.declaration;

import com.bein.gescoapi.dto.UserPasswordResetRequestPayload;
import com.bein.gescoapi.dto.UtilisateurRequestDto;
import com.bein.gescoapi.dto.UtilisateurResponseDto;

import java.util.List;

public interface UtilisateurService {

    List<UtilisateurResponseDto> getAllByIdinstitution(Integer id);

    UtilisateurResponseDto saveUser(UtilisateurRequestDto utilisateurRequestDto);

    UtilisateurResponseDto editUser(UtilisateurRequestDto utilisateurRequestDto);

    void resetPassword(String username);

    void changePassword(UserPasswordResetRequestPayload requestPayload);
}

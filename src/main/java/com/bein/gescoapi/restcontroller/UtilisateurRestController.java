package com.bein.gescoapi.restcontroller;

import com.bein.gescoapi.dto.UserPasswordResetRequestPayload;
import com.bein.gescoapi.dto.UtilisateurRequestDto;
import com.bein.gescoapi.dto.UtilisateurResponseDto;
import com.bein.gescoapi.service.declaration.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UtilisateurRestController {

    private final UtilisateurService utilisateurService;

    public UtilisateurRestController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/all/{idinstitution}")
    @ResponseBody
    public List<UtilisateurResponseDto> getAll(@PathVariable(name = "idinstitution") Integer id) {
        return utilisateurService.getAllByIdinstitution(id);
    }

    @PostMapping("/save")
    public ResponseEntity<UtilisateurResponseDto> saveUser(@RequestBody UtilisateurRequestDto requestDto) {
        return ResponseEntity.ok().body(utilisateurService.saveUser(requestDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UtilisateurResponseDto> editUser(@PathVariable("id") Long id, @RequestBody UtilisateurRequestDto requestDto) {
        if (id == null) {
            return ResponseEntity.badRequest().build();
        }
        requestDto.setIdutilisateur(id);
        return ResponseEntity.ok().body(utilisateurService.editUser(requestDto));
    }

    @PutMapping("/reset-password/{username}")
    public ResponseEntity<?> resetPassword(@PathVariable("username") String username) {
        if (username == null) {
            return ResponseEntity.badRequest().build();
        }
        utilisateurService.resetPassword(username);
        return ResponseEntity.ok().body("User password reseted successfully");
    }

    @PutMapping("/change-password")
    public ResponseEntity<?> changeCredentials(@RequestBody UserPasswordResetRequestPayload requestPayload) {
        utilisateurService.changePassword(requestPayload);
        return ResponseEntity.ok().body("User Credentials changed with success");
    }

}

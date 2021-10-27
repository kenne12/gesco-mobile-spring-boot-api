package com.bein.gescoapi.dto;

import lombok.Data;

@Data
public class UserPasswordResetRequestPayload {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String repeatNewPassword;
}

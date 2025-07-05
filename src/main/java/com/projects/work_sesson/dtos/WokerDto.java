package com.projects.work_sesson.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record WokerDto(
        @NotNull(message = "name is required") String firstName,
        @NotNull(message = "name is required") String lastName,
        @Email(message = "Email should be valid") String email,
        String password) {

}

package com.akshat.project.university.management.system.jwt.auth;

import com.akshat.project.university.management.system.jwt.user.Role;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Role role;
}

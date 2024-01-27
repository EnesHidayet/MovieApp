package org.enes.dto.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {

    private String name;
    private String surname;
    private String email;
    private String password;
    private String rePassword;

}

package org.enes.dto.response;

import lombok.*;
import org.enes.utility.EStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponseDto {

    private String name;
    private String surname;
    private String email;
    private EStatus status;

}

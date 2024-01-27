package org.enes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.enes.utility.EStatus;
import org.enes.utility.EUserType;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Size(max = 50)
    String name;

//    @Size(max = 50)
    String surname;

//    @Size(max = 50)
    @Email
    String email;

//    @Size(max = 15)
    String phone;

//    @Size(max = 32)
    String password;

//    @Size(max = 32)
    String rePassword;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    EUserType userType = EUserType.USER;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    EStatus status = EStatus.PENDING;

    @ElementCollection
    List<Long> favMovies;

    @ElementCollection
    List<Long> favGenres;

    @ElementCollection
    List<Long> comments;
}

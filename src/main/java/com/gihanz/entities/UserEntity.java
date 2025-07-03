package com.gihanz.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(indexes = {
        @Index(name = "index_username_email",columnList = "username")

},name = "TBL_R_USERS")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends SuperEntity{

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
}

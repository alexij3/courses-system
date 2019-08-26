package com.buzilov.studying.practice.courses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_authorities")
public class UserAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Authority authority;

    enum Authority {
        ROLE_USER, ROLE_ADMIN, ROLE_CONTENT_MANAGER
    }

}

package com.buzilov.studying.practice.courses.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts_balances")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "balance_value", precision = 2)
    private Double balanceValue;


}

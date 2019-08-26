package com.buzilov.studying.practice.courses.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts_balances")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_balance_generator")
    @SequenceGenerator(name = "account_balance_generator", sequenceName = "account_balances_seq")
    private Long id;

    @Column(name = "balance_value", precision = 2)
    private Double balanceValue;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;

    public AccountBalance(Double balanceValue, User user) {
        this.balanceValue = balanceValue;
        this.user = user;
    }
}

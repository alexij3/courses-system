package com.buzilov.studying.practice.courses.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "accounts_balances")
public class AccountBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_balance_generator")
    @SequenceGenerator(name = "account_balance_generator", sequenceName = "account_balances_seq", allocationSize = 1)
    private Long id;

    @Column(name = "balance_value", precision = 2, nullable = false, columnDefinition = "DOUBLE PRECISION default 0.0")
    private Double balanceValue;

    @OneToOne(cascade = CascadeType.REMOVE)
    private User user;

    public AccountBalance(Double balanceValue, User user) {
        this.balanceValue = balanceValue;
        this.user = user;
    }
}

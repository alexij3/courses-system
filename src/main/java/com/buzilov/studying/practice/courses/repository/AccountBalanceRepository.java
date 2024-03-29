package com.buzilov.studying.practice.courses.repository;

import com.buzilov.studying.practice.courses.model.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Long> {

}

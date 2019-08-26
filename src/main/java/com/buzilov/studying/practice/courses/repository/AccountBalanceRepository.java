package com.buzilov.studying.practice.courses.repository;

import com.buzilov.studying.practice.courses.model.AccountBalance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountBalanceRepository extends CrudRepository<AccountBalance, Long> {

}

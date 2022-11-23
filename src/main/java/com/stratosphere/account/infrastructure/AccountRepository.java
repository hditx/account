package com.stratosphere.account.infrastructure;

import com.stratosphere.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    public Account findByEmail(String email);
}

package com.stratosphere.account.shared.infrastructure;

import com.stratosphere.account.domain.Account;
import com.stratosphere.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetails implements UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByEmail(username);
        UserBuilder userBuilder = null;
        if(account != null) {
            userBuilder = User.withUsername(username);
            userBuilder.disabled(false);
            userBuilder.password(account.getPassword());
            userBuilder.authorities(new SimpleGrantedAuthority("ROL_USER"));
        } else {
            throw new UsernameNotFoundException("Account not found");
        }
        return userBuilder.build();
    }
}

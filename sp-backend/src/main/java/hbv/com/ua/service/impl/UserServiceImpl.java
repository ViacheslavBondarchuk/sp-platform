package hbv.com.ua.service.impl;

import hbv.com.ua.model.User;
import hbv.com.ua.repository.mybatis.UserRepository;
import hbv.com.ua.service.AbstractService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, Long, UserRepository> implements UserDetailsService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }


    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User by username %s has been not found", username)));
    }
}

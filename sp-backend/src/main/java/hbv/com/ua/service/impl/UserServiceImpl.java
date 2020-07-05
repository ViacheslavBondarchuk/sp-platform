package hbv.com.ua.service.impl;

import hbv.com.ua.model.Authority;
import hbv.com.ua.model.User;
import hbv.com.ua.repository.mybatis.UserRepository;
import hbv.com.ua.service.AbstractService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<User, Long, UserRepository> implements UserDetailsService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User read(Long aLong) throws NotFoundException {
        return super.read(aLong);
    }

    @Override
    public List<User> readAll() {
        return super.readAll();
    }

    @Override
    public void create(User user) {
        super.create(this.prepare(user));
    }

    @Override
    public User update(User user, Long aLong) {
        return super.update(user, aLong);
    }

    @Override
    public void delete(Long aLong) {
        super.delete(aLong);
    }

    private User prepare(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAuthorities(Collections.singleton(Authority.USER));
        return user;
    }

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User by username %s has been not found", username)));
    }
}

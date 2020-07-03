package hbv.com.ua.repository.mybatis;

import hbv.com.ua.model.User;

import java.util.Optional;

public interface UserRepository extends CRUD<User, Long> {

    Optional<User> findByUsername(final String username);
}

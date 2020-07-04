package hbv.com.ua.repository.mybatis;

import hbv.com.ua.model.User;
import hbv.com.ua.repository.CRUD;

import java.util.Optional;

public interface UserRepository extends CRUD<User, Long> {

    Optional<User> findByUsername(final String username);
}

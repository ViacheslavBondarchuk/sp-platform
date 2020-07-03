package hbv.com.ua.repository.mybatis;

import hbv.com.ua.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(final long id);
}

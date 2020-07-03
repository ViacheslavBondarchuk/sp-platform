package hbv.com.ua.repository.mybatis;

import java.util.Optional;

public interface CRUD<T, ID> {
    Optional<T> findById(final ID id);

    T create(final T t);

    T update(final T t, ID id);

    void delete(final ID id);
}

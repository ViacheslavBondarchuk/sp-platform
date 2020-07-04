package hbv.com.ua.repository;

import java.util.List;
import java.util.Optional;

public interface CRUD<T, ID> {
    Optional<T> read(final ID id);

    List<T> readAll();

    void create(final T t);

    T update(final T t, ID id);

    void delete(final ID id);
}

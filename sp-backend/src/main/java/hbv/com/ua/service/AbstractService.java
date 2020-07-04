package hbv.com.ua.service;

import hbv.com.ua.repository.CRUD;
import org.apache.ibatis.javassist.NotFoundException;

public abstract class AbstractService<T, ID, R extends CRUD<T, ID>> {
    protected final R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    public T read(final ID id) throws NotFoundException {
        return repository.read(id)
                .orElseThrow(() -> new NotFoundException("entity has been not found"));
    }

    public T create(final T t) {
        return repository.create(t);
    }

    public T update(final T t, ID id) {
        return repository.update(t, id);
    }

    public void delete(final ID id) {
        repository.delete(id);
    }
}

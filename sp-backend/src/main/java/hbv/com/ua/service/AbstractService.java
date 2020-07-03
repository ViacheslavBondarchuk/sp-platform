package hbv.com.ua.service;

import hbv.com.ua.repository.mybatis.CRUD;
import org.apache.ibatis.javassist.NotFoundException;

public class AbstractService<T, ID, R extends CRUD<T, ID>> {
    protected R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    protected T findById(final ID id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("entity has been not found"));
    }

    protected T create(final T t) {
        return repository.create(t);
    }

    protected T update(final T t, ID id) {
        return repository.update(t, id);
    }

    protected void delete(final ID id) {
        repository.delete(id);
    }
}

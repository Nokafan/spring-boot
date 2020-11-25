package spring.boot.parser.service;

import java.util.List;

public interface GeneralService<T> {
    T save(T entity);

    List<T> saveAll(Iterable<T> users);

    T getById(Long id);

    List<T> getAll();
}

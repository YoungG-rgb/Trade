package kg.tech.commons.services;

import java.util.List;

public interface BaseService<T> {

    T save(T data);

    T update(T data);

    void delete(Long id) throws Exception;

    List<T> getAll();
}

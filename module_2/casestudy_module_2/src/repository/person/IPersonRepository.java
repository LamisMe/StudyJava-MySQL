package repository.person;

import java.util.List;

public interface IPersonRepository<T> {
    List<T> getAll();
    void add(T t);
    void remove(T t);
    List<T> searchByName(String name);
    void edit(String id, T t);
    T getById(String id);
}

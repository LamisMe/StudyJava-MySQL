package extra_exercises.repository;

import java.util.List;

public interface IPersonRepository <E>{
    List<E> display();
    void add(E e);
    void remove(E e);
    void edit(String code,E e);
    E getByID(String code);
}

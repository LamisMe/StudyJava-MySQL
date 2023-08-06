package repository.booking;

import model.booking.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> getAll();

    void add(Contract contract);

    void edit(int id, Contract contract);
    Contract getById(int id);
}

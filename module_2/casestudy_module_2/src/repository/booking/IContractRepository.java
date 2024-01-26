package repository.booking;

import model.booking.Contract;
import service.booking.IBookingService;

import java.util.List;

public interface IContractRepository  {
    List<Contract> getAll();

    void add(Contract contract);

    void edit(int id, Contract contract);
    Contract getById(int id);
}

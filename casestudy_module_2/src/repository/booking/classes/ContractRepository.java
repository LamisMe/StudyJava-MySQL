package repository.booking.classes;

import model.booking.Contract;
import model.person.sub_class.Customer;
import repository.booking.IContractRepository;

import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private static final List<Contract> contracts = new ArrayList<>();

    static {
        contracts.add(new Contract(1, "1", 100000, 1200000));
    }

    @Override
    public List<Contract> getAll() {
        return contracts;
    }

    @Override
    public void add(Contract contract) {
        contracts.add(contract);
    }

    @Override
    public void edit(int id, Contract contract) {
        for (Contract c : contracts) {
            if (c.getBooking().equals(id)) {
                c = contract;
            }
            contracts.add(c);
        }
    }
    public Contract getById(int id) {
        List<Contract> contractList = getAll();
        for (Contract contract : contractList) {
            if (contract.getSomeContracts()==id) {
                return contract;
            }
        }
        return null;
    }
}

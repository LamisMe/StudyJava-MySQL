package extra_exercises.repository;

import extra_exercises.model.Bill;

import java.util.List;

public interface IBillRepository {
    List<Bill> getAllBill();
    void addBill(Bill bill);
    Bill getById(String code);
    void update(String code, Bill bill);
}

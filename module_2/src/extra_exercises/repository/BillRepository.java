package extra_exercises.repository;

import extra_exercises.common.ReadToFile;
import extra_exercises.common.WriteToFile;
import extra_exercises.model.Bill;
import extra_exercises.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BillRepository implements IBillRepository{
    private final String PATH_BILL = "src/extra_exercises/data/bill.csv";
    private List<Bill> list = new ArrayList<>();
    @Override
    public List<Bill> getAllBill() {
         List<String> stringList = ReadToFile.readToFile(PATH_BILL);
         list.clear();
         String[] info;
        for (String str: stringList) {
            info = str.split(",");
            list.add(new Bill(info[0], info[1], info[2], Integer.parseInt(info[3]), Long.parseLong(info[4]), Long.parseLong(info[5])));
        }
        return list;
    }

    @Override
    public void addBill(Bill bill) {
        List<String> stringList = new ArrayList<>();
        stringList.add(bill.infoBillCSV());
        WriteToFile.writeToFile(PATH_BILL,stringList,true);
    }

    @Override
    public Bill getById(String code) {
        list = getAllBill();
        for (Bill bill: list) {
            if(bill.getCodeBill().equals(code)){
                return bill;
            }
        }
        return null;
    }

    @Override
    public void update(String code, Bill bill) {
        list = getAllBill();
        List<String> stringList = new ArrayList<>();
        for (Bill bill1:list) {
            if(bill1.getCodeBill().equals(code)){
                bill1 = bill;
            }
            stringList.add(bill1.infoBillCSV());
        }
        WriteToFile.writeToFile(PATH_BILL,stringList,false);
    }
}

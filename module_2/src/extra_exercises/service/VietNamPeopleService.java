package extra_exercises.service;

import extra_exercises.model.VietNamPeople;
import extra_exercises.repository.IPersonRepository;
import extra_exercises.repository.VietNamPeopleRepository;

import java.util.List;

import static extra_exercises.view.Main.scanner;


public class VietNamPeopleService implements IPersonService {

    private final IPersonRepository<VietNamPeople> personRepository = new VietNamPeopleRepository();
    @Override
    public void read() {
        List<VietNamPeople> vietNamPeople = personRepository.display();
        for (VietNamPeople vietNamPeople1:vietNamPeople) {
            System.out.println(vietNamPeople1);
        }
    }

    @Override
    public void create() {
        System.out.println("Nhâp mã khách hàng");
        String codePerson = scanner.nextLine();
        System.out.println("Nhập tên khách hàng");
        String namePerson = scanner.nextLine();
        System.out.println("Nhập loại khách hàng");
        String customerType = scanner.nextLine();
        System.out.println("Nhập định mức tiêu thụ");
        long consumptionNorms = Long.parseLong(scanner.nextLine());
        VietNamPeople vietNamPeople = new VietNamPeople(codePerson,namePerson,customerType,consumptionNorms);
        personRepository.add(vietNamPeople);
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void search() {

    }
}

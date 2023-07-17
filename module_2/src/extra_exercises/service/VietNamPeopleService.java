package extra_exercises.service;

import extra_exercises.model.VietNamPeople;
import extra_exercises.repository.IPersonRepository;
import extra_exercises.repository.VietNamPeopleRepository;

import java.util.List;
import java.util.Scanner;

public class VietNamPeopleService implements IPersonService {
    private Scanner scanner = new Scanner(System.in);
    private IPersonRepository<VietNamPeople> personRepository = new VietNamPeopleRepository();
    @Override
    public void read() {
        List<VietNamPeople> vietNamPeople = personRepository.display();
        for (VietNamPeople vietNamPeople1:vietNamPeople) {
            System.out.println(vietNamPeople1);
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

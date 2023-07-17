package extra_exercises.service;

import extra_exercises.model.VietNamPeople;
import extra_exercises.repository.IPersonRepository;
import extra_exercises.repository.VietNamPeopleRepository;

import java.util.Scanner;

public class VietNamPeopleService implements IPersonService {
    private Scanner scanner = new Scanner(System.in);
    private IPersonRepository<VietNamPeople> personRepository = new VietNamPeopleRepository();
    @Override
    public void create() {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}

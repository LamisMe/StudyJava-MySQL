package extra_exercises.service;

import extra_exercises.model.ForeignerPeople;
import extra_exercises.repository.ForeignerPeopleRepository;
import extra_exercises.repository.IPersonRepository;

import java.util.List;
import java.util.Scanner;

public class ForeignerPeopleService implements IPersonService{
    private final Scanner scanner = new Scanner(System.in);
    private IPersonRepository<ForeignerPeople> foreignerPeopleIPersonRepository = new ForeignerPeopleRepository();
    @Override
    public void read() {
        List<ForeignerPeople> foreignerPeople = foreignerPeopleIPersonRepository.display();
        for (ForeignerPeople people:foreignerPeople) {
            System.out.println(people);
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

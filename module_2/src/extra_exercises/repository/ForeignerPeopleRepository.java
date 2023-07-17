package extra_exercises.repository;

import extra_exercises.common.ReadToFile;
import extra_exercises.common.WriteToFile;
import extra_exercises.model.ForeignerPeople;

import java.util.ArrayList;
import java.util.List;

public class ForeignerPeopleRepository implements IPersonRepository<ForeignerPeople>{
    private final String PATH_ELECTRICITY = "src/extra_exercises/data/electricity_bill_foreigner.csv";
    private static List<ForeignerPeople> foreignerPeoples = new ArrayList<>();
    @Override
    public List<ForeignerPeople> display() {
        List<String> stringList = ReadToFile.readToFile(PATH_ELECTRICITY);
        foreignerPeoples.clear();
        String[] info;
        for (String str: stringList) {
            info = str.split(",");
            foreignerPeoples.add(new ForeignerPeople(info[0],info[1],info[2]));
        }
        return foreignerPeoples;
    }

    @Override
    public void add(ForeignerPeople foreignerPeople) {
        List<String> stringList = new ArrayList<>();
        stringList.add(foreignerPeople.infoForeignerToCSV());
        WriteToFile.writeToFile(PATH_ELECTRICITY,stringList,true);
    }

    @Override
    public void remove(ForeignerPeople foreignerPeople) {
        foreignerPeoples = display();
        foreignerPeoples.remove(foreignerPeople);
        List<String> stringList = new ArrayList<>();
        for (ForeignerPeople f: foreignerPeoples) {
            stringList.add(f.infoForeignerToCSV());
        }
        WriteToFile.writeToFile(PATH_ELECTRICITY,stringList,false);
    }

    @Override
    public void edit(String code, ForeignerPeople foreignerPeople) {
        foreignerPeoples = display();
        List<String> stringList = new ArrayList<>();
        for (ForeignerPeople f:foreignerPeoples) {
            if(f.getCodePerson().equals(code)){
                f = foreignerPeople;
            }
            stringList.add(f.infoForeignerToCSV());
        }
        WriteToFile.writeToFile(PATH_ELECTRICITY,stringList,false);
    }

    @Override
    public ForeignerPeople getByID(String code) {
        foreignerPeoples = display();
        for (ForeignerPeople f:foreignerPeoples) {
            if(f.getCodePerson().equals(code)){
                return f;
            }
        }
        return null;
    }
}

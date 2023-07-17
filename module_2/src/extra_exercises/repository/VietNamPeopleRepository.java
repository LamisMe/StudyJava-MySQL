package extra_exercises.repository;

import extra_exercises.common.ReadToFile;
import extra_exercises.common.WriteToFile;
import extra_exercises.model.VietNamPeople;

import java.util.ArrayList;
import java.util.List;

public class VietNamPeopleRepository implements IPersonRepository<VietNamPeople>{
    private final String PATH_ELECTRICITY = "src/extra_exercises/data/electricity_bill_vietnam.csv";
    private List<VietNamPeople> vietNamPeoples = new ArrayList<>();
    @Override
    public List<VietNamPeople> display() {
        List<String> stringList = ReadToFile.readToFile(PATH_ELECTRICITY);
        vietNamPeoples.clear();
        String[] info;
        for (String str: stringList) {
            info = str.split(",");
            vietNamPeoples.add(new VietNamPeople(info[0],info[1],info[2],Long.parseLong(info[3])));
        }
        return vietNamPeoples;
    }

    @Override
    public void add(VietNamPeople vietNamPeople) {
        List<String> stringList = new ArrayList<>();
        stringList.add(vietNamPeople.infoVietNamToCSV());
        WriteToFile.writeToFile(PATH_ELECTRICITY,stringList,true);
    }

    @Override
    public void remove(VietNamPeople vietNamPeople) {
        vietNamPeoples = display();
        vietNamPeoples.remove(vietNamPeople);
        List<String> stringList = new ArrayList<>();
        for (VietNamPeople vietNamPeople1: vietNamPeoples) {
            stringList.add(vietNamPeople1.infoVietNamToCSV());
        }
        WriteToFile.writeToFile(PATH_ELECTRICITY,stringList,false);
    }

    @Override
    public void edit(String code, VietNamPeople vietNamPeople) {
        vietNamPeoples = display();
        List<String> stringList = new ArrayList<>();
        for (VietNamPeople vietNamPeople1:vietNamPeoples) {
            if(vietNamPeople1.getCodePerson().equals(code)){
                vietNamPeople1 = vietNamPeople;
            }
            stringList.add(vietNamPeople1.infoVietNamToCSV());
        }
        WriteToFile.writeToFile(PATH_ELECTRICITY,stringList,false);
    }

    @Override
    public VietNamPeople getByID(String code) {
        vietNamPeoples = display();
        for (VietNamPeople vietNamPeople: vietNamPeoples) {
            if(vietNamPeople.getCodePerson().equals(code)){
                return vietNamPeople;
            }
        }
        return null;
    }
}

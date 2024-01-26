package repository.facility.classes;

import common.ReadToFile;
import common.WriteToFile;
import model.facility.Facility;
import model.facility.sub_class.House;
import model.facility.sub_class.Room;
import model.facility.sub_class.Villa;
import repository.facility.IFacilityRepository;

import java.util.*;

public class FacilityRepository implements IFacilityRepository {
    private static final Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static final String PATH_FACILITY = "src/data/facility.csv";
    private static final int value = 0;

    @Override
    public Map<Facility, Integer> getAll() {
        List<String> strings = ReadToFile.readToFile(PATH_FACILITY);
        facilityIntegerMap.clear();
        String[] info;
        try {
            for (String str : strings) {
                info = str.split(",");
                if (info.length > 9) {
                    facilityIntegerMap.put(new Villa(info[0], info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]), Integer.parseInt(info[4]), info[5], info[6], Float.parseFloat(info[7]), Integer.parseInt(info[8])), Integer.valueOf(info[9]));
                } else if (info.length == 9) {
                    facilityIntegerMap.put(new House(info[0], info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]), Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
                } else {
                    facilityIntegerMap.put(new Room(info[0], info[1], Float.parseFloat(info[2]), Float.parseFloat(info[3]), Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return facilityIntegerMap;
    }

    @Override
    public void add(Facility facility) {
        List<String> stringList = ReadToFile.readToFile(PATH_FACILITY);
        if (facility instanceof Villa) {
            stringList.add(((Villa) facility).infoVillaToCSV() + "," + value);
        } else if (facility instanceof House) {
            stringList.add(((House) facility).infoHouseToCSV() + "," + value);
        } else {
            stringList.add(((Room) facility).infoRoomToCSV() + "," + value);
        }
        WriteToFile.writeToFile(PATH_FACILITY, stringList, false);
    }

    @Override
    public void remove(Facility facility) {
        facilityIntegerMap.remove(facility, facilityIntegerMap.get(facility));
        List<String> strings = new ArrayList<>();
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (facility instanceof Villa) {
                strings.add(entry.getKey().toString() + "," + entry.getValue());
            } else if (facility instanceof House) {
                strings.add(entry.getKey().toString() + "," + entry.getValue());
            } else {
                if (facility instanceof Room) {
                    strings.add(entry.getKey().toString() + "," + entry.getValue());
                }
            }
        }
        WriteToFile.writeToFile(PATH_FACILITY, strings, false);
    }

    @Override
    public Map<Facility, Integer> getAllMaintenance() {
        Map<Facility, Integer> integerMap = new LinkedHashMap<>();
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (entry.getValue() >= 5) {
                integerMap.put(entry.getKey(), entry.getValue());
            }
        }
        return integerMap;
    }

    @Override
    public Facility getByID(String id) {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (entry.getKey().getCodeService().equals(id)) {
                return entry.getKey();
            }
        }
        return null;
    }

}

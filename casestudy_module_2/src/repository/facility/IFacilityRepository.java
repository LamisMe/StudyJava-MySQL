package repository.facility;

import model.facility.Facility;

import java.util.Map;

public interface IFacilityRepository {
    Map<Facility,Integer> getAll();
    void add(Facility facility);
    void remove(Facility facility);
    Map<Facility,Integer> getAllMaintenance();
    Facility getByID(String id);
}

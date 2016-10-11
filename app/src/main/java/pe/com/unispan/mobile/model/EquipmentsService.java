package pe.com.unispan.mobile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emarquez on 10/10/2016.
 */

public class EquipmentsService {
    private List<Equipment> equipments = new ArrayList<>();

    public List<Equipment> getEquipments() {
        equipments = Equipment.listAll(Equipment.class);
        if (equipments.size() == 0) {
            this.initializeData();
        }
        return equipments;
    }

    public boolean addEquipment(String nameEquipment, String stateEquipment) {
        if (findGroupByNameEquipment(nameEquipment) != null) return false;
        Equipment equipment = new Equipment(nameEquipment, stateEquipment);
        this.equipments.add(equipment);
        equipment.save();
        return true;
    }

    public Equipment findGroupByNameEquipment(String nameEquipment) {
        Equipment equipment = null;
        List<Equipment> results = Equipment.find(Equipment.class, "name_equipment = ?", nameEquipment);
        if (results != null && results.size() > 0)
            equipment = results.get(0);
        return equipment;
    }

    private void initializeData() {
        this.addEquipment("Equipo 1", "Pendiente");
        this.addEquipment("Equipo 2", "Pendiente");
        this.addEquipment("Equipo 3", "Pendiente");
        this.addEquipment("Equipo 4", "Pendiente");
    }
}

package pe.com.unispan.mobile.model;

import com.orm.SugarRecord;

/**
 * Created by emarquez on 10/10/2016.
 */

public class Equipment extends SugarRecord {
    private String nameEquipment;
    private String stateEquipment;

    public Equipment() {}

    public Equipment(String nameEquipment, String stateEquipment) {
        setNameEquipment(nameEquipment);
        setStateEquipment(stateEquipment);
    }

    public String getNameEquipment() {
        return nameEquipment;
    }

    public void setNameEquipment(String nameEquipment) {
        this.nameEquipment = nameEquipment;
    }

    public String getStateEquipment() {
        return stateEquipment;
    }

    public void setStateEquipment(String stateEquipment) {
        this.stateEquipment = stateEquipment;
    }
}

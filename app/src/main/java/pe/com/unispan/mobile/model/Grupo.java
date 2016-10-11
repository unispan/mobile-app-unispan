package pe.com.unispan.mobile.model;

import com.orm.SugarRecord;

/**
 * Created by emarquez on 10/10/2016.
 */

public class Grupo extends SugarRecord {
    private String nameGroup;
    private String countGroup;

    public Grupo() {

    }

    public Grupo(String nameGroup, String countGroup) {
        this.setNameGroup(nameGroup);
        this.setCountGroup(countGroup);
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getCountGroup() {
        return countGroup;
    }

    public void setCountGroup(String countGroup) {
        this.countGroup = countGroup;
    }
}

package pe.com.unispan.mobile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emarquez on 3/10/2016.
 */

public class DevolutionsService {
    private List<Devolution> devolutions = new ArrayList<>();


    public List<Devolution> getDevolutions() {
        devolutions = Devolution.listAll(Devolution.class);

        if (devolutions.size() == 0) {
            this.inicializeData();
        }

        return devolutions;
    }

    public void setDevolutions(List<Devolution> devolutions) {
        this.devolutions = devolutions;
    }

    public boolean addDevolution(Integer order, String customer, String schedule, String building) {
        Devolution devolution = new Devolution(order, customer, schedule, building);
        this.devolutions.add(devolution);

        devolution.save();

        return true;
    }

    private void inicializeData() {
        this.addDevolution(1, "Los Constructores SAC", "08:00 - 10:00", "Edificio Los Alamos");
        this.addDevolution(2, "GyN SAC", "10:00 - 12:00", "CC Los Laureles");
    }
}

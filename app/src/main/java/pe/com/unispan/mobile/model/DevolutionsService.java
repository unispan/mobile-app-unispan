package pe.com.unispan.mobile.model;

import java.util.ArrayList;
import java.util.List;

import pe.com.unispan.mobile.R;

/**
 * Created by emarquez on 3/10/2016.
 */

public class DevolutionsService {
    private List<Devolution> devolutions = new ArrayList<>();

    public List<Devolution> getDevolutions() {
/*        devolutions = Devolution.listAll(Devolution.class);

        if (devolutions.size() == 0) {
            this.inicializeData();
        }

        return devolutions;*/
        return null;
    }

    public boolean addDevolution(Integer order, String customer, String schedule, String building, String pictureUri) {
/*        if(findDevolutionByOrder(order) != null) return false;
        Devolution devolution = new Devolution(order, customer, schedule, building, pictureUri);
        this.devolutions.add(devolution);
        devolution.save();*/
        return true;
    }

    public Devolution findDevolutionByOrder(Integer order) {
        Devolution devolution = null;
/*        List<Devolution> results = Devolution.find(Devolution.class, "order = ?", order.toString());
        if(results != null && results.size() > 0)
            devolution = results.get(0);*/
        return devolution;
    }

    private void inicializeData() {
        this.addDevolution(1, "Los Constructores SAC", "08:00 - 10:00", "Edificio Los Alamos", Integer.toString(R.mipmap.ic_scheduled));
        this.addDevolution(2, "GyN SAC", "10:00 - 12:00", "CC Los Laureles", Integer.toString(R.mipmap.ic_scheduled));
    }
}

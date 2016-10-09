package pe.com.unispan.mobile.model;

import java.util.ArrayList;
import java.util.List;

import pe.com.unispan.mobile.R;

/**
 * Created by Miguel-PC on 08/10/2016.
 */

public class DevolutionService {
    private List<Devolution> devolution = new ArrayList<>();

    public List<Devolution> getDevolution(){
        devolution = Devolution.listAll(Devolution.class);
        if(devolution.size() == 0){
            this.initializeDate();
        }
        return devolution;
    }


    public boolean addDevolution(Integer order, String customer, String schedule, String building, String pictureUri){
        if(findDevolutionByOrder(order) != null) return false;
        Devolution devolution = new Devolution(order,customer,schedule,building,pictureUri);
        this.devolution.add(devolution);
        devolution.save();
        return true;
    }


    public Devolution findDevolutionByOrder(Integer order){
        Devolution devolution = null;
        List<Devolution> results = Devolution.find(Devolution.class, "order = ?", order.toString());
        if(results !=null && results.size() > 0)
            devolution = results.get(0);
        return devolution;
    }

    private void initializeDate(){
        this.addDevolution(1, "Los Constructores SAC", "08:00 - 10:00", "Edificio Los Alamos", Integer.toString(R.mipmap.ic_scheduled));
        this.addDevolution(2, "GyN SAC", "10:00 - 12:00", "CC Los Laureles", Integer.toString(R.mipmap.ic_scheduled));
    }




}


package pe.com.unispan.mobile.model;

import com.orm.SugarRecord;

/**
 * Created by emarquez on 3/10/2016.
 */
public class Devolution extends SugarRecord {
    private Integer numberOrder;
    private String customer;
    private String schedule;
    private String building;
    private String pictureUri;

    public Devolution() {}

    public Devolution(Integer numberOrder, String customer, String schedule, String building, String pictureUri) {
        this.setNumberOrder(numberOrder);
        this.setCustomer(customer);
        this.setSchedule(schedule);
        this.setBuilding(building);
        this.setPictureUri(pictureUri);
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }
}

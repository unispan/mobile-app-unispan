package pe.com.unispan.mobile.model;

import com.orm.SugarRecord;

/**
 * Created by emarquez on 3/10/2016.
 */

public class Devolution extends SugarRecord {
    private Integer order;
    private String customer;
    private String schedule;
    private String building;

    public Devolution() {}

    public Devolution(Integer order, String customer, String schedule, String building) {
        this.order = order;
        this.customer = customer;
        this.schedule = schedule;
        this.building = building;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
}

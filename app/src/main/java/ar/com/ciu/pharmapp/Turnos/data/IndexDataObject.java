package ar.com.ciu.pharmapp.Turnos.data;

import java.util.List;

import ar.com.ciu.pharmapp.PharmacyListPack.PharmacyDataObject;

/**
 * Created by ramiro on 12/12/17.
 */

public class IndexDataObject {

    //Constructors

    public IndexDataObject() {
    }

    //Fields

    private String date;
    private List<PharmacyDataObject> shiftPharmacys;
    private List<EventDataObject> eventData;


    //Methods

    //Getters y Setters

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public List<PharmacyDataObject> getShiftPharmacys() {
        return shiftPharmacys;
    }
    public void setShiftPharmacys(List<PharmacyDataObject> list) {
        this.shiftPharmacys = list;
    }

    public List<EventDataObject> getEventData() {
        return eventData;
    }
    public void setEventData(List<EventDataObject> list) {
        this.eventData = list;
    }
}

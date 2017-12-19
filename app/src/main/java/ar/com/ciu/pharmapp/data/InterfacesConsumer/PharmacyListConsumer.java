package ar.com.ciu.pharmapp.data.InterfacesConsumer;

import java.util.List;

import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;

/**
 * Created by santi on 12/12/2017.
 */

public interface PharmacyListConsumer {
    public void accept(List<PharmacyDataObject> data);
}

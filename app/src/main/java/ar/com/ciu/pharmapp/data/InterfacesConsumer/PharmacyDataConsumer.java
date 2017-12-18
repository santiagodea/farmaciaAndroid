package ar.com.ciu.pharmapp.data.InterfacesConsumer;

import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;

/**
 * Created by santi on 12/12/2017.
 */

public interface PharmacyDataConsumer {
    public void accept(PharmacyDataObject data);
}

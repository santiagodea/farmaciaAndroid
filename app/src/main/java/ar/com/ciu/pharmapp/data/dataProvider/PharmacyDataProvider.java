package ar.com.ciu.pharmapp.data.dataProvider;

import ar.com.ciu.pharmapp.data.InterfacesConsumer.PharmacyDataConsumer;
import ar.com.ciu.pharmapp.data.InterfacesConsumer.PharmacyListConsumer;
import ar.com.ciu.pharmapp.data.dataProvider.ApiPharmacyDataProvider;

/**
 * Created by santi on 14/12/2017.
 */

public abstract class PharmacyDataProvider {
    private static ApiPharmacyDataProvider apiInstance = new ApiPharmacyDataProvider();

    public static ApiPharmacyDataProvider api() { return apiInstance; }

    protected PharmacyDataProvider() {
        super();
    }

    public abstract void fetchPharmacyList(PharmacyListConsumer theFunction);
    public abstract void fetchPharmacyData(String pharmacyName, PharmacyDataConsumer theFunction);
}
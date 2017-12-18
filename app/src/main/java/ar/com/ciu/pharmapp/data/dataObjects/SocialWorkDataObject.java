package ar.com.ciu.pharmapp.data.dataObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urti on 18/12/2017.
 */

public class SocialWorkDataObject {
    private String name;
    private String address;
    private String landphone;
    private List<PharmacyDataObject> pharmacys = new ArrayList<>();

    public SocialWorkDataObject(String name, String address, String landphone, List<PharmacyDataObject> phars ){
        this.name = name;
        this.address = address;
        this.landphone = landphone;
        this.pharmacys = phars;
    }

}

package ar.com.ciu.pharmapp.PharmacyListPack;

import java.io.Serializable;

/**
 * Created by santi on 6/12/2017.
 */

public class PharmacyDataObject implements Serializable
{
    private String name;
    private String address;
    private Integer landphone;
    private Integer alternativePhone;

    public PharmacyDataObject(String name, String address, Integer landPhone, Integer alternativePhone) {
        super();
        this.name = name;
        this.address = address;
        this.landphone = landPhone;
        this.alternativePhone = alternativePhone;
    }

    public String getName() {return name;}
    public String getAddress() {
        return address;
    }
    public Integer getLandphone() {
        return landphone;
    }
    public Integer getAlternativePhone() {
        return alternativePhone;
    }
}
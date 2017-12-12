package ar.com.ciu.pharmapp.PharmacyListPack;

import java.util.List;

/**
 * Created by santi on 12/12/2017.
 */

public interface PharmacyListConsumer {
    public void accept(List<PharmacyDataConsumer> data);
}

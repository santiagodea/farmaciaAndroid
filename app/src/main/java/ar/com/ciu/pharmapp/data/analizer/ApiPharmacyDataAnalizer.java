package ar.com.ciu.pharmapp.data.analizer;

import org.json.JSONException;
import org.json.JSONObject;

import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;

/**
 * Created by santi on 12/12/2017.
 */

public class ApiPharmacyDataAnalizer {
    private JSONObject rawData;

    public ApiPharmacyDataAnalizer(JSONObject _rawData) {
        super();
        this.rawData = _rawData;
    }

    public String getString(String fieldName) throws JSONException {
        return this.rawData.getString(fieldName);
    }

    public PharmacyDataObject buildPharmacyDataObject() {
            String name = "";
            try {
                name = this.rawData.getString("name");
            } catch (JSONException e) {
                // nothing to do
            }

            String address = "";
            try {
                address = this.rawData.getString("address");
            } catch (JSONException e) {
                // nothing to do
            }
            Integer landPhone = 0;
            try {
                landPhone = this.rawData.getInt("landphone");
            } catch (JSONException e) {
                // nothing to do
            }
            Integer alternativePhone = 0;
            try {
                alternativePhone = this.rawData.getInt("alternativePhone");
            } catch (JSONException e) {
                // nothing to do
            }
            return new PharmacyDataObject(name, address, landPhone, alternativePhone);
    }
}

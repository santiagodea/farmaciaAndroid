package ar.com.ciu.pharmapp.PharmacyListPack.analizer;

import org.json.JSONException;
import org.json.JSONObject;

import ar.com.ciu.pharmapp.PharmacyListPack.PharmacyDataObject;

/**
 * Created by santi on 12/12/2017.
 */

public class ApiPharmacyDataAnalizer {
    private JSONObject rawData;

    public ApiPharmacyDataAnalizer(JSONObject _rawData) {
        super();
        this.rawData = _rawData;
    }
/*
    public boolean isOnTarget() throws JSONException {
        return this.getString("subregion").equals("South America") &&
                !(this.getString("name").contains("Falkland")
                        || this.getString("name").contains("South Georgia")
                );
    }
*/
    public String getString(String fieldName) throws JSONException {
        return this.rawData.getString(fieldName);
    }

    public PharmacyDataObject buildPharmacyDataObject() {
       // try {
            //String code = this.getString("alpha3Code");  // este tiene que estar
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
                landPhone = this.rawData.getInt("landPhone");
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
       // } catch (JSONException e) {
          //  e.printStackTrace();
          //  return null;
        //}
    }
}

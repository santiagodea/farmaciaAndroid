package ar.com.ciu.pharmapp.data.analizer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;

/**
 * Created by santi on 12/12/2017.
 */

public class ApiPharmacyListAnalizer {
    JSONArray rawData;
    List<PharmacyDataObject> processedData;

    public ApiPharmacyListAnalizer(JSONArray _rawData) {
        super();
        this.rawData = _rawData;
    }

    private void doProcessData() {
        this.processedData = new ArrayList<>();
        try {
            for (int i = 0; i < this.rawData.length(); i++) {
                JSONObject element = this.rawData.getJSONObject(i);
                ApiPharmacyDataAnalizer elementAnalyzer = new ApiPharmacyDataAnalizer(element);
                    PharmacyDataObject elementAsCountryData = elementAnalyzer.buildPharmacyDataObject();
                    if (elementAsCountryData != null) {
                        this.processedData.add(elementAsCountryData);
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException("Error al procesar la respuesta JSON", e);
        }
    }

    private void checkData() {
        if (this.processedData == null) { this.doProcessData(); }
    }

    public List<PharmacyDataObject> getPharmacyList() {
        this.checkData();
        return this.processedData;
    }
}

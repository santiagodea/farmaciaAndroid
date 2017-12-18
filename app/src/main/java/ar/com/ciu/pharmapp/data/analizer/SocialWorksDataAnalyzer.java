package ar.com.ciu.pharmapp.data.analizer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ar.com.ciu.pharmapp.data.dataObjects.SocialWorkDataObject;

/**
 * Created by Urti on 18/12/2017.
 */

public class SocialWorksDataAnalyzer {

    private JSONArray rawData;
    public SocialWorksDataAnalyzer(JSONArray response){
        this.rawData = response;
    }



    public List<SocialWorkDataObject> getSocialWorksValues(){
        try {
            List<SocialWorkDataObject> result = new ArrayList<>();

            JSONArray socialWorksArray = this.rawData;

            JSONObject tempData;
            for (int i = 0; socialWorksArray.length() > i; i++){
                tempData = socialWorksArray.getJSONObject(i);

                JSONObject socialWorkData = tempData.getJSONObject("socialWork");

                ApiPharmacyListAnalizer pharmListAnalizer = new ApiPharmacyListAnalizer(tempData.getJSONArray("pharmacys"));

                result.add(
                        new SocialWorkDataObject(socialWorkData.getString("name"),
                                socialWorkData.getString("address"),
                                socialWorkData.getString("ladphone"),
                                pharmListAnalizer.getPharmacyList()
                        )
                );
            }
            return result;
        } catch (JSONException e){
            throw new RuntimeException("No se pudo manejar los datos JSON");
        }
    }
}

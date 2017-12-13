package ar.com.ciu.pharmapp.Turnos.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ar.com.ciu.pharmapp.PharmacyListPack.analizer.ApiPharmacyListAnalizer;

/**
 * Created by ramiro on 12/12/17.
 */

public class PharmDataAnalyzer {
    private JSONObject rawData;
    public PharmDataAnalyzer(JSONObject response){
        this.rawData = response;
    }

    public IndexDataObject getIndexValues(){
        try {
            IndexDataObject result = new IndexDataObject();
            JSONObject dateData = this.rawData.getJSONObject("date");
            JSONArray pharmacysDataArray = this.rawData.getJSONArray("shiftPharmacys");
            JSONArray eventDataArray = this.rawData.getJSONArray("eventData");
/*

            SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            Date d = date.parse(dateData.getString("day") +"/" + dateData.getString("month") + "/" +dateData.getString("year"));
*/
            //Fecha
            result.setDate(dateData.getString("day") +"/" + dateData.getString("month") + "/" +dateData.getString("year"));

            //Lista de farmacias
            /*ArrayList<PharmacyDataObject> listPharmacys = new ArrayList<>();
            JSONObject pharmData;
            for (int i = 0; pharmacysDataArray.length() > i; i++){
                pharmData = pharmacysDataArray.getJSONObject(i);
                listPharmacys.add(
                        new PharmacyDataObject( pharmData.getString("name"),
                                                pharmData.getString("address"),
                                                Integer.getInteger(pharmData.getString("landPhone")),
                                                Integer.getInteger(pharmData.getString("alternativePhone"))
                        )
                );
            }
            result.setShiftPharmacys(listPharmacys);*/



            ApiPharmacyListAnalizer pharmListAnalizer = new ApiPharmacyListAnalizer(pharmacysDataArray);
            result.setShiftPharmacys(pharmListAnalizer.getSouthAmericaCountryList());

            //Lista de eventos
            ArrayList<EventDataObject> listEvents = new ArrayList<>();
            JSONObject eventData;
            for (int i = 0; eventDataArray.length() > i; i++){
                 eventData = eventDataArray.getJSONObject(i);
                 listEvents.add(
                         new EventDataObject(eventData.getString("name"),
                                             eventData.getString("title"),
                                             eventData.getString("description")
                         )
                 );
            }
            result.setEventData(listEvents);



            return result;
        }
        catch (JSONException e){
            throw new RuntimeException("No se pudo manejar los datos JSON");
        }
    }
}

package ar.com.ciu.pharmapp.data.dataProvider;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import ar.com.ciu.pharmapp.data.InterfacesConsumer.PharmAccept;
import ar.com.ciu.pharmapp.data.InterfacesConsumer.SocialWorkAccept;
import ar.com.ciu.pharmapp.data.analizer.PharmDataAnalyzer;
import ar.com.ciu.pharmapp.data.analizer.SocialWorksDataAnalyzer;
import ar.com.ciu.pharmapp.tool.ApplicationToolset;

/**
 * Created by ramiro on 11/12/17.
 */

public class PharmDataProvider {

    static String mainApiUrl =  "https://agile-falls-22343.herokuapp.com/api/";

    public static void fetchDateIndex(int desplazamiento, PharmAccept theFunction) {
        String url =  mainApiUrl + "index/" + desplazamiento;
        JsonObjectRequest jsObjectRequest = new JsonObjectRequest
                (url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        PharmDataAnalyzer analyzer = new PharmDataAnalyzer(response);
                        theFunction.accept(analyzer.getIndexValues());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsObjectRequest);
    }

    public static void fetchSocialWorks(SocialWorkAccept theFunction){
        String url = mainApiUrl + "/socialWorks";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest
                (url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        SocialWorksDataAnalyzer analyzer = new SocialWorksDataAnalyzer(response);
                        theFunction.accept(analyzer.getSocialWorksValues());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsonArrayRequest);
    }
}

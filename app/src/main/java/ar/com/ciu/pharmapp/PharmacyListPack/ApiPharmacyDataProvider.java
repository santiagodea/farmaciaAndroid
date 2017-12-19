package ar.com.ciu.pharmapp.PharmacyListPack;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import ar.com.ciu.pharmapp.PharmacyListPack.analizer.ApiPharmacyDataAnalizer;
import ar.com.ciu.pharmapp.PharmacyListPack.analizer.ApiPharmacyListAnalizer;
import ar.com.ciu.pharmapp.Turnos.data.PharmAccept;
import ar.com.ciu.pharmapp.Turnos.data.PharmDataAnalyzer;
import ar.com.ciu.pharmapp.tool.ApplicationToolset;

import static java.net.URLEncoder.encode;

/**
 * Created by santi on 14/12/2017.
 */

public class ApiPharmacyDataProvider extends PharmacyDataProvider {

    @Override
    public void fetchPharmacyList(PharmacyListConsumer theFunction) {
        String url = "https://agile-falls-22343.herokuapp.com/api/farmacias";
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        ApiPharmacyListAnalizer analyzer = new ApiPharmacyListAnalizer(response);
                        theFunction.accept(analyzer.getPharmacyList());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsArrayRequest);
    }

    @Override
    public void fetchPharmacyData(String pharmacyName, PharmacyDataConsumer theFunction) {
        String name = pharmacyName.replace(" ", "%20");
        String url = "https://agile-falls-22343.herokuapp.com/api/farmacia/" + name;
        JsonObjectRequest jsObjectRequest = new JsonObjectRequest
                (url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ApiPharmacyDataAnalizer analyzer = new ApiPharmacyDataAnalizer(response);
                        theFunction.accept(analyzer.buildPharmacyDataObject());
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
}
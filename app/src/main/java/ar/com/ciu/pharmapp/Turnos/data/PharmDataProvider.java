package ar.com.ciu.pharmapp.Turnos.data;

import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import ar.com.ciu.pharmapp.tool.ApplicationToolset;

/**
 * Created by ramiro on 11/12/17.
 */

public class PharmDataProvider {

    public static void fetchDateIndex(int desplazamiento, PharmAccept theFunction) {
        String url =  "http://192.168.0.107:8080/farmacia/api/index/" + desplazamiento;
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
}

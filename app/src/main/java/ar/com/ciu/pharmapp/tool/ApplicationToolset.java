package ar.com.ciu.pharmapp.tool;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import android.content.Context;

/**
 * Created by santi on 12/12/2017.
 */

public class ApplicationToolset {
    private static ApplicationToolset theToolset;

    private Context appContext;
    private RequestQueue requestQueue;


    public static ApplicationToolset toolset() {
        if (theToolset == null) {
            throw new RuntimeException("Hay que setear la aplicacion para usar el ApplicationToolset");
        }
        return theToolset;
    }

    public static void setContext(Context ctx) {
        theToolset = new ApplicationToolset();
        theToolset.setApplicationContext(ctx.getApplicationContext());
    }

    private void setApplicationContext(Context theAppContext) {
        this.appContext = theAppContext;
    }

    public RequestQueue getRequestQueue() {
        if (this.requestQueue == null) {
            this.requestQueue = Volley.newRequestQueue(this.appContext);
        }
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        this.getRequestQueue().add(req);
    }
}
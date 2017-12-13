package ar.com.ciu.pharmapp.Turnos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import ar.com.ciu.pharmapp.R;
import ar.com.ciu.pharmapp.Turnos.data.PharmDataProvider;
import ar.com.ciu.pharmapp.tool.ApplicationToolset;

public class Turnos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);

        ApplicationToolset.setContext(this);

        int offset = 0;

        TextView date = this.findViewById(R.id.fecha);
        ListView pharmacys = this.findViewById(R.id.listaDeFarmacias);
        ListView events = this.findViewById(R.id.listaDeEventos);



        PharmDataProvider.fetchDateIndex(offset,(data) -> {
            date.setText(data.getDate());

            PharmacyAdapter pa = new PharmacyAdapter(this,data.getShiftPharmacys());
            pharmacys.setAdapter(pa);

        });
    }
}

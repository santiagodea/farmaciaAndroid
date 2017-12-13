package ar.com.ciu.pharmapp.Turnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Intent in = getIntent();
        if(in.hasExtra("offset")){
            offset = Integer.parseInt(in.getStringExtra("offset"));
        }

        TextView date = this.findViewById(R.id.fecha);
        ListView pharmacys = this.findViewById(R.id.listaDeFarmacias);
        ListView events = this.findViewById(R.id.listaDeEventos);


        PharmDataProvider.fetchDateIndex(offset,(data) -> {
            date.setText(data.getDate());

            PharmacyAdapter pa = new PharmacyAdapter(this,data.getShiftPharmacys());
            pharmacys.setAdapter(pa);

            EventAdapter ea = new EventAdapter(this,data.getEventData());
            events.setAdapter(ea);

        });

        Button back = this.findViewById(R.id.anterior);
        Button next = this.findViewById(R.id.Siguiente);

        //este final me lo pidio....
        int finalOffset = offset;

        back.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, Turnos.class);
            intent.putExtra("offset", String.valueOf(finalOffset -1));
            startActivity(intent);
        });

        next.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, Turnos.class);
            intent.putExtra("offset", String.valueOf(finalOffset +1));
            startActivity(intent);
        });
    }
}

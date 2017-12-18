package ar.com.ciu.pharmapp.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ar.com.ciu.pharmapp.R;
import ar.com.ciu.pharmapp.adapters.EventAdapter;
import ar.com.ciu.pharmapp.adapters.ListaDeFarmaciasAdapter;
import ar.com.ciu.pharmapp.adapters.PharmacyAdapter;
import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;
import ar.com.ciu.pharmapp.data.dataProvider.PharmDataProvider;
import ar.com.ciu.pharmapp.tool.ApplicationToolset;

public class Turnos extends AppCompatActivity {
    int offset = 0;
    TextView date;
    ListView pharmacys;
    ListView events;
    Button back;
    Button next;

    //private ListaDeFarmaciasAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);

        ApplicationToolset.setContext(this);

        Intent in = getIntent();
        if(in.hasExtra("offset")){
            offset = Integer.parseInt(in.getStringExtra("offset"));
        }

        date = this.findViewById(R.id.fecha);
        pharmacys = this.findViewById(R.id.listaDeFarmacias);
        events = this.findViewById(R.id.listaDeEventos);
        back = this.findViewById(R.id.anterior);
        next = this.findViewById(R.id.Siguiente);


        this.takeData();

        back.setOnClickListener((View v) -> {
            this.offset -=1;
            this.loadMessage();
            this.takeData();
        });

        next.setOnClickListener((View v) -> {
            this.offset +=1;
            this.loadMessage();
            this.takeData();
        });

        pharmacys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PharmacyDataObject selectedData = (PharmacyDataObject) Turnos.this.pharmacys.getAdapter().getItem(position);

                // salto a otra Activity
                Intent intent = new Intent(Turnos.this, Pharmacy.class);
                intent.putExtra("name", selectedData.getName());
                intent.putExtra("address", selectedData.getAddress());
                intent.putExtra("landPhone", String.valueOf(selectedData.getLandphone()));
                intent.putExtra("alternativePhone", String.valueOf(selectedData.getAlternativePhone()));

                startActivity(intent);
            }
        });
    }

    private void loadMessage() {
        date.setText(R.string.aguarde_con);
        pharmacys.setAdapter(new PharmacyAdapter(this, new ArrayList<>()));
        events.setAdapter(new EventAdapter(this, new ArrayList<>()));
    }

    private void takeData() {
        PharmDataProvider.fetchDateIndex(offset,(data) -> {
            if(offset == 0){
                date.setText("AHORA");
            }else {
                date.setText(data.getDate());
            }

            PharmacyAdapter pa = new PharmacyAdapter(this,data.getShiftPharmacys());
            pharmacys.setAdapter(pa);

            EventAdapter ea = new EventAdapter(this,data.getEventData());
            events.setAdapter(ea);

        });
    }
}

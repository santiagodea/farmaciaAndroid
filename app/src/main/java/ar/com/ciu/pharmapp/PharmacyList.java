package ar.com.ciu.pharmapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ar.com.ciu.pharmapp.PharmacyListPack.ListaDeFarmaciasAdapter;
import ar.com.ciu.pharmapp.PharmacyListPack.PharmacyData;

public class PharmacyList extends AppCompatActivity {
    private ListView listView;
    private ListaDeFarmaciasAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_list);


        this.listView = this.findViewById(R.id.listaFarmacias);

        PharmacyList.PharmacyDataProvider.api().fetchPharmacyList((data) -> {
            this.listAdapter = new ListaDeFarmaciasAdapter(this, data);
            this.listView.setAdapter(this.listAdapter);
        });

        // clase anonima: se crea al voleo una clase que
        // implementa la interface AdapterView.OnItemClickListener,
        // y se le hace new a esa clase.
        // la clase no tiene nombre, de ahí lo de "anonima"
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // obtengo el objeto a partir de la posicion, OJO hay que pedirselo al listAdapter
                // ListaDePaisesActivity.this es el "this de afuera"
               PharmacyData selectedData = ListaDeFarmaciasActivity.this.listAdapter.getItem(position);

                // salto a otra Activity
                Intent intent = new Intent(ListaDeFarmaciasActivity.this, DetalleDeFarmaciActivity.class);
                intent.putExtra("countryName", selectedData.getSpanishName());
                intent.putExtra("countryCode", selectedData.getCode());
                startActivity(intent);
            }
        });

    }
    public ListaDeFarmaciasAdapter listAdapter() {
        return this.listAdapter;
    }


}

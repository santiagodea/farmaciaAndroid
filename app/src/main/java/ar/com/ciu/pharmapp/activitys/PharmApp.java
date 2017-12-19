package ar.com.ciu.pharmapp.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ar.com.ciu.pharmapp.R;

public class PharmApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharm_app);


        Button botonIrAListaDeFarmacias = this.findViewById(R.id.listaFarmacias);
        botonIrAListaDeFarmacias.setOnClickListener((View v) -> {
            this.irAListaDeFarmacias();
        });

        Button botonIrATurnos = this.findViewById(R.id.turnos);
        botonIrATurnos.setOnClickListener((View v) -> {
            this.irATurnos();
        });
    }

    public void irATurnos(){
        Intent intent = new Intent(this, Turnos.class);
        startActivity(intent);
    }

    public void irAListaDeFarmacias() {
        Intent intent = new Intent(this, PharmacyList.class);
        startActivity(intent);
    }
}

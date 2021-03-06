package ar.com.ciu.pharmapp.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ar.com.ciu.pharmapp.data.dataProvider.PharmacyDataProvider;
import ar.com.ciu.pharmapp.R;
import ar.com.ciu.pharmapp.tool.ApplicationToolset;

public class Pharmacy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationToolset.setContext(this);
        setContentView(R.layout.activity_pharmacy);

        Intent intent = this.getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String landPhone = intent.getStringExtra("landphone");
        String alternativePhone = intent.getStringExtra("alternativePhone");


        TextView namePharm = this.findViewById(R.id.name);
        TextView addressPharm = this.findViewById(R.id.address);
        TextView landPhonePharm = this.findViewById(R.id.landPhone);
        TextView alternativePhonePharm = this.findViewById(R.id.alternativePhone);


        PharmacyDataProvider.api().fetchPharmacyData(name, (data) -> {
            namePharm.setText(String.valueOf(data.getName()));
            addressPharm.setText(String.valueOf(data.getAddress()));
            landPhonePharm.setText(String.valueOf(data.getLandphone()));
            alternativePhonePharm.setText(String.valueOf(data.getAlternativePhone()));
        });



    }
}

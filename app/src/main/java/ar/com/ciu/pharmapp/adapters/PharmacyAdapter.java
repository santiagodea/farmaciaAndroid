package ar.com.ciu.pharmapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;
import ar.com.ciu.pharmapp.R;

/**
 * Created by ramiro on 13/12/17.
 */

public class PharmacyAdapter extends ArrayAdapter<PharmacyDataObject>{

    private LayoutInflater inflater;

    public PharmacyAdapter(@NonNull Context context, List<PharmacyDataObject> data) {
        super(context,0,R.id.nombre, data);
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.custom_list_item, parent, false);
        }

        View view = super.getView(position, convertView, parent);
        TextView text1 = (TextView) view.findViewById(R.id.nombre);
        TextView text2 = (TextView) view.findViewById(R.id.localPhone);
        TextView text3 = (TextView) view.findViewById(R.id.location);


        PharmacyDataObject item = (PharmacyDataObject) this.getItem(position);

        text1.setText(item.getName());
        text2.setText(String.valueOf(item.getLandphone()));
        text3.setText(item.getAddress());

        return view;
    }
}

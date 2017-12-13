package ar.com.ciu.pharmapp.Turnos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ar.com.ciu.pharmapp.PharmacyListPack.PharmacyDataObject;
import ar.com.ciu.pharmapp.Turnos.data.IndexDataObject;

/**
 * Created by ramiro on 13/12/17.
 */

class PharmacyAdapter extends ArrayAdapter<PharmacyDataObject>{

    private LayoutInflater inflater;

    public PharmacyAdapter(@NonNull Context context, List<PharmacyDataObject> data) {
        super(context,0, data);
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView whereTextMustBeSet = (TextView) convertView;

        PharmacyDataObject item =(PharmacyDataObject) this.getItem(position);

        whereTextMustBeSet.setText(item.getName());

        return convertView; //super.getView(position, convertView, parent);
    }
}

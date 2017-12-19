package ar.com.ciu.pharmapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ar.com.ciu.pharmapp.data.dataObjects.PharmacyDataObject;

/**
 * Created by santi on 6/12/2017.
 */

public class ListaDeFarmaciasAdapter extends ArrayAdapter<PharmacyDataObject> {
    private LayoutInflater inflater;

    public ListaDeFarmaciasAdapter(@NonNull Context context, List<PharmacyDataObject> objects) {
        super(context, 0, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView whereTextMustBeSet = (TextView) convertView;

        PharmacyDataObject item = this.getItem(position);

        whereTextMustBeSet.setText(item.getName());

        return convertView;
    }
}

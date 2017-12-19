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

import ar.com.ciu.pharmapp.data.dataObjects.EventDataObject;

/**
 * Created by ramiro on 13/12/17.
 */

public class EventAdapter extends ArrayAdapter<EventDataObject>{

    private LayoutInflater inflater;

    public EventAdapter(@NonNull Context context, List<EventDataObject> data) {
        super(context,0,android.R.id.text1, data);
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        View view = super.getView(position, convertView, parent);
        TextView text1 = (TextView) view.findViewById(android.R.id.text1);
        TextView text2 = (TextView) view.findViewById(android.R.id.text2);


        EventDataObject item = (EventDataObject) this.getItem(position);

        text1.setText(item.getTitle());
        text2.setText(item.getDescription());

        return view;// convertView; //
    }
}

package com.example.donoralert;

import android.app.*;
import android.view.*;
import android.widget.*;

public class CustomListAdaptor extends ArrayAdapter<Food> {

    private final Activity context;
    private final Food [] foods;

    public CustomListAdaptor(Activity context, Food [] foods)
    {
        super(context, R.layout.activity_listview, foods);
        this.context = context;
        this.foods = foods;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.activity_listview, null, true);

        TextView nameLabel = rowView.findViewById(R.id.namelabel);
        TextView desLabel = rowView.findViewById(R.id.descriptionlabel);

        nameLabel.setText(foods[position].name);
        desLabel.setText(foods [position].description);

        return rowView;
    }

}

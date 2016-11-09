package com.desk.vova.xpens;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by vova on 03/05/2016.
 */
public class PurchaseArrayAdapter extends ArrayAdapter<PurchaseData> {
    Context                 context                                             ;
    int                     layout_resource_id                                  ;
    LinearLayout            purchase_layout                                     ;
    ArrayList<PurchaseData> data                = new ArrayList<PurchaseData>() ;

    public PurchaseArrayAdapter(Context context, int layoutResourceId, ArrayList<PurchaseData> data) {
        super(context, layoutResourceId, data);
        this.layout_resource_id = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layout_resource_id, parent, false);

            purchase_layout = (LinearLayout) row.findViewById(R.id.singlePurchaseView);

            PurchaseData current_purchase_data = data.get(position);


            TextView purchase_date_view = new TextView(context)                                  ;
            purchase_date_view.setText(current_purchase_data.getDateString(getContext()));
            purchase_layout.addView(purchase_date_view);

            TextView purchase_type_view = new TextView(context);
            purchase_type_view.setText(current_purchase_data.getTypeString());
            purchase_layout.addView(purchase_type_view);

            TextView purchase_desc_view = new TextView(context);
            purchase_type_view.setText(current_purchase_data.getDescription());
            purchase_layout.addView(purchase_desc_view);

            TextView purchase_price_view = new TextView(context);
            purchase_type_view.setText(Integer.toString(current_purchase_data.getPrice()));
            purchase_layout.addView(purchase_price_view);

            purchase_layout.setTag(current_purchase_data);
            //Button delete_item_button = new Button(context);
            //delete_item_button.setId(R.integer.delete_beaver_button_offset + beaver_item.getId());
            //Log.d("BeaverArrayAdapter", "getView: created delete button with id " + delete_item_button.getId());
            //BeaverListActivity my_activity = (BeaverListActivity) this.context;
            //delete_item_button.setOnClickListener(my_activity.on_click_listener_delete_beaver);
            //delete_item_button.setText(R.string.delete_menu_item_string);
            //delete_item_button.setFocusable(false);
            //purchase_layout.addView(delete_item_button);
        }
        return row;
    }

}
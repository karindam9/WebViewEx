package com.web.arindam.webviewex.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.web.arindam.webviewex.R;
import com.web.arindam.webviewex.SlidingMenu;

import java.util.ArrayList;

public class SideMenuAdapter extends BaseAdapter {


    ArrayList<SlidingMenu> al_menus=new ArrayList<>();
    Activity context;

    public SideMenuAdapter(Activity context, ArrayList<SlidingMenu> al_menus) {
        super();
        this.context = context;

        this.al_menus.addAll(al_menus);
    }

    private class ViewHolder {
        TextView txt_name;
        //ImageView img_menu;

        //Typeface custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/CaviarDreams.ttf");

        public ViewHolder(View v)
        {

            txt_name=(TextView)v.findViewById(R.id.txt_name);


        }

    }

    public int getCount() {
        return al_menus.size();
    }

    public Object getItem(int position) {
        return al_menus.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.adapter_menu_group, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }
        holder.txt_name.setText(al_menus.get(position).getMenu_name());


        return convertView;

    }

}


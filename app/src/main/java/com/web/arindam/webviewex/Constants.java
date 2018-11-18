package com.web.arindam.webviewex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;


/**
 * Created by webskitters on 4/10/2017.
 */

public class Constants {

    Context con;
    Activity a;


    public Constants(Context con, Activity a)
    {
        this.con=con;
        this.a=a;

        }

    public void openActivity(String event) {

        if (event.equalsIgnoreCase("Home")) {

            if (!(con instanceof ShoppingSite)) {
                Intent intent = new Intent(con, ShoppingSite.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                con.startActivity(intent);

            }

        }

        if (event.equalsIgnoreCase("My Wishlist")) {

            if (!(con instanceof Main2Activity)) {
                Intent intent = new Intent(con, Main2Activity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                con.startActivity(intent);

                if (!(con instanceof ShoppingSite))
                    a.finish();
            }

        } else if (event.equalsIgnoreCase("My Trips")) {
            if (!(con instanceof Main3Activity)) {
                Intent intent = new Intent(con, Main3Activity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                con.startActivity(intent);

                if (!(con instanceof ShoppingSite))
                    a.finish();
            }
        }



    }


        public static ArrayList<SlidingMenu> prepareSideMenu (Activity act){

            ArrayList<SlidingMenu> al_menu_item;  //Array list Class Declare
            SlidingMenu side_menu = new SlidingMenu();  //Model Class Initialize

            al_menu_item = new ArrayList<>();

            side_menu = new SlidingMenu();
            side_menu.setMenu_name("Home");
            al_menu_item.add(side_menu);

            side_menu = new SlidingMenu();
            side_menu.setMenu_name("My Wishlist");
            al_menu_item.add(side_menu);


            side_menu = new SlidingMenu();
            side_menu.setMenu_name("My Trips");
            al_menu_item.add(side_menu);


            return al_menu_item;

        }




}

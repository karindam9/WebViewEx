package com.web.arindam.webviewex;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.web.arindam.webviewex.Adapter.SideMenuAdapter;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawer;
    ListView menu_list;

    ArrayList<SlidingMenu> al_menu_item;
    SideMenuAdapter side_menu;
    NavigationView navigationView;
    private ImageButton img_nav;
    LinearLayout lin_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        img_nav=findViewById(R.id.img_nav);
        lin_nav=findViewById(R.id.lin_nav);


        img_nav.setOnClickListener(this);
        lin_nav.setOnClickListener(this);

        prepareNavigationMenu();

    }

    private void prepareNavigationMenu() {
        menu_list=(ListView)findViewById(R.id.menu_list);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        al_menu_item= Constants.prepareSideMenu(this);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        //txt_nav_name.setText(prefs.getString(Constants.strShPrefUserName, ""));

        side_menu = new SideMenuAdapter(this,al_menu_item);
        menu_list.setAdapter(side_menu);

        menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

                new Constants(Main3Activity.this,Main3Activity.this).openActivity(al_menu_item.get(position).getMenu_name());
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_nav:
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                else
                    drawer.openDrawer(GravityCompat.START);
                break;

            case R.id.lin_nav:
                InputMethodManager iManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                iManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
                else
                    drawer.openDrawer(GravityCompat.START);
                break;

        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}


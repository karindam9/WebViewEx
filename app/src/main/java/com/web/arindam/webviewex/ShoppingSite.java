package com.web.arindam.webviewex;

import android.Manifest;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.web.arindam.webviewex.Adapter.ModelData;
import com.web.arindam.webviewex.Adapter.SideMenuAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingSite extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout rel1,rel3,rel5,rl_dress_off;

    ArrayList<row_model> arrayList1=new ArrayList<>();
    RecyclerView recycler;
    CustomAdapter adapter1;
    LinearLayoutManager layoutManager;

    ArrayList<ModelData> arrayList2=new ArrayList<>();
    RecyclerView recycler1;
    RecyclerAdapter adapter2;
    LinearLayoutManager layoutManager1;

    ImageView img_share;
    ImageView img_love;

    EditText edt_go;
    ImageView search;
    Boolean flag=true;

    ImageView iv_image;
    private Handler handler;
    int pog=0;

    ImageView img_ch;
    private Handler handler1;
    int pog1=0;


    /*For navigationView*/

    ImageView header_img;
//    private byte[] byteArray=null;

    DrawerLayout drawer;
    ListView menu_list;/*For navigationView*/

    ArrayList<SlidingMenu> arrayList;/*For navigationView*/
    SideMenuAdapter adapter;/*For navigationView*/

    NavigationView navigationView;/*For navigationView*/

    private ImageButton img_nav;/*For navigationView*/
    LinearLayout lin_nav;/*For navigationView*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_site);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);//initially hide keyboard

        recycler=findViewById(R.id.recycler);
        rel1=findViewById(R.id.rel1);
        rel3=findViewById(R.id.rel3);
        rel5=findViewById(R.id.rel5);
        rl_dress_off=findViewById(R.id.rl_dress_off);

        recycler1=findViewById(R.id.recycler1);


        img_share=findViewById(R.id.img_share);
        img_love=findViewById(R.id.img_love);

        edt_go=findViewById(R.id.edt_go);
        search=findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() { /*To use Google interface in your application.......*/
            @Override
            public void onClick(View v) {
                onSearchClick(v);
            }
        });/*Background change one after another*/

        iv_image= findViewById(R.id.iv_image);    /*Background change one after another*/
        handler = new Handler();/*Background change one after another*/
        startProgress();/*Background change one after another*/

        img_ch= findViewById(R.id.img_ch);    /*Background change one after another*/
        handler = new Handler();/*Background change one after another*/
        startProgress1();/*Background change one after another*/



        img_nav=findViewById(R.id.img_nav);/*For navigationView*/
        lin_nav=findViewById(R.id.lin_nav);/*For navigationView*/

        header_img=findViewById(R.id.header_img);


        img_nav.setOnClickListener(ShoppingSite.this);/*For navigationView*/
        lin_nav.setOnClickListener(ShoppingSite.this);/*For navigationView*/

        header_img.setOnClickListener(this);

        prepareNavigationMenu();/*For navigationView*/



        arrayList1.add(new row_model(R.mipmap.images));
        arrayList1.add(new row_model(R.mipmap.flipkart));
        arrayList1.add(new row_model(R.mipmap.snapdeal));
        arrayList1.add(new row_model(R.mipmap.shop));
        arrayList1.add(new row_model(R.mipmap.limeroad));
        arrayList1.add(new row_model(R.mipmap.homeshop));
        arrayList1.add(new row_model(R.mipmap.jabong));
        arrayList1.add(new row_model(R.mipmap.my));

        adapter1=new CustomAdapter(arrayList1,this);

//        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter1);

       /* recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {

                    }
                })
        );*/
       arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));
        arrayList2.add(new ModelData(R.mipmap.dress1,R.mipmap.love_img,false));

        adapter2=new RecyclerAdapter(arrayList2, this, new RecyclerAdapter.OnRowClick() {
            @Override
            public void onLike(int po) {
                arrayList2.get(po).setB_flag(!arrayList2.get(po).isB_flag());
                if(arrayList2.get(po).isB_flag()){
                    Toast.makeText(ShoppingSite.this,"Add to f",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ShoppingSite.this,"Remove to f",Toast.LENGTH_LONG).show();
                }
                adapter2.notifyDataSetChanged();
            }
        });
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this, 2);
        recycler1.setLayoutManager(layoutManager1);
        recycler1.setItemAnimator(new DefaultItemAnimator());
        recycler1.setAdapter(adapter2);



        rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShoppingSite.this,CuponGuru.class);

                startActivity(intent);
            }
        });

        rel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ShoppingSite.this,DealsofDay.class);

                startActivity(intent);
            }
        });
        rel5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(ShoppingSite.this,DealsofDay.class);

                startActivity(intent);
            }
        });
        rl_dress_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShoppingSite.this,Dressoff.class);

                startActivity(intent);
            }
        });

        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));

            }
        });

    img_love.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

//                Toast.makeText(ShoppingSite.this, "Added to favourite", Toast.LENGTH_SHORT).show();
//                img_love.setImageResource(R.mipmap.blubr_save_red);
//
//                img_love.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Toast.makeText(ShoppingSite.this, "Removed from favourite", Toast.LENGTH_SHORT).show();
//                        img_love.setImageResource(R.mipmap.blubr_save);
//                    }
//                });

            if(flag==true){
                Toast.makeText(ShoppingSite.this, "Added to favourite", Toast.LENGTH_SHORT).show();
                img_love.setImageResource(R.mipmap.blubr_save_red);

                flag=false;
            }
            else{
                Toast.makeText(ShoppingSite.this, "Removed from favourite", Toast.LENGTH_SHORT).show();
                img_love.setImageResource(R.mipmap.blubr_save);

                flag=true;
            }


            }

    });



        }



    private void startProgress() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
//                    final int currentProgressCount = i;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                  Update the value background thread to UI thread
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pog++;
                            switch (pog%5){
                                case 0:
                                    iv_image.setImageResource(R.drawable.background1);
                                    break;
                                case 1:
                                    iv_image.setImageResource(R.drawable.background2);

                                    break;
                                case 2:
                                    iv_image.setImageResource(R.drawable.background3);

                                    break;
                                case 3:
                                    iv_image.setImageResource(R.drawable.background4);

                                    break;
                                case 4:
                                    iv_image.setImageResource(R.drawable.background5);

                                    break;
                            }

                        }
                    });
                }
            }
        }).start();

    }

    private void startProgress1() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
//                    final int currentProgressCount = i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                  Update the value background thread to UI thread
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pog1++;
                            switch (pog1%5){
                                case 0:
                                    img_ch.setImageResource(R.mipmap.shopping);
                                    break;
                                case 1:
                                    img_ch.setImageResource(R.mipmap.retail);

                                    break;
                                case 2:
                                    img_ch.setImageResource(R.mipmap.bjb);

                                    break;
                                case 3:
                                    img_ch.setImageResource(R.mipmap.jhjhklh);

                                    break;
                                case 4:
                                    img_ch.setImageResource(R.mipmap.shopm);

                                    break;
                            }

                        }
                    });
                }
            }
        }).start();

    }



    public void onSearchClick(View v)  /*To use Google interface in your application.......*/
    {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            String term = edt_go.getText().toString();
            intent.putExtra(SearchManager.QUERY, term);
            startActivity(intent);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    /*For navigationView.....*/

    private void prepareNavigationMenu() {

        menu_list=(ListView)findViewById(R.id.menu_list);  //ListView

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        arrayList= Constants.prepareSideMenu(this);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        adapter = new SideMenuAdapter(this,arrayList);

        menu_list.setAdapter(adapter);

        menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }

                new Constants(ShoppingSite.this,ShoppingSite.this).openActivity(arrayList.get(position).getMenu_name());
            }
        });

    }

    /*For navigationView.......*/

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.img_nav:

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


            case R.id.header_img:


                        permissionMars();


                break;

        }

    }
    /*For navigationView......*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void permissionMars() {
        List<String> permissionsNeeded = new ArrayList<String>();

        final List<String> permissionsList = new ArrayList<String>();

        if (!addPermission(permissionsList, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) /*Show addPermission method step 2*/
            permissionsNeeded.add("WRITE_EXTERNAL_STORAGE");
        if (!addPermission(permissionsList, android.Manifest.permission.CAMERA))
            permissionsNeeded.add("CAMERA");

        if(!addPermission(permissionsList, Manifest.permission.READ_EXTERNAL_STORAGE))
            permissionsNeeded.add("READ_EXTERNAL_STORAGE");

        if (permissionsList.size() > 0) {  /*Step 3*/
            if (permissionsNeeded.size() > 0) {
                // Need Rationale
                String message = "You need to grant  access to " + permissionsNeeded.get(0);
                for (int i = 1; i < permissionsNeeded.size(); i++)
                    message = message + ", " + permissionsNeeded.get(i);

                showMessageOKCancel(ShoppingSite.this, message,  /*Show showMessageOKCancel method step 4 */
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {



                                ActivityCompat.requestPermissions(ShoppingSite.this,
                                        permissionsList.toArray(new String[permissionsList.size()]),
                                        100);

                            }
                        });
                return;
            }

            /*For 2nd time after all permission granted*/
            ActivityCompat.requestPermissions(this, permissionsList.toArray(new String[permissionsList.size()]),
                    100);
//            captureImage();
            return;
        }


        else{

            captureImage(); /*Step 5*/
        }
    }



    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 10);
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  /*Step 6*/

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10){
            if(resultCode == RESULT_OK) {

                onCaptureImageResult(data);  /*Step 7*/
            }
            else{
                if (resultCode == RESULT_CANCELED) {
                    // user cancelled Image capture
                    Toast.makeText(this,
                            "User cancelled image capture", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    // failed to capture image

                    Toast.makeText(this,
                            "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                            .show();

                }
            }
        }


    }

    private void onCaptureImageResult(Intent data) {
        Bitmap photo = (Bitmap) data.getExtras().get("data");
        header_img.setImageBitmap(photo);  /*Step 8*/

//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byteArray = stream.toByteArray();
        //photo.recycle();

    }

    public static void showMessageOKCancel(Context context, String message, DialogInterface.OnClickListener okListener) { /*Step 4 */
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    private boolean addPermission(List<String> permissionsList, String permission) {  /*Step 2*/
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
            // Check for Rationale Option
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission))
                return false;
        }
        return true;
    }




}

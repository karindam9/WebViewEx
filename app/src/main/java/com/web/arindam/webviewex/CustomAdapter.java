package com.web.arindam.webviewex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyRecyclerAdapter> {


    ArrayList<row_model>arrayList=new ArrayList<>();
    Context context;

    public CustomAdapter(ArrayList<row_model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.MyRecyclerAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_demo,viewGroup,false);

        return new MyRecyclerAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyRecyclerAdapter myRecyclerAdapter, final int position) {

        myRecyclerAdapter.img_amazon.setImageResource(arrayList.get(position).getImg_amazon());


        myRecyclerAdapter.img_amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){

                    Intent intent=new Intent(context,AmazonSite.class);
                    intent.putExtra("a","http://www.amazon.in");

                    context.startActivity(intent);
                }
                else if(position==1){
                    Intent intent=new Intent(context,FlipkartSite.class);
                    intent.putExtra("b","http://www.flipkart.com");

                    context.startActivity(intent);
                }
                else if(position==2){
                    Intent intent=new Intent(context,Snapdeal.class);

                    context.startActivity(intent);
                }
                else if(position==3){
                    Intent intent=new Intent(context,ShopClues.class);

                    context.startActivity(intent);
                }
                else if(position==4){
                    Intent intent=new Intent(context,LimeRoad.class);

                    context.startActivity(intent);
                }
                else if(position==5){
                    Intent intent=new Intent(context,HomeShop.class);

                    context.startActivity(intent);
                }
                else if(position==6){
                    Intent intent=new Intent(context,Jabong.class);

                    context.startActivity(intent);
                }
                else if(position==7){
                    Intent intent=new Intent(context,Myntra.class);

                    context.startActivity(intent);
                }

            }
        });
        
        }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyRecyclerAdapter extends RecyclerView.ViewHolder {

        ImageView img_amazon;
        RelativeLayout rel;

        public MyRecyclerAdapter(@NonNull View itemView) {
            super(itemView);

            img_amazon=itemView.findViewById(R.id.img_amazon);
            rel=itemView.findViewById(R.id.rel);


        }
    }
}

package com.web.arindam.webviewex;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.web.arindam.webviewex.Adapter.ModelData;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayList<ModelData>arrayList=new ArrayList<>();
    Context context;
    OnRowClick onRowClick;

    public RecyclerAdapter(ArrayList<ModelData> arrayList, Context context,OnRowClick onRowClick) {
        this.arrayList = arrayList;
        this.context = context;
        this.onRowClick = onRowClick;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlistdemo,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.IM_img.setImageResource(arrayList.get(position).getIM_img());
        myViewHolder.i_love.setImageResource(arrayList.get(position).getI_love());

        myViewHolder.i_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRowClick.onLike(position);

            }
        });
        myViewHolder.IM_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent in=new Intent(context,Dress1.class);
                    context.startActivity(in);

                }
            }
        });

        if(arrayList.get(position).isB_flag()){
            myViewHolder.i_love.setImageResource(R.mipmap.blubr_save_red);
        }
        else {
            myViewHolder.i_love.setImageResource(R.mipmap.love_img);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView IM_img,i_love;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            IM_img=itemView.findViewById(R.id.IM_img);
            i_love=itemView.findViewById(R.id.i_love);


        }
    }
    interface OnRowClick{
        void onLike(int po);
    }
}

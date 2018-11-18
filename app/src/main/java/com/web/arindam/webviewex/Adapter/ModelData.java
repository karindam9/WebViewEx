package com.web.arindam.webviewex.Adapter;

public class ModelData {
    private   int IM_img;
    private int i_love;
    private boolean b_flag=false;


    public int getI_love() {
        return i_love;
    }

    public void setI_love(int i_love) {
        this.i_love = i_love;
    }

    public ModelData(int IM_img, int i_love,boolean b_flag) {
        this.IM_img = IM_img;
        this.i_love = i_love;
        this.b_flag = b_flag;
    }

    public int getIM_img() {
        return IM_img;
    }

    public void setIM_img(int IM_img) {
        this.IM_img = IM_img;
    }

    public boolean isB_flag() {
        return b_flag;
    }

    public void setB_flag(boolean b_flag) {
        this.b_flag = b_flag;
    }
}

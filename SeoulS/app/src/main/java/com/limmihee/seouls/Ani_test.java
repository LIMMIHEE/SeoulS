package com.limmihee.seouls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Ani_test {

    private String Sp_name;
    private String simple_info;
    private  String long_ingo;
    private String Image_name;

    public Ani_test(String sp_name, String simple_info, String long_ingo, String image_name) {
        Sp_name = sp_name;
        this.simple_info = simple_info;
        this.long_ingo = long_ingo;
        Image_name = image_name;
    }

    public String getSp_name() {
        return Sp_name;
    }

    public void setSp_name(String sp_name) {
        Sp_name = sp_name;
    }

    public String getSimple_info() {
        return simple_info;
    }

    public void setSimple_info(String simple_info) {
        this.simple_info = simple_info;
    }

    public String getLong_ingo() {
        return long_ingo;
    }

    public void setLong_ingo(String long_ingo) {
        this.long_ingo = long_ingo;
    }

    public String getImage_name() {
        return Image_name;
    }

    public void setImage_name(String image_name) {
        Image_name = image_name;
    }


}

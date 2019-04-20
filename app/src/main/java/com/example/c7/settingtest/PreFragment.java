package com.example.c7.settingtest;

/**
 * Created by c7 on 2019/4/10.
 */

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class PreFragment extends PreferenceFragment{
   @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //从xml文件中加载选项
       addPreferencesFromResource(R.xml.preference);
   }
}

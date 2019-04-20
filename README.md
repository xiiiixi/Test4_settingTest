# Test4_settingTest
这是设置界面的实验

# 实验四
学号：123012016072 
姓名：陈琪
班级：软工2班

## 一、实验内容
实现设置Activity：
总共四组设置项
1、In-line preferences
CheckBoxPreference
2、Dialog-based preferences:
EditTextPreference
ListPreference
3、Launch preferences
PreferenceScreen: 跳转到另一个PreferenceScreen
PreferenceScreen: 启动一个网页
4、Preference attributes
CheckBox: 父选项
CheckBox: 子选项，当父选项勾选时呈现
## 二、实验步骤和结果
### (1)关键代码：
**1、MainActivity.java:**
```
package com.example.c7.settingtest;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //加载Fragment
        FragmentManager fragmentManager=getFragmentManager();
        //开启一个新事务
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        PreFragment preFragment=new PreFragment();
        transaction.add(R.id.frag_example,preFragment);
        transaction.commit();
    }
}

```
**2、PreFragment.java:**
```
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

```

**3、preference.xml:**
```
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android">
    <!--此文件为设置加载的布局文件-->
    <PreferenceCategory
    android:title="@string/in_line">
    <CheckBoxPreference
        android:title="@string/checkboxPreference"
        android:summary="@string/this_is_a_checkbox"/>
    </PreferenceCategory>
    <PreferenceCategory
        android:title="@string/dialog_based">
        <EditTextPreference
           android:title="@string/edit_text"
            android:summary="@string/uses_an_edit_text_dialog"
            android:dialogTitle="@string/enter_your_favorite_animal"/>
        <ListPreference
            android:title="@string/list"
            android:summary="@string/uses_a_list_dialog"
            android:dialogTitle="@string/choose_one"
            android:entries="@array/option"
            android:entryValues="@array/option"/>
    </PreferenceCategory>

    <PreferenceCategory
        android:title="@string/launch">
        <!-- 子屏幕形式 -->
        <PreferenceScreen
            android:title="@string/screen_preference"
            android:summary="@string/show_screen">
          <CheckBoxPreference
            android:title="@string/toggle_preference"
            android:summary="@string/next_screen"/>
        </PreferenceScreen>
        <PreferenceScreen
            android:title="@string/intent"
            android:summary="@string/intent_content">
           <intent
            android:action="android.intent.action.VIEW"
            android:data="https://developer.android.google.cn/"/>
        </PreferenceScreen>
    </PreferenceCategory>


    <!--设置项关联，选中父选项时，子选项才显示。使用dependency属性-->
    <PreferenceCategory
        android:title="@string/attributes">
       <CheckBoxPreference
           android:key="@string/parent_checkbox"
           android:title="@string/parent_checkbox_preference"
           android:summary="@string/parent_content"/>
        <!-- 子类的可见类型是由样式属性定义的 -->
        <CheckBoxPreference
            android:title="@string/child_checkbox_preference"
            android:summary="@string/child_content"
            android:dependency="@string/parent_checkbox"/>
    </PreferenceCategory>
</PreferenceScreen>

```


### (2)结果截图：
#### 1、设置界面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105051381.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105103450.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)

#### 2、点击复选框：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105151273.jpg)

#### 3、对话框：输入最喜欢的动物
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105351469.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)

#### 4、点击ListPreference
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105452312.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)

#### 5、点击ScreenPreference，跳转子屏幕
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019042010555987.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105547347.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)

#### 6、点击IntentPreference，启动外部网站
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105659324.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105708609.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)

#### 7、点击ParentCheckboxPreference，设置项关联，选中父选项时，子选项才显示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190420105807439.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZpdmljNw==,size_16,color_FFFFFF,t_70)

## 三、总结
  1、
  https://developer.android.google.cn/guide/topics/ui/settings.html
  2、子屏幕形式除了<PreferenceScreen>嵌套<PreferenceScreen>方法，还有创建标头文件形式：header。






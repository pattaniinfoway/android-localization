package com.pti.localisaztion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {


    RadioGroup language_Selection;
    Context mContext;
    RadioButton english,chinee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        language_Selection=(RadioGroup)findViewById(R.id.language_Selection);
        english=(RadioButton) findViewById(R.id.english);
        chinee=(RadioButton) findViewById(R.id.chinee);

        if (LocaleHelper.getLanguage(mContext).equals("en")) {
            english.setChecked(true);
        }else if (LocaleHelper.getLanguage(mContext).equals("zh")){
            chinee.setChecked(true);
        }

        language_Selection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.english)
                {
                    LocaleHelper.setLocale(mContext, "en");
                }else{
                    LocaleHelper.setLocale(mContext, "zh");
                }
                recreate();
            }
        });
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }
}

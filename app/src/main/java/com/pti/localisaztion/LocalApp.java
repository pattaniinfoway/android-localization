package com.pti.localisaztion;

import android.app.Application;
import android.content.Context;

public class LocalApp extends Application {


    public static final String LOGTAG = LocalApp.class
            .getSimpleName();
    private static LocalApp mInstance;



    public static synchronized LocalApp getInstance() {
        return mInstance;
    }
}

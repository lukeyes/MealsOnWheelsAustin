
package com.mowaa.mealsonwheels.app;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MealsOnWheelsApp extends Application {

    private static Context mContext;
    public static MealsOnWheelsApp defaultInstance;

    @Override
    public void onCreate() {
        MealsOnWheelsApp.mContext = getApplicationContext();
        MealsOnWheelsApp.defaultInstance = this;
        initialize();
    }

    public static MealsOnWheelsApp getInstance() {
        return MealsOnWheelsApp.defaultInstance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    // Context for routines not explicitly in an Activity.
    public static Context getAppContext() {
        return mContext;
    }

    public static boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) MealsOnWheelsApp.mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    private void initialize() {
    }
}

package pe.com.unispan.mobile;

import android.util.Log;

import com.orm.SugarApp;

import pe.com.unispan.mobile.model.User;
import pe.com.unispan.mobile.storage.ExternalStorage;

/**
 * Created by emarquez on 01/10/16.
 */

public class MobileApp extends SugarApp {
    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("STATE", "Leer de memoria");

        ExternalStorage externalStorage = new ExternalStorage(getApplicationContext());
        User user = User.getInstance();
        user.setLogin(externalStorage.getKeptName());
        //mEmailView.setText(email);
/*
        Intent loginActivity = new Intent(MobileApp.this, LoginActivity.class);
        startActivity(loginActivity);*/
    }
}

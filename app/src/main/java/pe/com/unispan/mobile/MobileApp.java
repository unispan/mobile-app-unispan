package pe.com.unispan.mobile;

import android.util.Log;

import com.orm.SugarApp;

import pe.com.unispan.mobile.model.DevolutionService;
import pe.com.unispan.mobile.model.User;
import pe.com.unispan.mobile.storage.ExternalStorage;

/**
 * Created by emarquez on 01/10/16.
 */

public class MobileApp extends SugarApp {
    private DevolutionService service = new DevolutionService();

  // @Override
  //  public void onCreate() {
  //      super.onCreate();

/*        Log.d("STATE", "Leer de memoria");

        ExternalStorage externalStorage = new ExternalStorage(getApplicationContext());
        User userModel = User.getInstance();
        userModel.setLogin(externalStorage.getKeptName());
        userModel.setUserName(externalStorage.getKeptName()); // Se debe cambiar por el nombre real*/
   // }

    public DevolutionService getService() {
        return service;
    }

    public void setService(DevolutionService service) {
        this.service = service;
    }
}

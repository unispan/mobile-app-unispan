package pe.com.unispan.mobile;

import com.orm.SugarApp;

import pe.com.unispan.mobile.model.DevolutionsService;

/**
 * Created by emarquez on 01/10/16.
 */

public class MobileApp extends SugarApp {
    private DevolutionsService service = new DevolutionsService();

  // @Override
  //  public void onCreate() {
  //      super.onCreate();

/*        Log.d("STATE", "Leer de memoria");

        ExternalStorage externalStorage = new ExternalStorage(getApplicationContext());
        User userModel = User.getInstance();
        userModel.setLogin(externalStorage.getKeptName());
        userModel.setUserName(externalStorage.getKeptName()); // Se debe cambiar por el nombre real*/
   // }

    public DevolutionsService getService() {
        return service;
    }

    public void setService(DevolutionsService service) {
        this.service = service;
    }
}

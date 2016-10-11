package pe.com.unispan.mobile;

import com.orm.SugarApp;

import pe.com.unispan.mobile.model.DevolutionsService;
import pe.com.unispan.mobile.model.EquipmentsService;
import pe.com.unispan.mobile.model.GroupsService;

/**
 * Created by emarquez on 01/10/16.
 */

public class MobileApp extends SugarApp {
    private DevolutionsService service = new DevolutionsService();
    private GroupsService groupsService = new GroupsService();
    private EquipmentsService equipmentsService = new EquipmentsService();

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

    public GroupsService getGroupsService() {
        return groupsService;
    }

    public void setGroupsService(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    public EquipmentsService getEquipmentsService() {
        return equipmentsService;
    }

    public void setEquipmentsService(EquipmentsService equipmentsService) {
        this.equipmentsService = equipmentsService;
    }
}

package pe.com.unispan.mobile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emarquez on 10/10/2016.
 */

public class GroupsService {
    private List<Grupo> grupos = new ArrayList<>();

    public List<Grupo> getGrupos() {
        grupos = Grupo.listAll(Grupo.class);
        if (grupos.size() == 0) {
            this.initializeData();
        }
        return grupos;
    }

    public boolean addGroup(String nameGroup, String countGroup) {
        if (findGroupByNameGroup(nameGroup) != null) return false;
        Grupo grupo = new Grupo(nameGroup, countGroup);
        this.grupos.add(grupo);
        grupo.save();
        return true;
    }

    public Grupo findGroupByNameGroup(String nameGroup) {
        Grupo grupo = null;
        List<Grupo> results = Grupo.find(Grupo.class, "name_group = ?", nameGroup);
        if (results != null && results.size() > 0)
            grupo = results.get(0);
        return grupo;
    }

    private void initializeData() {
        this.addGroup("Encofrados Allstell", "0 de 4");
        this.addGroup("Sistemas Trepantes", "0 de 4");
        this.addGroup("Encofrados Duo", "0 de 4");
        this.addGroup("Mesas Voladoras", "0 de 4");
    }
}

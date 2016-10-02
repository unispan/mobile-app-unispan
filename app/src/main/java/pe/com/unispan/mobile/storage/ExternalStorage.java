package pe.com.unispan.mobile.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by emarquez on 01/10/16.
 */

public class ExternalStorage {
    // Preferences parameters
    private static final String PREFS = "prefs";
    private static final String PREF_NAME = "name";
    Context context;

    public ExternalStorage(Context context){
        this.context = context;
    }

    // Preferences object
    SharedPreferences sharedPreferences;

    public void setKeptName(String name) {
        // Stores given name in Preferences
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        }

        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString(PREF_NAME, name);
        e.commit();
    }

    public String getKeptName() {
        // Obtains stored name if present,
        // otherwise returns an empty string
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        }
        return sharedPreferences.getString(PREF_NAME, "");
    }
}

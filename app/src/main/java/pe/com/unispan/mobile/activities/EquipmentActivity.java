package pe.com.unispan.mobile.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import pe.com.unispan.mobile.MobileApp;
import pe.com.unispan.mobile.R;
import pe.com.unispan.mobile.adapters.EquipmentsAdapter;
import pe.com.unispan.mobile.adapters.GroupsAdapter;
import pe.com.unispan.mobile.model.EquipmentsService;
import pe.com.unispan.mobile.model.GroupsService;

public class EquipmentActivity extends AppCompatActivity {

    RecyclerView equipmentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("Devolution", "Crear equipmentRecyclerView 1");
        equipmentRecyclerView = (RecyclerView) findViewById(R.id.equipmentRecyclerView);
        Log.d("Devolution", "Crear equipmentRecyclerView 2");
        equipmentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("Devolution", "Crear equipmentRecyclerView 3");
        equipmentRecyclerView.setAdapter(new EquipmentsAdapter(getService().getEquipments()));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private EquipmentsService getService() {
        return ((MobileApp) getApplication()).getEquipmentsService();
    }
}

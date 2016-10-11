package pe.com.unispan.mobile.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.com.unispan.mobile.R;
import pe.com.unispan.mobile.activities.EquipmentActivity;
import pe.com.unispan.mobile.model.Equipment;

/**
 * Created by emarquez on 10/10/2016.
 */

public class EquipmentsAdapter extends
        RecyclerView.Adapter<EquipmentsAdapter.ViewHolder> {
    private List<Equipment> equipments;

    public EquipmentsAdapter(List<Equipment> equipments) {
        this.setEquipments(equipments);
    }

    @Override
    public EquipmentsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_equipment, parent, false);
        EquipmentsAdapter.ViewHolder viewHolder = new EquipmentsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            EquipmentsAdapter.ViewHolder holder, final int position) {
        holder.nameEquipmentTextView.setText(
                getEquipments().get(position).getNameEquipment());
        holder.stateEquipmentTextView.setText(
                getEquipments().get(position).getStateEquipment());
        // Make element clickable
        holder.equipmentCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), EquipmentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameEquipment", getEquipments().get(position).getNameEquipment());
                bundle.putString("stateEquipment", getEquipments().get(position).getStateEquipment());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getEquipments().size();
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView equipmentCardView;
        TextView nameEquipmentTextView;
        TextView stateEquipmentTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            equipmentCardView = (CardView) itemView.findViewById(R.id.equipmentCardView);
            nameEquipmentTextView = (TextView) itemView.findViewById(R.id.nameEquipmentTextView);
            stateEquipmentTextView = (TextView) itemView.findViewById(R.id.stateEquipmentTextView);
        }
    }
}

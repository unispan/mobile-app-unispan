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
import pe.com.unispan.mobile.model.Grupo;

/**
 * Created by emarquez on 10/10/2016.
 */
public class GroupsAdapter extends
        RecyclerView.Adapter<GroupsAdapter.ViewHolder> {
    private List<Grupo> grupos;

    public GroupsAdapter(List<Grupo> grupos) {
        this.setGrupos(grupos);
    }

    @Override
    public GroupsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_group, parent, false);
        GroupsAdapter.ViewHolder viewHolder = new GroupsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            GroupsAdapter.ViewHolder holder, final int position) {
        holder.nameGroupTextView.setText(
                getGrupos().get(position).getNameGroup());
        holder.countGroupTextView.setText(
                getGrupos().get(position).getCountGroup());
        // Make element clickable
        holder.groupCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), EquipmentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nameGroup", getGrupos().get(position).getNameGroup());
                bundle.putString("countGroup", getGrupos().get(position).getCountGroup());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getGrupos().size();
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView groupCardView;
        TextView nameGroupTextView;
        TextView countGroupTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            groupCardView = (CardView) itemView.findViewById(R.id.groupCardView);
            nameGroupTextView = (TextView) itemView.findViewById(R.id.nameGroupTextView);
            countGroupTextView = (TextView) itemView.findViewById(R.id.countGroupTextView);
        }
    }
}

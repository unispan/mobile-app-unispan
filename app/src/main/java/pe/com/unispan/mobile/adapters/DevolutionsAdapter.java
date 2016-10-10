package pe.com.unispan.mobile.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.com.unispan.mobile.R;
import pe.com.unispan.mobile.activities.DevolutionActivity;
import pe.com.unispan.mobile.activities.MainActivity;
import pe.com.unispan.mobile.model.Devolution;

/**
 * Created by emarquez on 3/10/2016.
 */
public class DevolutionsAdapter extends
        RecyclerView.Adapter<DevolutionsAdapter.ViewHolder> {
    private List<Devolution> devolutions;

    public DevolutionsAdapter(List<Devolution> devolutions) {
        this.setDevolutions(devolutions);
    }

    @Override
    public DevolutionsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_devolution, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(
            DevolutionsAdapter.ViewHolder holder, final int position) {
        holder.customerTextView.setText(
                getDevolutions().get(position).getCustomer());
        holder.buildTextView.setText(
                getDevolutions().get(position).getBuilding());
        holder.pictureImageView.setImageResource(
                Integer.parseInt(
                        getDevolutions().get(position).getPictureUri()));
        // Make element clickable
        holder.devolutionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), DevolutionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("customer", getDevolutions().get(position).getCustomer());
                bundle.putString("build", getDevolutions().get(position).getBuilding());
                bundle.putString("pictureUri", getDevolutions().get(position).getPictureUri());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getDevolutions().size();
    }

    public List<Devolution> getDevolutions() {
        return devolutions;
    }

    public void setDevolutions(List<Devolution> devolutions) {
        this.devolutions = devolutions;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView devolutionCardView;
        ImageView pictureImageView;
        TextView customerTextView;
        TextView buildTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            devolutionCardView = (CardView) itemView.findViewById(R.id.devolutionCardView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
            customerTextView = (TextView) itemView.findViewById(R.id.customerTextView);
            buildTextView = (TextView) itemView.findViewById(R.id.buildTextView);
        }
    }
}

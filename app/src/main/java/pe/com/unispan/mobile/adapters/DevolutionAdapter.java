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
import pe.com.unispan.mobile.activities.MainActivity;
import pe.com.unispan.mobile.model.Devolution;

/**
 * Created by emarquez on 3/10/2016.
 */

public class DevolutionAdapter extends
        RecyclerView.Adapter<DevolutionAdapter.ViewHolder> {
    private List<Devolution> devolution;

    public DevolutionAdapter(List<Devolution> devolution) {
        this.setDevolution(devolution);
    }

    @Override
    public DevolutionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DevolutionAdapter.ViewHolder holder, final int position) {
        holder.customerTextView.setText(
                getDevolution().get(position).getCustomer());
        holder.buildTextView.setText(
                getDevolution().get(position).getBuilding());
        holder.pictureImageView.setImageResource(
                Integer.parseInt(
                        getDevolution().get(position).getPictureUri()));
        // Make element clickable
        holder.devolutionCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itemIntent = new Intent(view.getContext(), MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("customer", getDevolution().get(position).getCustomer());
                bundle.putString("build", getDevolution().get(position).getBuilding());
                bundle.putString("pictureUri", getDevolution().get(position).getPictureUri());
                itemIntent.putExtras(bundle);
                view.getContext().startActivity(itemIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public List<Devolution> getDevolution() {
        return devolution;
    }

    public void setDevolution(List<Devolution> devolution) {
        this.devolution = devolution;
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

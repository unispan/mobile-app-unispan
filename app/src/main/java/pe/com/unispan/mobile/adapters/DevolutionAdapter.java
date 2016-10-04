package pe.com.unispan.mobile.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.com.unispan.mobile.R;
import pe.com.unispan.mobile.model.Devolution;

/**
 * Created by emarquez on 3/10/2016.
 */

public class DevolutionAdapter extends RecyclerView.Adapter<DevolutionAdapter.ViewHolder> {
    private List<Devolution> devolution;

    public DevolutionAdapter(List<Devolution> devolution) {
        this.setDevolution(devolution);
    }

    @Override
    public DevolutionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout)
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

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
        public ViewHolder(View itemView) {
            super(itemView);
        }
/*        CardView quoteCardView;
        ImageView pictureImageView;
        TextView phraseTextView;
        TextView authorTextView;
        public ViewHolder(View itemView) {
            super(itemView);
            quoteCardView = (CardView) itemView.findViewById(R.id.quoteCardView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
            phraseTextView = (TextView) itemView.findViewById(R.id.phraseTextView);
            authorTextView = (TextView) itemView.findViewById(R.id.authorTextView);
        }*/
    }
}

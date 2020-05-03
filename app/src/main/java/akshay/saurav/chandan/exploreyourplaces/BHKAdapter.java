package akshay.saurav.chandan.exploreyourplaces;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import akshay.saurav.chandan.exploreyourplaces.model.BhkModel;
import akshay.saurav.chandan.exploreyourplaces.services.BhkApi;


class BHKAdapter extends RecyclerView.Adapter<BHKAdapter.ViewHolder> {

    private List<BhkModel>  bhkDatalist;
    private Context context;


    public BHKAdapter(List<BhkApi> adslist, BHK context) {
        this.bhkDatalist = bhkDatalist;
        this.context = context;
    }

    @NonNull
    @Override
    public BHKAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.content_bhk,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BHKAdapter.ViewHolder holder, int position) {
        BhkModel bhkModel=bhkDatalist.get(position);

        holder.type.setText(bhkModel.getPropertyType());
        holder.rate.setText(bhkModel.getPrice());
        holder.location.setText(bhkModel.getLocation());
    }

    @Override
    public int getItemCount() {
        return bhkDatalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView   type,rate,location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.imageView3);
            type=itemView.findViewById(R.id.tv1);
            rate=itemView.findViewById(R.id.tv2);
            location=itemView.findViewById(R.id.tv3);
        }
    }
}




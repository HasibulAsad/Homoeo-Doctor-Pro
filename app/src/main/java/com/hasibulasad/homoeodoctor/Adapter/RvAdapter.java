package com.hasibulasad.homoeodoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Models.SystemModel;
import com.hasibulasad.homoeodoctor.R;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    Context context;
    ArrayList<SystemModel> systemlist = new ArrayList<>();
    int lastpos = -1;
    ClickInterface clickInterface;

    public RvAdapter(Context context, ArrayList<SystemModel> systemlist, ClickInterface clickInterface) {
        this.context = context;
        this.systemlist = systemlist;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder holder, int position) {
        SystemModel model = systemlist.get(position);
        holder.numbertv.setText(model.getNumber()+"");
        holder.nametv.setText(model.getName());
        holder.descriptiontv.setText(model.getDescription());
//        setAnimation(holder.itemView,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterface.itemClickListener(position);
            }
        });
    }
    private void setAnimation(View itemView, int position) {
        if (position > lastpos) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            itemView.setAnimation(animation);
            lastpos = position;
        }
    }

    @Override
    public int getItemCount() {
        return systemlist.size();
    }

    public interface ClickInterface {
        void itemClickListener(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numbertv, nametv,descriptiontv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numbertv = itemView.findViewById(R.id.idnumbertv);
            nametv = itemView.findViewById(R.id.idnametv);
            descriptiontv = itemView.findViewById(R.id.iddescription);

        }
    }
}

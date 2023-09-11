package com.hasibulasad.homoeodoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Models.SystemModel;
import com.hasibulasad.homoeodoctor.R;

import java.util.ArrayList;

public class SystemRvAdapter extends RecyclerView.Adapter<SystemRvAdapter.ViewHolder> {

    Context context;
    ArrayList<SystemModel> systemlist = new ArrayList<>();

    public SystemRvAdapter(Context context, ArrayList<SystemModel> systemlist) {
        this.context = context;
        this.systemlist = systemlist;
    }

    @NonNull
    @Override
    public SystemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.system_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SystemRvAdapter.ViewHolder holder, int position) {
        SystemModel model = systemlist.get(position);
        holder.numbertv.setText(model.getNumber()+"");
        holder.nametv.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return systemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView numbertv, nametv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numbertv = itemView.findViewById(R.id.idnumbertv);
            nametv = itemView.findViewById(R.id.idnametv);
        }
    }
}

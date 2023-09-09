package com.hasibulasad.homoeodoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Models.LokkhonModel;
import com.hasibulasad.homoeodoctor.R;

import java.util.ArrayList;
import java.util.List;

public class LokkhonRvAdapter extends RecyclerView.Adapter<LokkhonRvAdapter.Viewholder> {
    Context context;
    ArrayList<LokkhonModel> lokkhonlist = new ArrayList<>();

    public LokkhonRvAdapter(Context context, ArrayList<LokkhonModel> lokkhonlist) {
        this.context = context;
        this.lokkhonlist = lokkhonlist;
    }


    @NonNull
    @Override
    public LokkhonRvAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(context).inflate(R.layout.midicine_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LokkhonRvAdapter.Viewholder holder, int position) {
        LokkhonModel model = lokkhonlist.get(position);
        holder.medicinetv.setText("Gosol : "+model.getGosollokkhon()+"\n"
        +"Gham : "+model.getGhamlokkhon()+"\n"
        +"khabar : "+ model.getKhabarlokkhon()+"\n"
        +"pipasa : "+ model.getPipasalokkhon()+"\n"
        +"paikhana : "+ model.getPaikhanalokkhon()+"\n"
        +"Prosab : "+model.getProsablokkhon()+"\n"
        +"Manosikota : "+model.getManosikotalokkhon()+"\n"
        +"Srab : "+ model.getSrablokkhon()+"\n"
        +"Boisisto : "+ model.getBoisistolokkhon());

    }

    @Override
    public int getItemCount() {
        return lokkhonlist.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView medicinetv;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            medicinetv = itemView.findViewById(R.id.midicinelisttv);
        }
    }
}

package com.hasibulasad.homoeodoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Models.DoctorListModel;
import com.hasibulasad.homoeodoctor.Models.SystemModel;
import com.hasibulasad.homoeodoctor.R;

import java.util.ArrayList;

public class FindDoctorAdapter extends RecyclerView.Adapter<FindDoctorAdapter.ViewHolder> {

    Context context;
    ArrayList<DoctorListModel> doctorList = new ArrayList<>();
    int lastpos = -1;
    ClickInterface clickInterface;

    public FindDoctorAdapter(Context context, ArrayList<DoctorListModel> doctorList, ClickInterface clickInterface) {
        this.context = context;
        this.doctorList = doctorList;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public FindDoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.find_doctor_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FindDoctorAdapter.ViewHolder holder, int position) {
        DoctorListModel model = doctorList.get(position);
        holder.doctorImage.setImageResource(model.getImage());
        holder.doctorName.setText(model.getName());
        holder.doctorDegree.setText(model.getDegree());
        holder.doctorLocation.setText(model.getLocation());
        holder.doctorPhone.setText(model.getPhone());
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
        return doctorList.size();
    }

    public interface ClickInterface {
        void itemClickListener(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView doctorName, doctorDegree, doctorLocation, doctorPhone;
        ImageView doctorImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           doctorImage = itemView.findViewById(R.id.doctorimage);
           doctorName = itemView.findViewById(R.id.doctorName);
           doctorDegree = itemView.findViewById(R.id.doctorDegree);
           doctorLocation = itemView.findViewById(R.id.doctorLocation);
           doctorPhone = itemView.findViewById(R.id.doctorPhone);

        }
    }
}

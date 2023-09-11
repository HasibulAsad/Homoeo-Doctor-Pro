package com.hasibulasad.homoeodoctor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hasibulasad.homoeodoctor.Models.LokkhonModel;
import com.hasibulasad.homoeodoctor.Models.Product;
import com.hasibulasad.homoeodoctor.R;

import java.util.List;

/**
 * Created by NgocTri on 11/7/2015.
 */
public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ViewHolder> {
    private Context mContext;
    private List<Product> mProductList;

    public ListProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @NonNull
    @Override
    public ListProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_listview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListProductAdapter.ViewHolder holder, int position) {
        Product model =mProductList.get(position);
        holder.tvName.setText(model.getName());
        holder.tvPrice.setText(String.valueOf(model.getPrice()) + "");
        holder.tvDescription.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_product_price);
            tvDescription = itemView.findViewById(R.id.tv_product_description);
        }
    }
}

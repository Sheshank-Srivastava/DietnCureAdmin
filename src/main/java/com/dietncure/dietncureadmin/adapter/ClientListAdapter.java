package com.dietncure.dietncureadmin.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dietncure.dietncureadmin.R;
import com.dietncure.dietncureadmin.model.ClientListModel;

import java.util.ArrayList;

public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.ClientListViewHolder> {
    ArrayList<ClientListModel> mData;
    Context context;
    ClickListener clickListener;
    public ClientListAdapter(ArrayList<ClientListModel> mData, Context context,
                             ClickListener clickListener) {
        this.mData = mData;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ClientListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_list_row, parent, false);
        final ClientListViewHolder holder = new ClientListViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, holder.getAdapterPosition());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClientListViewHolder holder, int position) {
        ClientListModel model = mData.get(position);
        char alpha = model.getClientName().charAt(0);
        holder.imgClient.setText(alpha+"");
        holder.txtClientName.setText(model.getClientName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ClientListViewHolder extends RecyclerView.ViewHolder {
        TextView imgClient;
        TextView txtClientName;

        public ClientListViewHolder(View itemView) {
            super(itemView);
            imgClient = itemView.findViewById(R.id.imgClient);
            txtClientName = itemView.findViewById(R.id.txtClientName);
        }
    }
    public  interface ClickListener{
        void onItemClick(View v,int position);
    }
}

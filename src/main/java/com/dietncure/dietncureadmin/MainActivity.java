package com.dietncure.dietncureadmin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dietncure.dietncureadmin.adapter.ClientListAdapter;
import com.dietncure.dietncureadmin.model.ClientListModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ClientListAdapter adapter;
    ArrayList<ClientListModel> mData;
Context context =MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * data for  recycler View
         */
        mData = new ArrayList<>();
        mData.add(new ClientListModel("Sheshank"));
        mData.add(new ClientListModel("Akshit"));
        mData.add(new ClientListModel("Manya"));
        mData.add(new ClientListModel("Paras"));
        mData.add(new ClientListModel("Balkeerat"));
        mData.add(new ClientListModel("Summit"));

        recyclerView = findViewById(R.id.recClientList);
        adapter = new ClientListAdapter(mData, MainActivity.this, new ClientListAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(MainActivity.this,ChatActivity.class);
                intent.putExtra("name",mData.get(position).getClientName());
                context.startActivity(intent);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}

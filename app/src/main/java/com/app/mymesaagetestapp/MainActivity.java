package com.app.mymesaagetestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.app.mymesaagetestapp.adapter.MessageRecyclerAdapter;
import com.app.mymesaagetestapp.apiservice.ApiClient;
import com.app.mymesaagetestapp.apiservice.ApiInterface;
import com.app.mymesaagetestapp.common.ItemOffsetDecoration;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
MessageRecyclerAdapter adapter;
ProgressDialog progressDialog;
List<MessageModel.MessageList>data;
MessageModel message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        adapter=new MessageRecyclerAdapter(data,MainActivity.this);
        recyclerView.setAdapter(adapter);



        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);

        getMessageList();
    }

    private void getMessageList() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data..");
        progressDialog.setCancelable(false);
        progressDialog.show();


        ApiInterface service = ApiClient.getRetrofitInstance().create(ApiInterface.class);
        Call<String> call = service.getMessageList();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String str=response.body();
                Gson gson = new Gson();
                MessageModel.MessageList stringdata = gson.fromJson(str, MessageModel.MessageList.class);

                data= Collections.singletonList(stringdata);
                adapter=new MessageRecyclerAdapter(data,MainActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();




            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
    }
}
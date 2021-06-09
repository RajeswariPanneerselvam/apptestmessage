package com.app.mymesaagetestapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.mymesaagetestapp.MessageModel;
import com.app.mymesaagetestapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MessageRecyclerAdapter  extends RecyclerView.Adapter<MessageRecyclerAdapter.ViewHolder> {


    List<MessageModel.MessageList> messages;
    Context context;



    public MessageRecyclerAdapter(List<MessageModel.MessageList>data,Context context){

        this.messages=data;

        this.context=context;
        notifyDataSetChanged();
    }


    @Override
    public MessageRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.mesaage_recyler_adapter_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder( MessageRecyclerAdapter.ViewHolder holder, int position) {
   /*  holder.text_subject.setText(messages.get(position).getSubjectHeader());
        holder.text_name.setText(messages.get(position).getSenderName());
        holder.text_message.setText(messages.get(position).getMessage());
      if(messages.get(position).getSenderImage().equals("No Image")){

        }
        else{
            Picasso.with(context).load(messages.get(position).getSenderImage()).into(holder.image_hero);
        }

*/





    }

    @Override
    public int getItemCount() {
        return 11;
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{


        TextView text_subject,text_message,text_name;

        ImageView image_hero;
        public ViewHolder( View itemView) {
            super(itemView);
            text_name=itemView.findViewById(R.id.text_name);
            text_subject=itemView.findViewById(R.id.text_subject) ;
            image_hero=itemView.findViewById(R.id.image_teacher);
            text_message=itemView.findViewById(R.id.text_message);

        }
    }
}

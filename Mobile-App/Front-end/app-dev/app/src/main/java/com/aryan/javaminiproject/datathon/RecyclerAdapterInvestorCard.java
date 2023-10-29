package com.aryan.javaminiproject.datathon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.aryan.javaminiproject.datathon.activities.HomeScreen;
import com.aryan.javaminiproject.datathon.fragments.ChatFragment;
import com.aryan.javaminiproject.datathon.model.Investor;

import java.util.ArrayList;

public class RecyclerAdapterInvestorCard extends RecyclerView.Adapter<RecyclerAdapterInvestorCard.ViewHolder> {

    Context context;
    ArrayList<Investor> arrayList;
    FragmentManager fragmentManager;

    public RecyclerAdapterInvestorCard(Context context, ArrayList<Investor> arrayList,FragmentManager f) {
        this.context = context;
        this.arrayList = arrayList;
        this.fragmentManager = f;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.invester_card_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.investorName.setText(arrayList.get(position).getName());
        holder.investorContact.setText("Contact : "+arrayList.get(position).getContact());
        holder.investorEmail.setText("Email : "+arrayList.get(position).getEmail());
        holder.investorType.setText("Investment Type : "+arrayList.get(position).getType());
        holder.contactBtn.setOnClickListener(view->{
            Bundle b = new Bundle();
            b.putString("INVESTOR_NAME",arrayList.get(position).getName());
            b.putString("INVESTOR_EMAIL",arrayList.get(position).getEmail());
            ChatFragment chatFragment = new ChatFragment();
            chatFragment.setArguments(b);
            HomeScreen hs = (HomeScreen) context;
            hs.switchToChatFragment(b);
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView investorName,investorContact,investorEmail,investorType;
        private LinearLayout contactBtn;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           investorName = itemView.findViewById(R.id.investorName);
           investorContact = itemView.findViewById(R.id.investorContact);
           investorEmail = itemView.findViewById(R.id.investorEmail);
           investorType = itemView.findViewById(R.id.investorType);
           contactBtn = itemView.findViewById(R.id.contactBtn);
       }
   }

}

package com.aryan.javaminiproject.datathon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.aryan.javaminiproject.datathon.R;
import com.aryan.javaminiproject.datathon.activities.HomeScreen;

public class ChatFragment extends Fragment {
    public ChatFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat, container, false);

        EditText emailhere = v.findViewById(R.id.emailhere);
        EditText messageHere = v.findViewById(R.id.messageHere);
        ImageView sendButton = v.findViewById(R.id.sendButton);
        ImageView backBtn = v.findViewById(R.id.backBtn);
        Bundle bundle = getArguments();
        if (bundle!=null){
            String name = bundle.getString("INVESTOR_NAME");
            String email = bundle.getString("INVESTOR_EMAIL");
            emailhere.setText(email);
            messageHere.setText("To Respected "+name + ",");
        }

        sendButton.setOnClickListener(view->{
            if (emailhere.getText().toString().isEmpty()||messageHere.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Invalid Fields", Toast.LENGTH_SHORT).show();
            }
            else {
                emailhere.setText("");
                messageHere.setText("");
                Toast.makeText(getContext(), "Message Sent", Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(back->{
            HomePageFragment hpf = new HomePageFragment();
            HomeScreen hs = (HomeScreen) getContext();
            hs.loadFragment(hpf,1);
        });

        return v;
    }
}
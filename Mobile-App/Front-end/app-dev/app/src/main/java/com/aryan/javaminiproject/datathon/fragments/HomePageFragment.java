package com.aryan.javaminiproject.datathon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aryan.javaminiproject.datathon.R;
import com.aryan.javaminiproject.datathon.RecyclerAdapterInvestorCard;
import com.aryan.javaminiproject.datathon.model.Investor;

import java.util.ArrayList;


public class HomePageFragment extends Fragment {
    public HomePageFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home_page, container, false);
        ArrayList<Investor> arrayList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        arrayList.add(new Investor("Aryan Fredericks","+91-9372575720","aryanfredericks21@gmail.com","AI"));
        arrayList.add(new Investor("Ralston Dcruz","+91-298472874","ralstonDcruz@gmail.com","AI"));
        arrayList.add(new Investor("Aryan Nayak","+91-34534673","aryannayak@gmail.com","EV"));
        arrayList.add(new Investor("Dhaval Jain","+91-435345436","dhavaljain@gmail.com","AI"));
        arrayList.add(new Investor("Ami Desai","+91-678678678","amidesai@gmail.com","EV"));
        arrayList.add(new Investor("Ezekiel Luis","+91-124972987","ezekiel@gmail.com","EV"));
        arrayList.add(new Investor("Yash Ganiga","94729472","yashganiga@gmail.com","AI"));
        arrayList.add(new Investor("Rohit Shah","+91-5674986","rohitshah@gmail.com","AI"));
        arrayList.add(new Investor("Nancy Puloni","+91-49568748967","nancypuloni@gmail.com","EV"));
        arrayList.add(new Investor("Rachel Drew","+91-958709687","racheldrew@gmail.com","EV"));
        arrayList.add(new Investor("Kriya Shah","+91-434980249","Kriiyashah@gmail.com","AI"));
        arrayList.add(new Investor("Khushi Jain","+91-34958730","randomemail@gmail.com","AI"));
        arrayList.add(new Investor("Tyrone","+91-45730987","tyrone@gmail.com","AI"));
        arrayList.add(new Investor("John Doe","+91-457398457","jondoe@gmail.com","EV"));
        arrayList.add(new Investor("Macy ","+91-490870956","macy@gmail.com","EV"));
        arrayList.add(new Investor("K-Means Killers","+91-09785609","randomemail@gmail.com","AI"));

        RecyclerAdapterInvestorCard adapter = new RecyclerAdapterInvestorCard(getContext(),arrayList,getParentFragmentManager());

        recyclerView.setAdapter(adapter);

        return view;
    }
}
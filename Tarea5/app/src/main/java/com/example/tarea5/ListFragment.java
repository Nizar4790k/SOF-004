package com.example.tarea5;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    public static final String  ADJECTIVE="ADJECTIVE";

    private RecyclerView mRecyclerView;
    private ItemAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment,null,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;


    }


    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView mTextView;
        private String mText;

        public ItemHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item,parent,false));
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(this);


        }


        public void  bind(String text){
            mText = text;
            mTextView.setText(mText);

        }

        @Override
        public void onClick(View v) {

            String name = getActivity().getIntent().getStringExtra(MainFragment.NAME);

            Intent intent = new Intent(getContext(),ResultActivity.class);
            intent.putExtra(MainFragment.NAME,name);
            intent.putExtra(ADJECTIVE,mText);
            startActivity(intent);




        }
    }


    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder>{

        private List<String> mWords;

        public ItemAdapter(List<String> words){
            mWords = words;
        }


        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());



            return new ItemHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            String word = mWords.get(position);
            holder.bind(word);

        }

        @Override
        public int getItemCount() {
            return mWords.size();
        }
    }


    private void updateUI(){

        Resources resources = getResources();

        String bello = resources.getString(R.string.bello);
        String habil= resources.getString(R.string.habil);
        String grande = resources.getString(R.string.grande);
        String mejor = resources.getString(R.string.mejor);
        String inteligente = resources.getString(R.string.inteligente);


        String [] array = {bello,habil,grande,mejor,inteligente};

        List<String> list = new ArrayList<>();

        for (String e : array){
            list.add(e);

        }

        mAdapter = new ItemAdapter(list);
        mRecyclerView.setAdapter(mAdapter);








    }

}

package com.example.tarea9.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea9.R;
import com.example.tarea9.model.Worker;

import java.util.List;

public class WorkerListFragment extends Fragment {


    private RecyclerView mRecyclerView;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment,container,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);




        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main_activity,menu);
    }


    private class WorkerAdapter extends RecyclerView.Adapter<WorkerHolder>{

        private List<Worker> mWorkers;

        public WorkerAdapter(List<Worker> workers){
            mWorkers=workers;
        }


        @NonNull
        @Override
        public WorkerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull WorkerHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }


    private class WorkerHolder extends RecyclerView.ViewHolder{

        public WorkerHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.worker_list_item,parent,false));

        }


        public WorkerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

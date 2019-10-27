package com.example.tarea9.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea9.R;
import com.example.tarea9.lab.EmployeeLab;
import com.example.tarea9.model.Manager;
import com.example.tarea9.model.Worker;

import java.util.List;

public class ManagerListFragment extends ManagerFragment {




    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment,container,false);


        mRecyclerView = view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        updateUI();




        return view;
    }


    public void updateUI(){
        List<Manager> workerList = EmployeeLab.getInstance(getContext()).getManagerList();

        WorkerListFragment.ManagerAdapter workerAdapter = new WorkerListFragment.ManagerAdapter(workerList);

        mRecyclerView.setAdapter(workerAdapter);

    }

    private class ManagerAdapter extends RecyclerView.Adapter<WorkerListFragment.ManagerHolder>  {

        private List<Worker> mWorkers;

        public ManagerAdapter(List<Worker> workers){
            mWorkers=workers;
        }


        @NonNull
        @Override
        public WorkerListFragment.ManagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(getContext());

            return new WorkerListFragment.ManagerHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkerListFragment.ManagerHolder holder, int position) {

            Worker worker = mWorkers.get(position);

            holder.onBind(worker);

        }

        @Override
        public int getItemCount() {
            return mWorkers.size();
        }


    }









}

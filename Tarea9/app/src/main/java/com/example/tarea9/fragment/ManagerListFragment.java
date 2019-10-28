package com.example.tarea9.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        ManagerListFragment.ManagerAdapter workerAdapter = new ManagerListFragment.ManagerAdapter(workerList);

        mRecyclerView.setAdapter(workerAdapter);

    }

    private class ManagerAdapter extends RecyclerView.Adapter<WorkerListFragment.ManagerHolder>  {

        private List<Worker> mWorkers;

        public ManagerAdapter(List<Worke> workers){
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


    private class ManagerHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{

        private TextView mTextViewName;
        private TextView mTextViewLocal;

        private TextView mTextViewSalary;

        private Manager mManager;

        public ManagerHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.manager_list_item,parent,false));
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewLocal = itemView.findViewById(R.id.text_view_local);
            mTextViewSalary =  itemView.findViewById(R.id.text_view_salary);
            itemView.setOnClickListener(this);


        }





        @Override
        public void onClick(View v) {

            Intent intent = WorkerFragment.newIntent(getContext(), mManager.getUUID());
            startActivity(intent);



        }


        public void onBind(Manager mManager){

            mTextViewName.setText(getString(R.string.name_text_view,mManager.getName()));
            mTextViewLocal.setText(getString(R.string.local_text_view,String.valueOf(mManager.getLocal())));
            mTextViewSalary.setText(String.valueOf(mManager.getSalary()));

            this.mManager =mManager;
        }




    }









}

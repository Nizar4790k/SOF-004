package com.example.tarea9.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tarea9.R;
import com.example.tarea9.lab.EmployeeLab;
import com.example.tarea9.model.Worker;

import java.util.List;

public class WorkerListFragment extends Fragment {


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.add:

                Intent intent = WorkerFragment.newIntent(getActivity(),null);
                startActivity(intent);

                return true;

                default:
                    return super.onOptionsItemSelected(item);

        }

    }

    private class ManagerAdapter extends RecyclerView.Adapter<WorkerHolder>  {

        private List<Worker> mWorkers;

        public ManagerAdapter(List<Worker> workers){
            mWorkers=workers;
        }


        @NonNull
        @Override
        public WorkerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

           LayoutInflater inflater = LayoutInflater.from(getContext());

            return new WorkerHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WorkerHolder holder, int position) {

        Worker worker = mWorkers.get(position);

            holder.onBind(worker);

        }

        @Override
        public int getItemCount() {
            return mWorkers.size();
        }


    }


    private class WorkerHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{

        private TextView mTextViewName;
        private TextView mTextViewLocal;

        private TextView mTextViewTotalSalary;

        private Worker mWorker;

        public WorkerHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.worker_list_item,parent,false));
            mTextViewName = itemView.findViewById(R.id.text_view_name);
            mTextViewLocal = itemView.findViewById(R.id.text_view_local);
            mTextViewTotalSalary =  itemView.findViewById(R.id.text_view_total_salary);
            itemView.setOnClickListener(this);


        }





        @Override
        public void onClick(View v) {

            Intent intent = WorkerFragment.newIntent(getContext(),mWorker.getUUID());
            startActivity(intent);



        }


        public void onBind(Worker worker){

            mTextViewName.setText(getString(R.string.name_text_view,worker.getName()));
            mTextViewLocal.setText(getString(R.string.local_text_view,String.valueOf(worker.getLocal())));
            mTextViewTotalSalary.setText(getString(R.string.total_salary,
                    String.valueOf(Worker.calculateTotalSalary(worker.getSalary(),worker.hasTitle()))));

            mWorker=worker;
        }




    }

    public void updateUI(){
        List<Worker> workerList = EmployeeLab.getInstance(getContext()).getWorkerList();

        ManagerAdapter managerAdapter = new ManagerAdapter(workerList);

        mRecyclerView.setAdapter(managerAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


}

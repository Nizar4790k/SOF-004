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
import com.example.tarea9.model.Manager;

import java.util.List;

public class ManagerListFragment extends Fragment {




    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment,null,false);


        mRecyclerView = view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        updateUI();


        return view;
    }


    public void updateUI(){

        List<Manager> managerList = EmployeeLab.getInstance(getContext()).getManagerList();



        ManagerListFragment.ManagerAdapter managerAdapter = new ManagerListFragment.ManagerAdapter(managerList);

        mRecyclerView.setAdapter(managerAdapter);

    }

    private class ManagerAdapter extends RecyclerView.Adapter<ManagerListFragment.ManagerHolder>  {

        private List<Manager> mManagers;

        public ManagerAdapter(List<Manager> managers){
            mManagers=managers;
        }


        @NonNull
        @Override
        public ManagerListFragment.ManagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(getContext());

            return new ManagerListFragment.ManagerHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ManagerListFragment.ManagerHolder holder, int position) {

            Manager manager = mManagers.get(position);

            holder.onBind(manager);

        }

        @Override
        public int getItemCount() {
            return mManagers.size();
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

            Intent intent = ManagerFragment.newIntent(getContext(), mManager.getUUID());
            startActivity(intent);



        }


        public void onBind(Manager mManager){

            mTextViewName.setText(getString(R.string.name_text_view,mManager.getName()));
            mTextViewLocal.setText(getString(R.string.local_text_view,String.valueOf(mManager.getLocal())));
            mTextViewSalary.setText(getString(R.string.salary,String.valueOf(mManager.getSalary())));

            this.mManager =mManager;
        }




    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.list_fragment,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.add:

                Intent intent = ManagerFragment.newIntent(getActivity(),null);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }


}

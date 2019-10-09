package com.example.tarea6;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {



    private VideoView mVideoView;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);





        mVideoView  = view.findViewById(R.id.video_view);

        Uri uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.intro);
        getVideoView().setVideoURI(uri);
        getVideoView().start();



        return view;




    }


    public VideoView getVideoView() {
        return mVideoView;
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser && getView() != null);




        if(mVideoView!=null) {
            if (isVisibleToUser) {


                mVideoView.start();
            } else {
                mVideoView.pause();
            }
        }




    }


}

package com.example.tarea6;

import android.content.Intent;
import android.net.Uri;
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

public class MusicFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MusicAdapter mMusicAdapter;




    public MusicFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music,container,false);

        mRecyclerView = view.findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Music> musicList = new ArrayList<>();

        musicList.add(new Music("In the end","Linkin Park","https://www.youtube.com/watch?v=eVTXPUF4Oz4"));
        musicList.add(new Music("New Divide","Linkin Park","https://www.youtube.com/watch?v=ysSxxIqKNN0"));
        musicList.add(new Music("Orion","Metallica","https://www.youtube.com/watch?v=V4mb_BnKP1A"));
        musicList.add(new Music("St.Anger","Metallica","https://www.youtube.com/watch?v=6ajl1ABdD8A"));
        musicList.add(new Music("Addicted To Chaos","Megadeth","https://www.youtube.com/watch?v=G9P_4RXHCys"));
        musicList.add(new Music("Dystopia", "Megadeth","https://www.youtube.com/watch?v=bK95lWHl7js"));
        musicList.add(new Music("Ghost Of The Navigator","Iron Maiden","https://www.youtube.com/watch?v=CQVCJziKw-E"));
        musicList.add(new Music("Black Diamond","Stratovarius","https://www.youtube.com/watch?v=Tn58-Nl9NYw"));
        musicList.add(new Music("Princess of the Night","Saxon","https://www.youtube.com/watch?v=-49noOAFsG8"));
        musicList.add(new Music("Lie Lie Lie","Serj Tankian","https://www.youtube.com/watch?v=TkPbJIlEXow"));

        mMusicAdapter = new MusicAdapter(musicList);

        mRecyclerView.setAdapter(mMusicAdapter);


        return view;
    }

    private  class MusicAdapter extends RecyclerView.Adapter<MusicHolder> {

        private List<Music> mList;

        public MusicAdapter(List<Music> list){
            mList = list;
        }

        @NonNull
        @Override
        public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new MusicHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MusicHolder holder, int position) {

            Music music = mList.get(position);
            holder.bind(music);

        }



        @Override
        public int getItemCount() {
            return mList.size();
        }
    }


    private class MusicHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTextViewName;
        private TextView mTextViewArtist;
        private Music mMusic;


        public MusicHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.music_list_item, parent, false));

            this.mTextViewName  = itemView.findViewById(R.id.text_view_name_music);
            mTextViewArtist = itemView.findViewById(R.id.text_view_artist);
            itemView.setOnClickListener(this);

        }


        public void bind(Music music){
            mMusic = music;
            this.mTextViewName.setText(getString(R.string.song,music.getName()));
            this.mTextViewArtist.setText(getString(R.string.artist,mMusic.getArtist()));
        }

        @Override
        public void onClick(View v) {

            Intent intent  = new Intent(Intent.ACTION_VIEW, Uri.parse(mMusic.getUrl()));
            startActivity(intent);


        }
    }


}

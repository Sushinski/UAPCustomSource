package com.example.android.uamp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudioSource {

    class Song {
        private int mId;
        private String mArtistName;
        private String mTrackName;
        private String mSource;

        public Song(int id, String artistName, String trackName, String source) {
            mId = id;
            mArtistName = artistName;
            mTrackName = trackName;
            mSource = source;
        }

        public int getId() {
            return mId;
        }

        public void setId(int id) {
            mId = id;
        }

        public String getArtistName() {
            return mArtistName;
        }

        public void setArtistName(String artistName) {
            mArtistName = artistName;
        }

        public String getTrackName() {
            return mTrackName;
        }

        public void setTrackName(String trackName) {
            mTrackName = trackName;
        }

        public String getSource() {
            return mSource;
        }

        public void setSource(String source) {
            mSource = source;
        }
    }

    private int mCurrentPlaylist = 0;

    private List<List<Song>> mInitialData = Arrays.asList(
            Arrays.asList(
                    new Song(0, "Media Right Productions", "Jazz in Paris", "http://storage.googleapis.com/automotive-media/Jazz_In_Paris.mp3"),
                    new Song(1, "Silent Partner", "The Messenger", "http://storage.googleapis.com/automotive-media/The_Messenger.mp3"),
                    new Song(2, "Huma-Huma", "Talkies", "http://storage.googleapis.com/automotive-media/Talkies.mp3")),
            Arrays.asList(
                    new Song(3, "Silent Partner", "Drop and Roll", "http://storage.googleapis.com/automotive-media/Drop_and_Roll.mp3"),
                    new Song(4, "Topher Mohr and Alex Elena", "Motocross", "http://storage.googleapis.com/automotive-media/Motocross.mp3"),
                    new Song(5, "The 126ers", "Wish You'd Come True", "http://storage.googleapis.com/automotive-media/Wish_You_d_Come_True.mp3"))
    );

    public boolean hasNext(){
        return mCurrentPlaylist < get_playlists_count();
    }

    public List<Song> next() {
        if(mCurrentPlaylist < get_playlists_count()) {
            List<Song> next_list = mInitialData.get(mCurrentPlaylist);
            mCurrentPlaylist += 1;
            return next_list;
        }else{
            return new ArrayList<>();
        }
    }

    public int get_playlists_count(){
        return mInitialData.size();
    }
}

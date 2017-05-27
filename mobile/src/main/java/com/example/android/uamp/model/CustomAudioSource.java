package com.example.android.uamp.model;

import android.support.v4.media.MediaMetadataCompat;

import com.example.android.uamp.utils.LogHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CustomAudioSource extends AudioSource implements MusicProviderSource {
    private final static String UNKNOWN = "Unknown";

    @Override
    public Iterator<MediaMetadataCompat> iterator() {
        ArrayList<MediaMetadataCompat> tracks = new ArrayList<>();
        long playlist_num = 0;
        while(hasNext()){
            playlist_num += 1;
            List<Song> playlist = next();
            long total_tracks = playlist.size();
            long track_number = 0;
            for(Song song: playlist){
                track_number += 1;
                tracks.add(buildFromSongSource(song, "Playlist: " + playlist_num,
                        track_number, total_tracks));
            }
        }
        return tracks.iterator();
    }

    private MediaMetadataCompat buildFromSongSource(Song song,
                                                    String playlist_name,
                                                    long track_number,
                                                    long total_tracks
                                                    ){
        return new MediaMetadataCompat.Builder()
                .putString(MediaMetadataCompat.METADATA_KEY_MEDIA_ID, String.valueOf(song.getId()))
                .putString(MusicProviderSource.CUSTOM_METADATA_TRACK_SOURCE, song.getSource())
                .putString(MediaMetadataCompat.METADATA_KEY_GENRE, UNKNOWN)
                .putString(MediaMetadataCompat.METADATA_KEY_ALBUM, UNKNOWN)
                .putLong(MediaMetadataCompat.METADATA_KEY_DURATION, 0) // todo track duration
                .putString(MediaMetadataCompat.METADATA_KEY_COMPILATION, playlist_name )
                .putLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER, track_number)
                .putLong(MediaMetadataCompat.METADATA_KEY_NUM_TRACKS, total_tracks)
                .putString(MediaMetadataCompat.METADATA_KEY_ARTIST, song.getArtistName())
                .putString(MediaMetadataCompat.METADATA_KEY_TITLE, song.getTrackName())
                .build();
    }



}

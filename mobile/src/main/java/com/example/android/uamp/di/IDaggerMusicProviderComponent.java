package com.example.android.uamp.di;

import com.example.android.uamp.MusicService;
import com.example.android.uamp.di.PerSource;
import com.example.android.uamp.model.MusicProvider;

import dagger.Component;

@PerSource
@Component(modules={DaggerMusicProviderModule.class})
public interface IDaggerMusicProviderComponent {
    void inject(MusicService service);
}

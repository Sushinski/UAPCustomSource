package com.example.android.uamp.di;

import com.example.android.uamp.model.CustomAudioSource;
import com.example.android.uamp.model.MusicProviderSource;

import dagger.Module;
import dagger.Provides;

@PerSource
@Module
public class DaggerAudioSourceModule {

    @Provides
    public MusicProviderSource provideAudioSource(){
        return new CustomAudioSource();
    }
}

package com.example.android.uamp.di;
import com.example.android.uamp.model.MusicProvider;
import com.example.android.uamp.model.MusicProviderSource;

import dagger.Module;
import dagger.Provides;

@PerSource
@Module(includes = {DaggerAudioSourceModule.class})
public class DaggerMusicProviderModule {

    @Provides
    public MusicProvider provideProvider(MusicProviderSource source){
        return new MusicProvider(source);
    }
}

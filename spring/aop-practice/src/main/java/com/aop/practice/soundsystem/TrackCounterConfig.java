package com.aop.practice.soundsystem;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    // TODO: 여기에 Bean을 만들지 않고, BlankDisc에 @Component 붙여서 호출할 수 있는 방법으로 해봤으면 함.
    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        cd.setTracks(getTracks());

        return cd;
    }

    private List<String> getTracks() {
        List<String> tracks = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            tracks.add(i, i + " Track");
        }
        return tracks;
    }
}

package com.aop.practice.soundsystem;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackCounterTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private TrackCounter trackCounter;

    @Test
    public void testTrackCounter() {
        cd.playTrack(1);
        assertThat(trackCounter.getPlayCount(1), equalTo(1));

        cd.playTrack(2);
        assertThat(trackCounter.getPlayCount(2), equalTo(1));

        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        cd.playTrack(3);
        assertThat(trackCounter.getPlayCount(3), equalTo(5));

        assertThat(trackCounter.getPlayCount(4), equalTo(0));
        assertThat(trackCounter.getPlayCount(5), equalTo(0));
        assertThat(trackCounter.getPlayCount(6), equalTo(0));
        assertThat(trackCounter.getPlayCount(7), equalTo(0));
        assertThat(trackCounter.getPlayCount(8), equalTo(0));
        assertThat(trackCounter.getPlayCount(9), equalTo(0));
    }
}

package chap13;

import org.junit.Test;

public class TrainJourneyExerciseTest {

    @Test
    public void link() {
        TrainJourney a = new TrainJourney(1, new TrainJourney(10, null));
        TrainJourney b = new TrainJourney(10, new TrainJourney(20, null));
        TrainJourney link = TrainJourneyExercise.link(a, b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(link);
    }

    @Test
    public void append() {
        TrainJourney a = new TrainJourney(1, new TrainJourney(10, null));
        TrainJourney b = new TrainJourney(10, new TrainJourney(20, null));
        TrainJourney link = TrainJourneyExercise.append(a, b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(link);
    }
}

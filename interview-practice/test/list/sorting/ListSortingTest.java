package list.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSortingTest {

    @Test
    public void shouldSortList() {
        final int[] numbers = {-3, -5, 1, 7, 4, -2};
        final int[] expected = {-5, -3, -2, 1, 4, 7};

        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void shouldSortComparableClassList() {
        final String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
        final String[] expected = {"abc", "x", "y", "z", "zazzy", "zzz"};

        Arrays.sort(strings);
        assertArrayEquals(expected, strings);
    }

    @Test
    public void shouldSortNoneComparableClassList() {
        // Given.
        Movie movie1 = new Movie(LocalTime.of(20, 55), LocalTime.of(22, 55), "영화1");
        Movie movie2 = new Movie(LocalTime.of(20, 0), LocalTime.of(21, 5), "영화2");
        Movie movie3 = new Movie(LocalTime.of(21, 0), LocalTime.of(23, 30), "영화3");

        final List<Movie> movies = Arrays.asList(movie1, movie2, movie3);

        // When.
        Collections.sort(movies);

        // Then.
        final List<Movie> expected = Arrays.asList(movie2, movie1, movie3);
        assertArrayEquals(movies.toArray(), expected.toArray());
    }
}

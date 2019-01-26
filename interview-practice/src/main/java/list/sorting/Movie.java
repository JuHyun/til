package list.sorting;

import java.time.LocalTime;

public class Movie implements Comparable<Movie> {
    private LocalTime start;
    private LocalTime end;
    private String name;

    public Movie(LocalTime start, LocalTime end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Movie movie) {
        LocalTime start = this.start;
        LocalTime otherStart = movie.start;
        int result = compare(start.getHour(), otherStart.getHour());
        if (result == 0) {
            result = compare(start.getMinute(), otherStart.getMinute());
        }

        return result;
    }

    private int compare(int value1, int value2) {
        if (value1 < value2) {
            return -1;
        } else if (value1 == value2) {
            return 0;
        }
        return 1;
    }
}

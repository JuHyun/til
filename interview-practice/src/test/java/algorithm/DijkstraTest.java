package algorithm;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DijkstraTest {

    @Test
    public void dijkstra() {
        Dijkstra dijkstra = new Dijkstra(8);

        dijkstra.input(1, 2, 3);
        dijkstra.input(1, 5, 4);
        dijkstra.input(1, 4, 4);
        dijkstra.input(2, 3, 2);
        dijkstra.input(3, 4, 1);
        dijkstra.input(4, 5, 2);
        dijkstra.input(5, 6, 4);
        dijkstra.input(4, 7, 6);
        dijkstra.input(7, 6, 3);
        dijkstra.input(3, 8, 3);
        dijkstra.input(6, 8, 2);

        assertArrayEquals(new int[]{0, 3, 5, 4, 4, 8, 10, 8}, dijkstra.dijkstra(1));
    }
}

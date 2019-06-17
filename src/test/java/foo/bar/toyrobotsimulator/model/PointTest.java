package foo.bar.toyrobotsimulator.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    private final Point sut = new Point(1, 3);

    @Test
    public void shouldReturnNewPointByAddingCoordinatesFoNewPoint() {
        Point actual = sut.add(new Point(2, 3));

        assertThat(actual).isEqualToComparingFieldByFieldRecursively(new Point(3, 6));
    }
}

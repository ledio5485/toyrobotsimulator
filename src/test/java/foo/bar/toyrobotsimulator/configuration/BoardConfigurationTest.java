package foo.bar.toyrobotsimulator.configuration;

import foo.bar.toyrobotsimulator.model.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class BoardConfigurationTest {

    private BoardConfiguration sut = new BoardConfiguration();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Point(-1, -1), false},
                {new Point(-1, 0), false},
                {new Point(0, -1), false},
                {new Point(0, 0), true},
                {new Point(1, 0), true},
                {new Point(0, 1), true},
                {new Point(1, 1), true},
                {new Point(1, 2), false},
                {new Point(2, 1), false},
                {new Point(2, 2), false},
                {new Point(3, 2), false},
                {new Point(2, 3), false},
                {new Point(3, 3), false},
        });
    }

    private Point location;
    private boolean expected;

    public BoardConfigurationTest(Point location, boolean expected) {
        this.location = location;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        sut.setRows(2);
        sut.setColumns(2);
    }

    @Test
    public void testCardinalDirection() {
        assertThat(sut.containsPoint(location)).isEqualTo(expected);
    }

}
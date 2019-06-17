package de.idealo.toyrobotsimulator.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class CardinalDirectionTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0, CardinalDirection.NORTH},
                {450, 90, CardinalDirection.EAST},
                {180, -90, CardinalDirection.SOUTH},
                {270, -90, CardinalDirection.WEST},
                {360, 0, CardinalDirection.NORTH},
                {360, 90, CardinalDirection.NORTH}
        });
    }

    private int degree;
    private int angle;

    private CardinalDirection expected;

    public CardinalDirectionTest(int degree, int angle, CardinalDirection direction) {
        this.degree = degree;
        this.angle = angle;
        this.expected = direction;
    }

    @Test
    public void testCardinalDirection() {
        assertThat(CardinalDirection.of(degree, angle)).isEqualTo(expected);
    }
}

package de.idealo.toyrobotsimulator.model;

import de.idealo.toyrobotsimulator.configuration.BoardConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {
    private Robot sut;

    @Before
    public void setUp() {
        BoardConfiguration boardConfiguration = create3X3BoardConfiguration();
        sut = new Robot(boardConfiguration);

        assertThat(sut.report()).isEmpty();
    }

    @Test
    public void shouldNotPlaceTheRobotIfStartingPointIsOutsideTheBoard() {
        sut.place(new Point(1, -1), CardinalDirection.SOUTH);

        assertThat(sut.report()).isEmpty();
    }

    @Test
    public void shouldPlaceTheRobotIfStartingPointIsInsideTheBoard() throws Exception {
        Point location = new Point(1, 1);
        CardinalDirection facing = CardinalDirection.SOUTH;

        sut.place(location, facing);

        assertThat(sut.report()).isNotEmpty();

        Position actual = getCurrentPosition();

        Position expected = new Position(location, facing);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldNotMoveTheRobotIfItIsNotPlacedYet() {
        sut.move();

        assertThat(sut.report()).isEmpty();
    }

    @Test
    public void shouldNotMoveTheRobotIfStartingPointIsInsideTheBoardButNextPointIsOutsideTheBoard() throws Exception {
        Point location = new Point(0, 0);
        CardinalDirection facing = CardinalDirection.WEST;
        sut.place(location, facing);
        assertThat(sut.report()).isNotEmpty();

        sut.move();

        Position actual = getCurrentPosition();

        Position expected = new Position(location, facing);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldMoveTheRobotIfStartingPointAndNextPointAreInsideTheBoard() throws Exception {
        sut.place(new Point(0, 0), CardinalDirection.NORTH);

        sut.move();

        Position actual = getCurrentPosition();

        Position expected = new Position(new Point(0, 1), CardinalDirection.NORTH);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldNotRotateTheRobotIfItIsNotPlacedYet() {
        sut.rotate(RotationDirection.LEFT);

        assertThat(sut.report()).isEmpty();
    }

    @Test
    public void shouldRotateTheRobotOnTheLeftIfStartingPointIsInsideTheBoardAndRotateDirectionIsLeft() throws Exception {
        sut.place(new Point(0, 0), CardinalDirection.NORTH);

        sut.rotate(RotationDirection.LEFT);

        Position actual = getCurrentPosition();

        Position expected = new Position(new Point(0, 0), CardinalDirection.WEST);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldRotateTheRobotOnTheRightIfStartingPointIsInsideTheBoardAndRotateDirectionIsRight() throws Exception {
        sut.place(new Point(0, 0), CardinalDirection.NORTH);

        sut.rotate(RotationDirection.RIGHT);

        Position actual = getCurrentPosition();

        Position expected = new Position(new Point(0, 0), CardinalDirection.EAST);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldReturnEmptyPositionIfRobotIsNotPlacedYet() {
        Optional<Position> actual = sut.report();

        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldReturnCurrentPositionIfRobotIsAlreadyPlaced() throws Exception {
        Point location = new Point(0, 0);
        CardinalDirection facing = CardinalDirection.WEST;
        sut.place(location, facing);

        Position actual = getCurrentPosition();

        Position expected = new Position(location, facing);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    private Position getCurrentPosition() throws Exception {
        return sut.report()
                .orElseThrow(() -> new Exception("ROBOT MISSING"));
    }

    private BoardConfiguration create3X3BoardConfiguration() {
        BoardConfiguration boardConfiguration = new BoardConfiguration();
        boardConfiguration.setRows(3);
        boardConfiguration.setColumns(3);

        return boardConfiguration;
    }
}

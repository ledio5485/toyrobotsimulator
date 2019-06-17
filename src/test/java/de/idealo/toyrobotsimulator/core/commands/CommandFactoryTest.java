package de.idealo.toyrobotsimulator.core.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.idealo.toyrobotsimulator.rest.dto.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandFactoryTest {

    private final CommandFactory sut = new CommandFactory(new ObjectMapper());

    @Test
    public void shouldCreatePlaceCommand() {
        PositionDto positionDto = new PositionDto(new PointDto(1, 1), CardinalDirection.NORTH);

        Command actual = sut.create(new PlaceCommandDto(positionDto));

        Command expected = new PlaceCommand(1, 1, de.idealo.toyrobotsimulator.model.CardinalDirection.NORTH);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldCreateMoveCommand() {
        Command actual = sut.create(new CommandDto(CommandName.MOVE));

        Command expected = new MoveCommand();
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldCreateRotateLeftCommand() {
        Command actual = sut.create(new CommandDto(CommandName.LEFT));

        Command expected = new RotateLeftCommand();
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void shouldCreateRotateRightCommand() {
        Command actual = sut.create(new CommandDto(CommandName.RIGHT));

        Command expected = new RotateRightCommand();
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }
}
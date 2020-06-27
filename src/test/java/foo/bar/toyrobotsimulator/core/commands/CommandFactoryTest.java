package foo.bar.toyrobotsimulator.core.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import foo.bar.toyrobotsimulator.rest.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandFactoryTest {

    @Autowired
    private CommandFactory sut;

    @Test
    public void shouldCreatePlaceCommand() {
        PositionDto positionDto = new PositionDto(new PointDto(1, 1), CardinalDirection.NORTH);

        Command actual = sut.create(new PlaceCommandDto(positionDto));

        Command expected = new PlaceCommand(1, 1, foo.bar.toyrobotsimulator.model.CardinalDirection.NORTH);
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
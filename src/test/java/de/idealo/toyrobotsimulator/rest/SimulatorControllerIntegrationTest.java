package de.idealo.toyrobotsimulator.rest;

import de.idealo.toyrobotsimulator.ToyRobotSimulatorApplication;
import de.idealo.toyrobotsimulator.rest.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ToyRobotSimulatorApplication.class)
public class SimulatorControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSimulationOnlyMove() {
        PositionDto position = new PositionDto(new PointDto(0, 0), CardinalDirection.NORTH);
        List<CommandDto> commands = new ArrayList<CommandDto>() {{
            add(new PlaceCommandDto(position));
            add(new CommandDto(CommandName.MOVE));
            add(new CommandDto(CommandName.REPORT));
        }};
        SimulationRequest request = new SimulationRequest(commands);

        SimulationResponse actual = this.restTemplate.postForObject("/api/simulate", request, SimulationResponse.class);

        SimulationResponse expected = new SimulationResponse(new PositionDto(new PointDto(0, 1), CardinalDirection.NORTH));
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void testSimulationOnlyRotate() {
        PositionDto position = new PositionDto(new PointDto(0, 0), CardinalDirection.NORTH);
        List<CommandDto> commands = new ArrayList<CommandDto>() {{
            add(new PlaceCommandDto(position));
            add(new CommandDto(CommandName.LEFT));
            add(new CommandDto(CommandName.REPORT));
        }};
        SimulationRequest request = new SimulationRequest(commands);

        SimulationResponse actual = this.restTemplate.postForObject("/api/simulate", request, SimulationResponse.class);

        SimulationResponse expected = new SimulationResponse(new PositionDto(new PointDto(0, 0), CardinalDirection.WEST));
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void testSimulationIgnoreCommandsWhenRobotCannotMoveForward() {
        PositionDto position = new PositionDto(new PointDto(0, 0), CardinalDirection.SOUTH);
        List<CommandDto> commands = new ArrayList<CommandDto>() {{
            add(new PlaceCommandDto(position));
            add(new CommandDto(CommandName.MOVE));
            add(new CommandDto(CommandName.REPORT));
        }};
        SimulationRequest request = new SimulationRequest(commands);

        SimulationResponse actual = this.restTemplate.postForObject("/api/simulate", request, SimulationResponse.class);

        SimulationResponse expected = new SimulationResponse(new PositionDto(new PointDto(0, 0), CardinalDirection.SOUTH));
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void testSimulationWithMoveAndRotateCommands() {
        PositionDto position = new PositionDto(new PointDto(1, 2), CardinalDirection.EAST);
        List<CommandDto> commands = new ArrayList<CommandDto>() {{
            add(new PlaceCommandDto(position));
            add(new CommandDto(CommandName.MOVE));
            add(new CommandDto(CommandName.MOVE));
            add(new CommandDto(CommandName.LEFT));
            add(new CommandDto(CommandName.MOVE));
            add(new CommandDto(CommandName.RIGHT));
            add(new CommandDto(CommandName.REPORT));
        }};
        SimulationRequest request = new SimulationRequest(commands);

        SimulationResponse actual = this.restTemplate.postForObject("/api/simulate", request, SimulationResponse.class);

        SimulationResponse expected = new SimulationResponse(new PositionDto(new PointDto(3, 3), CardinalDirection.EAST));
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void testSimulationShouldReturnApiErrorWhenRobotIsMissing() {
        PositionDto position = new PositionDto(new PointDto(0, -1), CardinalDirection.NORTH);
        List<CommandDto> commands = new ArrayList<CommandDto>() {{
            add(new PlaceCommandDto(position));
            add(new CommandDto(CommandName.MOVE));
            add(new CommandDto(CommandName.REPORT));
        }};
        SimulationRequest request = new SimulationRequest(commands);

        ApiError actual = this.restTemplate.postForObject("/api/simulate", request, ApiError.class);

        ApiError expected = new ApiError(HttpStatus.BAD_REQUEST.value(), "ROBOT MISSING");
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "timestamp");
    }
}
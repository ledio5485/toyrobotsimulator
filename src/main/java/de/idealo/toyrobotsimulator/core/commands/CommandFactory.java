package de.idealo.toyrobotsimulator.core.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.idealo.toyrobotsimulator.model.CardinalDirection;
import de.idealo.toyrobotsimulator.rest.dto.CommandDto;
import de.idealo.toyrobotsimulator.rest.dto.PointDto;
import de.idealo.toyrobotsimulator.rest.dto.PositionDto;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    private final ObjectMapper objectMapper;

    public CommandFactory(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Command create(CommandDto commandDto) {
        switch (commandDto.getName()) {
            case PLACE:
                PositionDto positionDto = objectMapper.convertValue(commandDto.getArgs(), PositionDto.class);
                PointDto location = positionDto.getLocation();
                return new PlaceCommand(location.getX(), location.getY(), CardinalDirection.valueOf(positionDto.getFacing().toString()));
            case MOVE:
                return new MoveCommand();
            case LEFT:
                return new RotateLeftCommand();
            case RIGHT:
                return new RotateRightCommand();
            case REPORT:
                return new ReportCommand();
            default:
                throw new IllegalArgumentException("Command not found");
        }
    }
}

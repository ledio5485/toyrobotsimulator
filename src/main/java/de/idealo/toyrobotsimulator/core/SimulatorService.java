package de.idealo.toyrobotsimulator.core;

import de.idealo.toyrobotsimulator.configuration.BoardConfiguration;
import de.idealo.toyrobotsimulator.core.commands.Command;
import de.idealo.toyrobotsimulator.model.Position;
import de.idealo.toyrobotsimulator.model.Robot;
import de.idealo.toyrobotsimulator.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulatorService {

    private final BoardConfiguration boardConfiguration;

    public SimulatorService(BoardConfiguration boardConfiguration) {
        this.boardConfiguration = boardConfiguration;
    }

    public Position execute(List<Command> commands) {
        Vehicle robot = new Robot(boardConfiguration);
        commands.forEach(command -> command.execute(robot));
        return robot.report()
                .orElseThrow(() -> new IllegalStateException("ROBOT MISSING"));
    }
}

package foo.bar.toyrobotsimulator.core;

import foo.bar.toyrobotsimulator.configuration.BoardConfiguration;
import foo.bar.toyrobotsimulator.core.commands.Command;
import foo.bar.toyrobotsimulator.model.Position;
import foo.bar.toyrobotsimulator.model.Robot;
import foo.bar.toyrobotsimulator.model.Vehicle;
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

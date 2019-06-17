package foo.bar.toyrobotsimulator.rest.dto;

import java.util.Collections;
import java.util.List;

public class SimulationRequest {
    private List<CommandDto> commands;

    public SimulationRequest() {
    }

    public SimulationRequest(List<CommandDto> commands) {
        this.commands = commands;
    }

    public List<CommandDto> getCommands() {
        return Collections.unmodifiableList(commands);
    }
}

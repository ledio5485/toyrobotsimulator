package foo.bar.toyrobotsimulator.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Collections;
import java.util.List;

public class SimulationRequest {
    private final List<CommandDto> commands;

    @JsonCreator
    public SimulationRequest(List<CommandDto> commands) {
        this.commands = commands;
    }

    public List<CommandDto> getCommands() {
        return Collections.unmodifiableList(commands);
    }
}

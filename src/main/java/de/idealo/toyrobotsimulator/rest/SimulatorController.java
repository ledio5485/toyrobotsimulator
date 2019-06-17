package de.idealo.toyrobotsimulator.rest;

import de.idealo.toyrobotsimulator.core.SimulatorService;
import de.idealo.toyrobotsimulator.core.commands.Command;
import de.idealo.toyrobotsimulator.rest.dto.PositionDto;
import de.idealo.toyrobotsimulator.rest.dto.SimulationRequest;
import de.idealo.toyrobotsimulator.rest.dto.SimulationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SimulatorController {

    private final SimulatorService simulatorService;
    private final CommandConverter commandConverter;
    private final PositionConverter positionConverter;

    public SimulatorController(SimulatorService simulatorService, CommandConverter commandConverter, PositionConverter positionConverter) {
        this.simulatorService = simulatorService;
        this.commandConverter = commandConverter;
        this.positionConverter = positionConverter;
    }

    @PostMapping(value = "/simulate")
    public SimulationResponse handleRequest(@RequestBody @NotNull SimulationRequest request) {
        List<Command> commands = commandConverter.convert(request.getCommands());
        PositionDto position = positionConverter.convert(simulatorService.execute(commands));
        return new SimulationResponse(position);
    }
}

package de.idealo.toyrobotsimulator.rest;

import de.idealo.toyrobotsimulator.core.commands.Command;
import de.idealo.toyrobotsimulator.core.commands.CommandFactory;
import de.idealo.toyrobotsimulator.rest.dto.CommandDto;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandConverter {
    private final CommandFactory commandFactory;

    public CommandConverter(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public List<Command> convert(Collection<CommandDto> commands) {
        return commands.stream()
                .map(commandFactory::create)
                .collect(Collectors.toList());
    }
}

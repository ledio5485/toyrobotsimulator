package de.idealo.toyrobotsimulator.core.commands;

import de.idealo.toyrobotsimulator.model.Vehicle;

public interface Command {

    void execute(Vehicle vehicle);
}

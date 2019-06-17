package de.idealo.toyrobotsimulator.core.commands;

import de.idealo.toyrobotsimulator.model.Vehicle;

final class MoveCommand implements Command {

    @Override
    public void execute(Vehicle vehicle) {
        vehicle.move();
    }
}

package de.idealo.toyrobotsimulator.core.commands;

import de.idealo.toyrobotsimulator.model.Vehicle;

import static de.idealo.toyrobotsimulator.model.RotationDirection.LEFT;

final class RotateLeftCommand implements Command {

    @Override
    public void execute(Vehicle vehicle) {
        vehicle.rotate(LEFT);
    }
}

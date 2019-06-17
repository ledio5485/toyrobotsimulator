package de.idealo.toyrobotsimulator.core.commands;

import de.idealo.toyrobotsimulator.model.Vehicle;

import static de.idealo.toyrobotsimulator.model.RotationDirection.RIGHT;

final class RotateRightCommand implements Command {

    @Override
    public void execute(Vehicle vehicle) {
        vehicle.rotate(RIGHT);
    }
}

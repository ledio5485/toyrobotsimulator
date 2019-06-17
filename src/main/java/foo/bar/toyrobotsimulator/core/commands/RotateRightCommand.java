package foo.bar.toyrobotsimulator.core.commands;

import foo.bar.toyrobotsimulator.model.Vehicle;
import foo.bar.toyrobotsimulator.model.RotationDirection;

final class RotateRightCommand implements Command {

    @Override
    public void execute(Vehicle vehicle) {
        vehicle.rotate(RotationDirection.RIGHT);
    }
}

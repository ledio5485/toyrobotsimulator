package foo.bar.toyrobotsimulator.core.commands;

import foo.bar.toyrobotsimulator.model.CardinalDirection;
import foo.bar.toyrobotsimulator.model.Point;
import foo.bar.toyrobotsimulator.model.Vehicle;

final class PlaceCommand implements Command {

    private final Point point;
    private final CardinalDirection direction;

    PlaceCommand(int x, int y, CardinalDirection direction) {
        point = new Point(x, y);
        this.direction = direction;
    }

    @Override
    public void execute(Vehicle vehicle) {
        vehicle.place(point, direction);
    }

}

package de.idealo.toyrobotsimulator.core.commands;

import de.idealo.toyrobotsimulator.model.CardinalDirection;
import de.idealo.toyrobotsimulator.model.Point;
import de.idealo.toyrobotsimulator.model.Vehicle;

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

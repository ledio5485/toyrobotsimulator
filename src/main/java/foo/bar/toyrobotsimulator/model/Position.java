package foo.bar.toyrobotsimulator.model;

public class Position {
    private final Point location;
    private final CardinalDirection facing;

    Position(Point location, CardinalDirection facing) {
        this.location = location;
        this.facing = facing;
    }

    public Point getLocation() {
        return location;
    }

    public CardinalDirection getFacing() {
        return facing;
    }
}

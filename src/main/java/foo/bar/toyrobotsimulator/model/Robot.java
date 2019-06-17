package foo.bar.toyrobotsimulator.model;

import foo.bar.toyrobotsimulator.configuration.BoardConfiguration;

import java.util.Optional;

public final class Robot implements Vehicle {
    private final BoardConfiguration board;

    private Point location;
    private CardinalDirection facing;

    public Robot(BoardConfiguration board) {
        this.board = board;
    }

    @Override
    public void place(Point location, CardinalDirection facing) {
        if (board.containsPoint(location)) {
            this.location = location;
            this.facing = facing;
        }
    }

    @Override
    public void move() {
        if(isPresent()) {
            Point latest = location.add(facing.getUnit());
            if (board.containsPoint(latest)) {
                this.location = latest;
            }
        }
    }

    @Override
    public void rotate(RotationDirection rotation) {
        if(isPresent()) {
            int rotatedDegree = facing.getDegree() + rotation.getAngle();
            this.facing = CardinalDirection.of(rotatedDegree, rotation.getAngle());
        }
    }

    @Override
    public Optional<Position> report() {
        return isPresent() ? Optional.of(new Position(location, facing)) : Optional.empty();
    }

    private boolean isPresent() {
        return location != null && facing != null;
    }
}

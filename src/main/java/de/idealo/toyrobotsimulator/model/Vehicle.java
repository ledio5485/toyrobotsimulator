package de.idealo.toyrobotsimulator.model;

import java.util.Optional;

public interface Vehicle {
    void place(Point location, CardinalDirection facing);

    void move();

    void rotate(RotationDirection rotation);

    Optional<Position> report();
}

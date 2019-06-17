package de.idealo.toyrobotsimulator.model;

public enum CardinalDirection {
    NORTH(360, new Point(0,1)),
    EAST(90, new Point(1, 0)),
    SOUTH(180, new Point(0, -1)),
    WEST(270, new Point(-1, 0));

    private final int degree;
    private final Point unit;

    CardinalDirection(int degree, Point unit) {
        this.degree = degree;
        this.unit = unit;
    }

    public int getDegree() {
        return degree;
    }

    public Point getUnit() {
        return unit;
    }

    public static CardinalDirection of(int degree, int angle) {
        CardinalDirection[] directions = values();
        int index = (int) Math.round((((double) degree % 360) / Math.abs(angle))) % directions.length;
        return directions[index];
    }
}

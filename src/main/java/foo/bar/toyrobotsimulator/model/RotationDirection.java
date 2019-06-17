package foo.bar.toyrobotsimulator.model;

public enum RotationDirection {
    LEFT(-90),
    RIGHT(90);

    private final int angle;

    RotationDirection(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }
}

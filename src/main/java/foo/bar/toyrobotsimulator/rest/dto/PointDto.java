package foo.bar.toyrobotsimulator.rest.dto;

public final class PointDto {

    private final int x;
    private final int y;

    public PointDto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

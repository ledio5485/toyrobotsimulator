package foo.bar.toyrobotsimulator.rest.dto;

import javax.validation.constraints.NotNull;

public class PositionDto {
    @NotNull
    private PointDto location;
    @NotNull
    private CardinalDirection facing;

    public PositionDto() {
    }

    public PositionDto(PointDto location, CardinalDirection facing) {
        this.location = location;
        this.facing = facing;
    }

    public PointDto getLocation() {
        return location;
    }

    public CardinalDirection getFacing() {
        return facing;
    }
}

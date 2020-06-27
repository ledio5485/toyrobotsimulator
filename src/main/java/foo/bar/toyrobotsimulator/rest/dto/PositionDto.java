package foo.bar.toyrobotsimulator.rest.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Valid
public class PositionDto {
    @NotNull
    private final PointDto location;
    @NotNull
    private final CardinalDirection facing;

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

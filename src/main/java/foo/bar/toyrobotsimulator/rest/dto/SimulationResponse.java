package foo.bar.toyrobotsimulator.rest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SimulationResponse {
    private final PositionDto position;

    @JsonCreator
    public SimulationResponse(PositionDto position) {
        this.position = position;
    }

    public PositionDto getPosition() {
        return position;
    }
}

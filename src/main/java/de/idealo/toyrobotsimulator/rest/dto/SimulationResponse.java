package de.idealo.toyrobotsimulator.rest.dto;

public class SimulationResponse {
    private PositionDto position;

    public SimulationResponse() {
    }

    public SimulationResponse(PositionDto position) {
        this.position = position;
    }

    public PositionDto getPosition() {
        return position;
    }
}

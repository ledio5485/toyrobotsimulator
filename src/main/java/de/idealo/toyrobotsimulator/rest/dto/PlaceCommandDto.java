package de.idealo.toyrobotsimulator.rest.dto;

import javax.validation.constraints.NotNull;

public class PlaceCommandDto extends CommandDto<PositionDto> {

    public PlaceCommandDto() {
    }

    public PlaceCommandDto(@NotNull PositionDto positionDto) {
        super(CommandName.PLACE, positionDto);
    }
}

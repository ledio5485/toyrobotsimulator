package foo.bar.toyrobotsimulator.rest.dto;

import javax.validation.constraints.NotNull;

public class PlaceCommandDto extends CommandDto<PositionDto> {

    public PlaceCommandDto() {
    }

    public PlaceCommandDto(@NotNull PositionDto positionDto) {
        super(CommandName.PLACE, positionDto);
    }
}

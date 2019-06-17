package foo.bar.toyrobotsimulator.rest;

import foo.bar.toyrobotsimulator.model.Position;
import foo.bar.toyrobotsimulator.rest.dto.CardinalDirection;
import foo.bar.toyrobotsimulator.rest.dto.PointDto;
import foo.bar.toyrobotsimulator.rest.dto.PositionDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionConverter implements Converter<Position, PositionDto> {

    @Override
    public PositionDto convert(Position position) {
        PointDto pointDto = new PointDto(position.getLocation().getX(), position.getLocation().getY());
        return new PositionDto(pointDto, CardinalDirection.valueOf(position.getFacing().name()));
    }
}

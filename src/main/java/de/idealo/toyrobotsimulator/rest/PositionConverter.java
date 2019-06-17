package de.idealo.toyrobotsimulator.rest;

import de.idealo.toyrobotsimulator.model.Position;
import de.idealo.toyrobotsimulator.rest.dto.CardinalDirection;
import de.idealo.toyrobotsimulator.rest.dto.PointDto;
import de.idealo.toyrobotsimulator.rest.dto.PositionDto;
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

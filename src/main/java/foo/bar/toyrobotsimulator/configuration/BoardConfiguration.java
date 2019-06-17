package foo.bar.toyrobotsimulator.configuration;

import foo.bar.toyrobotsimulator.model.Point;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "board-config")
public final class BoardConfiguration {

    private int rows;
    private int columns;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public boolean containsPoint(Point location) {
        return location.getX() >= 0 && location.getX() < columns &&
               location.getY() >= 0 && location.getY() < rows;
    }
}

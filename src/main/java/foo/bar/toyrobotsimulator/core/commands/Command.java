package foo.bar.toyrobotsimulator.core.commands;

import foo.bar.toyrobotsimulator.model.Vehicle;

public interface Command {

    void execute(Vehicle vehicle);
}

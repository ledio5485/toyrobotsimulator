package foo.bar.toyrobotsimulator.core.commands;

import foo.bar.toyrobotsimulator.model.Vehicle;

final class ReportCommand implements Command {

    @Override
    public void execute(Vehicle vehicle) {
        vehicle.report();
    }
}

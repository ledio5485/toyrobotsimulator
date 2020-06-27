package foo.bar.toyrobotsimulator.rest.dto;

import javax.validation.constraints.NotNull;

public class CommandDto<T> {

    @NotNull
    private final CommandName name;
    private final T args;

    public CommandDto(CommandName name) {
        this.name = name;
        this.args = null;
    }

    public CommandDto(CommandName name, T args) {
        this.name = name;
        this.args = args;
    }

    public CommandName getName() {
        return name;
    }

    public T getArgs() {
        return args;
    }
}

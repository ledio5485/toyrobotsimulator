package foo.bar.toyrobotsimulator.rest.dto;

import javax.validation.constraints.NotNull;

public class CommandDto<T> {

    @NotNull
    private CommandName name;
    private T args;

    public CommandDto() {
    }

    public CommandDto(CommandName name) {
        this.name = name;
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

package exercise.barracksWars1.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}

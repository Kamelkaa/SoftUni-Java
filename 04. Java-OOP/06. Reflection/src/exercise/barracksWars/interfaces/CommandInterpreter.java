package exercise.barracksWars.interfaces;

import exercise.barracksWars1.interfaces.Executable;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}

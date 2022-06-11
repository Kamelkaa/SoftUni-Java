package exercise.barracksWars1;

import exercise.barracksWars1.interfaces.Repository;
import exercise.barracksWars1.interfaces.Runnable;
import exercise.barracksWars1.interfaces.UnitFactory;
import exercise.barracksWars1.core.Engine;
import exercise.barracksWars1.core.factories.UnitFactoryImpl;
import exercise.barracksWars1.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}

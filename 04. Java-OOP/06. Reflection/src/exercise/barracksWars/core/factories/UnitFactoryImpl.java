package exercise.barracksWars.core.factories;

import exercise.barracksWars1.interfaces.Unit;
import exercise.barracksWars1.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> constructor = unitClass.getConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}

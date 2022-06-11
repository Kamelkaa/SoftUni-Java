package exercise.barracksWars.interfaces;

import exercise.barracksWars1.interfaces.Unit;

public interface UnitFactory {

    Unit createUnit(String unitType);
}
package ru.kolyadintseva.jungles._main;

import ru.kolyadintseva.jungles.entity.Tiger;
import ru.kolyadintseva.jungles.util.EventSimulator;

public class _Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(tiger);
    }
}


package com.codecool.marsexploration.mapexplorer.simulation.analyzers;

import com.codecool.marsexploration.mapexplorer.simulation.ExplorationOutcome;
import com.codecool.marsexploration.mapexplorer.simulation.SimulationContext;

public class TimeoutAnalyzer implements OutcomeAnalyzer{
    @Override
    public boolean checkforOutcome(SimulationContext context) {

        if (context.getStepsToTimeout() == context.getStepsNumber()) {
            context.setOutcome(ExplorationOutcome.TIMEOUT);
            System.out.println("Rover run out of energy. Mission failure.");
            return true;
        }
        System.out.println("Rover still running");
        return false;
    }
}

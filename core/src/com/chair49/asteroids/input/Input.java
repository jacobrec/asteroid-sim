package com.chair49.asteroids.input;

import com.chair49.asteroids.controller.FieldController;
import com.chair49.asteroids.model.AsteroidField;

/**
 * Created by jacob on 30/10/17.
 */
public abstract class Input {
    abstract boolean isResetPressed();

    abstract boolean isIncreaseAsteroidsPressed();

    abstract boolean isDecreaseAsteroidsPressed();

    abstract boolean isUpPressed();

    abstract boolean isDownPressed();

    abstract boolean isRightPressed();

    abstract boolean isLeftPressed();

    abstract boolean isFirePressed();

    public int handleInput(FieldController controller, AsteroidField model) {
        // Reset if space is pressed
        if (this.isResetPressed()) {
            controller.setupWorld(model);
        } else if (this.isIncreaseAsteroidsPressed()) {
            // Add an asteroid
            controller.asteroidCount += 5;
        } else if (this.isDecreaseAsteroidsPressed()) {
            // Subtract an asteroid
            controller.asteroidCount -= 4;
        }
        if (this.isRightPressed()) {
            model.shuttle.applyTurnThrusters(-2);
        }
        if (this.isUpPressed()) {
            model.shuttle.applyRearThrusters(10);
        }
        if (this.isLeftPressed()) {
            model.shuttle.applyTurnThrusters(2);
        }
        return controller.asteroidCount;
    }


}

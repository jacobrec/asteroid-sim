package com.chair49.astroids.controller;

import com.badlogic.gdx.math.Vector2;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;

/**
 * Created by jacob on 29/10/17.
 */
public class FieldController {
    // Max distance off screen asteroids are allowed to travel
    int padding = 5;

    public void update(AsteroidField model, float delta) {
        model.getWorld().step(delta, 6, 2);

        // Check for asteroids that are out of bounds and travelling away from the screen
        // Then wrap them to the opposite side of the world
        for (Asteroid asteroid : model.asteroids) {
            Vector2 position = asteroid.getBody().getPosition();
            Vector2 velocity = asteroid.getBody().getLinearVelocity();

            // Horizontal bounds
            float minX = -padding;
            float maxX = model.getWorldWidth() + padding;
            if (position.x < minX && velocity.x < 0) {
                position.x = maxX;
            } else if (position.x > maxX && velocity.x > 0) {
                position.x = minX;
            }

            // Vertical bounds
            float minY = -padding;
            float maxY = model.getWorldHeight() + padding;
            if (position.y < minY && velocity.y < 0) {
                position.y = maxY;
            } else if (position.y > maxY && velocity.y > 0) {
                position.y = minY;
            }

            asteroid.getBody().setTransform(position, asteroid.getBody().getAngle());
        }
    }
}

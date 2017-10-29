package com.chair49.astroids.controller;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;
import com.chair49.astroids.model.LightWeightAstroidThingy;
import com.chair49.astroids.model.Shuttle;

import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class FieldController {
    // Max distance off screen asteroids are allowed to travel
    final private int padding = 5;

    public FieldController(AsteroidField model){
        // Create the asteroids with random positions and velocities
        for (int i = 0; i < model.getAsteroidCount(); i++) {
            float x = MathUtils.random(AsteroidField.worldWidth);
            float y = MathUtils.random(AsteroidField.worldHeight);
            float vx = MathUtils.random(-3f,3f);
            float vy = MathUtils.random(-3f,3f);
            Asteroid asteroid = AsteroidFactory.getAsteroid(model.getWorld(), new Vector2(vx, vy),new Vector2(x, y), MathUtils.random(0.5f, 1f));
            model.addAsteroid(asteroid);
        }
        model.getWorld().setContactListener(new Destructor3000(model));
    }

    public void update(AsteroidField model, float delta) {
        model.getWorld().step(delta, 6, 2);
        repositionOffscreenAsteroids(model);
        removeDeadAsteroids(model);
        addNewAstroids(model);
    }

    private void addNewAstroids(AsteroidField model) {
        for(int i = model.asteroidsToAdd.size()-1; i >= 0; i--){
            model.addAsteroid(AsteroidFactory.getAsteroid(model.asteroidsToAdd.remove(i)));
        }
    }

    private void removeDeadAsteroids(AsteroidField model) {
        for(int i = model.asteroids.size()-1; i >= 0; i--){
            if(model.asteroids.get(i).killMe){
                AsteroidFactory.recycle(model.asteroids.remove(i));
            }
        }
    }


    private void repositionOffscreenAsteroids(AsteroidField model) {
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

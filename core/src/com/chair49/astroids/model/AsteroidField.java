package com.chair49.astroids.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidField {
    public List<Asteroid> asteroids;
    World world;
    final int asteroidCount = 100;
    final float worldWidth = 16f;
    final float worldHeight = 9f;
    // Ratio between Gdx world measurements and coordinate system.
    final float boxToWorld = Gdx.graphics.getWidth() / worldWidth;

    public AsteroidField() {
        // Linked list because we will mainly be iterating the entire array as well as adding and removing from random indices
        asteroids = new LinkedList<Asteroid>();
        Box2D.init();
        world = new World(new Vector2(0, 0), true);

        // Create the asteroids with random positions and velocities
        for (int i = 0; i < asteroidCount; i++) {
            float x = MathUtils.random(worldWidth);
            float y = MathUtils.random(worldHeight);
            Asteroid asteroid = new Asteroid(world, new Vector2(x, y), MathUtils.random(1f, 3f));
            float vx = MathUtils.random(-3f,3f);
            float vy = MathUtils.random(-3f,3f);
            asteroid.setVelocity(new Vector2(vx, vy));
            asteroids.add(asteroid);
        }
    }

    public World getWorld() {
        return world;
    }

    public float getWorldWidth() {
        return worldWidth;
    }

    public float getWorldHeight() {
        return worldHeight;
    }

    public float getBoxToWorld() {
        return boxToWorld;
    }
}


package com.chair49.astroids.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.chair49.astroids.model.Asteroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidFactory {
    List<Asteroid> astroids;

    public AsteroidFactory(int poolSize) {
        this.astroids = new ArrayList<Asteroid>(poolSize);
    }
    public Asteroid getAsteroid(float area, Vector2 momentum, Vector2 position, World world){
        return new Asteroid(world, position, area);
    }
}

package com.chair49.astroids.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.chair49.astroids.model.Asteroid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidFactory {
    static LinkedList<Asteroid> astroids;

    static {
        AsteroidFactory.astroids = new LinkedList<Asteroid>();
    }

    /**
     * Returns a new asteroid, if there is a recycled in is
     *
     * @param area     of the new asteroid
     * @param momentum of the new asteroid
     * @param position of the new asteroid
     * @param world    of the new asteroid
     * @return the new asteroid
     */
    public static Asteroid getAsteroid(World world, Vector2 momentum, Vector2 position, float area) {
        Asteroid a;
        if (astroids.size() > 0) {
            a = AsteroidFactory.astroids.pop();
            a.reset(world, position, area, momentum);
        } else {
            a = new Asteroid(world, position, area, momentum);
        }
        return a;
    }

    /**
     * Removes asteroids from the world, adds it to a list of objects to be recycled
     *
     * @param a Asteroid to recycle
     */
    public static void recycle(Asteroid a) {
        AsteroidFactory.astroids.add(a);
        a.getBody().getWorld().destroyBody(a.getBody());
        for (int i = 0; i < a.getBody().getFixtureList().size; i++) {
            a.getBody().destroyFixture(a.getBody().getFixtureList().get(i));
        }
    }
}

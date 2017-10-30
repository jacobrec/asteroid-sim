package com.chair49.asteroids.controller;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.chair49.asteroids.model.Asteroid;
import com.chair49.asteroids.model.LightWeightAsteroidThingy;

import java.util.LinkedList;

/**
 * Created by jacob on 29/10/17.
 */
public class AsteroidFactory {
    static LinkedList<Asteroid> asteroids;

    static {
        AsteroidFactory.asteroids = new LinkedList<Asteroid>();
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
        if (asteroids.size() > 0) {
            a = AsteroidFactory.asteroids.pop();
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
        AsteroidFactory.asteroids.add(a);
        a.getBody().getWorld().destroyBody(a.getBody());
        for (int i = 0; i < a.getBody().getFixtureList().size; i++) {
            a.getBody().destroyFixture(a.getBody().getFixtureList().get(i));
        }
    }

    public static Asteroid getAsteroid(LightWeightAsteroidThingy a) {
        return getAsteroid(a.w, a.momentum, a.position, a.area);
    }
}

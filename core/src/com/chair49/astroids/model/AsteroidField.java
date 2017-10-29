package com.chair49.astroids.model;

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

    public AsteroidField(){
        // Linked list because we will mainly be iterating the entire array as well as adding and removing from random locations
        asteroids = new LinkedList<Asteroid>();
        Box2D.init();
        world = new World(new Vector2(0, 0), true);
    }
}

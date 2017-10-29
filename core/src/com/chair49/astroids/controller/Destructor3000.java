package com.chair49.astroids.controller;

import com.badlogic.gdx.physics.box2d.*;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;

/**
 * Created by jacob on 29/10/17.
 */
public class Destructor3000 implements ContactListener {
    AsteroidField model;
    public Destructor3000(AsteroidField world){
        this.model = world;
    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {
        Body b1 = contact.getFixtureA().getBody();
        Body b2 = contact.getFixtureB().getBody();
        Asteroid a1 = model.getAsteroidFromBody(b1);
        Asteroid a2 = model.getAsteroidFromBody(b2);
       // AsteroidFactory.recycle(a1);AsteroidFactory.recycle(a2);

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

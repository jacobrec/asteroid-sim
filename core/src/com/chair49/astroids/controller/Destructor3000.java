package com.chair49.astroids.controller;

import com.badlogic.gdx.physics.box2d.*;
import com.chair49.astroids.model.Asteroid;
import com.chair49.astroids.model.AsteroidField;
import com.chair49.astroids.model.LightWeightAstroidThingy;

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
        a1.killMe = true;
        a2.killMe = true;

        LightWeightAstroidThingy a3 = new LightWeightAstroidThingy(model.getWorld(), a1.getBody().getLinearVelocity(), a2.getBody().getPosition(), 1);
//        Asteroid a4 = model.getAsteroidFromBody(b1);
//        Asteroid a5 = model.getAsteroidFromBody(b1);


          //model.asteroidsToAdd.add(a3);
//        model.asteroidsToAdd.add(a4);
//        model.asteroidsToAdd.add(a5);


    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

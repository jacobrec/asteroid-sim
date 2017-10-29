package com.chair49.astroids.controller;

import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by jacob on 29/10/17.
 */
public class Destructor3000 implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Body b1 = contact.getFixtureA().getBody();
        Body b2 = contact.getFixtureB().getBody();

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

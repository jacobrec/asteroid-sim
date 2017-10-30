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

    public Destructor3000(AsteroidField world) {
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

        if (b1 == model.shuttle.getBody() || b2 == model.shuttle.getBody()) {
            // empty on purpose
        } else if (Math.abs(a1.area - a2.area) > 0.5f) {
            // empty on purpose
        } else if (a1.timeAlive + a2.timeAlive > 1) {
            a1.killMe = true;
            a2.killMe = true;
            if (a1.area + a2.area > 0.01f) {


                LightWeightAstroidThingy a3 = new LightWeightAstroidThingy(model.getWorld(), a1.getBody().getLinearVelocity().add(0.1f, 0.1f), a1.getBody().getPosition().add(0.2f, 0.2f), a1.area / 5);
                LightWeightAstroidThingy a4 = new LightWeightAstroidThingy(model.getWorld(), a1.getBody().getLinearVelocity().add(-0.1f, -0.1f), a1.getBody().getPosition().add(-0.2f, -0.2f), a1.area / 5);
                LightWeightAstroidThingy a5 = new LightWeightAstroidThingy(model.getWorld(), a2.getBody().getLinearVelocity().add(0.1f, 0.1f), a2.getBody().getPosition(), a2.area / 5);

                model.asteroidsToAdd.add(a3);
                model.asteroidsToAdd.add(a4);
                model.asteroidsToAdd.add(a5);
                //model.asteroidsToAdd.add(a6);
            }
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}

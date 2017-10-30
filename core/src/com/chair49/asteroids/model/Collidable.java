package com.chair49.asteroids.model;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by jacob on 29/10/17.
 */
public abstract class Collidable {
    Body body;


    public Body getBody() {
        return body;
    }


    public void setBody(Body body) {
        this.body = body;
    }

}

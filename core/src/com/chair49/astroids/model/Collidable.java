package com.chair49.astroids.model;

import com.badlogic.gdx.math.Vector2;
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

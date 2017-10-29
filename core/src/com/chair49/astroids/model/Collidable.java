package com.chair49.astroids.model;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

import java.util.List;

/**
 * Created by jacob on 29/10/17.
 */
public abstract class Collidable {
    Body body;
    List<Fixture> segments;



    public Body getBody() {
        return body;
    }

    public List<Fixture> getSegments() {
        return segments;
    }



    public void setBody(Body body) {
        this.body = body;
    }

    public void setSegments(List<Fixture> segments) {
        this.segments = segments;
    }
}

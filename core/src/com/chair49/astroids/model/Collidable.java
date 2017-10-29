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
    Polygon collision;
    Rectangle boundingBox;

    Vector2 position;
    Vector2 acceleration;

    double mass;

    Body body;

    List<Fixture> segments;

    public Polygon getCollisionPolygon() {
        return collision;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public double getMass() {
        return mass;
    }

    public Body getBody() {
        return body;
    }

    public List<Fixture> getSegments() {
        return segments;
    }

    public void setCollisionPolygon(Polygon collision) {
        this.collision = collision;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public void setSegments(List<Fixture> segments) {
        this.segments = segments;
    }
}

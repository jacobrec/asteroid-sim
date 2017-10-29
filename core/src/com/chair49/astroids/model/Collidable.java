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

}

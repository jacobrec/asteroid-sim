package com.chair49.astroids.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jacob on 29/10/17.
 */
public class LightWeightAstroidThingy {
    public World w;
    public Vector2 momentum;
    public Vector2 position;
    public float area;

    public LightWeightAstroidThingy(World w, Vector2 momentum, Vector2 position, float area) {
        this.w = w;
        this.momentum = momentum;
        this.position = position;
        this.area = area;
    }
}

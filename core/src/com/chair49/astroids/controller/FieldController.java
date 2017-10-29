package com.chair49.astroids.controller;

import com.chair49.astroids.model.AsteroidField;

/**
 * Created by jacob on 29/10/17.
 */
public class FieldController {
    public void update(AsteroidField model, float delta) {
        model.getWorld().step(delta, 6, 2);
    }
}

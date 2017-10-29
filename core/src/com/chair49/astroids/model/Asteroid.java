package com.chair49.astroids.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.LinkedList;

/**
 * Created by jacob on 29/10/17.
 */
public class Asteroid extends Collidable {

    public Asteroid(World world, Vector2 position) {
        this.segments = new LinkedList<Fixture>();

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // Set our body's starting position in the world
        bodyDef.position.set(position);

        this.body = world.createBody(bodyDef);

        for (int i = 0; i < 1; i++) {
            segments.add(createFixture(body));
        }
    }

    private Fixture createFixture(Body body) {
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape triangle = new PolygonShape();

        triangle.set(new float[]{0, 0, 0, 1, 0.5f, 1});

        fixtureDef.shape = triangle;
        fixtureDef.density = 0.5f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.6f; // Make it bounce a little bit
        return body.createFixture(fixtureDef);
    }
}
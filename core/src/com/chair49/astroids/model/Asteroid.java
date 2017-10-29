package com.chair49.astroids.model;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.LinkedList;
import java.util.List;

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

        createFixtures(body, 5);
    }

    private void createFixtures(Body body, int numberOfFixtures) {
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape triangle = new PolygonShape();

        Vector2[] vertices = new Vector2[3];
        List<Vector2> points = new LinkedList<Vector2>();
        points.add(getPoint());
        points.add(getPoint());



        for(int i = 0; i < numberOfFixtures; i++) {
            points.add(getPoint());

            vertices = points.subList(points.size() - 3, points.size()).toArray(vertices);
            triangle.set(vertices);

            fixtureDef.shape = triangle;
            fixtureDef.density = MathUtils.random(0.1f, 5f);
            fixtureDef.friction = MathUtils.random(0.1f, 5f);
            fixtureDef.restitution = MathUtils.random(0.1f, 0.9f); // Make it bounce a little bit

            segments.add(body.createFixture(fixtureDef));
        }
    }

    public Vector2 getPoint(){
        return new Vector2(MathUtils.random() + 0.1f, MathUtils.random() + 0.1f);
    }

    public void setVelocity(Vector2 velocity) {
        this.body.setLinearVelocity(velocity);
    }
}

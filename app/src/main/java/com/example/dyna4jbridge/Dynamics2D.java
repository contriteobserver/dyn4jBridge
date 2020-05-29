package com.example.dyna4jbridge;

import androidx.annotation.Nullable;

import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;

class Dynamics2D {

    private World dynWorld;

    Dynamics2D()
    {
        dynWorld = new World();
    }

    void Update(double ellapsedRealtime)
    {
        dynWorld.update(ellapsedRealtime);
    }

    void destroyBody(Body body) {
        dynWorld.removeBody(body);
    }

    Body CreateSquare(Vector2 position, @Nullable Vector2 velocity)
    {
        Vector2 v = velocity == null ? new Vector2() : velocity;

        Body body = new Body();
        body.addFixture(Geometry.createSquare(2.0));
        body.rotate(Math.PI/4);
        body.translate(position);
        body.setMass(MassType.NORMAL);
        dynWorld.addBody(body);
        return body;
    }

    Body CreateCircle(Vector2 position, @Nullable Vector2 velocity)
    {
        Vector2 v = velocity == null ? new Vector2() : velocity;

        Body body = new Body();
        body.addFixture(Geometry.createCircle(1.0));
        body.translate(position);
        body.setMass(MassType.NORMAL);
        dynWorld.addBody(body);
        return body;
    }

    Body CreateBarrier(Vector2 position, float width, float height)
    {
        Body body = new Body();
        body.addFixture(Geometry.createRectangle(width, height));
        body.translate(position);
        body.setMass(MassType.INFINITE);
        dynWorld.addBody(body);
        return body;
    }
}

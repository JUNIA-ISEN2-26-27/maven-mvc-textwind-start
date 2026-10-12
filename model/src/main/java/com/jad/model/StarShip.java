package com.jad.model;

import com.jad.view.Pixel;

import java.awt.*;

public class StarShip extends AbstractPixelMatrix {
    private final Point position = new Point(0, 0);
    private Maze maze;

    public StarShip(final Dimension dimension, final Pixel[][] pixels) {
        super(dimension, pixels);
    }

    public Point getPosition() {
        return this.position;
    }

    public int getX() {
        return this.position.x;
    }

    public int getY() {
        return this.position.y;
    }

    public void moveUp() {
        this.position.y--;
    }

    public void moveDown() {
        this.position.y++;
    }

    public void moveForward() {
        this.position.x = (this.position.x + 1) % (this.maze.getWidth() + this.dimension.width);
    }

    public void setMaze(final Maze maze) {
        this.maze = maze;
        this.position.y = this.maze.getHeight() / 2;
    }
}

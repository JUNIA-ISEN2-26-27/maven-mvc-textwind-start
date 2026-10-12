package com.jad.model;

import com.jad.view.Pixel;

import java.awt.*;

public class Model implements IModel {
    private Maze maze;
    private StarShip starShip;

    public Model() {
        this.starShip = Util.makeStarShipFromFile("starship.txt");
    }

    @Override
    public Screen getScreen(final Dimension dimension) {
        final int startX = this.starShip.getX() - (dimension.width / 2);
        final int startY = this.starShip.getY() - (dimension.height / 2);
        Pixel[][] pixels = new Pixel[dimension.height][dimension.width];
        for (int y = startY; y < dimension.height + startY; y++) {
            for (int x = startX; x < dimension.width + startX; x++) {
                Pixel temp;
                if ((x >= this.starShip.getX()) && (x < this.starShip.getX() + this.starShip.dimension.width) &&
                        (y >= this.starShip.getY()) && (y < this.starShip.getY() + this.starShip.dimension.height)) {
                    temp = new Pixel(
                            this.starShip.getPixelAt(x - this.starShip.getX(),
                                                     y - this.starShip.getY()
                                                    ).obstacle());
                } else if ((x < 0) || (x >= this.maze.getWidth())) {
                    temp = new Pixel(false);
                } else if ((y < 0) || (y >= this.maze.getHeight())) {
                    temp = new Pixel(true);
                } else {
                    temp = this.maze.getPixelAt(x, y);
                }
                pixels[y - startY][x - startX] = temp;
            }
        }
        return new Screen(dimension, pixels);
    }

    @Override
    public void loadMaze(final String fileName) {
        this.maze = Util.makeMazeFromFile(fileName);
        this.starShip.setMaze(this.maze);
    }

    @Override
    public void live() {
        this.starShip.moveForward();
    }
}

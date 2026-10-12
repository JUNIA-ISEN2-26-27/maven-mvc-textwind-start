package com.jad.model;

import com.jad.view.Pixel;
import com.jad.view.Screen;

import java.awt.*;

public class Model implements IModel {
    private Maze maze;
    private Point starShipPosition = new Point(0, 31);

    @Override
    public Screen getScreen(final Dimension dimension) {
        final int startX = this.starShipPosition.x - (dimension.width / 2);
        final int startY = this.starShipPosition.y - (dimension.height / 2);
        Pixel[][] pixels = new Pixel[dimension.height][dimension.width];
        for (int y = startY; y < dimension.height + startY; y++) {
            for (int x = startX; x < dimension.width + startX; x++) {
                Pixel temp;
                if ((x < 0) || (x >= this.maze.getWidth())) {
                    temp = new Pixel(false);
                } else if ((y < 0) || (y >= this.maze.getHeight())) {
                    temp = new Pixel(true);
                } else {
                    temp = this.maze.getPixelAt(x, y);
                }
                pixels[y - startY][x - startX] = temp;
            }
        }
        this.starShipPosition.x = (this.starShipPosition.x + 1) % (this.maze.getWidth() + 64);
        return new Screen(dimension, pixels);
    }

    @Override
    public void loadMaze(final String fileName) {
        this.maze = MazeFactory.makeFromFile(fileName);
    }
}

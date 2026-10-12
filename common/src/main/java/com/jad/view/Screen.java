package com.jad.view;

import java.awt.*;

public record Screen(Dimension dimension,
                     Pixel[][] pixels) {
    int getHeight() {
        return this.dimension.height;
    }

    int getWidth() {
        return this.dimension.width;
    }

    Pixel getPixelAt(Point position) {
        return this.getPixelAt(position.x, position.y);
    }

    Pixel getPixelAt(final int x, final int y) {
        if ((x < 0) || (x > this.dimension.width) || (y < 0) || (y > this.dimension.height)) {
            throw new IllegalArgumentException("Position (" + x + ", " + y + ") is out of range.");
        }
        return this.pixels[y][x];
    }
}

package com.jad.model;

import com.jad.view.Pixel;
import com.jad.view.Screen;

import java.awt.*;

public class Model implements IModel {
    @Override
    public Screen getScreen(final Dimension dimension) {
        Pixel[][] pixels = new Pixel[dimension.height][dimension.width];
        for (int y = 0; y < dimension.height; y++) {
            for (int x = 0; x < dimension.width; x++) {
                if ((x == 0) || (x == dimension.width - 1)
                        || (y == 0) || (y == dimension.height - 1)) {
                    pixels[y][x] = new Pixel(true);
                } else {
                    pixels[y][x] = new Pixel(false);
                }
            }
        }
        return new Screen(dimension, pixels);
    }
}

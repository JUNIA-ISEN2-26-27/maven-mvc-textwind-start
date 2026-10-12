package com.jad.model;

import com.jad.view.Pixel;

import java.awt.*;

public class Screen extends AbstractPixelMatrix implements IScreen {
    public Screen(final Dimension dimension, final Pixel[][] pixels) {
        super(dimension, pixels);
    }
}

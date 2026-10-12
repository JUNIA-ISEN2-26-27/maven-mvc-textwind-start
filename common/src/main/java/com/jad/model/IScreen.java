package com.jad.model;

import com.jad.view.Pixel;

public interface IScreen {
    int getHeight();

    int getWidth();

    Pixel getPixelAt(int x, int y);
}

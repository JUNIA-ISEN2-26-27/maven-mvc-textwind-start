package com.jad.model;


import java.awt.*;

public interface IModel {
    IScreen getScreen(Dimension dimension);

    void loadMaze(final String fileName);

    void live();
}

package com.jad.controller;

import com.jad.model.IModel;
import com.jad.view.IView;

import java.util.ArrayList;
import java.util.List;

public class Controller implements IController {
    private final IModel model;
    private final IView view;

    public Controller(final IModel model, final IView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }


    @Override
    public void proceed() {
        this.view.display();
    }
}

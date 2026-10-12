package com.jad.view;

import com.jad.controller.IController;
import com.jad.model.IModel;
import com.jad.model.IScreen;
import com.jad.textwindow.TextWindow;
import com.jad.textwindow.TextWindowSettings;

import java.awt.*;

public class View implements IView {
    private final IModel model;
    private IController controller;
    private TextWindow textWindow;

    public View(final IModel model) {
        this.model = model;
        TextWindowSettings textWindowSettings = new TextWindowSettings();
        textWindowSettings.setTitle("XenoJava");
        textWindowSettings.setScreenHeight(50);
        textWindowSettings.setScreenWidth(100);
        textWindowSettings.setFontSize(12f);
        this.textWindow = new TextWindow(textWindowSettings);
        this.textWindow.setVisible(true);
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void display() {
        IScreen screen = this.model.getScreen(new Dimension(50, 50));
        StringBuilder screenTxt = new StringBuilder();
        for (int y = 0; y < screen.getHeight(); y++) {
            for (int x = 0; x < screen.getWidth(); x++) {
                screenTxt.append(screen.getPixelAt(x, y).obstacle() ? "██" : "  ");
            }
            screenTxt.append("\n");
        }
        this.textWindow.display(screenTxt.toString());
    }
}

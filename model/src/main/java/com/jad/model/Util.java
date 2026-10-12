package com.jad.model;

import com.jad.view.Pixel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public enum Util {
    ;

    public static Maze makeMazeFromFile(final String fileName) {
        InputStream inputStream = Util.class.getResourceAsStream("/" + fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File " + fileName + " not found.");
        }
        try {
            Result result = getResult(inputStream);
            return new Maze(result.dimension(), result.pixels());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static Result getResult(final InputStream inputStream) throws IOException {
        String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        String[] lines = content.split("\n");
        final Dimension dimension = new Dimension(lines[0].length(), lines.length);
        Pixel[][] pixels = new Pixel[dimension.height][dimension.width];
        for (int y = 0; y < dimension.height; y++) {
            for (int x = 0; x < dimension.width; x++) {
                pixels[y][x] = lines[y].charAt(x) == '1' ? new Pixel(true) : new Pixel(false);
            }
        }
        return new Result(dimension, pixels);
    }

    public static StarShip makeStarShipFromFile(final String fileName) {
        InputStream inputStream = Util.class.getResourceAsStream("/" + fileName);
        if (inputStream == null) {
            throw new IllegalArgumentException("File " + fileName + " not found.");
        }
        try {
            Result result = getResult(inputStream);
            return new StarShip(result.dimension(), result.pixels());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private record Result(Dimension dimension, Pixel[][] pixels) {
    }
}

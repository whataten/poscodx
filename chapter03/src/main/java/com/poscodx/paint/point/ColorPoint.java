package com.poscodx.paint.point;

public class ColorPoint extends Point {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ColorPoint(int x, int y, String color) {
        // setX(x);
        // setY(y);
        super(x, y);
        this.color = color;
    }

    @Override
    public void show() {
        System.out.println("paint point(" + getX() + ", " + getY() + ", " + color + ")");
    }

    // @Override
    // public static void test() {
    // System.out.println("for test2");
    // }
}

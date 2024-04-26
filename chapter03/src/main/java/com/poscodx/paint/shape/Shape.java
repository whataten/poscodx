package com.poscodx.paint.shape;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.Point;

public abstract class Shape implements Drawable {
    Point[] points;
    String fillColor;
    String lineColor;
}

package paint;

public class Main {
    public static void main(String[] args) {
        Point point1 = new Point(10, 20);
        // point.setX(10);
        // point.setY(20);
        // drawPoint(point1);
        // point.disappear();
        // point1.show(false);
        draw(point1);

        ColorPoint point2 = new ColorPoint(100, 200, "red");

        // drawPoint(point2);
        draw(point2);

        MyColorPoint point3 = new MyColorPoint(100, 200, "asdf");

        // drawPoint(point3);
        draw(point3);

        // drawShape(new Triangle());
        // drawShape(new Rectangle());
        // drawShape(new Circle());
        draw(new Triangle());
        draw(new Rectangle());
        draw(new Circle());

        draw(new GraphicText("hello world"));

        var c = new Circle();

        System.out.println(c instanceof Circle);

    }

    private static void draw(Drawable drawable) {
        drawable.draw();
    }

    // private static void drawPoint(Point point) {
    // point.show();
    // }
    private static void drawShape(Shape shape) {
        shape.draw();
    }
    // private static void drawTriangle(Triangle triangle) {
    // triangle.draw();
    // }

    // private static void drawRectangle (Rectangle rectangle) {
    // rectangle.draw();
    // }
}

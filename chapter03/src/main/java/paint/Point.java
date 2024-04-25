package paint;

public class Point implements Drawable {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void show(boolean visible) {
        if (visible) {
            System.out.println("paint point(" + this.x + ", " + this.y + ")");
        } else {
            System.out.println("clear paper");
        }
    }

    public void show() {
        System.out.println("paint point(" + this.x + ", " + this.y + ")");
    }

    public void disappear() {
        System.out.println("clear paper");
    }

    public static void test() {
        System.out.println("for test");
    }

    @Override
    public void draw() {
        show();
    }
}

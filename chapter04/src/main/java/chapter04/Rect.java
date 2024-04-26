package chapter04;

public class Rect {
    private int w;
    private int h;

    public Rect(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Rect [w=" + w + ", h=" + h + "]";
    }

    @Override
    public int hashCode() {
        // final int prime = 31;
        // int result = 1;
        // result = prime * result + w;
        // result = prime * result + h;
        // return result;
        return h*w;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rect other = (Rect) obj;
        if (w * h != other.h * other.w)
            return false;
        return true;
    }
}

package lab4;

import java.awt.Graphics2D;

public abstract class Draw {
    protected int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Draw(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics2D g2d);
}

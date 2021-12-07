package lab4;

import java.awt.*;

public class Circle extends Draw{

    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillOval(x,y,50,50);
    }

    public Circle(int x, int y){
        super(x,y);
    }
}

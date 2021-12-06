package lab4;

import java.awt.*;

public class Square extends Draw{
    @Override
    public void draw(Graphics2D g2d) {
        g2d.fillRect(x,y,50,50);
    }
    public Square(int x, int y){
        super(x,y);
    }
}

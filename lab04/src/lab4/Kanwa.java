package lab4;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Kanwa extends JPanel implements MouseInputListener {

    private boolean drawing = true;
    Draw shape = null;
    private int keyCode;
    private int x;
    private int y;
    ArrayList<Point> points = new ArrayList<>();

    public boolean isDrawing() {
        return drawing;
    }

    public void addDrawing(Draw shape){
        this.shape = shape;
    }

    public Kanwa(){
        setFocusable(true);
        requestFocusInWindow();
        setLayout(null);
        setBounds(5,5, 775, 555);
        setBackground(Color.white);
        this.addKeyListener(new KeyAdapter() { // k - kwadrat, o - koło
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_K ){
                    keyCode = KeyEvent.VK_K;
                }
                if (e.getKeyCode() == KeyEvent.VK_O){
                    keyCode = KeyEvent.VK_O;
                }
            }
        });
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();
        Graphics2D g2d = (Graphics2D) g.create();
        if(!isDrawing()) return;
        if(shape == null) return;
        g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        int a,b;
        for(Point p: points) {
            a = (int)p.getX();
            b = (int)p.getY();
            shape.setX(a);
            shape.setY(b);
            addDrawing(shape);
            shape.draw(g2d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        points.add(new Point(x, y));
        Draw circle = new Circle(x, y); //początkowo rysuje kółka
        addDrawing(circle);

        if (keyCode == KeyEvent.VK_K){ //'k' zamienia rysowane kształty na kwadraty
                Draw square = new Square(x,y);
                addDrawing(square);
        }
        if (keyCode == KeyEvent.VK_O){ //'o' zamienia rysowane kształty na kółka
                circle = new Circle(x,y);
                addDrawing(circle);
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

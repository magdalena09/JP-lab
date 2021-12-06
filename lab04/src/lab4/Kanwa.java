package lab4;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kanwa extends JPanel implements MouseInputListener {

    private boolean drawing = true;
    Draw shape = null;
    private int keyCode;
    private int x;
    private int y;

    public boolean isDrawing() {
        return drawing;
    }

    public void setDrawing(boolean drawing){
        this.drawing = drawing;
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

        addKeyListener(new KeyAdapter() { //nie wchodzi tutaj kod w ogóle
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
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            if(!isDrawing()) return;
            if(shape == null) return;
            g2d.setColor(Color.green);
            shape.draw(g2d);
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        Draw circle = new Circle(x,y);
        addDrawing(circle);
        if (keyCode == KeyEvent.VK_K){
                Draw square = new Square(x,y);
                addDrawing(square);
        }
        if (keyCode == KeyEvent.VK_O){
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

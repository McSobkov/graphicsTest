import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DotsPanel extends JPanel {
    private final int WIDTH = 300, HEIGHT = 200, RADIUS = 6;

    private ArrayList<Point> pointList;
    private int count;

    //---------------------------------------------
    //Sets up this panel to listen to mouse events.
    //---------------------------------------------
    public DotsPanel(){
        pointList = new ArrayList<Point>();
        count = 0;

        addMouseListener(new DotsListener());

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    //------------------------------------------
    // Draws all of the dots stored in the list.
    //------------------------------------------

    public void paintComponent(Graphics page){
        super.paintComponent(page);

        page.setColor(Color.green);

        for (Point point : pointList){
            page.fillOval(point.x - RADIUS, point.y - RADIUS,
                    RADIUS*2, RADIUS*2);
        }

        page.drawString("Count: " + count, 5,15);

    }

    public class DotsListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            pointList.add(e.getPoint());
            count++;
            repaint();
        }

        //---------------------------------
        //Empty Listeners for unused events
        //---------------------------------

        public void mouseClicked(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }

}

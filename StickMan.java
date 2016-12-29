package stickman;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class StickMan extends JComponent{
    
    private static JFrame frame;
    
    public StickMan() {
        System.out.println("Creating stickman");
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Painting");
        
        drawHead();
        drawBody();
        drawArms();
        drawLegs();
        
    }
    
    private void drawHead() {
        
    }
    
    private void drawBody() {
        
    }
    
    private void drawArms() {
        
    }
    
    private void drawLegs() {
        
    }
    
    
    public static void main(String[] args) {
        frame = new JFrame("Stick Man");
        
        frame.add(new StickMan());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}

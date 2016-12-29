package stickman;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Stickman extends JComponent{
    
    private static JFrame frame;
    
    private int headRadius, bodySize, armSize, legSize;
    private int xLocation = 200, yLocation = 136;
    private int xHeadOffset = 0, yHeadOffset = 0;
    
    public Stickman(int headRadius, int bodySize, int armSize, int legSize) {
        this.headRadius = headRadius;
        this.bodySize = bodySize;
        this.armSize = armSize;
        this.legSize = legSize;
        
        System.out.println("Creating stickman");
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("Painting");
        
        drawHead(g);
        drawBody(g);
        drawArms(g);
        drawLegs(g);
        
    }
    
    private void drawHead(Graphics g) {
        // head
        g.drawOval(this.xLocation + this.xHeadOffset, this.yLocation + this.yHeadOffset, this.headRadius*2, this.headRadius*2);
        
        // eye
        int eyeXLocation = new Double(this.xLocation + this.headRadius * 2 * 0.70).intValue();
        int eyeYLocation = new Double(this.yLocation + this.headRadius * 2 * 0.30).intValue();
        int eyeSize = new Double(this.headRadius * 2 * 0.15).intValue();
        g.fillOval(eyeXLocation, eyeYLocation, eyeSize, eyeSize);
        
        //eyebrow
        int eyebrowX1 = eyeXLocation;
        int eyebrowX2 = eyeXLocation + eyeSize;
        int eyebrowY1 = new Double(eyeYLocation - this.headRadius * 2 * 0.10).intValue();
        int eyebrowY2 = new Double(eyeYLocation - this.headRadius * 2 * 0.05).intValue();
        g.drawLine(eyebrowX1, eyebrowY1, eyebrowX2, eyebrowY2);
        
        //mouth
        int mouthX1 = eyeXLocation;
        int mouthX2 = new Double(this.xLocation + this.headRadius * 2 * 0.95).intValue();
        int mouthY = new Double(this.yLocation + this.headRadius * 2 * 0.70).intValue();
        g.drawLine(mouthX1, mouthY, mouthX2, mouthY);
    }
    
    private void drawBody(Graphics g) {
        
    }
    
    private void drawArms(Graphics g) {
        
    }
    
    private void drawLegs(Graphics g) {
        
    }
    
    
    
    /***********************
     * Collision Detection *
     ***********************/
    
    private boolean pointInHead(int x, int y) {
        double distanceFromCenterOfHead = Math.pow(this.headRadius + this.xLocation - x, 2) + Math.pow(this.headRadius + this.yLocation - y, 2);
        
        //System.out.print("(" + x + ", " + y + ") in head : ");
        //System.out.print("(" + this.headRadius + " + " + this.xLocation + " - " + x + ")^2 + " + "(" + this.headRadius + " + " + this.yLocation + " - " + y + ")^2 = ");
        //System.out.println(distanceFromCenterOfHead + " <= " + Math.pow(this.headRadius, 2) + " : " + (distanceFromCenterOfHead <= Math.pow(this.headRadius, 2)));
        
        return distanceFromCenterOfHead <= Math.pow(this.headRadius, 2);
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        int headRadius = 25;
        int bodySize = 50;
        int armSize = 50;
        int legSize = 50;
        
        Stickman george = new Stickman(headRadius, bodySize, armSize, legSize);
        
        setupFrame(george);
        
        george.pointInHead(0,0);
        george.pointInHead(10,10);
        george.pointInHead(0,25);
        george.pointInHead(35,20);
        
    }
    
    private static void setupFrame(Stickman s) {
        frame = new JFrame("Stick Man");
        
        frame.add(s);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}

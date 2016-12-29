package stickman;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Stickman extends JComponent{
    
    private static JFrame frame;
    
    private int headRadius, bodySize, armSize, legSize;
    private int xLocation = 200, yLocation = 136;
    private int leftHandX, leftHandY, rightHandX, rightHandY;
    private iWeapon weapon = new Axe();
    
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
        System.out.println("repainting");
        
        drawHead(g);
        drawBody(g);
        drawArms(g);
        drawLegs(g);
        drawWeapon(g);
    }
    
    private void drawHead(Graphics g) {
        // head
        g.drawOval(this.xLocation, this.yLocation, this.headRadius*2, this.headRadius*2);
        
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
        int bodyX = new Double(this.xLocation + this.headRadius).intValue();
        int bodyY1 = new Double(this.yLocation + this.headRadius * 2).intValue();
        int bodyY2 = new Double(this.yLocation + this.headRadius * 2 + this.bodySize).intValue();
        
        g.drawLine(bodyX, bodyY1, bodyX, bodyY2);
    }
    
    private void drawArms(Graphics g) {
        int armsY1 = new Double(this.yLocation + this.headRadius * 2 + this.bodySize/2).intValue();
        int armsX1 = new Double(this.xLocation + this.headRadius).intValue();
        int armsX2 = new Double(this.xLocation + this.headRadius + this.armSize).intValue();
        
        //left
        int leftArmY2 = new Double(this.yLocation + this.headRadius * 2 + this.bodySize * 0.2).intValue();
        g.drawLine(armsX1, armsY1, armsX2, leftArmY2);
        
        //right
        int rightArmY2 = new Double(this.yLocation + this.headRadius * 2 + this.bodySize * 0.3).intValue();
        g.drawLine(armsX1, armsY1, armsX2, rightArmY2);
        
        this.leftHandX = armsX2;
        this.leftHandY = leftArmY2;
        this.rightHandX = armsX2;
        this.rightHandY = rightArmY2;
    }
    
    private void drawLegs(Graphics g) {
        int legsY1 = new Double(this.yLocation + this.headRadius * 2 + this.bodySize).intValue();
        int legsY2 = new Double(this.yLocation + this.headRadius * 2 + this.bodySize + this.legSize).intValue();
        int legsX1 = new Double(this.xLocation + this.headRadius).intValue();
        
        //left
        int leftLegX2 = new Double(this.xLocation + this.headRadius - legSize/2).intValue();
        g.drawLine(legsX1, legsY1, leftLegX2, legsY2);
        
        //right
        int rightLegX2 = new Double(this.xLocation + this.headRadius + legSize/2).intValue();
        g.drawLine(legsX1, legsY1, rightLegX2, legsY2);
    }
    
    private void drawWeapon(Graphics g) {
        this.weapon.draw(g, Math.min(this.leftHandX, this.rightHandX), Math.max(this.leftHandY, this.rightHandY));
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
    
    private boolean pointInBody(int x, int y) {
        
        return x == this.xLocation + this.headRadius && y >= this.yLocation + headRadius*2 && y <= this.yLocation + headRadius*2 + this.bodySize;
    }
    
    /*private boolean pointInLegs(int x, int y) {
        boolean inLeftLeg = ;
        boolean inRightLeg = ;
        
        return inLeftLeg || inRightLeg;
    }*/
    
    /*private boolean pointInArms(int x, int y) {
        boolean inLeftArm = ;
        boolean inRightArm = ;
        
        return inLeftArm || inRightArm;
    }*/
    
    
    
    
    
    public static void main(String[] args) {
        
        int headRadius = 25;
        int bodySize = 50;
        int armSize = 50;
        int legSize = 50;
        
        Stickman george = new Stickman(headRadius, bodySize, armSize, legSize);
        
        setupFrame(george);
        
        // test head collision
        /*george.pointInHead(0,0);
        george.pointInHead(10,10);
        george.pointInHead(0,25);
        george.pointInHead(35,20);*/
        
        // test body collision
        /*System.out.println(george.pointInBody(0, 0));
        System.out.println(george.pointInBody(225, 136));
        System.out.println(george.pointInBody(225, 186));
        System.out.println(george.pointInBody(225, 196));
        System.out.println(george.pointInBody(225, 236));
        System.out.println(george.pointInBody(225, 246));*/
        
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

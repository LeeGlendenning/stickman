/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickman;

import java.awt.Graphics;

/**
 *
 * @author theboss
 */
public class Bow implements iWeapon{
    
    private final int bowHeight = 40;
     // the handY given in draw method is the bottom hand so this offset is used to center the bow
    private final static int HAND_Y_OFFSET = 5;
    private final static int HAND_X_OFFSET = 23;
    
    public Bow() {
        
    }

    @Override
    public void draw(Graphics g, int handX, int handY) {
        
        int bowY1 = handY - bowHeight;
        int bowY2 = handY + bowHeight - HAND_Y_OFFSET;
        
        // bowstring
        int stringX = handX - HAND_X_OFFSET;
        g.drawLine(stringX, bowY1, stringX, bowY2);
        
        // grip
        int gripArcSize = 50;
        g.drawArc(stringX - gripArcSize/2, bowY1, gripArcSize, bowY2 - bowY1, 90, -180);
        
        
        
    }
    
    @Override
    public void attackAnimation(Graphics g) {
        
    }
    
}

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
        
        handY = handY - 7; // use upper hand instead of lower hand y position
        int bowY1 = handY - bowHeight;
        int bowY2 = handY + bowHeight - HAND_Y_OFFSET;
        
        /***** Draw Bow *****/
        
        // bowstring
        int stringX = handX - HAND_X_OFFSET;
        g.drawLine(stringX, bowY1, stringX, bowY2);
        
        // grip
        int gripArcSize = 50;
        g.drawArc(stringX - gripArcSize/2, bowY1, gripArcSize, bowY2 - bowY1, 90, -180);
        
        /*******************/
        
        drawArrow(g, stringX, gripArcSize, handY);
    }
    
    private void drawArrow(Graphics g, int stringX, int gripArcSize, int handY) {
        // arrow shaft
        int arrowShaftX1 = stringX - 5;
        int arrowShaftX2 = stringX + gripArcSize/2 + 5;
        g.drawLine(arrowShaftX1, handY, arrowShaftX2, handY);
        
        // arrow tip
        int arrowTipSize = 2;
        g.drawLine(arrowShaftX2, handY - arrowTipSize, arrowShaftX2, handY + arrowTipSize); // vertical part
        g.drawLine(arrowShaftX2, handY - arrowTipSize, arrowShaftX2 + arrowTipSize, handY); // diagonal top part
        g.drawLine(arrowShaftX2, handY + arrowTipSize, arrowShaftX2 + arrowTipSize, handY); // diagonal bottom part
        
        // arrow flight
        int flightSize = 2;
        int flight2Offset = 2;
        // part 1
        g.drawLine(arrowShaftX1, handY, arrowShaftX1 - flightSize, handY - flightSize); // diagonal top part
        g.drawLine(arrowShaftX1, handY, arrowShaftX1 - flightSize, handY + flightSize); // diagonal bottom part
        // part 2
        g.drawLine(arrowShaftX1 + flight2Offset, handY, arrowShaftX1 + flight2Offset - flightSize, handY - flightSize); // diagonal top part
        g.drawLine(arrowShaftX1 + flight2Offset, handY, arrowShaftX1 + flight2Offset - flightSize, handY + flightSize); // diagonal bottom part
        
    }
    
    @Override
    public void attackAnimation(Graphics g) {
        
    }
    
}

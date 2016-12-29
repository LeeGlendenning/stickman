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
public class Sword implements iWeapon{
    
    private final int swordHeight = 70;
    
    public Sword() {
        
    }
    
    @Override
    public void draw (Graphics g, int handX, int handY) {
        
        // hilt
        int handleHeight = new Double(swordHeight * .25).intValue();
        int handleWidth = new Double(swordHeight * .05).intValue();
        int handleY1 = handY + new Double(handleHeight * 0.15).intValue() - handleHeight;
        g.drawRect(handX, handleY1, handleWidth, handleHeight);
        
        // hilt ornament
        int ornamentY1 = handleY1 + handleHeight + new Double(handleHeight * 0.06).intValue();
        g.drawOval(handX, ornamentY1, handleWidth, handleWidth);
        
        // hilt guard
        int guardWidth = handleHeight;
        int guardHeight = handleWidth;
        int guardX1 = handX + new Double(handleWidth/2 - guardWidth/2).intValue();
        int guardY1 = handleY1 - handleWidth;
        g.drawRect(guardX1, guardY1, guardWidth, guardHeight);
        
        //blade
        int bladeWidth = new Double(handleWidth * 1.5).intValue();
        int bladeX1 = handX - bladeWidth/2;
        int bladeBotY = handleY1 - guardHeight;
        int bladeTipY = handY - swordHeight - new Double(swordHeight * 0.05).intValue();
        g.drawPolyline(new int[]{bladeX1, bladeX1, handX + bladeWidth, handX + bladeWidth, handX + bladeWidth/4, bladeX1}, 
                new int[]{handY - swordHeight, bladeBotY, bladeBotY, handY - swordHeight, bladeTipY, handY - swordHeight}, 6);
        
    }
    
}

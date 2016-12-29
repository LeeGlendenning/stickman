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
public class Axe implements iWeapon{
    
    private final int axeHeight = 40;
    private final static double HANDLE_WIDTH_MOD = 0.09; // handle width is calculated using this modifier
    
    public Axe() {
        
    }
    
    @Override
    public void draw(Graphics g, int handleX, int handleY) {
        // handle
        int handleY2 = new Double(handleY - axeHeight).intValue();
        int handleWidth = new Double(axeHeight * HANDLE_WIDTH_MOD).intValue();
        g.fillRect(handleX, handleY2, handleWidth, axeHeight);
        
        // bottom of blade
        int botBladeY1 = new Double(handleY - axeHeight * 0.8).intValue();
        int botBladeY2 = new Double(handleY - axeHeight * 0.75).intValue();
        int botBladeX1 = handleX + handleWidth;
        int botBladeX2 = handleX + handleWidth + new Double(axeHeight/4).intValue();
        g.drawLine(botBladeX1, botBladeY1, botBladeX2, botBladeY2);
        
        // bottom of blade
        int topBladeY1 = new Double(handleY - axeHeight).intValue();
        int topBladeY2 = new Double(handleY - axeHeight * 1.05).intValue();
        int topBladeX1 = handleX + handleWidth;
        int topBladeX2 = handleX + handleWidth + new Double(axeHeight/4).intValue();
        g.drawLine(topBladeX1, topBladeY1, topBladeX2, topBladeY2);
        
        // blade
        int bladeY1 = botBladeY2;
        int bladeY2 = topBladeY2;
        int bladeX = topBladeX2;
        g.drawLine(bladeX, bladeY1, bladeX, bladeY2);
    }
    
}

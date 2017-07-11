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
public interface iWeapon {
    
    /**
     * draw method draws the weapon starting at given x, y coordinate using the given Graphics object
     * @param g Graphics object used to draw the weapon
     * @param x int x value to begin drawing at
     * @param y int y value to vegin drawing at
     */
    void draw(Graphics g, int x, int y);
    
    void attackAnimation(Graphics g);
}

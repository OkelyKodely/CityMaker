
import java.awt.Graphics;
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhcho
 */
public class Renderer {
    public void draw(Image[] img, CityMaker.Img[] imgs, Graphics g) {
        for(int i=0; i<img.length; i++) {
            try {
                g.drawImage(img[i], imgs[i].x, imgs[i].y, imgs[i].width, imgs[i].height, null);
            } catch(Exception e) {
            }
        }
    }
}

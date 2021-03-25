/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Diurno
 */
public class CreacionCaja extends JPanel{
        int height;
        int width;
    public CreacionCaja(int name){
        this.width = (int)Math.floor(Math.random() * 500);
        this.height = (int)Math.floor(Math.random() * 500);
        this.setName(""+name+"");
        this.setBackground(java.awt.Color.red);
        this.setBounds(width,height,30,30);
        this.setVisible(true);
        this.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                death();
            }

            public void mousePressed(MouseEvent e) {
                
            }

            public void mouseReleased(MouseEvent e) {
               
            }

            public void mouseEntered(MouseEvent e) {
                
            }

            public void mouseExited(MouseEvent e) {

            }
        
        });
        
    }
    public void death(){
        System.out.println("dead: " + this.getName());
        this.setVisible(false);
        Ventana.caja.remove(this.getName());
        Ventana.points ++;
        Ventana.a.setText("Points: " +Ventana.points);
        if(Ventana.points == Ventana.nextLvl){
            updateSpeed();
        }
    }
    public void updateSpeed(){
        Ventana.nextLvl += 10;
        Ventana.velocidad -= 0.2;
        System.out.println(Ventana.velocidad);
    }
}

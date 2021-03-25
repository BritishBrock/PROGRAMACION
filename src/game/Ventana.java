
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.*;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javax.swing.*;


public class Ventana extends JFrame{
    
    JPanel p;
    JButton creador;
    JButton stop;
    Thread t1;
    
    static double velocidad;
    static int nextLvl;
    
    static ArrayList<JPanel> caja = new ArrayList<JPanel>();
    static JTextArea a;
    
    static int points;
    public Ventana(){
        this.setSize(600, 600);
        this.setLayout(null);
        this.setName("game");
        this.points = 0;
        this.velocidad = 2;
        this.nextLvl = 10;
        p = new JPanel();
        p.setBackground(java.awt.Color.blue);
        p.setSize(this.getWidth(), this.getHeight());
        p.setVisible(true);
        p.setLayout(null);
        this.add(p);
        
        a = new JTextArea();
        a.setText("Points: " + points);
        a.setBounds(350,0,100,50);
        a.setBackground(java.awt.Color.blue);
        a.setForeground(java.awt.Color.white);
        a.setVisible(true);
        p.add(a);
        
        
        
        creador = new JButton("start");
        creador.setBackground(java.awt.Color.gray);
        creador.setSize(100,20);
        creador.setVisible(true);
        creador.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                start();
            }
        });
        p.add(creador);
        stop = new JButton("Stop");
        stop.setBackground(java.awt.Color.gray);
        stop.setBounds(100,0,100,20);
        stop.setVisible(true);
        stop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t1.stop();
            }
        });
        p.add(stop);
        this.setVisible(true);
    }
    public void start(){
        t1 = new Thread(){
            public void run(){
                while(true){
                    JPanel elemento = new CreacionCaja(caja.size());
                    p.add(elemento);
                    caja.add(elemento);
                    p.repaint();
                    try{Thread.sleep((long) (velocidad*1000));}catch(Exception e){System.out.println(e.getMessage());}
                }
            }
        };
        t1.start();
    }
}

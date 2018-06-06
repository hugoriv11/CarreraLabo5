/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrera.threads;

import javax.swing.JLabel;

/**
 *
 * @author HugoJr. <Hugo Rivera at 00161417@uca.edu.sv>
 */
public class AnimalThread extends Thread{
    private String nombre;
    private int limite, x, y;
    private JLabel animal;
    
    public AnimalThread(){}

    public AnimalThread(String nombre, int limite, int x, int y, JLabel animal) {
        this.nombre = nombre;
        this.limite = limite;
        this.x = x;
        this.y = y;
        this.animal = animal;
    }
    
    @Override
    public void run(){
        int f = 0;
        for (int i=0; i<this.limite; i+=5){
            System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i, y);
            if(this.nombre == "tortuga"){
                try{
                sleep(50);
            } 
            catch (InterruptedException e){
                e.printStackTrace();
            }
            
            }
            try{
                sleep(100);
            } 
            catch (InterruptedException e){
                e.printStackTrace();
            }
            
            f = i + 5;
            
            yield();//no obstaculiza a otros hilos que tienen prioridad corran tambien
        }
        //System.out.println(this.nombre + " a llegado a la meta");
        
      
        for(int i = f; i>0; i-=5){
            System.out.println(this.nombre + " avanza");
            this.animal.setLocation(i, y);
            try{
                sleep(100);
            } 
            catch (InterruptedException e){
                e.printStackTrace();
            }
            yield();
        }
        System.out.println(this.nombre + " a llegado a la meta");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GX505DT
 */
public class NodoPrioridad {
    char valor;
    NodoPrioridad sig;
    NodoPrioridad ant;
    int prio;
    
    public NodoPrioridad(char v, int p){
        valor = v;
        prio = p;
        sig=null;
        ant=null;
    }
}

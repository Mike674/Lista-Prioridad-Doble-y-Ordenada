/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GX505DT
 */
public class ListaDoblePrioridad {
    private NodoPrioridad ini;
    private NodoPrioridad fin;
    
    public ListaDoblePrioridad(){
        ini = null;
        fin = null;
    }
    
    public boolean insertar(char v, int p){
        NodoPrioridad nuevo = new NodoPrioridad(v, p);
        
        if(nuevo == null){
            return false;
        }
        if(ini==null && fin==null){
            ini=fin=nuevo;
            return true;
        }
        if(nuevo.prio>ini.prio){
            ini.ant=nuevo;
            nuevo.sig=ini;
            ini=nuevo;
            return true;
        }
        if(nuevo.prio<=fin.prio){
            fin.sig=nuevo;
            nuevo.ant=fin;
            fin=nuevo;
            return true;
        }
        NodoPrioridad t2;
        for(t2 = fin.ant; nuevo.prio>t2.prio; t2=t2.ant){
                
        }
        t2.sig.ant=nuevo;
        nuevo.sig=t2.sig;
        t2.sig=nuevo;
        nuevo.ant=t2;
        return true;
    }
    
    public String mostrar(){
        if(ini==null && fin==null){
            return "LISTA VACÍA";
        }
        return mostrar(ini);
    }
    
    private String mostrar(NodoPrioridad temp){
        if(temp==null){
            return "";
        }
        return temp.valor + " -> " + mostrar(temp.sig);
    }
    
    public String mostrar2(){
        if(ini==null && fin==null){
            return "LISTA VACÍA";
        }
        String cad = "";
        for(NodoPrioridad temp = ini; temp != null; temp = temp.sig){
            cad += temp.valor + " -> ";
        }
        return cad;
    }
    
    public boolean eliminar(char v, int p){
        if(ini == null && fin == null){
            return false;
        }
        if(ini==fin && ini!=null){
            if(ini.valor==v && ini.prio==p){
                ini=fin=null;
                return false;
            }
            return false;
        }
        if(ini.valor==v && ini.prio==p){
            NodoPrioridad temp = ini.sig;
            temp.ant=null;
            ini.sig=null;
            ini=temp;
            return true;
        }
        if(fin.valor==v && fin.prio==p){
            NodoPrioridad temp = fin.ant;
            temp.sig=null;
            fin.ant=null;
            fin=temp;
            return true;
        }
        
        for(NodoPrioridad temp = ini.sig; temp!=fin; temp = temp.sig){
            if(temp.valor==v && temp.prio==p){
                temp.ant.sig=temp.sig;
                temp.sig.ant=temp.ant;
                temp.ant=temp.sig=null; 
                return true;
            }
        }
        
        return false;
    }
    
    public boolean insertarOrden(char valor, int p){
        p=0;
        NodoPrioridad temp = new NodoPrioridad(valor, p);
        if (temp == null){
            return false;
        }
        if (ini == null && fin == null){
            ini=fin=temp;
            return true;
        }
        fin.sig=temp;
        fin=temp;
        return true;
    }
    
    public boolean eliminarOrden(){
        if (ini == null && fin == null){
            return false;
        }
        if (ini == fin && ini != null){
            fin=ini=null;
            return true;
        }
        NodoPrioridad temp = ini.sig;
        ini.sig=null;
        ini=temp;
        return true;
    }
}

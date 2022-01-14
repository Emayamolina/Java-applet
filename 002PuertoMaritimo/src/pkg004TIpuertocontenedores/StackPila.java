/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg004TIpuertocontenedores;

/**
 *
 * @author Usuario
 */
public class StackPila {
    private Node top;

    public StackPila() {
    }
    
    public boolean isEmpty(){
        return top==null;
    }
    
    //Add meter guardar
    public  void Push(Object data){
    
        if(isEmpty())
            top = new Node(data);
        else{
            Node n = new Node(data, top);
            top = n;
        }
    }
    
    //eliminar sacar
    public Object Pop(){
        Object obj = null;
        if(!isEmpty()){
            Node aux = top;
            obj = aux.getData();
            top = top.getLink();
            aux=null;
        }
        return obj;
    }
    
    
    
    
}

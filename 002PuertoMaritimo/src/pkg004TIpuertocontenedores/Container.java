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
public class Container {
  
    private String countryOrigin;
    private int value;
    private int idContainer;
    
    //GET 

    public int getIdContainer() {
        return idContainer;
    }
    

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public int getValue() {
        return value;
    }

    //SET

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    
    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    //CONSTRUCTOR
    public Container(String countryOrigin, int value, int idContainer) {
        this.countryOrigin = countryOrigin;
        this.value = value;
        this.idContainer= idContainer;
    }
    
    //TOSTRING

    @Override
    public String toString() {
        return "Container{" + "countryOrigin=" + countryOrigin + ", value=" + value + ", idContainer=" + idContainer + '}';
    }
   
    
    
}

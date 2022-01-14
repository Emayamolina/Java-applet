/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg004TIpuertocontenedores;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MainMenuPuerto {

    //ELEMENTOS ESTATICOS 
    static String country;
    static int ValueContainer;
    static int idContainer;

    //PILAS ESTATICAS
    static StackPila contP = new StackPila();
    static StackPila auxConP = new StackPila();

    public static void main(String[] args) {
        String menuPort[] = {"Add container", "Determine the containers by country",
            "Containers in the port", "Show information",
            "Total value of port content", "Modify value",
            "Exit"};
        String name, opt;
       
        do {
            opt = (String) JOptionPane.showInputDialog(null,
                    "Selected option",
                    "Main menu",
                    1,
                    null,
                    menuPort,
                    menuPort[0]);
            switch (opt) {

                case "Add container":
                    JOptionPane.showMessageDialog(null, "You are adding containers at the port");
                    addContainers(contP);
                    break;

                case "Determine the containers by country":
                    country = JOptionPane.showInputDialog("Please enter the country of container");
                    JOptionPane.showMessageDialog(null, "The number of containers in the port is: " + cantContainerByCountry(contP, country));
                    break;

                case "Containers in the port":
                    JOptionPane.showMessageDialog(null, "The number of containers in the port is: " + cantContainerPort(contP));
                    break;

                case "Show information":
                    String text = "";
                    while (!contP.isEmpty()) {
                        Object h = contP.Pop();
                        text = text + h + "\n";
                        auxConP.Push(h);
                    }
                    while (!auxConP.isEmpty()) {
                        contP.Push(auxConP.Pop());
                    }
                    JOptionPane.showMessageDialog(null, text, "Stack", 1);
                    break;

                case "Total value of port content":
                    JOptionPane.showMessageDialog(null, ValueTotalPort(contP));
                    break;

                case "Modify value":
                    modify(contP);
                    while (!auxConP.isEmpty()) {
                        contP.Push(auxConP.Pop());
                    }
                    break;

            }
        } while (!opt.equals("Exit"));

    }

    //CREACIÓN DE MÉTODOS 1
    public static void addContainers(StackPila contP) {

        country = JOptionPane.showInputDialog("Please enter the country of container");
        ValueContainer = Integer.parseInt(JOptionPane.showInputDialog("Please enter the value"));
        idContainer = Integer.parseInt(JOptionPane.showInputDialog("Please enter the id"));
        Container adcon = new Container(country, ValueContainer, idContainer);
        contP.Push(adcon);
        JOptionPane.showMessageDialog(null, "Saved container");
    }

    //2 contenedores por pais en el puerto 
    public static int cantContainerByCountry(StackPila contP, String cnt) {
        int cp = 0;
        Container cpc;
        String tt;

        while (!contP.isEmpty()) {
            cpc = (Container) contP.Pop();
            if (cpc.getCountryOrigin().equalsIgnoreCase(cnt)) {
                auxConP.Push(cpc);
                cp++;
            } else {
                auxConP.Push(cpc);
            }
        }
        while (!auxConP.isEmpty()) {
            contP.Push(auxConP.Pop());
        }
        JOptionPane.showMessageDialog(null, "The information shown is the number of containers for a given country in the port");
        return cp;
    }

    //Contenedores en el puerto 
    public static double cantContainerPort(StackPila contP) {
        StackPila auxConP = new StackPila();
        int cant = 0;
        while (!contP.isEmpty()) {
            auxConP.Push((Container) contP.Pop());
            auxConP.Push(contP.Pop());
            cant++;
        }
        while (!contP.isEmpty()) {
            contP.Push(contP.Pop());
        }
        JOptionPane.showMessageDialog(null, "The information displayed is the total number of containers in the port");
        return cant;
    }
    
    //valor total del contenido del puerto
    public static double ValueTotalPort(StackPila contP) {
        double nt = 0;
        Container ct;
        while (!contP.isEmpty()) {
            ct = (Container) contP.Pop();
            nt += ct.getValue();
            auxConP.Push(ct);
        }
        while (!auxConP.isEmpty()) {
            contP.Push(auxConP.Pop());
        }
        return nt;
    }

    public static int modify(StackPila contP) {
        int m=0;
        idContainer = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID: "));
        while (!contP.isEmpty()) {
            Container con = (Container) contP.Pop();
            if ((int) con.getIdContainer() == idContainer) {
                ValueContainer = Integer.parseInt((JOptionPane.showInputDialog("Enter de value container: ")));
                con.setValue(ValueContainer);
                auxConP.Push(con);
                JOptionPane.showMessageDialog(null, "the container has been updated");

            } else {
                auxConP.Push(con);
            }
        }
        return m;
    }
    
}

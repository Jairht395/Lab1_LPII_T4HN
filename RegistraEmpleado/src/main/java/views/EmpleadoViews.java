package views;

import controllers.EmpleadoControllers;

public class EmpleadoViews {

    public static void main(String[] args) {

    	// TODO Auto-generated method stub
        String empleado = new EmpleadoControllers().createEmpleado("Navarro","Cesar",18,"Masculino",50);
        //String empleado = new EmpleadoController().createEmpleado("Salazar","Carlos",14,"Masculino",30);
        //String empleado = new EmpleadoController().deleteEmpleado(1);
        //String empleado = new EmpleadoController().updateEmpleado(2, "Herrera");
        //String empleado = new EmpleadoControllers().getEmpleado(2);
        System.out.println(empleado);
    }

}
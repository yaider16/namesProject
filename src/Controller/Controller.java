package Controller;

import Model.App;
import Model.Input;
import View.View;

public class Controller {
    public static View view = new View();
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.menu();
    }

    public void menu(){
        view.show("Ingrese la cantidad de nombres y apellidos a combinar ");
        int cantNames = Integer.parseInt(view.read());
        int cantLastNames = Integer.parseInt(view.read());
        view.show("Ingrese el nombre del archivo a guardar");
        String fileName = view.read();
        App app = new App(cantNames, cantLastNames, fileName);
        app.combinations();
        view.show("Archivo guardado con exito");
    }
}

package Model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Input {
    public boolean write(String[] message, String fileName) {
        String ruta= "C:\\Users\\tomas\\Documents\\Programacion\\TercerSemestreProgramacion{\\names\\"+fileName+".txt";
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < message.length; i++) {
                bw.write(message[i]);
                bw.newLine();
            }
            bw.newLine();
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

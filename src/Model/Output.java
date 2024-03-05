package Model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Output {
    public String[] read(boolean names){
        List<String> lines = new ArrayList<String>();
        try {
            FileReader fr;
            if (names) {
                fr = new FileReader("C:\\Users\\tomas\\Documents\\Programacion\\TercerSemestreProgramacion{\\names\\src\\names.txt");
            }else{
                fr = new FileReader("C:\\Users\\tomas\\Documents\\Programacion\\TercerSemestreProgramacion{\\names\\src\\lastNames.txt");
            }
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                lines.add(linea);
            }
            br.close();
            fr.close();
            String[] arrayLines = lines.toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines.toArray(new String[0]);
    }
}

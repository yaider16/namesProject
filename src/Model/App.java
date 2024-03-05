package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class App {
    private int cantNames;
    private int cantLastNames;
    private String fileName;
    private String[] names;
    private ArrayList<String> femaleNames;
    private ArrayList<String> maleNames;
    private String[] lastNames;

    public App(int cantNames, int cantLastNames, String fileName) {
        this.cantNames = cantNames;
        this.cantLastNames = cantLastNames;
        this.fileName = fileName;
    }


    public void combinations() {
        Output output = new Output();
        this.names = output.read(true);
        this.lastNames = output.read(false);
        ArrayList<String> result = new ArrayList<>();
        namesSeparatingByGender();

        if(cantNames<2 && cantLastNames<2){
            for (int i = 0; i < this.names.length; i++) {
                for (int j = 0; j < this.lastNames.length; j++) {
                    result.add(this.names[i] + " " + this.lastNames[j]);
                }
            }
        }
        if (cantNames >= 2 && cantLastNames >= 1) {
            ArrayList<String> selectedNames = (maleNames.size() >= cantNames) ? maleNames : femaleNames;

            generateCombinations(selectedNames, lastNames, result, new ArrayList<>(), 0);
        }
        Input input = new Input();
        input.write(result.toArray(new String[0]), this.fileName);
    }

    private void generateCombinations(ArrayList<String> names, String[] lastNames, ArrayList<String> result, ArrayList<String> currentCombo, int index) {
        if (currentCombo.size() == cantNames) {
            for (String lastName : lastNames) {
                StringBuilder combination = new StringBuilder();
                for (String name : currentCombo) {
                    combination.append(name).append(" ");
                }
                combination.append(lastName);
                result.add(combination.toString());
            }
            return;
        }

        for (int i = index; i < names.size(); i++) {
            currentCombo.add(names.get(i));
            generateCombinations(names, lastNames, result, currentCombo, i + 1);
            currentCombo.remove(currentCombo.size() - 1);
        }
    }
    public void namesSeparatingByGender(){
        this.femaleNames = new ArrayList<>();
        this.maleNames = new ArrayList<>();
        for (int i = 0; i < this.names.length; i++) {
            if(this.names[i].contains("Femenino")){
                this.femaleNames.add(Arrays.toString(new String[] {this.names[i].split(" ")[0]}));
            }else if(this.names[i].contains("Masculino")){
                this.maleNames.add(Arrays.toString(new String[] {this.names[i].split(" ")[0]}));
            }
        }
        for (int i = 0; i < this.names.length; i++) {
            if(this.names[i].contains("Femenino")){
                this.names[i] = this.names[i].split(" ")[0];
            }else if(this.names[i].contains("Masculino")){
                this.names[i] = this.names[i].split(" ")[0];
            }
        }
    }
    public boolean isMale(String name){
        for (String maleName : this.maleNames) {
            if (maleName.contains(name)) {
                return true;
            }
        }
        return false;
    }

}

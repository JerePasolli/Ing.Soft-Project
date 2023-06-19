package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JSONMaker {
    private File json;
    private FileWriter jsonWriter;
    private Scanner reader;
    private ArrayList<String> lines;
    public JSONMaker(){
        json = new File("scores.json");
        lines = new ArrayList<String>();
        read();
    }

    private void addScore(String name, int score){
       /* lines.add("\t{");
        lines.add("\t\t" + "\"" + name + "\"" + ": " + score);
        lines.add("\t}");*/
        lines.add("\t{\n" + "\t\t" + "\"" + name + "\"" + ": " + score + "\n\t}");
    }

    public void write(String name, int score){
        addScore(name, score);
        try{
            jsonWriter = new FileWriter(json);
            jsonWriter.write("[\n");
            for(int i=0; i<lines.size(); i++){
                // jsonWriter.write(line + "\n");
                String line = lines.get(i);
                jsonWriter.write(line);
                if(lines.size() != 1 && line.equals("\t}") && i != lines.size()-1){
                    jsonWriter.write(",");
                }
                jsonWriter.write("\n");
            }
            jsonWriter.write("]");
            jsonWriter.close();
        }catch(Exception ex){
            System.out.println("no se puede escribir archivo");
        }
    }

    private void read(){
        try{
            json.createNewFile();
            reader = new Scanner(json);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
                if(!(line.equals("]") || line.equals("["))){
                    lines.add(line);
                }
            }
        }catch(Exception ex){
            System.out.println("no se puede leer");
        }
    }
}

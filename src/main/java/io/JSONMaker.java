package io;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import constants.Constants;

public class JSONMaker {
    private File json;
    private FileWriter jsonWriter;
    private Scanner reader;
    private ArrayList<String> lines;
    private String bestDate;
    private Integer bestScore;
    private boolean isBest;
    private HashSet<ScoreData> scoreDataList;

    private static JSONMaker instance;

    /**
     *  Constructor de la clase, abre un archivo json o lo crea segun corresponda, leyendo los scores registrados.
     */
    private JSONMaker(){
        json = new File(Constants.JSON_PATH);
        scoreDataList = new HashSet<ScoreData>();
        read();
        readScores();
    }

    /**
     *  Retorna instancia de JSONMaker, si no hay ninguna crea una, siguiendo el patron Singleton.
     */
    public static JSONMaker getInstance(){
        if(instance == null){
            instance = new JSONMaker();
        }
        return instance;
    }

    /**
     *  Agrega una nueva linea con un registro nuevo de score.
     *  @param name fecha del score registrado por el jugador
     *  @param score score registrado en la partida
     */
    private void addScore(String name, int score){
        lines.add("\t{\n" + "\t\t" + "\"" + name + "\"" + ": " + score + "\n\t}");
    }

    /**
     *  Agrega un nuevo registro al archivo JSON.
     *  @param name fecha del score registrado por el jugador
     *  @param score score registrado en la partida
     */
    public void write(String name, int score){
        read();
        addScore(name, score);
        try{
            jsonWriter = new FileWriter(json);
            jsonWriter.write("[\n");
            for(int i=0; i<lines.size(); i++){
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
      //  verify();
      readScores();
    }

    /**
     *  Lee el archivo JSON con scores guardados y los agrega a una lista.
     */
    private void read(){
        lines = new ArrayList<String>();

        try{
            json.createNewFile();
            reader = new Scanner(json);
            while(reader.hasNextLine()){
                String line = reader.nextLine();
                if(!(line.equals("]") || line.equals("["))){
                    lines.add(line);
                }
            }
        }catch(Exception ex){
            System.out.println("no se puede leer");
        }
    }

    /**
     *  Lee y parsea los scores que se extraen del JSON.
     */
    private void readScores(){
        read();
        bestScore = 0;
        this.scoreDataList.clear();
        for(String line : lines){
            if(line.contains(":")){
                Integer aux = Integer.valueOf(line.substring(line.indexOf(":")+2));
                String date = line.substring(3, line.indexOf(":")-1);
                ScoreData newScoreData = new ScoreData();
                newScoreData.setScore(aux);
                newScoreData.setDate(date);
                this.scoreDataList.add(newScoreData);
                /*if(bestScore < aux){
                    bestScore = aux;
                    bestDate = line.substring(3, line.indexOf(":")-1);
                }*/
            }
        }
    }

    /**
     *  Retorna un booleano indicando si un score es el mejor registrado hasta la fecha.
     *  @return booleano que indica si un score es el mejor
     */
    public boolean isBest(){
        return isBest;
    }

    /**
     *  Verifica que el nuevo score es mejor que los previos.
     */
  /*  private void verify(){
        Integer scoreAux = bestScore;
        readScores();
        isBest = bestScore > scoreAux;
    } */

    /**
     *  Retorna la lista con los mejores scores registrados.
     *  @return arrayList de los mejores scores
     */
    public HashSet<ScoreData> getScoreData(){
        return this.scoreDataList;
    }
  
}
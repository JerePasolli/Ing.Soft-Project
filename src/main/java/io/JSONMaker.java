package io;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
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
    private ArrayList<ScoreData> scoreDataList;

    public JSONMaker(){
        json = new File(Constants.JSON_PATH);
        scoreDataList = new ArrayList<ScoreData>();
        read();
        readScores();
    }
 

    private void addScore(String name, int score){
        lines.add("\t{\n" + "\t\t" + "\"" + name + "\"" + ": " + score + "\n\t}");
    }

    public void write(String name, int score){
        read();
        readScores();
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
        verify();
    }

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

    private void readScores(){
        read();
        bestScore = 0;

        for(String line : lines){
            if(line.contains(":")){
                Integer aux = Integer.valueOf(line.substring(line.indexOf(":")+2));
                String date = line.substring(3, line.indexOf(":")-1);
                ScoreData newScoreData = new ScoreData();
                newScoreData.setScore(aux);
                newScoreData.setDate(date);
                this.scoreDataList.add(newScoreData);
                if(bestScore < aux){
                    bestScore = aux;
                    bestDate = line.substring(3, line.indexOf(":")-1);
                }
            }
        }
    }

    public boolean isBest(){
        return isBest;
    }
    private void verify(){
        Integer scoreAux = bestScore;
        readScores();
        isBest = bestScore > scoreAux;
    }

    public ArrayList<ScoreData> getScoreData(){
        return this.scoreDataList;
    }
  
}

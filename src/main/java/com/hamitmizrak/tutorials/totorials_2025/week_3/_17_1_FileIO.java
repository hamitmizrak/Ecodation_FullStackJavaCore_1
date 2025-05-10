package com.hamitmizrak.tutorials.totorials_2025.week_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

// File IO(Input/Output) - java.io paketi
    /*
    Java 1.0'dan beri beri vardır.
    Eski yöntemdir.
    Amaç: Dosya okumak ve yazmak
    */
public class _17_1_FileIO {

    // const
    private static final String filePath="hamitmizrak.txt";


    // YAZMA (WRITER)
    public void writeFileData(String data){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true))){
            bw.write(data);
            bw.flush();
        }catch (Exception e){
            System.out.println(e);
        }
    }


    // OKUMA (READER)
    public void readFileData(String data){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line="";
            while((line=br.readLine())!=null){}
            System.out.println("Okunan: "+line);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}

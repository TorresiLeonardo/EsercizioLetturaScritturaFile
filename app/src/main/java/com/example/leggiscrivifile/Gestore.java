package com.example.leggiscrivifile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gestore {
    public String leggiFile(String nomeFile, Context c){
        StringBuilder sb= new StringBuilder();
        try {
            BufferedReader fileDaLeggere= new BufferedReader(
                    new InputStreamReader(c.openFileInput(nomeFile))
            );
            String daRestituire= "";
            while((daRestituire= fileDaLeggere.readLine())!=null){
                sb.append(daRestituire +" \n");
            }
        } catch (FileNotFoundException e) {
            Log.e("errGestore", "File inesistente");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  sb.toString();
    }

    public String scriviFile(String nomeFile, Context c){
    String esito= "";
    FileOutputStream fileO;
    try{
        String str="Questo è il testo da scrivere";
        fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
        fileO.write(str.getBytes());
        fileO.close();
        esito="file scritto correttamente";
    } catch (FileNotFoundException e){
        esito="impossibile creare il file";
        e.printStackTrace();
    } catch (IOException e){
        esito="errore di scrittura file";
        e.printStackTrace();
    }
    return esito;
    }
}

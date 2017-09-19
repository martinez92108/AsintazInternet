package com.example.aula7.asintazinternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by aula7 on 19/09/17.
 */

public class HttpManager {
    public  static String getData(String uri) throws IOException {
        BufferedReader reader =null;
        //clase url de java para manejar rutas

        URL url= new URL(uri);


        //clases que me permiten hacer la conexion a internet
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();

        //declara variable para abrir un buffer de recoleccion de datos
        StringBuilder stringBuilder =new StringBuilder();
        reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String linea;
        while ( (linea=reader.readLine())!=null){
            stringBuilder.append(linea+"\n");





        }




        return stringBuilder.toString();
    }





}

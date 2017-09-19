package com.example.aula7.asintazinternet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progresbar;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progresbar=(ProgressBar)findViewById(R.id.pb_1);
        button=(Button)findViewById(R.id.btn_1);
        textView=(TextView)findViewById(R.id.tv_1);



    }

    public Boolean isonLine(){
        //objeto para manejar las conectividades VERIFICA SI HAY O NO HAY INTERNET

        ConnectivityManager connectivityManager=( ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
        //validar estado de la red
        if (networkInfo!=null){

            return true;
        }else {
            return false;
        }
    }


    public void  loadData(View view){
        if(isonLine()){
            MyTask task =new MyTask();
            task.execute();



        }else {

            Toast.makeText(this,"sin conexion",Toast.LENGTH_SHORT).show();
        }


    }
    public void proccessData(String s){

        textView.setText("item"+s);
        textView.setTextSize(Integer.parseInt(s));

    }






    public class MyTask extends AsyncTask<String,String,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progresbar.setVisibility(View.VISIBLE);


        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i=1; i<50;i++){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            proccessData(values[0]);

        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
                progresbar.setVisibility(View.GONE);
        }
    }







}

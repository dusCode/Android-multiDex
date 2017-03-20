package com.dus.multiDex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            createMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createMethod() throws IOException {
        FileWriter fw = new FileWriter("demo.txt");
        for(int i = 1 ; i <= 65539; i++){
            fw.write( "public void me" + i + "(){ }\r\n" );
            fw.flush();
        }
        fw.close();
    }
}

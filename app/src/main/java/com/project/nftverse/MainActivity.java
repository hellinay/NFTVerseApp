package com.project.nftverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);

        //img2 =findViewById(R.id.imgAta);

        //String imageAddress= "http://ctis.bilkent.edu.tr/ctis487/albums/ataturk.jpg";

        //Picasso.with(this)
               // .load(imageAddress)
              //  .resize(250, 250)
              //  .error(R.mipmap.ic_launcher)
              //  .into(img);

        img = findViewById(R.id.collectBTN);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        try {
            String fileToDatabase = "/data/data/" + getPackageName() + "/databases/"+DatabaseHelper.DATABASE_NAME;
            File file = new File(fileToDatabase);
            File pathToDatabasesFolder = new File("/data/data/" + getPackageName() + "/databases/");
            if (!file.exists()) {
                pathToDatabasesFolder.mkdirs();
                Log.d("BURDA", "BURDA");
                CopyDB( getResources().getAssets().open(DatabaseHelper.DATABASE_NAME),
                        new FileOutputStream(fileToDatabase));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Create DatabaseHelper object after try catch statement
        dbHelper = new DatabaseHelper(this);
    }

    public void CopyDB(InputStream inputStream, OutputStream outputStream) throws IOException {
        // Copy 1K bytes at a time
        byte[] buffer = new byte[1024];
        int length;
        Log.d("BURDA", "BURDA2");

        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
            Log.d("BURDA", "BURDA3");

        }
        inputStream.close();
        outputStream.close();
    }
}
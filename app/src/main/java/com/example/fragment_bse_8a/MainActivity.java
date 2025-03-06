package com.example.fragment_bse_8a;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    LinearLayout portrait, landscape;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        if(portrait!=null)
        {
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listfrag))
                    .hide(fragmentManager.findFragmentById(R.id.detailfrag))
                    .commit();
        }
        else
        {
            Toast.makeText(this, "Landscape", Toast.LENGTH_SHORT).show();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listfrag))
                    .show(fragmentManager.findFragmentById(R.id.detailfrag))
                    .commit();
        }

    }

    private void init(){
        portrait = findViewById(R.id.portrait);
        landscape = findViewById(R.id.landscape);
        fragmentManager = getSupportFragmentManager();

    }
}
package com.example.fragment_bse_8a;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.OnContactClicked {

    LinearLayout portrait, landscape;
    FragmentManager fragmentManager;

    ArrayList<Contact> contacts;

    // hooks of detail fragment views
    TextView tvPhoneNumber, tvAddress;
    View detailFragmentView;

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
        detailFragmentView = fragmentManager.findFragmentById(R.id.detailfrag).getView();
        tvPhoneNumber = detailFragmentView.findViewById(R.id.tvPhoneNumber);
        tvAddress = detailFragmentView.findViewById(R.id.tvAddress);

        contacts = new ArrayList<>();
        contacts.add(new Contact("Waqas", "123","321"));
        contacts.add(new Contact("Ali Raza", "123","321"));
        contacts.add(new Contact("Muzammil Hussain", "123","321"));
        contacts.add(new Contact("Fasih Ashraf", "123","321"));

    }

    @Override
    public void onContactItemClicked(int position) {
        tvAddress.setText(contacts.get(position).getAddress());
        tvPhoneNumber.setText(contacts.get(position).getPhone());

        if(portrait!=null)
        {
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.listfrag))
                    .show(fragmentManager.findFragmentById(R.id.detailfrag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
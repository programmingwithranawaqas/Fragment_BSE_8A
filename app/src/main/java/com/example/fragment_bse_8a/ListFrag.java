package com.example.fragment_bse_8a;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListFrag extends ListFragment {

    public interface OnContactClicked{
        public void onContactItemClicked(int position);
    }

    OnContactClicked pointerOfParent;

    public ListFrag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        pointerOfParent = (OnContactClicked) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // populate the data into listview
        ArrayList<String> data = new ArrayList<>();
        data.add("Waqas");
        data.add("Ali Raza");
        data.add("Muzammil Hussain");
        data.add("Fasih Ashraf");

        setListAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line, data));

    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        pointerOfParent.onContactItemClicked(position);
    }
}
package com.example.kongcw.testing;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kongcw.testing.databinding.FragmentSecondBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    String name;
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            name = savedInstanceState.getString("name");
        }
        FragmentSecondBinding fragmentSecondBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false);
        Bundle b = getArguments();
        name = b.getString("name");
    fragmentSecondBinding.secondTextView.setText(name);
        fragmentSecondBinding.secondbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"second button clicked", Toast.LENGTH_SHORT).show();
                FirstFragment firstFragment = new FirstFragment();
                FragmentManager fm  = getFragmentManager();
                fm.beginTransaction()
                        .replace(R.id.main_container, firstFragment, firstFragment.getTag())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return fragmentSecondBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("name", name);
        super.onSaveInstanceState(outState);
    }
}

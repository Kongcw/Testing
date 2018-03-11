package com.example.kongcw.testing;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kongcw.testing.databinding.FragmentFirstBinding;
import com.example.kongcw.testing.viewmodel.myViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    String name;
    int number = 1;
    FragmentFirstBinding fragmentFirstBinding;
    private myViewModel mMyViewModel;
    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentFirstBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);

        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name");
            fragmentFirstBinding.firstEditText.setText(name);
        }
        setViewModel();
        setAddButton();
        setFirstButton();

        return fragmentFirstBinding.getRoot();

    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putString("name", name);
//        super.onSaveInstanceState(outState);
//    }

    private void setFirstButton() {
        fragmentFirstBinding.firstbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "first button is clicked", Toast.LENGTH_SHORT).show();
                name = fragmentFirstBinding.firstEditText.getText().toString();
                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fm = getFragmentManager();
                Bundle b = new Bundle();
                b.putString("name", name);
                secondFragment.setArguments(b);

                fm.beginTransaction()
                        .replace(R.id.main_container, secondFragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        });
    }

    private void setViewModel(){
        mMyViewModel = ViewModelProviders.of(getActivity()).get(myViewModel.class);
        fragmentFirstBinding.shownumber.setText(String.valueOf(mMyViewModel.getCount()));
    }

    private void setAddButton(){
        fragmentFirstBinding.addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number++;
                mMyViewModel.getCount().setValue(number);
                fragmentFirstBinding.shownumber.setText(String.valueOf(mMyViewModel.getCount()));
            }
        });
    }

}

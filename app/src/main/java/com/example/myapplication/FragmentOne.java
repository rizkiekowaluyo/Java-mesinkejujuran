package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {

    View view;
    EditText editText;
    TextView textView;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_one,container,false);
        editText = view.findViewById(R.id.edText);
        button = view.findViewById(R.id.btn_enter);
        textView = view.findViewById(R.id.tv_one);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                str = str.toLowerCase();
                String[] arrayInput = str.split(" ");
                String result = "";

                for (int i = arrayInput.length  -1 ; i > 0  ; i--){

                    if (arrayInput[i].equals("bohong")){
                        arrayInput[i - 1] = Change(arrayInput[i-1]);
                    }
                }

                result = arrayInput[0];
                textView.setText(result);
            }
        });

        return view;
    }

    public String Change(String input){

        String result = "";

        if (input.equals("bohong")){
            result = "jujur";
        }else if (input.equals("jujur")){
            result = "bohong";
        }

        return result;
    }


}

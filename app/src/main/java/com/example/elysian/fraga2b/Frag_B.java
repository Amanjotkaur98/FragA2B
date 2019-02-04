package com.example.elysian.fraga2b;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Frag_B extends Fragment {

    FragBlistener listener;
    Button btn;
    EditText et;
    TextView tv;

    public interface FragBlistener
    {
        void inputbsent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_b, container, false);
        btn=(Button)v.findViewById(R.id.btn);
        et=(EditText)v.findViewById(R.id.et);
        tv=(TextView)v.findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=et.getText();
                listener.inputbsent(input);
            }
        });
        return v;
    }

    public void upadateTextView(CharSequence input)
    {
        tv.setText(input);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragBlistener) {
            listener = (FragBlistener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

}

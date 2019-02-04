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

public class Farg_A extends Fragment {

    FragAlistener alistener;
    EditText et;
    TextView tv;
    Button btn;

    public interface FragAlistener
    {
        void inputasent(CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_a, container, false);
        et=(EditText)v.findViewById(R.id.et);
        tv=(TextView)v.findViewById(R.id.tv);
        btn=(Button)v.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input=et.getText();
                alistener.inputasent(input);
            }
        });
        return v;
    }

    public void updateTextView(CharSequence input)
    {
        tv.setText(input);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragAlistener)
        {
            alistener=(FragAlistener) context;
        }
        else {
            throw new RuntimeException(context.toString()+"must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        alistener=null;
    }
}

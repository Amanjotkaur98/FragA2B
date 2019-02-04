package com.example.elysian.fraga2b;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Farg_A.FragAlistener,Frag_B.FragBlistener {

    Farg_A f_a;
    Frag_B f_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f_a=new Farg_A();
        f_b=new Frag_B();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_a,f_a)
                .replace(R.id.frag_b,f_b)
                .commit();
    }

    @Override
    public void inputasent(CharSequence input) {
        f_b.upadateTextView(input);
    }

    @Override
    public void inputbsent(CharSequence input) {
        f_a.updateTextView(input);
    }
}

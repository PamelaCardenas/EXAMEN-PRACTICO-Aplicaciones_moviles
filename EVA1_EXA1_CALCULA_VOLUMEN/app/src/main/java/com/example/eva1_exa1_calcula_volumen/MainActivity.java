package com.example.eva1_exa1_calcula_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener, View.OnTouchListener {

    TextView txtVwAngVal;
    SeekBar sBAng;
    EditText edTxtRadio;
    Button btnCalc;
    double radio, volumen;
    int angulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwAngVal = findViewById(R.id.txtVwAngVal);
        sBAng = findViewById(R.id.sBAng);
        edTxtRadio = findViewById(R.id.edTxtRadio);
        btnCalc = findViewById(R.id.btnCalc);

        //El layout principal se le agrega el metodo OnTouch
        findViewById(R.id.mainLayout).setOnTouchListener(this);

        sBAng.setOnSeekBarChangeListener(this);
        btnCalc.setOnClickListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        txtVwAngVal.setText(new Integer(i).toString());
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        angulo = sBAng.getProgress();
    }

    @Override
    public void onClick(View view) {
        if(edTxtRadio.getText().toString().isEmpty() == true){
            edTxtRadio.setError("Debe ingresar un valor en Radio");
        }else {
            radio = Double.parseDouble(edTxtRadio.getText().toString());
        }

        volumen = (((angulo*radio*3)*2)/3);

        Toast.makeText(this,"El volumen es: " + volumen,Toast.LENGTH_LONG).show();

    }

    //Metodo para ocultar el teclado
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return false;
    }
}
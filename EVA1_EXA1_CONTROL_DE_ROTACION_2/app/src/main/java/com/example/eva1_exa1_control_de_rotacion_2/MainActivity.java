package com.example.eva1_exa1_control_de_rotacion_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

/* EXAMEN PRACTICO UNIDAD 1
 * CONTROL DE ROTACION 2
 * EQUIPO NOUGAT
 * KARLA PAMELA CARDENAS LEYVA 18550338 */

public class MainActivity extends AppCompatActivity {

    TextView txtVwSpa, txtVwSci, txtVwTit, txtVwFecha;


    final String cadenaSci = "SCIENCE / TECHNOLOGY";
    final String cadenaTit = "SPACE SHUTTLE";
    final String cadenaFecha = "September 27, 2017";
    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //txtVwSpa = findViewById(R.id.txtVwSpa);
        //txtVwSpa.setText(cadenaDesc);
        //txtVwSpa.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        txtVwSci = findViewById(R.id.txtVwSci);
        txtVwSci.setText(cadenaSci);

        txtVwTit = findViewById(R.id.txtVwTit);
        txtVwTit.setText(cadenaTit);

        txtVwFecha = findViewById(R.id.txtVwFecha);
        txtVwFecha.setText(cadenaFecha);
    }
}
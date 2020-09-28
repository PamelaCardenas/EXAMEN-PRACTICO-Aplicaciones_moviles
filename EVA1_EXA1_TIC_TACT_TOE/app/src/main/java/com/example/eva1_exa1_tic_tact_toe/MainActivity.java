package com.example.eva1_exa1_tic_tact_toe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Declaracion
    private Button[][] btnArreglo = new Button[3][3];
    Button btnReiniciar;
    int totClick=0;
    TextView txtVwRes;
    String ganador;

    private boolean jugador1,jugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwRes = findViewById(R.id.txtVwRes);

        //Obtener el ID de los botones
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                String btnId = "btn"+i+j;
                int btnResID = getResources().getIdentifier(btnId,"id",getPackageName());
                btnArreglo[i][j] = findViewById(btnResID);
                btnArreglo[i][j].setOnClickListener(this);

            }
        }

        //Boton para reiniciar el juego
        btnReiniciar = findViewById(R.id.btnReinicio);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<3; i++) {
                    for (int j = 0; j < 3; j++) {
                        btnArreglo[i][j].setText("-");
                        btnArreglo[i][j].setEnabled(true);
                        totClick=0;
                        txtVwRes.setText("RESULTADO");
                        ganador="";
                    }
                }
            }
        });
    }

    //Evento cada que se hace un click
    @Override
    public void onClick(View view) {
        totClick++;
        if(!((Button) view).getText().toString().equals("-")){
            return;
        }

        //Al hcer click colocar la letra correspondiente dependiendo del turno
        if(totClick==1|totClick==3|totClick==5|totClick==7|totClick==9) {
            ((Button) view).setText("X");
            ((Button)view).setEnabled(false);
        }else {
            ((Button) view).setText("O");
            ((Button)view).setEnabled(false);
        }

        //Definir el ganador del juego
        if(ganador()){
            if(jugador1){
                ganadorJugador1();
            }else if(jugador2){
                ganadorJugador2();
            }
        }else if(totClick==9){
                sinGanador();
        }else{
            jugador1= !jugador1;
        }

    }

    //Metodo para validar al ganador
    private boolean ganador(){
        String[][] valorGanador = new String[3][3];

        //Obtener los valores (X/O) del juego terminado
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                valorGanador[i][j] = btnArreglo[i][j].getText().toString();
            }
        }

        //Comparar los valores en horizontal
        for (int i=0; i<3; i++){
            if (valorGanador[i][0].equals(valorGanador[i][1])
                    && valorGanador[i][0].equals(valorGanador[i][2])
                    && !valorGanador[i][0].equals("-")) {
                if (valorGanador[i][0].equals("X")){
                    jugador1=true;
                    jugador2=false;
                }else if(valorGanador[i][0].equals("O")){
                    jugador2=true;
                    jugador1=false;
                }
                return true;
            }
        }
        //Comparar valores en vertical
        for (int i=0; i<3; i++){
            if (valorGanador[0][i].equals(valorGanador[1][i])
                    && valorGanador[0][i].equals(valorGanador[2][i])
                    && !valorGanador[0][i].equals("-")) {
                if (valorGanador[0][i].equals("X")){
                    jugador1=true;
                    jugador2=false;
                }else if(valorGanador[0][i].equals("O")){
                    jugador2=true;
                    jugador1=false;
                }
                return true;
            }
        }
        //Comparar valores diagonal izquierda a derecha
        if (valorGanador[0][0].equals(valorGanador[1][1])
                && valorGanador[0][0].equals(valorGanador[2][2])
                && !valorGanador[0][0].equals("-")) {
            if (valorGanador[0][0].equals("X")){
                jugador1=true;
                jugador2=false;
            }else if(valorGanador[0][0].equals("O")){
                jugador2=true;
                jugador1=false;
            }
            return true;
        }
        //Comparar valores diagonal derecha a izquierda
        if (valorGanador[0][2].equals(valorGanador[1][1])
                && valorGanador[0][2].equals(valorGanador[2][0])
                && !valorGanador[0][2].equals("-")) {
            if (valorGanador[0][2].equals("X")){
                jugador1=true;
                jugador2=false;
            }else if(valorGanador[0][2].equals("O")){
                jugador2=true;
                jugador1=false;
            }
            return true;
        }
        return false;
    }

    //Definir al ganador como el jugador 1
    private void ganadorJugador1(){
        ganador = "GANADOR X";
        txtVwRes.setText("GANADOR X");
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                btnArreglo[i][j].setEnabled(false);
            }
        }
        onShowAlertDialog();
    }

    //Definir al ganador como el jugador 1
    private void ganadorJugador2(){
        ganador = "GANADOR O";
        txtVwRes.setText("GANADOR O");
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                btnArreglo[i][j].setEnabled(false);
            }
        }
        onShowAlertDialog();
    }

    //Definir al ganador como ninguno
    private void sinGanador(){
        ganador = "SIN GANADOR";
        txtVwRes.setText("SIN GANADOR");
        onShowAlertDialog();

    }

    public void onShowAlertDialog(){
        new AlertDialog.Builder(this).setTitle("RESULTADO")
                .setMessage(ganador)
                .setNeutralButton("Volver al juego", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.wtf("ALERT DIALOG", "VOLVER AL JUEGO");
                    }
                }).create().show();
    }
}
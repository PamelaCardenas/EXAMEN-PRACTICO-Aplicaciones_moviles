package com.example.eva1_exa1_acredita_no_acredita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    TextView txtVwPuntosAc, txtVwPuntCal, txtVwRes;
    SeekBar sBAcred, sBCalifa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwPuntCal = findViewById(R.id.txtVwPuntCal);
        txtVwPuntosAc = findViewById(R.id.txtVwPuntosAc);
        txtVwRes = findViewById(R.id.txtVwRes);
        sBAcred = findViewById(R.id.sBAcred);
        sBCalifa = findViewById(R.id.sBCalifa);

        sBCalifa.setOnSeekBarChangeListener(this);
        sBAcred.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if(seekBar == sBAcred){
            txtVwPuntosAc.setText(new Integer(i).toString());
            if(sBAcred.getProgress()>sBCalifa.getProgress()){
                txtVwRes.setText("NO ACREDITADO");
            }else{
                txtVwRes.setText("ACREDITADO!!");
            }
        }else{
            txtVwPuntCal.setText(new Integer(i).toString());
            if(sBAcred.getProgress()>sBCalifa.getProgress()){
                txtVwRes.setText("NO ACREDITADO");
            }else{
                txtVwRes.setText("ACREDITADO!!");
            }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
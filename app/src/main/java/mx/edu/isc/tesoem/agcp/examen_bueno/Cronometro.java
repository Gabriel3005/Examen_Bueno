package mx.edu.isc.tesoem.agcp.examen_bueno;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.CountDownTimer;

import java.util.Timer;
import java.util.TimerTask;


public class Cronometro extends Service {

    Timer tiempo = new Timer();

    public static PrincipalActivity miactividad;

    double contador=0;

    public static void Escucha_actividad(PrincipalActivity actividad){
        miactividad=actividad;
    }

    public Cronometro() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        tiempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                contador++;
                miactividad.cactualiza(String.valueOf(contador));
            }
        },0,1000);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
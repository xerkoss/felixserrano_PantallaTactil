package felixserrano.example.org.pantallatctil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class PantallaTactilActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView entrada = (TextView)findViewById(R.id.TextViewEntrada);
        entrada.setOnTouchListener(this);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        TextView salida = (TextView) findViewById(R.id.TextViewSalida);
        salida.append("\nPresión: " + motionEvent.getPressure() + "\nTamaño: " + motionEvent.getSize()+ "\n");
        salida.append("\n" + motionEvent.toString()+ "\n");

        // extra desplazar scroll abajo
        final ScrollView scrollView = (ScrollView)findViewById(R.id.Scroll);
        scrollView.postDelayed(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        },500);

        return true;
    }
}

package dangkhoa.dmt.dapchau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        nhapNut();

    }

    private Button btnNewGame;

    private Button btnHighScore;

    private Button btnAbout;

    private void anhXa()
    {
        btnNewGame = (Button)findViewById(R.id.btnNewGame);
        btnHighScore = (Button)findViewById(R.id.btnHighScore);
        btnAbout = (Button)findViewById(R.id.btnAbout);
    }

    private void nhapNut()
    {
        btnNewGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                startActivity(new Intent(MainActivity.this, NewGame.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });

        btnHighScore.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                startActivity(new Intent(MainActivity.this, HighScore.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });

        btnAbout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                startActivity(new Intent(MainActivity.this, About.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });
    }
}

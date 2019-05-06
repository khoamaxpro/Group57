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
        if(tinhHinh == 1)
        {
            tinhHinh = 0;
            startActivity(new Intent(MainActivity.this, HighScore.class));
        }

        if(tinhHinh_2 == 1)
        {
            tinhHinh_2 = 0;
            startActivity(new Intent(MainActivity.this, GamePlay.class));
        }
        anhXa();
        nhapNut();

    }


    private Button btnNewGame;

    private Button btnHighScore;

    private Button btnAbout;

    static private int tinhHinh = 1;

    static private int tinhHinh_2 = 1;
    private void anhXa()
    {
        btnNewGame = (Button)findViewById(R.id.btnNewGame);
        btnHighScore = (Button)findViewById(R.id.btnHighScore);
        btnAbout = (Button)findViewById(R.id.btnAbout);
    }

    private void nhapNut()
    {
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HighScore.getHighScore().resetDiem();
                startActivity(new Intent(MainActivity.this, NewGame.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });

        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HighScore.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, About.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
    }
}

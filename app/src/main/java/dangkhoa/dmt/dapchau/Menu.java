package dangkhoa.dmt.dapchau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        anhXa();
        nhanNut();

    }
    private Button btnResume;

    private Button btnNewGame;

    private Button btnHighScore;

    private Button btnAbout;

    private ArrayList<Integer> arrayList;
    private void anhXa()
    {
        btnResume = (Button)findViewById(R.id.btnResume_Menu);
        btnNewGame = (Button)findViewById(R.id.btnNewGame_Menu);
        btnHighScore = (Button)findViewById(R.id.btnHighScore_Menu);
        btnAbout = (Button)findViewById(R.id.btnAbout_Menu);
    }

    private void nhanNut()
    {
        btnResume.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });

        btnNewGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                DataGame.getDatagame().restart();
                Intent intent = new Intent(Menu.this, NewGame.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });

        btnHighScore.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                startActivity(new Intent(Menu.this, HighScore.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });

        btnAbout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                startActivity(new Intent(Menu.this, About.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
                return true;
            }
        });

    }
}

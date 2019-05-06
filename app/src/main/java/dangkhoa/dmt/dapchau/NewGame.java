package dangkhoa.dmt.dapchau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class NewGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        anhXa();
        nhanNut();
    }

    private Button btnSingle;

    private Button btnMulti;

    private void anhXa()
    {
        btnSingle = (Button)findViewById(R.id.btnSinglePlay);
        btnMulti = (Button)findViewById(R.id.btnPlayWithFriend);
    }

    private void nhanNut()
    {
        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewGame.this, GamePlay.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NewGame.this, Multi.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
    }
}

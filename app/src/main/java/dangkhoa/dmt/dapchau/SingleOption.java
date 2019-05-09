package dangkhoa.dmt.dapchau;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SingleOption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_option);
        khaiBao();
        nhanNut();

    }

    private Button standard;

    private Button challenge;

    public void khaiBao()
    {
        standard = (Button)findViewById(R.id.btnStandard);
        challenge = (Button)findViewById(R.id.btnChallenge);
    }

    public void nhanNut()
    {
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HighScore.getHighScore().resetDiem();
                DataGame.getDatagame().restart();
                GamePlay.getMyGamePlay().resetTinhHinh();
                startActivity(new Intent(SingleOption.this, GamePlay.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });
    }
}

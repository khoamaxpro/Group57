package dangkhoa.dmt.dapchau;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.nkzawa.socketio.client.IO;
import java.net.URISyntaxException;
import com.github.nkzawa.socketio.client.Socket;

import java.util.ArrayList;

public class Multi extends AppCompatActivity {

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.56.1:3000");
        } catch (URISyntaxException e) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);

        myMulti = this;

        anhXa();
        mSocket.connect();
        khoiTao();
        setData();

    }




    private static Multi myMulti;

    public static Multi getMyMulti()
    {
        return myMulti;
    }

    private Animation animScale, animScale_appear;

    private GridView gdvGamePlay;

    private O_So_Adapter adapter;

    private Button btnMenu;

    private Button btnUndo;

    private TextView myDiem;

    private double x0, y0, x, y;

    private void anhXa(){
        gdvGamePlay = (GridView)findViewById(R.id.gdvGamePlayMulti);
        myDiem = (TextView)findViewById(R.id.myDiemMulti);
        btnMenu = (Button)findViewById(R.id.btnMenuMulti);
        btnUndo = (Button)findViewById(R.id.btnUnDoMulti);
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        animScale_appear = AnimationUtils.loadAnimation(this, R.anim.anim_scale_appear);
    }

    private void khoiTao(){
        DataGame.getDatagame().intt(Multi.this);
        adapter = new O_So_Adapter(Multi.this, 0, DataGame.getDatagame().getArrSo());
        gdvGamePlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x0 = event.getX();
                        y0 = event.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        x = event.getX();
                        y = event.getY();
                        if (Math.abs(x - x0) > Math.abs(y - y0)) {
                            if (x > x0) {                                     // Vuốt phải
                                DataGame.getDatagame().vuotPhai();
                                adapter.notifyDataSetChanged();
                            } else if(x < x0){                                //Vuốt trái
                                DataGame.getDatagame().vuotTrai();
                                adapter.notifyDataSetChanged();
                            }
                        } else if(Math.abs(x - x0) < Math.abs(y - y0)){
                            if (y > y0) {                            // Vuốt xuống
                                DataGame.getDatagame().vuotXuong();
                                adapter.notifyDataSetChanged();
                            } else if(y < y0) {                                 // Vuốt lên
                                DataGame.getDatagame().vuotLen();
                                adapter.notifyDataSetChanged();
                            }
                        }
                        myDiem.setText(""+DataGame.getDatagame().getDiem());
                        if(DataGame.getDatagame().kiemTra() == 0)
                        {
                            DataGame.getDatagame().dongBo();
                            Toast.makeText(Multi.this, "GAME OVER", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
                return true;
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Multi.this, Menu.class));
                overridePendingTransition(R.anim.anim_enter,R.anim.anim_exit);
            }
        });

        btnUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DataGame.getDatagame().getDiem() != 0) {
                    HighScore.getHighScore().quayLaiDiem();
                    setMyUnDo();
                }
            }
        });
    }

    public void setData(){
        gdvGamePlay.setAdapter(adapter);
    }

    public void phongTo(int a)
    {
        Toast.makeText(Multi.this,"" + a, Toast.LENGTH_SHORT).show();
    }

    public void xuatHien(ImageView img)
    {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(animScale_appear);
            }
        });
    }


    public void setMyUnDo()
    {
        DataGame.getDatagame().getBack();
        adapter.notifyDataSetChanged();
        myDiem.setText(""+DataGame.getDatagame().getDiem());
        setData();
    }
}

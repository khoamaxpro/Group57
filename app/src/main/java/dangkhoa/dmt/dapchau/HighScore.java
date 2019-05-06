package dangkhoa.dmt.dapchau;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        highScore = this;

        if(luuDiemHigh == null)
        {
            luuDiemHigh = getSharedPreferences("DiemSoHigh", MODE_PRIVATE);
        }

        if(tinhHinh == 1)
        {
            tinhHinh = 0;
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }

        diemTop[0] = luuDiemHigh.getInt("DiemTop1", 0);
        diemTop[1] = luuDiemHigh.getInt("DiemTop2", 0);
        diemTop[2] = luuDiemHigh.getInt("DiemTop3", 0);

        Top1 = (TextView)findViewById(R.id.myTop1);

        Top2 = (TextView)findViewById(R.id.myTop2);

        Top3 = (TextView)findViewById(R.id.myTop3);

        Top1.setText("1: " + diemTop[0]);

        Top2.setText("2: " + diemTop[1]);

        Top3.setText("3: " + diemTop[2]);


    }


    private static HighScore highScore;
    static {
        highScore = new HighScore();
    }
    public static HighScore getHighScore(){
        return highScore;
    }

    private TextView Top1;

    private TextView Top2;

    private TextView Top3;

    static private int diem = 0;
    static private int diem_2 = 0;
    static private int[] diemTop = {0,0,0};

    static private int tinhHinh = 1;

    private SharedPreferences luuDiemHigh;

    public void resetDiem() {
        diem = -10;
        diem_2 = 0;
    }

    public void congDiem()
    {
        diem_2 = diem;
        diem = diem + 10;
    }

    public void quayLaiDiem()
    {
        diem = diem_2;
    }

    public void ketThuc()
    {

        luuDiemHigh = getSharedPreferences("DiemSoHigh", MODE_PRIVATE);


        diemTop[0] = luuDiemHigh.getInt("DiemTop1", 0);
        diemTop[1] = luuDiemHigh.getInt("DiemTop2", 0);
        diemTop[2] = luuDiemHigh.getInt("DiemTop3", 0);

        if(diem > diemTop[2]) {
            int i;
            for (i = 2; i >= 0; i--) {
                if (diem < diemTop[i]) {
                    break;
                }
            }
            for (int j = 2; j > i + 1; j--) {
                diemTop[j] = diemTop[j - 1];
            }
            diemTop[i + 1] = diem;
        }

        setLuuDiemHighTop();
    }
    public void setLuuDiemHighTop()
    {
        SharedPreferences.Editor editor = luuDiemHigh.edit();
        editor.putInt("DiemTop1", diemTop[0]);
        editor.putInt("DiemTop2", diemTop[1]);
        editor.putInt("DiemTop3", diemTop[2]);
        editor.commit();
    }
}

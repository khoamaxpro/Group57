package dangkhoa.dmt.dapchau;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        textView = (TextView)findViewById(R.id.myHighScore);

        textView.setText("1: " + diem);

    }

    private static HighScore highScore;
    static {
        highScore = new HighScore();
    }
    public static HighScore getHighScore(){
        return highScore;
    }

    private TextView textView;

    private int diem;

    public void setDiem(int a) {
        diem = a;
    }
}

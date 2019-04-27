package dangkhoa.dmt.dapchau;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;

public class O_Vuong extends ImageView {



    public O_Vuong(Context context) {
        super(context);
    }

    public O_Vuong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public O_Vuong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ImageView imgHinh;

    public ArrayList<Integer> arrayHinh;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai = getMeasuredWidth();
        setMeasuredDimension(dai - 7, dai - 7);

    }

    public void setHinh(int so,int loai)
    {
        arrayHinh = new ArrayList<>();
        arrayHinh.add(R.drawable.a);
        arrayHinh.add(R.drawable.pot1);
        arrayHinh.add(R.drawable.pot2);
        arrayHinh.add(R.drawable.pot3);
        arrayHinh.add(R.drawable.pot4);
        arrayHinh.add(R.drawable.pot5);
        arrayHinh.add(R.drawable.pot6);
        arrayHinh.add(R.drawable.pot7);
        arrayHinh.add(R.drawable.pot8);
        arrayHinh.add(R.drawable.pot9);
        arrayHinh.add(R.drawable.pot10);
        arrayHinh.add(R.drawable.pot11);
        arrayHinh.add(R.drawable.pot12);
        arrayHinh.add(R.drawable.pot13);
        arrayHinh.add(R.drawable.pot14);
        arrayHinh.add(R.drawable.pot15);
        arrayHinh.add(R.drawable.pot16);

        imgHinh = (ImageView)findViewById(R.id.txvOVuong);
        if(so > 0) {
            imgHinh.setImageResource(arrayHinh.get((int) (Math.log(so) / Math.log(2))));
        }
        else
        {
            imgHinh.setImageResource(arrayHinh.get(0));
        }
    }
}

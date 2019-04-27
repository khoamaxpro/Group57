package dangkhoa.dmt.dapchau;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class O_So_Adapter extends ArrayAdapter<Integer> {

    private Context ct;
    private ArrayList<Integer> arr;
    private ArrayList<Integer> loai;



    public O_So_Adapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
        this.loai = new ArrayList<>(objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_o_vuong ,null);
        }
        if(arr.size() > 0)
        {
            O_Vuong o = (O_Vuong)convertView.findViewById(R.id.txvOVuong);
            o.setHinh(arr.get(position), loai.get(position));
        }
        return convertView;
    }


    @Override
    public void notifyDataSetChanged() {
        arr = DataGame.getDatagame().getArrSo();
        loai = DataGame.getDatagame().getLoai();
        super.notifyDataSetChanged();
    }
}


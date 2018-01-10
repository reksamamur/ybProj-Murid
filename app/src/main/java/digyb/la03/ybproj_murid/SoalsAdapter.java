package digyb.la03.ybproj_murid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Created by reksa on 08/01/2018.
 */

public class SoalsAdapter extends RecyclerView.Adapter<SoalsAdapter.SoalsViewHOlder> {

    ArrayList<Soals> soals = new ArrayList<Soals>();

    public SoalsAdapter(ArrayList<Soals> soals){
        this.soals = soals;
    }
    @Override
    public SoalsAdapter.SoalsViewHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent,false);
        SoalsViewHOlder soalsViewHOlder = new SoalsViewHOlder(view);
        return soalsViewHOlder;
    }

    @Override
    public void onBindViewHolder(SoalsAdapter.SoalsViewHOlder holder, int position) {
        Soals so = soals.get(position);
        holder.textView.setText(so.getTerlihatsoals());
    }

    @Override
    public int getItemCount() {
        return soals.size();
    }

    public static class SoalsViewHOlder extends RecyclerView.ViewHolder {
        TextView textView;
        public SoalsViewHOlder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.soalTampil);
        }
    }
}

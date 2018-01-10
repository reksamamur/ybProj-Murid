package digyb.la03.ybproj_murid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by reksa on 08/01/2018.
 */

public class SoalsAdapter extends RecyclerView.Adapter<SoalsAdapter.SoalViewHolder> {
    ArrayList<Soals> soals = new ArrayList<Soals>();

    //private RadioGroup lastCheckedRadioGroup = null;
    public SoalsAdapter(ArrayList<Soals> soals){
        this.soals = soals;
    }
    @Override
    public SoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        SoalViewHolder soalViewHolder = new SoalViewHolder(view);
        return soalViewHolder;
    }

    @Override
    public void onBindViewHolder(SoalViewHolder holder, int position) {
        Soals so = soals.get(position);
        holder.terlihat_soal.setText(so.getTerlihatsoals());
    }

    @Override
    public int getItemCount() {
        return soals.size();
    }

    public static class SoalViewHolder extends RecyclerView.ViewHolder{
        TextView terlihat_soal;
        public SoalViewHolder(View itemView) {
            super(itemView);
            terlihat_soal = itemView.findViewById(R.id.soalTampil);
        }
    }
}

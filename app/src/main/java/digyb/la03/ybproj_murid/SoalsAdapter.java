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

import java.util.ArrayList;

import butterknife.OnClick;

/**
 * Created by reksa on 08/01/2018.
 */

public class SoalsAdapter extends RecyclerView.Adapter<SoalsAdapter.SoalViewHolder> {
    ArrayList<Soals> soals = new ArrayList<Soals>();
    //Context context;

    public SoalsAdapter(ArrayList<Soals> soals){
        //this.context = context;
        this.soals = soals;
    }
    @Override
    public SoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        SoalViewHolder soalViewHolder = new SoalViewHolder(view);

        /*
        RadioButton nol = view.findViewById(R.id.jawabA);
        RadioButton one = view.findViewById(R.id.jawabB);
        RadioButton two = view.findViewById(R.id.jawabC);
        RadioButton three = view.findViewById(R.id.jawabD);
        RadioButton four = view.findViewById(R.id.jawabE);
        RadioButton five = view.findViewById(R.id.jawabF);

        nol.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    ;
            }
        });*/

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

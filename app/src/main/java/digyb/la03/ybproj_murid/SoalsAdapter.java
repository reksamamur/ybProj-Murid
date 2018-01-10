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

import butterknife.OnClick;

/**
 * Created by reksa on 08/01/2018.
 */

public class SoalsAdapter extends RecyclerView.Adapter<SoalsAdapter.SoalViewHolder> {
    ArrayList<Soals> soals = new ArrayList<Soals>();
    int lastchecked = -1;
    String[] questionsList;
    //Context context;

    public SoalsAdapter(ArrayList<Soals> soals, String[] questionsList){
        //this.context = context;
        this.soals = soals;
        /*
        soals = new ArrayList<>();
        for (int i = 0; i < questionsList.length; i++) {
            soals.add("Not Attempted");
        }*/
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
        holder.nol.setChecked(position == lastchecked);
        holder.one.setChecked(position == lastchecked);
        holder.two.setChecked(position == lastchecked);
        holder.three.setChecked(position == lastchecked);
        holder.four.setChecked(position == lastchecked);
        holder.five.setChecked(position == lastchecked);
    }

    @Override
    public int getItemCount() {
        return soals.size();
    }

    public class SoalViewHolder extends RecyclerView.ViewHolder{
        TextView terlihat_soal;
        RadioButton nol;
        RadioButton one;
        RadioButton two;
        RadioButton three;
        RadioButton four;
        RadioButton five;
        public SoalViewHolder(View itemView) {
            super(itemView);
            terlihat_soal = itemView.findViewById(R.id.soalTampil);
            nol = itemView.findViewById(R.id.jawabA);
            one = itemView.findViewById(R.id.jawabB);
            two = itemView.findViewById(R.id.jawabC);
            three = itemView.findViewById(R.id.jawabD);
            four = itemView.findViewById(R.id.jawabE);
            five = itemView.findViewById(R.id.jawabF);

            nol.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if (isChecked){
                        lastchecked = getAdapterPosition();
                    }
                }
            });
            two.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if (isChecked){
                        lastchecked = getAdapterPosition();
                    }
                }
            });
            three.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if (isChecked){
                        lastchecked = getAdapterPosition();
                    }
                }
            });
            four.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if (isChecked){
                        lastchecked = getAdapterPosition();
                    }
                }
            });
            five.setOnCheckedChangeListener(new RadioButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
                {
                    if (isChecked){
                        lastchecked = getAdapterPosition();
                    }
                }
            });
        }
    }
}

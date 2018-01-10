package digyb.la03.ybproj_murid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.multidex.MultiDex;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Soals> list = new ArrayList<Soals>();
    String[] pertanyaan;

    //AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MultiDex.install(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = getResources().getStringArray(R.array.soal);
        int count = 0;
        for (String Pertanyaan : pertanyaan){
            Soals soals = new Soals(Pertanyaan);
            count++;
            list.add(soals);
        }
        recyclerView = findViewById(R.id.penampilsoal);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new SoalsAdapter(list);
        recyclerView.setAdapter(adapter);

        /*
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getItemId(pertanyaan.length) != -1){
                    AlertDialog.Builder alertNih = new AlertDialog.Builder(MainActivity.this);
                    alertNih.setTitle("Error");
                    alertNih.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alertNih.show();
                }else{
                    Intent intent = new Intent(MainActivity.this, ThankYou.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }

            }
        });*/
    }

    public void SubmitTombol(){
        if (adapter.getItemId(pertanyaan.length) != -1){
            AlertDialog.Builder alertNih = new AlertDialog.Builder(MainActivity.this);
            alertNih.setTitle("Error");
            alertNih.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertNih.show();
        }else{
            Intent intent = new Intent(MainActivity.this, ThankYou.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}

package digyb.la03.ybproj_murid;

import android.content.DialogInterface;
import android.content.Intent;
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

    AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }

    public void SubmitTombol(View view){
        Intent intent = new Intent(MainActivity.this, ThankYou.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

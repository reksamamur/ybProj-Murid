package digyb.la03.ybproj_murid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Soals> list = new ArrayList<Soals>();
    String[] pertanyaan;

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
}

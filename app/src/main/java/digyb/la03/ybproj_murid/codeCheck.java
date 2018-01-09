package digyb.la03.ybproj_murid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class codeCheck extends AppCompatActivity {

    EditText kode;
    Button btnKode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_check);

        kode = findViewById(R.id.codebox);
        btnKode = findViewById(R.id.entercode);

        btnKode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterCode();
            }
        });

    }

    public void enterCode(){

        //-----------------------------

        final String sKode = kode.getText().toString().trim();

        final ProgressDialog prog = ProgressDialog.show(codeCheck.this,"","Loading....",true);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_CODE,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {

                        //If we are getting success from server
                        if (response.contains(Config.CODE_ISLOG)) {
                            prog.dismiss();
                            gotoMainActivity();

                        } else {
                            prog.dismiss();
                            //Displaying an error message on toast
                            Toast.makeText(getApplicationContext(), "Invalid Code", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                        prog.dismiss();
                        Toast.makeText(getApplicationContext(), "The server unreachable", Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.CODE_KODE, sKode);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        Volley.newRequestQueue(this).add(stringRequest);

        //-----------------------------
    }

    public void gotoMainActivity()
    {

        Intent intent = new Intent(codeCheck.this, FillForm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }
}

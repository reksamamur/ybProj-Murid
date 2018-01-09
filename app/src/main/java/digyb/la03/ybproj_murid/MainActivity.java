package digyb.la03.ybproj_murid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    EditText code,name,email,telp,info;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = findViewById(R.id.edt_code);
        name = findViewById(R.id.edt_name);
        email = findViewById(R.id.edt_mail);
        telp = findViewById(R.id.edt_phone);
        info = findViewById(R.id.edt_info);

        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambah();
            }
        });
    }

    public void tambah()
    {
        final String sCode = code.getText().toString().trim();
        final String sName = name.getText().toString().trim();
        final String sMail = email.getText().toString().trim();
        final String sTelp = telp.getText().toString().trim();
        final String sInfo = info.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_TAMBAH,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //If we are getting success from server
                        if (response.contains(Config.MURID_ISREG)) {
//                            hideDialog();
                            Toast.makeText(MainActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                            gotoMainActivity();

                        } else {
//                            hideDialog();
                            //Displaying an error message on toast
//                            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
//                        hideDialog();
                        Toast.makeText(getApplicationContext(), "The server unreachable", Toast.LENGTH_LONG).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.MURID_KODE, sCode);
                params.put(Config.MURID_NAME, sName);
                params.put(Config.MURID_EMAIL, sMail);
                params.put(Config.MURID_TELP, sTelp);
                params.put(Config.MURID_INFO, sInfo);

                //returning parameter
                return params;
            }

//        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        finish();
//        startActivity(intent);

        };

        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void gotoMainActivity()
    {
        Intent intent = new Intent(MainActivity.this, FillForm.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }
}

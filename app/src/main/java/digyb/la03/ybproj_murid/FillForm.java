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

public class FillForm extends AppCompatActivity {

    EditText name,email,phone,info;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_form);

        name = findViewById(R.id.edtName);
        email = findViewById(R.id.edtEmail);
        phone = findViewById(R.id.edtPhone);
        info = findViewById(R.id.edtInfo);

        submit = findViewById(R.id.btn_submit_data);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

    }

    public void submitData(){
        //-------------------

        final String sName = name.getText().toString().trim();
        final String semail = email.getText().toString().trim();
        final String sPhone = phone.getText().toString().trim();
        final String sInfo = info.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_MURID,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //If we are getting success from server
                        if (response.contains(Config.MURID_ISREG)) {
//                            hideDialog();
                            Toast.makeText(FillForm.this, "Data Added", Toast.LENGTH_SHORT).show();
                            gotoMainActivity();

                        } else {
//                            hideDialog();
                            //Displaying an error message on toast
//                            Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                            Toast.makeText(FillForm.this, response, Toast.LENGTH_SHORT).show();
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
                params.put(Config.MURID_NAME, sName);
                params.put(Config.MURID_EMAIL, semail);
                params.put(Config.MURID_TELP, sPhone);
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

        //-------------------
    }

    public void gotoMainActivity()
    {
        Intent intent = new Intent(FillForm.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        startActivity(intent);
    }
}

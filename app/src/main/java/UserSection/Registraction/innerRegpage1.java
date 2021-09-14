package UserSection.Registraction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reformingkeralathroughdigitilization.Login_page;
import com.example.reformingkeralathroughdigitilization.R;

public class innerRegpage1 extends AppCompatActivity {

    EditText edtpassword,edtCmpPassword;
    String strpassword,strCmppassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_regpage1);
        edtpassword=findViewById(R.id.edtpassword);
        edtCmpPassword=findViewById(R.id.edtCmpPassword);

        strpassword=edtpassword.getText().toString().trim();
        strCmppassword=edtCmpPassword.getText().toString().trim();

        if (TextUtils.isEmpty(strpassword)){
            Toast.makeText(this, "Enter your Password", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(strCmppassword)){
            Toast.makeText(this, "Enter your Canform Password", Toast.LENGTH_SHORT).show();
        }else if (strpassword.equals(strCmppassword)){
            Toast.makeText(this, "Password are Not Equals", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent=new Intent(this, Login_page.class);
            startActivity(intent);
            finish();
        }
    }
}
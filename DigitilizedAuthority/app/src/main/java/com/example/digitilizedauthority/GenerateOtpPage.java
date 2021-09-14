package com.example.digitilizedauthority;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class GenerateOtpPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_otp_page);
        checkConnection();

        final EditText inputMobileNo=findViewById(R.id.EtxtphoneNo);
        final Button btnGetOTP=findViewById(R.id.btnGetOTP);
        final ProgressBar progressBar=findViewById(R.id.progressbar);
        btnGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputMobileNo.getText().toString().trim().isEmpty()){
                    Toast.makeText(GenerateOtpPage.this,"Enter Mobile Number",  Toast.LENGTH_SHORT).show();
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    btnGetOTP.setVisibility(View.INVISIBLE);

                    PhoneAuthProvider.getInstance().verifyPhoneNumber("+91"+inputMobileNo.getText().toString(),60,TimeUnit.SECONDS,GenerateOtpPage.this,new PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            progressBar.setVisibility(View.GONE);
                            btnGetOTP.setVisibility(View.VISIBLE);

                        }

                        @Override
                        public void onVerificationFailed(FirebaseException e) {

                            progressBar.setVisibility(View.GONE);
                            btnGetOTP.setVisibility(View.VISIBLE);
                            Toast.makeText(GenerateOtpPage.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            progressBar.setVisibility(View.GONE);
                            btnGetOTP.setVisibility(View.VISIBLE);
                            Intent intent=new Intent(getApplicationContext(),VerifyOtp.class);
                            intent.putExtra("mobile",inputMobileNo.getText().toString());
                            intent.putExtra("verificationId",verificationId);
                            startActivity(intent);
                        }
                    });


            }
            }
        });
    }
    public void checkConnection(){
        ConnectivityManager manager=(ConnectivityManager)getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork=manager.getActiveNetworkInfo();

        if (null!=activeNetwork){
            if (activeNetwork.getType()==ConnectivityManager.TYPE_WIFI){
                Toast.makeText(this,"Wifi Enabled",Toast.LENGTH_SHORT).show();
            }
            if (activeNetwork.getType()==ConnectivityManager.TYPE_MOBILE){
                Toast.makeText(this,"Mobile Data Enabled",Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this," No connection",Toast.LENGTH_SHORT).show();
        }
    }
}
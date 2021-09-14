package UserSection.Registraction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reformingkeralathroughdigitilization.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalInformationPage extends AppCompatActivity {

    EditText edtName,edtAddress,etdDob,edtStatus,edtUid,etdFathername,edtPhoneNo,etdEmail;
    Button Regbutton;
    CircleImageView profileimage;
    String strName,strAddress,strDob,strStatus,strUid,strFathername,strPhoneNo,strEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_page);

        profileimage=findViewById(R.id.img);
        edtName=findViewById(R.id.editName);
        edtAddress=findViewById(R.id.edtAddress);
        etdDob=findViewById(R.id.etdDob);
        edtStatus=findViewById(R.id.edtStatus);
        edtUid=findViewById(R.id.edtUid);
        etdFathername=findViewById(R.id.etdFathername);
        etdEmail=findViewById(R.id.etdEmail);
        Regbutton=findViewById(R.id.Regbutton);

        Regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                strName=edtName.getText().toString();
//                strAddress=edtAddress.getText().toString();
//                strDob=etdDob.getText().toString();
//                strStatus=edtStatus.getText().toString();
//                strUid=edtUid.getText().toString();
//                strFathername=etdFathername.getText().toString();
//                strPhoneNo=edtPhoneNo.getText().toString();
//                strEmail=etdEmail.getText().toString();
//
//                if(profileimage==null){
//                    Toast.makeText(PersonalInformationPage.this, "select Your image Name", Toast.LENGTH_SHORT).show();
//                }
//                else if (TextUtils.isEmpty(strName)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Name", Toast.LENGTH_SHORT).show();
//                }
//                else if (TextUtils.isEmpty(strAddress)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Address", Toast.LENGTH_SHORT).show();
//
//                }
//                else if (TextUtils.isEmpty(strDob)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Date of Birth", Toast.LENGTH_SHORT).show();
//
//                }
//                else if (TextUtils.isEmpty(strUid)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Adhaar UID", Toast.LENGTH_SHORT).show();
//
//                }
//                else if (TextUtils.isEmpty(strFathername)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Father Name", Toast.LENGTH_SHORT).show();
//
//                }
//                else if (TextUtils.isEmpty(strPhoneNo)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Phone Number", Toast.LENGTH_SHORT).show();
//
//                }
//                else if (TextUtils.isEmpty(strEmail)){
//                    Toast.makeText(PersonalInformationPage.this, "Enter your Email Id", Toast.LENGTH_SHORT).show();
//
//                }
//                else {
                    Intent intent=new Intent(PersonalInformationPage.this,GenerateOtpPage.class);
                    startActivity(intent);
                    finish();
                   // profileData.setImageUri(System.currentTimeMillis() + "." + getFileExtension(imageUri));

               // }
            }
        });
    }

//    private void openGallery() {
//
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent,1);
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode==1 && resultCode==RESULT_OK && data != null){
//            imageUri = data.getData();
//            profileimage.setImageURI(imageUri);
//        }
//    }
//
//    private String getFileExtension(Uri muri) {
//
//        ContentResolver contentResolver;
//        contentResolver= getApplicationContext().getContentResolver();
//        MimeTypeMap mime=MimeTypeMap.getSingleton();
//        return mime.getExtensionFromMimeType(contentResolver.getType(muri));
//    }
}
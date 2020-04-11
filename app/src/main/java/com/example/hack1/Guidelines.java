package com.example.hack1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Guidelines extends AppCompatActivity {
    Button b1;
    EditText name,phone,address,editText;
    FirebaseAuth mfirebaseAuth;
    FirebaseFirestore fstore;
    DatabaseReference databaseReference;
    RadioGroup rg,rg1,rg2;
    String value,value1,value2;
    String name1,phone1,address1,editText1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        b1 = (Button) findViewById(R.id.b1);
        //final Feedback feedback=new Feedback();
        rg = (RadioGroup) findViewById(R.id.rg);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rg2 = (RadioGroup) findViewById(R.id.rg2);

        editText = (EditText) findViewById(R.id.txt_feedback);
        name= (EditText) findViewById(R.id.txt_name);
        phone= (EditText) findViewById(R.id.txt_phn);
        address = (EditText) findViewById(R.id.txt_address);
        mfirebaseAuth=FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("FeedBack");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString().trim();
                String phone1 = phone.getText().toString().trim();
                String address1 = address.getText().toString().trim();
                String editText1 = editText.getText().toString().trim();
                value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                value1 = ((RadioButton) findViewById(rg1.getCheckedRadioButtonId())).getText().toString();
                value2 = ((RadioButton) findViewById(rg2.getCheckedRadioButtonId())).getText().toString();
                //String address = editText3.getText().toString();
                //Query query=FirebaseDatabase.getInstance().getReference("FeedBack").orderByChild("city2").equalTo(city1);
                //query.addListenerForSingleValueEvent(valueEventListener);
                if (name1.isEmpty()) {
                    name.setError("Please Enter Name");
                    name.requestFocus();
                    return;
                }
                if (phone1.isEmpty()) {
                    phone.setError("Please Enter Your Phone No.");
                    phone.requestFocus();
                    return;
                }
                if (address1.isEmpty()) {
                    address.setError("Please Enter your Address");
                    address.requestFocus();
                    return;
                }
                if (editText1.isEmpty()) {
                    editText.setError("Please Enter Item");
                    editText.requestFocus();
                    return;
                }
                String id = databaseReference.push().getKey();
                //userId = mfirebaseAuth.getCurrentUser().getUid();
                //DocumentReference documentReference = fstore.collection("Donate");
                /*Map<String, Object> user = new HashMap<>();
                user.put("Name",name1);
                user.put("Email",email1);
                user.put("Item", item);
                user.put("Quantity", quantity);
                user.put("Phone no", phone);
                user.put("State",state1);
                user.put("City",city1);
                user.put("Address", address);
                user.put("Accepted","No");*/
                Feedback feedback1=new Feedback(id,name1,phone1,address1,value,value1,value2,editText1);
                databaseReference.child(id).setValue(feedback1);
                Toast.makeText(Guidelines.this, "Thanks for Your Valuable Feedback!", Toast.LENGTH_SHORT).show();
                // Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("mail to:"+emailx));
                //intent.putExtra(Intent.EXTRA_SUBJECT,"Collect the item from the Specified Location");
                //intent.putExtra(Intent.EXTRA_TEXT,"Details already shown in the profile");
                //startActivity(intent);
                Intent intents = new Intent(Guidelines.this, MainActivity.class);
                startActivity(intents);


            }
        });
    }
}
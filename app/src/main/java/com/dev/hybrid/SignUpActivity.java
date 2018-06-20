package com.dev.hybrid;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    CheckBox chkRead,chkAgreed;
    RadioButton rbMale,rbFemale;
    RadioGroup rgGender;
    Spinner spCity;

    String cities [] ={"Cities","Nairobi","Kisumu","Eldoret","Nakuru","Thika"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        chkRead =findViewById(R.id.chk_read);
        chkAgreed=findViewById(R.id.chk_agreed);

        rbMale=findViewById(R.id.rb_male);
        rbFemale=findViewById(R.id.rb_female);

        rgGender=findViewById(R.id.radio_group);

        spCity=findViewById(R.id.spinner);


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cities);


        spCity.setAdapter(arrayAdapter);




        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_male){
                   // Toast.makeText(SignUpActivity.this, "Male", Toast.LENGTH_SHORT).show();
                }else {
                   // Toast.makeText(SignUpActivity.this, "Female", Toast.LENGTH_SHORT).show();

                }
            }
        });

        rbFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                   // Toast.makeText(SignUpActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }else {
                   // Toast.makeText(SignUpActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();

                }
            }
        });


        rbFemale.setChecked(true);

        rbFemale.setChecked(false);


    boolean state=    rbFemale.isChecked();


    chkRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                 Toast.makeText(SignUpActivity.this, "Read checked", Toast.LENGTH_SHORT).show();
            }else {
                 Toast.makeText(SignUpActivity.this, "Read Unchecked", Toast.LENGTH_SHORT).show();

            }
        }
    });



    spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            Toast.makeText(SignUpActivity.this, ""+cities[position], Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    }

    public void submit(View view) {

        String gender="";


        switch (rgGender.getCheckedRadioButtonId()){

            case R.id.rb_female:
                gender="Female";

                break;

            case R.id.rb_male:
                gender="Male";
                break;

                default:
                    gender=" please choose  JHVJHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH";



        }

        //Toast.makeText(this, gender, Toast.LENGTH_LONG).show();




        if(!chkRead.isChecked()){
            Snackbar.make(view, "Not read", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();           // Toast.makeText(this, "Not read", Toast.LENGTH_SHORT).show();
        }else {
            if(!chkAgreed.isChecked()){

            //    Toast.makeText(this, "Not agreed", Toast.LENGTH_SHORT).show();
            }
        }


        if(spCity.getSelectedItemPosition()==0){
            Toast.makeText(this, "Select city", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, cities[spCity.getSelectedItemPosition()], Toast.LENGTH_SHORT).show();

        }


    }
}

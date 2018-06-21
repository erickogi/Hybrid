package com.dev.hybrid;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
//implements   PopupMenu.OnMenuItemClickListener
public class Menus extends AppCompatActivity implements   PopupMenu.OnMenuItemClickListener {

    private Button button,btnPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        button=findViewById(R.id.btn_context);
        btnPopup=findViewById(R.id.btn_popup);

        registerForContextMenu(button);


        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp(v);
            }
        });

//        registerForContextMenu(button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menu_help:
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.menu_settings:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();

                break;

            case  R.id.menu_share:
                Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show();

                break;
            default:

        }

        return true;
    }







        public void showPopUp(View v){
        PopupMenu popupMenu=new PopupMenu(Menus.this,button);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.app_menu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(Menus.this);
        popupMenu.show();
    }
//
//
//    //creating the menus
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.app_menu,menu);
//        return true;
//    }
//
//
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);


    }
//
//
//
//    //Menu events listeners
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menu_help:
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.menu_settings:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();

                break;

            case  R.id.menu_share:
                Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show();

                break;
            default:

        }
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_help:
                Toast.makeText(this, "Help clicked", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_settings:
                Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show();

                break;

            case R.id.menu_share:
                Toast.makeText(this, "Share clicked", Toast.LENGTH_SHORT).show();

                break;
            default:
        }
        return true;
    }

    public void showDialog(){

    }


    public void showDialog(View view) {
//        Dialog d=new Dialog(Menus.this);
//        d.setContentView(R.layout.dialog);
//        d.setTitle("Sample dialog");
//        d.setCancelable(true);
//        d.show();
        //dialog();
        progressDialog();

    }



    private void dialog() {
        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:


                        Toast.makeText(Menus.this, "Positive clicked", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();


                        break;
                    case DialogInterface.BUTTON_NEGATIVE:

                        Toast.makeText(Menus.this, "Negative clicked", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                        break;
                }
            }
        };


        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setMessage(" Better dialog").setPositiveButton("Okay", dialogClickListener)
                 .setNegativeButton("Download Form",dialogClickListener)
                .setCancelable(false)

                .setIcon(R.drawable.ic_launcher_background)
                .show();
    }

    private void  progressDialog(){
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.setCancelable(true);
        progressDialog.setTitle("Progress");
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();




    }

}

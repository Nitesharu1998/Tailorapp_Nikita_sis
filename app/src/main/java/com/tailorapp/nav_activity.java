package com.tailorapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.media.MediaMetadataCompat;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.tailorapp.databinding.ActivityNavBinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class nav_activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    OutputStream outputStream;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.tailorapp.databinding.ActivityNavBinding binding = ActivityNavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNav.toolbar);
        binding.appBarNav.fab.setOnClickListener(view ->{
                Intent intent = new Intent(nav_activity.this,Customerdetails.class);
        startActivity(intent);
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        NavigationView navigationView1=findViewById(R.id.nav_view);
        navigationView1.getMenu().findItem(R.id.nav_Logout).setOnMenuItemClickListener(menuItem -> {
            logout();
            return true;
        });
        NavigationView navigationView2=findViewById(R.id.nav_view);
        navigationView2.getMenu().findItem(R.id.nav_Camera).setOnMenuItemClickListener(menuItem -> {
            askCameraPermissions();
            return true;
        });

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_Camera, R.id.nav_Customer, R.id.nav_Order, R.id.nav_Receipt, R.id.nav_Logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void askCameraPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 101);
        }else{
            openCamera();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==101){
            if(grantResults.length < 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            }else{
                Toast.makeText(this,"Camera Permission is required to use camera.",Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void openCamera() {
        Intent camera =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera,102);

    }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            if (requestCode == 102) {
                Bitmap image = (Bitmap) data.getExtras().get("data");

                File dir = new File(Environment.getExternalStorageDirectory(), "TailorAppImages");
                if (!dir.exists()) {
                    dir.mkdir();
              }
              File file = new File(dir, System.currentTimeMillis() + ".jpg");
              try {
                  outputStream = new FileOutputStream(file);
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              }
              image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
              Toast.makeText(nav_activity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();

                try {
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            super.onActivityResult(requestCode, resultCode, data);
        }

    //    private void takepicture() {
//        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivity(intent);
   // }

    private void logout() {
        Intent intent = new Intent(nav_activity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_activity, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
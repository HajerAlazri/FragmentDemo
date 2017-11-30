package ita.om.fragmentdemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import ita.om.fragmentdemo.hct_home.HCTHomeFragement;
import ita.om.fragmentdemo.hct_student.HCTStudent_fragment;

public class HomeScreen extends AppCompatActivity implements  HCTHomeFragement.OnFragmentInteractionListener,
    HCTStudent_fragment.OnFragmentInteractionListener{
    FrameLayout frame;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
       HCTHomeFragement homeFragement =new HCTHomeFragement();
       frame=(FrameLayout) findViewById(R.id.main_container);
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        HCTHomeFragement fragement= new HCTHomeFragement();
        fragmentTransaction.replace(R.id.main_container, fragement);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
    public void OnBackPressed(View view){
        getSupportActionBar().show();
        super.onBackPressed();

    }
    public void onFragmentBackPresed(View view){
        Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
        onBackPressed();

    }
}

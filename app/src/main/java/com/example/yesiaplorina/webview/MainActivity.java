package com.example.yesiaplorina.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yesiaplorina.webview.fragmen.Docs;
import com.example.yesiaplorina.webview.fragmen.Home;
import com.example.yesiaplorina.webview.fragmen.News;
import com.example.yesiaplorina.webview.fragmen.Platform;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //4. fragment yang pertama kali dijalankan
        Fragment fragment = new Home();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragment, fragment)
                    .commit();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //1
        Fragment fragment = null;
        //2
        if (id == R.id.nav_home) {
            fragment = new Home();
        } else if (id == R.id.nav_platform) {
            fragment = new Platform();
        } else if (id == R.id.nav_docs) {
            fragment = new Docs();

        } else if (id == R.id.nav_news) {
            fragment = new News();

        } else if (id == R.id.nav_email) {

            e();


        } else if (id == R.id.nav_contact) {
            call();

        }

        //3. cara memasukan fragmen kedalam scop activity dan jika ada perubahan dalam fragmen
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_fragment, fragment)
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void e() {
        Intent b=new Intent(Intent.ACTION_SENDTO
        ,Uri.fromParts("mailto"
        ,"kimyesiahyera@gmail.com"
        ,null));

        b.putExtra(Intent.EXTRA_SUBJECT,"Ini Subject loh");
        b.putExtra(Intent.EXTRA_TEXT,"Ini text loh");

        startActivity(b);
    }

    private void call() {

        Intent call = new Intent(Intent.ACTION_DIAL);

        call.setData(Uri.parse("tel:082159893068"));

        startActivity(call);

    }
}

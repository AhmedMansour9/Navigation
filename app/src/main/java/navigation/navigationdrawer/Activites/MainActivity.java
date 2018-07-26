package navigation.navigationdrawer.Activites;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import navigation.navigationdrawer.R;
import navigation.navigationdrawer.adapter.FirstGroub;
import navigation.navigationdrawer.adapter.Secondgroub;
import navigation.navigationdrawer.adapter.header;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView mRecyclerViewHederNotification,RecycleFirstGroub,RecycleSecondGroub;
    header headerListAdapter;
    ImageView imageViewHeader;
    ImageView school,addschool,home;
    public static FirstGroub adapterfirstgroub;
    public static  Secondgroub adapterscond;
    ArrayList headerNotificatList;
    public static DrawerLayout drawer;
    String[] ListFirstGroubnames = new String[] { "Home", "My Profile", "Events", "Favourits", "Inbox"};
    String[] ListSecondGroubnames = new String[] { "Contact Us", "Feed back", "Setting"};
    int[] ListFirstGroubimages = new int[] {R.drawable.home, R.drawable.user, R.drawable.calendar,
            R.drawable.favourit, R.drawable.inbox  };
    int[] ListSecondGroubimages = new int[] {R.drawable.phone, R.drawable.survey, R.drawable.settings };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ListProfile();
        ListFirstGroub();
        ListSecondGroub();
        School();
         addschool();
        home();

    }
    public void init(){
        mRecyclerViewHederNotification =findViewById(R.id.recycle_header);
        imageViewHeader=findViewById(R.id.imageView);
        RecycleFirstGroub=findViewById(R.id.recycler_FirstGroub);
        RecycleSecondGroub=findViewById(R.id.recycler_scondGroub);
        school=findViewById(R.id.school);
        addschool=findViewById(R.id.edit);
        home=findViewById(R.id.home);
    }
    private void ListFirstGroub() {

        adapterfirstgroub=new FirstGroub(this,ListFirstGroubnames,ListFirstGroubimages);
        RecycleFirstGroub.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecycleFirstGroub.setAdapter(adapterfirstgroub);

    }
    private void ListSecondGroub() {

        adapterscond=new Secondgroub(this,ListSecondGroubnames,ListSecondGroubimages);
        RecycleSecondGroub.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecycleSecondGroub.setAdapter(adapterscond);

    }
    private void ListProfile() {
        imageViewHeader.setImageResource(R.drawable.img);
         headerNotificatList = new ArrayList();
        headerNotificatList.add("a");
        headerNotificatList.add("a");
        headerNotificatList.add("a");
        headerListAdapter = new header(headerNotificatList);
        mRecyclerViewHederNotification.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRecyclerViewHederNotification.setAdapter(headerListAdapter);
    }
    public void School(){
        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             unselected();
                Toast.makeText(MainActivity.this, "School is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void addschool(){
        addschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unselected();
                Toast.makeText(MainActivity.this, "Add School is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void home(){
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unselected();
                Toast.makeText(MainActivity.this, "home is selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void unselected(){
        Secondgroub.selected_position=-1;
        MainActivity.adapterscond.notifyDataSetChanged();
        FirstGroub.selected_position=-1;
        MainActivity.adapterfirstgroub.notifyDataSetChanged();
        drawer.closeDrawer(GravityCompat.START);
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


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.android.viplove.betwithfriends.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.viplove.betwithfriends.R;
import com.android.viplove.betwithfriends.bet.Bet;
import com.android.viplove.betwithfriends.database.BetRepo;

public class CreateBetActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int eventCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bet);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.setting_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_change_odds_format) {
            // Go to Change Odds Format Page
            return true;
        } else if (id == R.id.action_edit_profile) {
            // Go to Edit Profile Page
            Intent intent = new Intent(this, EditProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_logout) {
            // Go to Login Page
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Go to Home Page
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_new_bet) {
            // Go to Create Bet Page

        } else if (id == R.id.nav_my_bets) {
            // Go to My Bets Page
            Intent intent = new Intent(this, MyBetsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_new_stake) {
            // Go to Create Stake Page
            Intent intent = new Intent(this, CreateStakeActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_my_stakes) {
            // Go to My Stakes Page
            Intent intent = new Intent(this, MyStakesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void createBet(View view) {

        EditText betName = (EditText) findViewById(R.id.editBetName);
        EditText betDetails = (EditText) findViewById(R.id.editBetDetails);
        TextView betId = (TextView) findViewById(R.id.textBetId);
        TextView betMessage = (TextView) findViewById(R.id.textBetMessage);
        EditText event1Name = (EditText) findViewById(R.id.editEvent1Name);
        EditText event2Name = (EditText) findViewById(R.id.editEvent2Name);
        EditText event3Name = (EditText) findViewById(R.id.editEvent3Name);
        EditText event1Probability = (EditText) findViewById(R.id.editEvent1Probability);
        EditText event2Probability = (EditText) findViewById(R.id.editEvent2Probability);
        EditText event3Probability = (EditText) findViewById(R.id.editEvent3Probability);

        Bet bet = new Bet();
        bet.addNewBet(betName.getText().toString(), (event1Name.getText().toString()), (event2Name.getText().toString()), (event3Name.getText().toString()),
                (Integer.valueOf(event1Probability.getText().toString())), (Integer.valueOf(event2Probability.getText().toString())), (Integer.valueOf(event3Probability.getText().toString())));

        betId.setText("" + bet.getBetId());
        Toast.makeText(CreateBetActivity.this, "Bet " + betName.getText().toString() + "is created", Toast.LENGTH_SHORT).show();

        BetRepo dbHandler = new BetRepo(this, null, null, 1);
        dbHandler.addNewBetRow(bet);

    }

    public void resetBet(View view) {
        EditText betName = (EditText) findViewById(R.id.editBetName);
        EditText betDetails = (EditText) findViewById(R.id.editBetDetails);
        TextView betId = (TextView) findViewById(R.id.textBetId);
        TextView betMessage = (TextView) findViewById(R.id.textBetMessage);
        EditText event1Name = (EditText) findViewById(R.id.editEvent1Name);
        EditText event2Name = (EditText) findViewById(R.id.editEvent2Name);
        EditText event3Name = (EditText) findViewById(R.id.editEvent3Name);
        EditText event1Probability = (EditText) findViewById(R.id.editEvent1Probability);
        EditText event2Probability = (EditText) findViewById(R.id.editEvent2Probability);
        EditText event3Probability = (EditText) findViewById(R.id.editEvent3Probability);

        betId.setText("");
        betName.setText("");
        betDetails.setText("");
        event1Name.setText("");
        event2Name.setText("");
        event3Name.setText("");
        event1Probability.setText("");
        event2Probability.setText("");
        event3Probability.setText("");
        betMessage.setText("");
    }

    public void increaseEventCount(View view) {
        TextView eventCounter = (TextView) findViewById(R.id.event_counter);
        eventCount = eventCount + 1;
        eventCounter.setText("" + eventCount);

    }

    public void decreaseEventCount(View view) {
        TextView eventCounter = (TextView) findViewById(R.id.event_counter);
        eventCount = eventCount - 1;
        eventCounter.setText("" + eventCount);

    }
}

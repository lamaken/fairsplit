package visualk.apps.fairsplit;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import visualk.apps.fairsplit.R;

public class ParticipantsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String session = extras.getString("SESSION_ID");
        }


    }
    public void addNewparticipantsLayout(){

        LinearLayout ll = (LinearLayout) findViewById(R.id.someLayoutId);


        LayoutInflater inflater =
                (LayoutInflater)this.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate( R.layout.participants_layout, null );
        ll.addView(view);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.participants, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_addParticipant) {
            addNewparticipantsLayout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

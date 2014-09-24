package visualk.apps.fairsplit;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import visualk.apps.fairsplit.model.ModelData;

import static visualk.apps.fairsplit.R.id.buttonDelete;


public class ResultatActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);


        updateLlistaParticipants();
    }





    public void updateOne(int m){

        final int n=m;

        LinearLayout ll = (LinearLayout) findViewById(R.id.resultatMainLayoutId);

        LayoutInflater inflater =
                (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.repartiment_layout, null);

        TextView t_dec = (TextView) v.findViewById(R.id.textViewDec);

        TextView t_emdeuen = (TextView) v.findViewById(R.id.textViewEmDeuen);

        TextView t_alias = (TextView) v.findViewById(R.id.textViewNom);
        t_alias.setText(ModelData.getInstance().llistadeparticipants.get(n).getAlias());





        t_dec.setText(ModelData.getInstance().llistadeparticipants.get(n).getDeu());
        t_emdeuen.setText(ModelData.getInstance().llistadeparticipants.get(n).getLiDeuen());


        ll.addView(v);


    }



    public void updateLlistaParticipants(){

        LinearLayout llsource = (LinearLayout) findViewById(R.id.resultatMainLayoutId);
        if(llsource!=null)llsource.removeAllViews();

        for (int n=0;n<ModelData.getInstance().llistadeparticipants.size();n++) {
            updateOne(n);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.resultat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

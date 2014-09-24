package visualk.apps.fairsplit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.LinkedList;

import visualk.apps.fairsplit.R;
import visualk.apps.fairsplit.model.ModelData;
import visualk.apps.fairsplit.model.Participant;
import visualk.apps.fairsplit.model.UniqueName;

import static visualk.apps.fairsplit.R.id.buttonDelete;


public class ParticipantsActivity extends ActionBarActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_participants);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String session = extras.getString("SESSION_ID");
        }

        Button bt = (Button) findViewById(R.id.buttonCalcula);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(getBaseContext(), ResultatActivity.class);
                intent.putExtra("SESSION_ID", "session");
                ModelData.getInstance().CalculaResultat();
                startActivity(intent);
            }
        });






    }

    @Override
    protected void onResume() {
        super.onResume();
       // Toast.makeText(getApplicationContext(), "start",Toast.LENGTH_LONG).show();
         updateLlistaParticipants();
    }

    public void updateOne(int m){

        final int n=m;

        LinearLayout ll = (LinearLayout) findViewById(R.id.participantsMainLayoutId);

        LayoutInflater inflater =
                (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.participants_layout, null);

        TextView t_alias = (TextView) v.findViewById(R.id.editTextNom);
        t_alias.setText(ModelData.getInstance().llistadeparticipants.get(n).getAlias());

        TextView t_money = (TextView) v.findViewById(R.id.editTextEuros);


        try {


            t_money.setText(ModelData.getInstance().llistadeparticipants.get(n).getMoney());

        }catch (NullPointerException e){
            t_money.setText("0");
        }






        t_alias.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                ModelData.getInstance().llistadeparticipants.get(n).setAlias(editable.toString());

            }
        });

        t_money.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                                             @Override
                                             public void onFocusChange(View v, boolean hasFocus) {
                                                 if (!hasFocus) {
                                                     // user is done editing
                                                     updateLlistaParticipants();

                                                 }
                                             }
                                         });

                t_money.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                        Float number;

                        try {
                            number = new Float(editable.toString());
                        } catch (NumberFormatException e) {
                            number = new Float("0");
                        }


                        ModelData.getInstance().llistadeparticipants.get(n).setMoney(number);

                    }
                });













        Button b = (Button) v.findViewById(buttonDelete);

        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     ModelData.getInstance().delParticipant(ModelData.getInstance().llistadeparticipants.get(n).getId());
                                     updateLlistaParticipants();
                                  }
                             }
        );
        ll.addView(v);


    }



    public void updateLlistaParticipants(){

        LinearLayout llsource = (LinearLayout) findViewById(R.id.participantsMainLayoutId);
        if(llsource!=null)llsource.removeAllViews();

        for (int n=0;n<ModelData.getInstance().llistadeparticipants.size();n++) {
            updateOne(n);
        }
    }

    public void addParticipantsLayout(){
        Participant p = new Participant("",new Float("0"));
        ModelData.getInstance().addParticipant(p);

        updateLlistaParticipants();
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
            addParticipantsLayout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

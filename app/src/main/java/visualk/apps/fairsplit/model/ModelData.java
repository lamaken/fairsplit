package visualk.apps.fairsplit.model;

import android.graphics.Bitmap;
import android.provider.Telephony;
import android.support.v7.internal.widget.LinearLayoutICS;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by lamaken on 13/09/14.
 */







public class ModelData {




   private static ModelData model=null;

   public static ModelData getInstance(){
       if(model==null){
           model=new ModelData("cadaques");
       }
       return model;
   }




    private String id;
    private String name;
    private Date date;
    public LinkedList<Participant> llistadeparticipants;


    public void CalculaResultat(){

        Float sumaTotal=new Float("0");
        for(int n=0;n< llistadeparticipants.size();n++){
            sumaTotal+=llistadeparticipants.get(n).getRealMoney();
        }

        Integer numParticipants=llistadeparticipants.size();

        Float resultat = new Float(sumaTotal/numParticipants);
        Float valor;

        for(int n=0;n< llistadeparticipants.size();n++){
            valor=new Float(new Float(llistadeparticipants.get(n).getRealMoney())-new Float(resultat));

            if(valor<0) {
                llistadeparticipants.get(n).setDeu(valor);
            }else{
                llistadeparticipants.get(n).setLiDeuen(new Float(valor));

            }
        }


    }

    public ModelData(String name) {
        this.id = new UniqueName(5).getName();
        this.date = new Date();
        this.name=name;
        this.llistadeparticipants=new LinkedList<Participant>();
    }
    public void addParticipant(Bitmap photo,String alias,Float money){
        Participant p = new Participant(/*photo,*/alias,money);
        llistadeparticipants.add(p);
    }
    public void addParticipant(Participant p){
        llistadeparticipants.add(p);
    }

    public void delParticipant(String id){
        for (int n=0;n<llistadeparticipants.size();n++){
            if(llistadeparticipants.get(n).getId()==id){
                llistadeparticipants.remove(n);
                n=llistadeparticipants.size()+1;//per que surti del bucle
            }
        }
    }

    @Override
    public String toString() {
        String ret="<"+name+">";

        for (int n=0;n<llistadeparticipants.size();n++){
            ret+=llistadeparticipants.get(n).toString();
        }
        return ret+"!";
    }


}


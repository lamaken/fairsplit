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
    private String id;
    private String name;
    private Date date;
    private LinkedList<Participant> llistadeparticipants;

    public ModelData(String name) {
        this.id = new UniqueName(5).getName();
        this.date = new Date();
        this.name=name;
        this.llistadeparticipants=new LinkedList<Participant>();
    }

    public void addParticipant(Bitmap photo,String alias,Integer money){
        Participant p = new Participant(photo,alias,money);
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
        return "id:"+id+" name:"+name+" date:"+date;
    }

    public class Participant{
        private String id="-1";
        private Bitmap photo=null;
        private String alias="anonymous";
        private Integer money=0;           //Centims

        public Participant(Bitmap photo,String alias,Integer money) {
            this.id=new UniqueName(5).getName();
            this.photo=photo;
            this.alias=alias;
            this.money=money;
        }
        public String getId(){
            return id;
        }


    }
}


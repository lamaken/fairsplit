package visualk.apps.fairsplit.model;

import android.graphics.Bitmap;

import java.text.NumberFormat;

/**
 * Created by lamaken on 14/09/14.
 */
public class Participant {
    private String id = "-1";
    // private Bitmap photo=null;
    private String alias = "anonymous";
    private Float money;           //Centims
    private Float deu;
    private Float liDeuen;

   public void setDeu(Float newDeu){
            if(deu==null){
                deu= new Float(newDeu);
            }
            else {
                deu=newDeu;
            }
        }

    public void setLiDeuen(Float newLiDeuen){
        if(deu==null){
            liDeuen= new Float(newLiDeuen);
        }
        else {
            liDeuen=newLiDeuen;
        }
    }




    public Participant(/*Bitmap photo,*/String alias, Float money) {
        this.id = new UniqueName(5).getName();
        //   this.photo=photo;
        this.alias = alias;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public Float getRealMoney(){
        if(money==null)money=new Float("0");
        Float resultat = new Float(money);
        return (resultat);
    }
    public String getMoney() {
        Float fmoney = new Float(money);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String output = formatter.format(fmoney);
        return output;
    }


    public String getDeu() {
        if (deu==null)deu=new Float(0);
        Float fmoney = new Float(deu);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String output = formatter.format(fmoney);
        return output;
    }

    public String getLiDeuen() {
        if(liDeuen==null)liDeuen=new Float(0);
        Float fmoney = new Float(liDeuen);
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String output = formatter.format(fmoney);
        return output;
    }

    public void setAlias(String newAlias) {
        alias = newAlias;
    }
    public void setMoney(Float newMoney){
        if(money==null){
            money= new Float(newMoney);
        }
        else {
            money=newMoney;
        }
    }
    @Override
    public String toString(){
        return ("[(" + getAlias() + ")," +getMoney() + "€]");
    }
}


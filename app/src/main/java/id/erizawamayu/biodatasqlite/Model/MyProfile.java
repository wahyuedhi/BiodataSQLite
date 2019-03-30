package id.erizawamayu.biodatasqlite.Model;

import android.text.Editable;

import com.orm.SugarRecord;

/**
 * Created by Ayu on 30/10/2017.
 */

public class MyProfile extends SugarRecord<MyProfile> {
    String namaProfil, nim, hobi, noHp;
    //String foto;

    public MyProfile(){

    }

    public MyProfile(String namaProfil, String nim, String hobi, String noHp) {
        this.namaProfil = namaProfil;
        this.nim = nim;
        this.hobi = hobi;
        this.noHp = noHp;
        //this.foto = foto;
    }

    public String getNamaProfil() {
        return namaProfil;
    }

    public void setNamaProfil(String namaProfil) {
        this.namaProfil = namaProfil;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    //public String getFoto() {
        //return foto;
   // }

    //public void setFoto(String foto) {
       // this.foto = foto;
    //}


}

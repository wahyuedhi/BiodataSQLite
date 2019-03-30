package id.erizawamayu.biodatasqlite;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import id.erizawamayu.biodatasqlite.Model.MyProfile;

public class TambahProfil extends AppCompatActivity {
    EditText tambahNama, tambahNim, tambahTelpn, tambahHobi, tambahUri;
    ImageView tambahImageProfil;

    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_profil);
        Button buttonSimpanProfil = (Button) findViewById(R.id.buttonSimpanProfil);
        Button buttonSelectImg = (Button) findViewById(R.id.buttonSelectImg);
        tambahImageProfil = (ImageView) findViewById(R.id.tambahImageProfil);
        tambahUri = (EditText) findViewById(R.id.tambahUri);
        tambahNama = (EditText) findViewById(R.id.tambahNama);
        tambahHobi = (EditText) findViewById(R.id.tambahUri);
        tambahNim = (EditText) findViewById(R.id.tambahNim);
        tambahTelpn = (EditText) findViewById(R.id.tambahTelpn);

        buttonSelectImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGaleri();
            }
        });

        buttonSimpanProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyProfile myProfile = new MyProfile(tambahNama.getText().toString(),tambahNim.getText().toString(), tambahTelpn.getText().toString(), tambahHobi.getText().toString() );
                myProfile.save();
                tambahNama.setText("");
                tambahTelpn.setText("");
                tambahNim.setText("");
                tambahHobi.setText("");

                Snackbar mySnackbar = Snackbar.make(findViewById(R.id.tambahProfilLayout),
                        "Data Profil berhasil di Simpan", Snackbar.LENGTH_SHORT);
                mySnackbar.show();
            }
        });


    }

    private void openGaleri(){
        Intent galeri = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galeri, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE)
        {
            imageUri = data.getData();
            tambahImageProfil.setImageURI(imageUri);

        }
        //tambahUri.setText((CharSequence) imageUri);
    }
}

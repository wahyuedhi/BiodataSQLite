package id.erizawamayu.biodatasqlite;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.erizawamayu.biodatasqlite.Adapter.ProfileAdapter;
import id.erizawamayu.biodatasqlite.Model.MyProfile;

public class MainActivity extends AppCompatActivity {

    private ProfileAdapter mProfileAdapter;
    private Button buttonTambahProfil;
    private List<MyProfile> mDaftarProfile = new ArrayList<>();
    TextView namaProfil, nimProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDaftarProfile = MyProfile.listAll(MyProfile.class);

        RecyclerView recyclerProfile = (RecyclerView) findViewById(R.id.recyeclerProfil);
        mProfileAdapter = new ProfileAdapter(getApplicationContext(), mDaftarProfile);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerProfile.setLayoutManager(mLayoutManager);
        recyclerProfile.setAdapter(mProfileAdapter);
        recyclerProfile.setItemAnimator(new DefaultItemAnimator());
        mProfileAdapter.notifyDataSetChanged();

        Intent i = getIntent();
        final Long idProfil = i.getLongExtra("profilId", 0L);
        final MyProfile detailProfil = MyProfile.findById(MyProfile.class, idProfil);

        namaProfil = (TextView) findViewById(R.id.namaProfil);
        namaProfil.setText(detailProfil.getNamaProfil());
        nimProfil = (TextView) findViewById(R.id.nimProfil);
        nimProfil.setText(detailProfil.getNim());

        Button buttonDeleteProfil = (Button) findViewById(R.id.buttonDeleteProfil);
        buttonDeleteProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailProfil.delete();
                Intent a = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(a);
            }
        });

        buttonTambahProfil = (Button) findViewById(R.id.buttonTambahProfil);
        buttonTambahProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TambahProfil.class);
                startActivity(i);
            }
        });
    }
}


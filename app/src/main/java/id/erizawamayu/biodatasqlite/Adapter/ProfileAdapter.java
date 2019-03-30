package id.erizawamayu.biodatasqlite.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.erizawamayu.biodatasqlite.Model.MyProfile;
import id.erizawamayu.biodatasqlite.R;

/**
 * Created by Ayu on 30/10/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    private Context context;
    private List<MyProfile> listProfile;

    public ProfileAdapter(Context context, List<MyProfile> listProfile) {
        this.context = context;
        this.listProfile = listProfile;
    }

    @Override
    public ProfileAdapter.ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profil,parent,false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.ProfileViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProfileViewHolder extends RecyclerView.ViewHolder {
        public ProfileViewHolder(View itemView) {
            super(itemView);
        }
    }
}

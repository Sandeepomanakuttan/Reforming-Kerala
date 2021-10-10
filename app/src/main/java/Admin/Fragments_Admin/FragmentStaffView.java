package Admin.Fragments_Admin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reformingkeralathroughdigitilization.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import Admin.RecycleAdaptor.Recycle_Staff_view_Adaptor;
import Admin.datacollectionClass.ProfileData;

public class FragmentStaffView extends Fragment {

    View view;
    RecyclerView recyclerView;
    Recycle_Staff_view_Adaptor adapter;
    String Status,authority,authority_Place;

    public FragmentStaffView(String authority, String authority_Place,String Status) {
        this.Status=Status;
        this.authority=authority;
        this.authority_Place=authority_Place;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_staff_view, container, false);
        recyclerView=view.findViewById(R.id.recycleStaffView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        if (Status.equals("officer")) {
            FirebaseRecyclerOptions<ProfileData> options =
                    new FirebaseRecyclerOptions.Builder<ProfileData>()
                            .setQuery(FirebaseDatabase.getInstance().getReference("LoginTable").orderByChild("user").equalTo("officer"), ProfileData.class)
                            .build();
            Log.e("test", options.toString());
            adapter = new Recycle_Staff_view_Adaptor(options);
            recyclerView.setAdapter(adapter);
            adapter.startListening();
        }
        return view;
    }
}
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

import Admin.PersonDataCollection;
import Admin.RecycleAdaptor.Recycle_User_view_Adaptor;

public class FragmentUserView extends Fragment {

    View view;
    RecyclerView recyclerView;
    Recycle_User_view_Adaptor adapter;
    public FragmentUserView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_user_view, container, false);
        recyclerView=view.findViewById(R.id.recycleUserView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        FirebaseRecyclerOptions<PersonDataCollection> options =
                new FirebaseRecyclerOptions.Builder<PersonDataCollection>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("User_Verification_Table"),PersonDataCollection.class)
                        .build();
        Log.e("test",options.toString());
        adapter=new Recycle_User_view_Adaptor(options);
        recyclerView.setAdapter(adapter);
        adapter.startListening();

        return view;
    }
}
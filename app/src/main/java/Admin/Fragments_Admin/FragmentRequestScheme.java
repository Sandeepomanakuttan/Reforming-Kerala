package Admin.Fragments_Admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reformingkeralathroughdigitilization.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Admin.RecycleAdaptor.RequestSchemeViewAdaptor;
import UserSection.Collectionclass.PersonSchemeCollection;


public class FragmentRequestScheme extends Fragment {
    View view;
    RecyclerView recyclerView;
    String id;
    String status,authority,authority_Place;
    ArrayList<PersonSchemeCollection> PersonSchemeCollection;
    RequestSchemeViewAdaptor viewAdaptor;

    public FragmentRequestScheme(String authority, String authority_Place) {
        this.authority=authority;
        this.authority_Place=authority_Place;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_request_scheme, container, false);

        recyclerView=view.findViewById(R.id.recycleRequestscheme);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        PersonSchemeCollection=new ArrayList<>();


        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Agree_Scheme_Table");
        Query query=reference2.orderByChild("authority").equalTo(authority);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                PersonSchemeCollection.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    PersonSchemeCollection collection = dataSnapshot.getValue(PersonSchemeCollection.class);
                    assert collection != null;
                   // if (collection.getAuthority_Place().equalsIgnoreCase("authority_Place")) {
                        if (collection.getStatus().equalsIgnoreCase("Request")){
                        PersonSchemeCollection.add(collection);

                    }else {
                        PersonSchemeCollection.clear();
                    }
                }
                viewAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
        viewAdaptor = new RequestSchemeViewAdaptor(getContext(), PersonSchemeCollection);
        recyclerView.setAdapter(viewAdaptor);

        return view;
    }
}
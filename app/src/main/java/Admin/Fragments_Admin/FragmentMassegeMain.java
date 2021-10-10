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
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

import Admin.RecycleAdaptor.MsgAdaptor;
import Admin.datacollectionClass.ProfileData;


public class FragmentMassegeMain extends Fragment {

    View view;
    RecyclerView recyclerView;
    String id;
    MsgAdaptor msgAdaptor;
    DatabaseReference reference;
    ArrayList<ProfileData> PersonArrayList;

    public FragmentMassegeMain() {

    }


    public FragmentMassegeMain(String id) {
                this.id=id;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_massege, container, false);


        PersonArrayList=new ArrayList<>();

        reference= FirebaseDatabase.getInstance().getReference("LoginTable");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                PersonArrayList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    ProfileData profileData=dataSnapshot.getValue(ProfileData.class);
                    String s=profileData.getId();
                    if (!Objects.equals(s, id)) {
                        PersonArrayList.add(profileData);
                    }

                }
                msgAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

        recyclerView=view.findViewById(R.id.recycleUsermsgView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        msgAdaptor=new MsgAdaptor(getContext(),PersonArrayList,id);
        recyclerView.setAdapter(msgAdaptor);






        return view;
    }
}
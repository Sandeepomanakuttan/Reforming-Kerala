package ViewAdaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reformingkeralathroughdigitilization.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import Admin.datacollectionClass.SchemedataCollection;
import UserSection.Collectionclass.PersonSchemeCollection;


public class SchemeViewAdaptor extends RecyclerView.Adapter<SchemeViewAdaptor.Viewholder> {

    Context context;
    ArrayList<SchemedataCollection> schemeArrayList;
    String id;
    int flag=0;

DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Agree_Scheme_Table");


    public SchemeViewAdaptor(Context context, ArrayList<SchemedataCollection> schemeArrayList, String id) {
        this.context = context;
        this.schemeArrayList = schemeArrayList;
        this.id = id;
    }

    public @NotNull Viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schemeview, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SchemeViewAdaptor.Viewholder holder, int position) {
        SchemedataCollection collection = schemeArrayList.get(position);
        String status=collection.getStrStatus();
//        if (status.equalsIgnoreCase("Accept")){
//            holder.txtschname.setText(collection.getStrschName());
//            holder.txtcategory.setText(collection.getStrcategory());
//            holder.txtType.setText(collection.getStrtype());
//            holder.txtBelow.setText(collection.getStrbelow());
//            holder.txtAbove.setText(collection.getStrabove());
//            holder.btnapply.setText("Remove");
//            holder.btnapply.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//        }else{
        holder.txtschname.setText(collection.getStrschName());
        holder.txtcategory.setText(collection.getStrcategory());
        holder.txtType.setText(collection.getStrtype());
        holder.txtBelow.setText(collection.getStrbelow());
        holder.txtAbove.setText(collection.getStrabove());
//        holder.btnapply.setOnClickListener(v -> {
//            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
//            PersonSchemeCollection personSchemeCollection = new PersonSchemeCollection();
//            personSchemeCollection.setPerson_id("1");
//            personSchemeCollection.setScheme_id(collection.getId());
//            personSchemeCollection.setScheme_Name(collection.getStrschName());
//            personSchemeCollection.setAmount(collection.getStramount());
//            personSchemeCollection.setStatus("Request");
//            personSchemeCollection.setAuthority_type(collection.getAuthority());
//            personSchemeCollection.setAuthority_Place(collection.getAuthority_Place());
//            Date date=new Date();
//            personSchemeCollection.setDate(date);
//            personSchemeCollection.setTimeStamp(date.getTime());
//            personSchemeCollection.setStatus(collection.getStrcategory());
//            checkdata(personSchemeCollection);
//        });
    }

    @Override
    public int getItemCount() {
        return schemeArrayList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder {

        TextView txtschname, txtcategory, txtType, txtBelow, txtAbove,txtAmount;
        Button btnapply;


        public Viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtschname = itemView.findViewById(R.id.txtschname);
            txtcategory = itemView.findViewById(R.id.txtcategory);
            txtType = itemView.findViewById(R.id.txtType);
            txtBelow = itemView.findViewById(R.id.txtBelow);
            txtAbove = itemView.findViewById(R.id.txtAbove);
            txtAmount = itemView.findViewById(R.id.txtAmount);


        }
    }

    private void InsertPersonalScheme(PersonSchemeCollection DataCollection) {
        String key = reference.push().getKey();
        DataCollection.setId(key);
        reference.child(DataCollection.getId()).setValue(DataCollection);
        Toast.makeText(context.getApplicationContext(), "succefully Inserted", Toast.LENGTH_SHORT).show();
    }

    public void checkdata(PersonSchemeCollection Data) {

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    PersonSchemeCollection data=childSnapshot.getValue(PersonSchemeCollection.class);
                    assert data != null;
                    if (data.getPerson_id().equals(Data.getPerson_id()) && data.getScheme_id().equals(Data.getScheme_id())) {
                            flag=1;
                        break;
                    }
                    else {
                        flag=0;
                    }
                }
            if (flag==1){
                Toast.makeText(context, "Already Applyed", Toast.LENGTH_SHORT).show();
            }else {
                InsertPersonalScheme(Data);
                flag=0;
                Toast.makeText(context, "Insert", Toast.LENGTH_SHORT).show();

            }}

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }


        });

    }
}
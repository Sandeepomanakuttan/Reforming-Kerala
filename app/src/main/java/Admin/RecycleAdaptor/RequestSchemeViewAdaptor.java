package Admin.RecycleAdaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reformingkeralathroughdigitilization.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import UserSection.Collectionclass.PersonSchemeCollection;

public class RequestSchemeViewAdaptor extends RecyclerView.Adapter<RequestSchemeViewAdaptor.Viewholder> {

    Context context;
    ArrayList<PersonSchemeCollection> PersonschemeArrayList;
    String id;
    int flag=0;

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Agree_Scheme_Table");

    public RequestSchemeViewAdaptor(Context context, ArrayList<PersonSchemeCollection> PersonschemeArrayList) {
        this.context = context;
        this.PersonschemeArrayList = PersonschemeArrayList;
        this.id = id;
    }

    public Viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userschemeview, parent, false);
        return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RequestSchemeViewAdaptor.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return PersonschemeArrayList.size();
    }

    static class Viewholder extends RecyclerView.ViewHolder {

        TextView txtschname, txtcategory, txtType, txtBelow, txtAbove;
        Button btnapply;


        public Viewholder(@NonNull @NotNull View itemView) {
            super(itemView);
            txtschname = itemView.findViewById(R.id.txtschname);
            txtcategory = itemView.findViewById(R.id.txtcategory);
            txtType = itemView.findViewById(R.id.txtType);
            txtBelow = itemView.findViewById(R.id.txtBelow);
            txtAbove = itemView.findViewById(R.id.txtAbove);
            btnapply = itemView.findViewById(R.id.btnaprove);


        }

    }}






package Admin.RecycleAdaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reformingkeralathroughdigitilization.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import Admin.FragmentApproveCertificate;
import Admin.PersonDataCollection;
import de.hdodenhof.circleimageview.CircleImageView;


public class Recycle_User_view_Adaptor extends FirebaseRecyclerAdapter<PersonDataCollection,Recycle_User_view_Adaptor.myviewholder> {

    public Recycle_User_view_Adaptor(@NonNull FirebaseRecyclerOptions<PersonDataCollection> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull PersonDataCollection model) {
        holder.txtname.setText(model.getHouse_OwnerName());
        holder.txtWard.setText(model.getWardNo());
        holder.txtHouseNo.setText(model.getHouseNo());
        holder.txtType.setText(model.getUserType());
//        Picasso.get().load(model.getImageUri()).into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new FragmentApproveCertificate();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, myFragment).addToBackStack(null).commit();
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        CircleImageView pic;
        ImageView cancel;
        TextView txtname,txtWard,txtHouseNo,txtType;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.txtname);
            txtWard=itemView.findViewById(R.id.txtWard);
            txtHouseNo=itemView.findViewById(R.id.txtHouseNo);
            pic=itemView.findViewById(R.id.pic);
            txtType=itemView.findViewById(R.id.txtType);
            cancel=itemView.findViewById(R.id.cancel);
        }
    }
}


package Admin.Fragments_Admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.reformingkeralathroughdigitilization.R;

public class FragmentRequestCertificate extends Fragment {

    public FragmentRequestCertificate(String authority, String authority_Place) {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_request_certificate, container, false);
    }
}
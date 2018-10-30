package cs.dal.easymeeting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PreviousManagerFragment extends Fragment {
    public PreviousManagerFragment() {
        // Required empty public constructor
    }

    public static PreviousManagerFragment newInstance() {
        PreviousManagerFragment fragment = new PreviousManagerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_manager, container, false);
    }
}

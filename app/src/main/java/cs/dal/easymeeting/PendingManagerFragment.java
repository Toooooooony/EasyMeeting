package cs.dal.easymeeting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PendingManagerFragment extends Fragment {
    public PendingManagerFragment() {
        // Required empty public constructor
    }

    public static PendingManagerFragment newInstance() {
        PendingManagerFragment fragment = new PendingManagerFragment();
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
        return inflater.inflate(R.layout.fragment_pending_manager, container, false);
    }
}

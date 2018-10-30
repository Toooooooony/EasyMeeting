package cs.dal.easymeeting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PendingNormalFragment extends Fragment {

    private ArrayList<MeetingInfoItem> MeetingInfoItemList;
    private MeetingInfoItemAdapter adapter;
    private Runnable runnable;

    public PendingNormalFragment() {
        // Required empty public constructor
    }

    public static PendingNormalFragment newInstance() {
        PendingNormalFragment fragment = new PendingNormalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_normal, container, false);
        ListView lvPendingNormal = view.findViewById(R.id.lvPendingNormal);
        MeetingInfoItemList = new ArrayList<>();
        adapter = new MeetingInfoItemAdapter(getActivity().getApplicationContext(), R.layout.listview_item_meeting_info, 0, MeetingInfoItemList);
        lvPendingNormal.setAdapter(adapter);
        runnable = new Runnable() {
            @Override
            public void run() {
                getMeetingInfo();
            }
        };
        Thread thread = new Thread(null,runnable,"background");
        thread.start();
        return view;
    }

    public void getMeetingInfo(){
        final String url = "http://data.fixer.io/api/latest?access_key=f0b83c805df3e3e4e232b6623b5e598e";
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            response = response.getJSONObject("rates");
                            MeetingInfoItemList.clear();
                            for (int i=0; i<response.names().length()/10; i++){
                                String name = response.names().getString(i);
                                MeetingInfoItemList.add(new MeetingInfoItem("weekday","date","state",name,"time","location"));
                            }

                            adapter.notifyDataSetChanged();
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );
        RequestQueueSingleton.getmInstance(getActivity().getApplicationContext()).addToRequestQueue(request);
    }

}

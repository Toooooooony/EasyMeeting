package cs.dal.easymeeting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MeetingInfoItemAdapter extends ArrayAdapter<MeetingInfoItem> {

    private ArrayList<MeetingInfoItem> meetingInfoItemList;

    private int[] listItemBackground = new int[] {
            R.drawable.list_background_w, R.drawable.list_background_g };

    public MeetingInfoItemAdapter(@NonNull Context context, int resource, int textViewResourceId,
                                  ArrayList<MeetingInfoItem> meetingInfoItemList) {
        super(context, resource, textViewResourceId, meetingInfoItemList);
        this.meetingInfoItemList = meetingInfoItemList;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;
        int listItemBackgroundPosition = position % listItemBackground.length;


        if (v == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listview_item_meeting_info,null);
        }

        MeetingInfoItem i = meetingInfoItemList.get(position);

        if (v != null){
            TextView tvWeekday = v.findViewById(R.id.weekday);
            TextView tvDate = v.findViewById(R.id.date);
            TextView tvState = v.findViewById(R.id.state);
            TextView tvName = v.findViewById(R.id.name);
            TextView tvTime = v.findViewById(R.id.time);
            TextView tvLocation = v.findViewById(R.id.location);

            tvWeekday.setText("Thurs");
            tvDate.setText("17 Jun");
            tvState.setText("On-Time");
            tvName.setText(i.getName());
            tvTime.setText("11:00AM - 12:00PM");
            tvLocation.setText("David's home");

            v.setBackgroundResource(listItemBackground[listItemBackgroundPosition]);
        }

        return v;
    }
}

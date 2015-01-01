package netpool.lab.barracks.netpool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Bala on 30/12/2014.
 */
public class SessionListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Date> sessionHeaders;
    private HashMap<Date,ArrayList<Sessions>> sessionData;

    public SessionListAdapter(Context context, ArrayList<Date> sessionHeaders, HashMap<Date, ArrayList<Sessions>> sessionData) {
        this.context = context;
        this.sessionHeaders = sessionHeaders;
        this.sessionData = sessionData;
    }

    @Override
    public int getGroupCount() {
        return this.sessionHeaders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.sessionData.get(this.sessionHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.sessionHeaders.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.sessionData.get(this.sessionHeaders.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater lf = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.session_list_header,null);
        }

        TextView header = (TextView) convertView.findViewById(R.id.sessionHeader);
        header.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final Sessions sessionData = (Sessions) getChild(groupPosition,childPosition);

        if (convertView == null){
            LayoutInflater lf = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = lf.inflate(R.layout.session_list_item,null);
        }

        TextView teamName = (TextView) convertView.findViewById(R.id.teamName);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        TextView time = (TextView) convertView.findViewById(R.id.netsTime);
        TextView slots = (TextView) convertView.findViewById(R.id.slots);
        TextView bookedSlots = (TextView) convertView.findViewById(R.id.players);
        TextView openSlots = (TextView) convertView.findViewById(R.id.openSlots);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

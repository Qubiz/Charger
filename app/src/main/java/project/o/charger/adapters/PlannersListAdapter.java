package project.o.charger.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import project.o.charger.R;
import project.o.charger.planners.Planner;

public class PlannersListAdapter extends BaseAdapter {

    private Context context;
    private List<Planner> planners;

    public PlannersListAdapter(Context context, List<Planner> planners) {
        this.context = context;
        this.planners = planners;
    }

    @Override
    public int getCount() {
        return planners.size();
    }

    @Override
    public Object getItem(int position) {
        return planners.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.planners_list_item, parent, false);

        TextView name = (TextView) view.findViewById(R.id.planner_list_row_name);
        TextView creator = (TextView) view.findViewById(R.id.planner_list_row_creator);

        final Planner planner = planners.get(position);

        name.setText(planner.getName());
        creator.setText("created by " + planner.getCreator());

        return view;
    }
}

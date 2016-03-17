package project.o.charger.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import project.o.charger.database.PlannersSQLiteHelper;
import project.o.charger.planners.Planner;

/**
 * Created by Mathijs on 17-3-2016.
 */
public class PlannersListAdapter extends BaseAdapter {

    private Context context;
    private List<Planner> planners;
    private PlannersSQLiteHelper database;


    public PlannersListAdapter(Context context, List<Planner> planners) {
        this.context = context;
        this.planners = planners;
        this.database = new PlannersSQLiteHelper(context);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

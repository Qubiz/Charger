package project.o.charger;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import project.o.charger.adapters.PlannersListAdapter;
import project.o.charger.planners.Planner;

public class MainActivity extends AppCompatActivity {

    List<Planner> planners;

    ListView plannersListView;
    PlannersListAdapter plannersListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        planners = new ArrayList<>();

        plannersListAdapter = new PlannersListAdapter(this, planners);
        plannersListView = (ListView) findViewById(R.id.planners_list_view);
        if (plannersListView != null) {
            plannersListView.setAdapter(plannersListAdapter);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addNewPlanner();
                }
            });
        }
    }

    private void addNewPlanner() {
        final View newPlannerDialogView = getLayoutInflater().inflate(R.layout.dialog_fragment_new_planner, null);
        final EditText plannerName = (EditText) newPlannerDialogView.findViewById(R.id.dialog_fragment_new_planner_edit_text_name);
        final EditText plannerCreator = (EditText) newPlannerDialogView.findViewById(R.id.dialog_fragment_new_planner_edit_text_creator);

        AlertDialog newPlannerDialog = new AlertDialog.Builder(this)
                .setView(newPlannerDialogView)
                .setPositiveButton("CREATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Planner newPlanner;
                        if(plannerName.getText().toString().isEmpty() && plannerCreator.getText().toString().isEmpty()) {
                            newPlanner = new Planner("Planner" + (planners.size() + 1), "Anoniem");
                        } else if(plannerName.getText().toString().isEmpty()) {
                            newPlanner = new Planner("Planner" + (planners.size() + 1), plannerCreator.getText().toString());
                        } else if(plannerCreator.getText().toString().isEmpty()){
                            newPlanner = new Planner(plannerName.getText().toString(), "Anoniem");
                        } else {
                            newPlanner = new Planner(plannerName.getText().toString(), plannerCreator.getText().toString());
                        }
                        planners.add(newPlanner);
                        plannersListAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("CANCEL", null)
                .create();

        newPlannerDialog.show();
    }

}

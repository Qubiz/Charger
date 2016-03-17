package project.o.charger.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;

import project.o.charger.planners.Planner;

/**
 * Created by Mathijs on 17-3-2016.
 */
public class PlannersSQLiteHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "PlannersDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PLANNERS = "planners";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CREATOR = "creator";

    private static final String[] COLUMNS = {KEY_ID, KEY_NAME, KEY_CREATOR};

    public PlannersSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase database) {
        String CREATE_PLANNERS_TABLE = "CREATE TABLE presets ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, "+
                "creator INTEGER )";

        database.execSQL(CREATE_PLANNERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(db);
    }

    public void addPlanner(Planner planner) {
        Log.d("addPlanner", planner.toString());

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, planner.getName());
        values.put(KEY_CREATOR, planner.getCreator());

        database.insert(TABLE_PLANNERS, null, values);

        database.close();
    }

    public Planner getPlanner(int id) {
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE_PLANNERS,
                COLUMNS,
                " id = ?",
                null,
                null,
                null,
                null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Planner planner = new Planner("", "");
        planner.setId(Integer.parseInt(cursor.getString(0)));
        planner.setName(cursor.getString(1));
        planner.setCreator(cursor.getString(2));

        cursor.close();

        Log.d("getPlanner(" + id + ")", planner.toString());

        return planner;
    }
}

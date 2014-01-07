package com.smartschedule.database;

import java.util.ArrayList;

import com.smartschedule.util.Constant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.sax.StartElementListener;
import android.util.Log;

public class SmartSchedulerDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SMART_SCHEDULER";
    public static final String TABLE_EVENT = "EVENT";
    public static final String COLUMN_EVENT_ID = "_id";
    public static final String COLUMN_EVENT_NAME = "name";
    public static final String COLUMN_EVENT_IMAGE = "image";
    public static final String COLUMN_EVENT_TIME_START_HOUR = "time_start_hour";
    public static final String COLUMN_EVENT_TIME_START_MINUTE = "time_start_minute";
    public static final String COLUMN_EVENT_TIME_END_HOUR = "time_end_hour";
    public static final String COLUMN_EVENT_TIME_END_MINUTE = "time_end_minute";
    public static final String COLUMN_EVENT_SCHEDULE = "schedule";
    public static final String COLUMN_EVENT_CATEGORY = "category";
    public static final String COLUMN_EVENT_STATE = "state";

    public static final String TABLE_SCHEDULE = "SCHEDULE";
    public static final String COLUMN_SCHEDULE_ID = "_id";
    public static final String COLUMN_SCHEDULE_EVENT_ID = "event_id";
    public static final String COLUMN_SCHEDULE_MON = "mon";
    public static final String COLUMN_SCHEDULE_TUE = "tue";
    public static final String COLUMN_SCHEDULE_WED = "wed";
    public static final String COLUMN_SCHEDULE_THU = "thu";
    public static final String COLUMN_SCHEDULE_FRI = "fri";
    public static final String COLUMN_SCHEDULE_SAT = "sat";
    public static final String COLUMN_SCHEDULE_SUN = "sun";

    public static final String TABLE_ACTION = "ACTION";
    public static final String COLUMN_ACTION_ID = "_id";
    public static final String COLUMN_ACTION_START_ID = "action_start_id";
    public static final String COLUMN_ACTION_END_ID = "action_end_id";
    public static final String COLUMN_ACTION_STATE = "state";
    public static final String COLUMN_ACTION_NAME = "name";
    public static final String COLUMN_ACTION_DRAW = "draw_action";

    private static Context context;
    private SQLiteDatabase db;
    private OpenHelper openHelper;

    public SmartSchedulerDatabase(Context c) {
        SmartSchedulerDatabase.context = c;
    }

    public SmartSchedulerDatabase open() throws SQLException {
        openHelper = new OpenHelper(context);
        db = openHelper.getWritableDatabase();
        return this;
    }

    public SmartSchedulerDatabase openRead() throws SQLException {
        openHelper = new OpenHelper(context);
        db = openHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        openHelper.close();
    }

    public long createData(String name, String image, int category, int state) {
        ContentValues event = new ContentValues();
        event.put(COLUMN_EVENT_NAME, name);
        event.put(COLUMN_EVENT_IMAGE, image);
        event.put(COLUMN_EVENT_CATEGORY, category);
        event.put(COLUMN_EVENT_STATE, state);

        // Cursor mCount = db
        // .rawQuery("select max("+ COLUMN_EVENT_ID + ") from " + TABLE_EVENT,
        // null);
        // mCount.moveToFirst();
        // int count = mCount.getInt(0);
        // mCount.close();

        long event_id = 0;
        try {
            event_id = db.insert(TABLE_EVENT, null, event);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }

        ContentValues update = new ContentValues();
        update.put(COLUMN_EVENT_SCHEDULE, event_id);

        update_event(update, event_id);

        ContentValues schedule = new ContentValues();
        schedule.put(COLUMN_SCHEDULE_EVENT_ID, event_id);

        long schedule_id = 0;
        try {
            schedule_id = db.insert(TABLE_SCHEDULE, null, schedule);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }

        // ContentValues action1 = new ContentValues();
        // action1.put(COLUMN_ACTION_START_ID, event_id);
        //
        // long action_id1 = 0;
        // try {
        // action_id1 = db.insert(TABLE_ACTION, null, action1);
        // } catch (Exception e) {
        // Log.e(this.toString(), e.getMessage());
        // }
        //
        // ContentValues action2 = new ContentValues();
        // action2.put(COLUMN_ACTION_END_ID, event_id);
        //
        // long action_id2 = 0;
        // try {
        // action_id2 = db.insert(TABLE_ACTION, null, action2);
        // } catch (Exception e) {
        // Log.e(this.toString(), e.getMessage());
        // }

        return event_id;

    }

    public String getAllData() {
        String[] columns = new String[] { COLUMN_EVENT_ID, COLUMN_EVENT_NAME,
                COLUMN_EVENT_IMAGE, COLUMN_EVENT_TIME_START_HOUR,
                COLUMN_EVENT_TIME_START_MINUTE, COLUMN_EVENT_TIME_END_HOUR,
                COLUMN_EVENT_TIME_END_MINUTE, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_STATE };
        Cursor c = db.query(TABLE_EVENT, columns, null, null, null, null, null);

        String result = "";

        int iId = c.getColumnIndex(COLUMN_EVENT_ID);
        int iName = c.getColumnIndex(COLUMN_EVENT_NAME);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result = result + " - _id:" + c.getString(iId) + " - name:"
                    + c.getString(iName) + "\n";
        }
        // String[] total = new String[]{"count: " + count, " value:" + result};
        return result;
    }

    public ArrayList<Event> getData() {

        String[] columns = new String[] { COLUMN_EVENT_ID, COLUMN_EVENT_NAME,
                COLUMN_EVENT_IMAGE, COLUMN_EVENT_TIME_START_HOUR,
                COLUMN_EVENT_TIME_START_MINUTE, COLUMN_EVENT_TIME_END_HOUR,
                COLUMN_EVENT_TIME_END_MINUTE, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_STATE };
        Cursor c = null;

        try {
            c = db.query(TABLE_EVENT, columns, null, null, null, null,
                    COLUMN_EVENT_ID + " DESC");
        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        ArrayList<Event> result = new ArrayList<Event>();

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Event event = new Event();
            event.setId(c.getInt(c.getColumnIndex(COLUMN_EVENT_ID)));
            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_START_HOUR))) {
                event.setTimeStartHour(null);
            } else {
                event.setTimeStartHour(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_START_HOUR)));
            }

            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_START_MINUTE))) {
                event.setTimeStartMinute(null);
            } else {
                event.setTimeStartMinute(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_START_MINUTE)));
            }

            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_END_HOUR))) {
                event.setTimeEndHour(null);
            } else {
                event.setTimeEndHour(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_END_HOUR)));
            }

            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_END_MINUTE))) {
                event.setTimeEndMinute(null);
            } else {
                event.setTimeEndMinute(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_END_MINUTE)));
            }
            event.setSchedule(c.getInt(c.getColumnIndex(COLUMN_EVENT_SCHEDULE)));
            event.setCategory(c.getInt(c.getColumnIndex(COLUMN_EVENT_ID)));
            event.setState(c.getInt(c.getColumnIndex(COLUMN_EVENT_STATE)));
            event.setImage(c.getString(c.getColumnIndex(COLUMN_EVENT_IMAGE)));
            event.setName(c.getString(c.getColumnIndex(COLUMN_EVENT_NAME)));
            result.add(event);
        }
        return result;
    }

    public Event getData(int id) {
        String[] columns = new String[] { COLUMN_EVENT_ID, COLUMN_EVENT_NAME,
                COLUMN_EVENT_IMAGE, COLUMN_EVENT_TIME_START_HOUR,
                COLUMN_EVENT_TIME_START_MINUTE, COLUMN_EVENT_TIME_END_HOUR,
                COLUMN_EVENT_TIME_END_MINUTE, COLUMN_EVENT_SCHEDULE,
                COLUMN_EVENT_CATEGORY, COLUMN_EVENT_STATE };
        Cursor c = null;

        try {
            c = db.query(TABLE_EVENT, columns, COLUMN_EVENT_ID + "=" + id,
                    null, null, null, COLUMN_EVENT_ID + " DESC");
        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        Event event = new Event();

        if (c.getCount() == 1) {
            c.moveToFirst();
            event.setId(c.getInt(c.getColumnIndex(COLUMN_EVENT_ID)));
            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_START_HOUR))) {
                event.setTimeStartHour(null);
            } else {
                event.setTimeStartHour(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_START_HOUR)));
            }

            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_START_MINUTE))) {
                event.setTimeStartMinute(null);
            } else {
                event.setTimeStartMinute(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_START_MINUTE)));
            }

            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_END_HOUR))) {
                event.setTimeEndHour(null);
            } else {
                event.setTimeEndHour(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_END_HOUR)));
            }

            if (c.isNull(c.getColumnIndex(COLUMN_EVENT_TIME_END_MINUTE))) {
                event.setTimeEndMinute(null);
            } else {
                event.setTimeEndMinute(c.getInt(c
                        .getColumnIndex(COLUMN_EVENT_TIME_END_MINUTE)));
            }
            event.setSchedule(c.getInt(c.getColumnIndex(COLUMN_EVENT_SCHEDULE)));
            event.setCategory(c.getInt(c.getColumnIndex(COLUMN_EVENT_ID)));
            event.setState(c.getInt(c.getColumnIndex(COLUMN_EVENT_STATE)));
            event.setImage(c.getString(c.getColumnIndex(COLUMN_EVENT_IMAGE)));
            event.setName(c.getString(c.getColumnIndex(COLUMN_EVENT_NAME)));
        } else {
            Log.e(SmartSchedulerDatabase.this.toString(),
                    "error when getdata follow id can not get event or more 2 event");
            throw new Error(
                    "error when getdata follow id can not get event or more 2 event");
        }

        return event;
    }

    public ArrayList<Action> getDataAction(int id, String key) {

        // get action
        String[] columnsAction = new String[] { COLUMN_ACTION_ID,
                COLUMN_ACTION_START_ID, COLUMN_ACTION_END_ID,
                COLUMN_ACTION_DRAW, COLUMN_ACTION_STATE, COLUMN_ACTION_NAME };

        ArrayList<Action> result = new ArrayList<Action>();

        if (key == Constant.ACTION_START_ID_KEY) {
            // get start action
            Cursor cActionStart = null;
            try {
                cActionStart = db.query(TABLE_ACTION, columnsAction,
                        COLUMN_ACTION_START_ID + "=" + id, null, null, null,
                        null);
            } catch (Exception e) {
                Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
            }

            for (cActionStart.moveToFirst(); !cActionStart.isAfterLast(); cActionStart
                    .moveToNext()) {
                Action action = new Action();

                action.setId(cActionStart.getInt(cActionStart
                        .getColumnIndex(COLUMN_ACTION_ID)));
                action.setActionStartId(cActionStart.getInt(cActionStart
                        .getColumnIndex(COLUMN_ACTION_START_ID)));
                action.setActionEndId(cActionStart.getInt(cActionStart
                        .getColumnIndex(COLUMN_ACTION_END_ID)));
                action.setState(cActionStart.getInt(cActionStart
                        .getColumnIndex(COLUMN_ACTION_STATE)));
                action.setName(cActionStart.getString(cActionStart
                        .getColumnIndex(COLUMN_ACTION_NAME)));
                action.setDrawAction(cActionStart.getString(cActionStart
                        .getColumnIndex(COLUMN_ACTION_DRAW)));
                result.add(action);
            }
        } else if (key == Constant.ACTION_END_ID_KEY) {
            // get end action
            Cursor cActionEnd = null;

            try {
                cActionEnd = db
                        .query(TABLE_ACTION, columnsAction,
                                COLUMN_ACTION_END_ID + "=" + id, null, null,
                                null, null);
            } catch (Exception e) {
                Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
            }

            for (cActionEnd.moveToFirst(); !cActionEnd.isAfterLast(); cActionEnd
                    .moveToNext()) {
                Action action = new Action();

                action.setId(cActionEnd.getInt(cActionEnd
                        .getColumnIndex(COLUMN_ACTION_ID)));
                action.setActionStartId(cActionEnd.getInt(cActionEnd
                        .getColumnIndex(COLUMN_ACTION_START_ID)));
                action.setActionEndId(cActionEnd.getInt(cActionEnd
                        .getColumnIndex(COLUMN_ACTION_END_ID)));
                action.setState(cActionEnd.getInt(cActionEnd
                        .getColumnIndex(COLUMN_ACTION_STATE)));
                action.setName(cActionEnd.getString(cActionEnd
                        .getColumnIndex(COLUMN_ACTION_NAME)));
                action.setDrawAction(cActionEnd.getString(cActionEnd
                        .getColumnIndex(COLUMN_ACTION_DRAW)));
                // DatabaseUtils.cursorRowToContentValues(cActionEnd, cv);

                result.add(action);
            }
        }

        return result;
    }

    public int update_event(ContentValues contentValues, long event_id) {
        return db.update(TABLE_EVENT, contentValues, COLUMN_EVENT_ID + "="
                + event_id, null);
    }

    public int update_action(ContentValues contentValues, long id) {
        Log.v(this.toString(), contentValues.getAsString(COLUMN_ACTION_DRAW));
        int result = 0;
        try {
            result = db.update(TABLE_ACTION, contentValues, COLUMN_ACTION_ID
                    + "=" + id, null);

        } catch (Exception e) {
            Log.e(SmartSchedulerDatabase.this.toString(), e.getMessage());
        }

        if (result != 1) {
            throw new Error("error update action row in database");
        }
        return result;
    }

    public long insert_action(ContentValues contentValues) {
        // TODO nen kiem tra dieu kien truoc khi insert
        try {
            return db.insert(TABLE_ACTION, null, contentValues);
        } catch (Exception e) {
            Log.e(this.toString(), e.getMessage());
        }
        return 0;
    }

    public int delete(int id) {
        return db.delete(TABLE_EVENT, COLUMN_EVENT_ID + "=" + id, null);
    }

    // ---------------- class OpenHelper ------------------
    private static class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase arg0) {
            arg0.execSQL("CREATE TABLE " + TABLE_EVENT + " (" + COLUMN_EVENT_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_EVENT_NAME + " TEXT, " + COLUMN_EVENT_IMAGE
                    + " TEXT, " + COLUMN_EVENT_TIME_START_HOUR
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_TIME_START_MINUTE
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_TIME_END_HOUR
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_TIME_END_MINUTE
                    + " INT DEFAULT NULL, " + COLUMN_EVENT_SCHEDULE
                    + " INT DEFAULT NULL UNIQUE, " + COLUMN_EVENT_CATEGORY
                    + " INT DEFAULT NULL UNIQUE, " + COLUMN_EVENT_STATE
                    + " INT NOT NULL" + ");");
            arg0.execSQL("CREATE TABLE " + TABLE_SCHEDULE + " ("
                    + COLUMN_SCHEDULE_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_SCHEDULE_EVENT_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_SCHEDULE_MON + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_TUE + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_WED + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_THU + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_FRI + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_SAT + " BOOLEAN DEFAULT FALSE, "
                    + COLUMN_SCHEDULE_SUN + " BOOLEAN DEFAULT FALSE " + ");");
            arg0.execSQL("CREATE TABLE " + TABLE_ACTION + " ("
                    + COLUMN_ACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_ACTION_START_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_END_ID + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_STATE + " INTEGER DEFAULT NULL, "
                    + COLUMN_ACTION_DRAW + " TEXT DEFAULT NULL, "
                    + COLUMN_ACTION_NAME + " TEXT " + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
            arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTION);
            onCreate(arg0);
        }
    }

}

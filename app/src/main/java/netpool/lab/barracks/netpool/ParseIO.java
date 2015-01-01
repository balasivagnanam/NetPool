package netpool.lab.barracks.netpool;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bala on 1/1/2015.
 */
public class ParseIO {

    public ParseIO() {

    }

    public void sessionInsert(){

    }

    public ArrayList<Sessions> sessionFetch(Date headers){
        ParseQuery<Sessions> query = ParseQuery.getQuery(Sessions.class);
        query.whereEqualTo("NetsDate",headers);
        final ArrayList<Sessions> sessionsData = new ArrayList<Sessions>();
        query.findInBackground(new FindCallback<Sessions>() {
            @Override
            public void done(List<Sessions> sessionsObjects, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("test", "Retrieved " + sessionsObjects.size() + " sessions");
                    for (Sessions session : sessionsObjects) {
                        sessionsData.add(session);
                    }
                } else {
                    Log.d("test", "Error: " + e.getMessage());
                }
            }
        });
        return sessionsData;
        //return null;
    }

    public ArrayList<Date> sessionHeaderFetch(){

        Log.d("test", "session fetch entry");
        ParseQuery<Sessions> query = ParseQuery.getQuery(Sessions.class);
        final ArrayList<Date> sessionHeaders = new ArrayList<Date>();
        query.findInBackground(new FindCallback<Sessions>() {
            @Override
            public void done(List<Sessions> sessionsObjects, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("test", "Retrieved -- hello" + sessionsObjects.size() + " sessions");
                    for (Sessions session : sessionsObjects) {
                        sessionHeaders.add(session.getNetsDate());
                    }
                    Log.d("test", "Parse fetched headers" + sessionHeaders.size());
               } else {
                    Log.d("test", "Error: " + e.getMessage());
                }
            }
        });
        Log.d("test", "session last value");
        Log.d("test", "Parse fetched headers last" + sessionHeaders.size());
        return sessionHeaders;
        //return null;
    }
}

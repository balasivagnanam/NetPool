package netpool.lab.barracks.netpool;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Bala on 1/1/2015.
 */
public class ParseIO {

    public ParseIO() {
        ParseObject.registerSubclass(Sessions.class);
    }

    public void sessionInsert(){

    }

    public List<Sessions> sessionFetch(Date headers){
        ParseQuery<Sessions> query = ParseQuery.getQuery(Sessions.class);
        query.whereEqualTo("NetsDate",headers);
        final List<Sessions> sessionsData = null;
        query.findInBackground(new FindCallback<Sessions>() {
            @Override
            public void done(List<Sessions> sessionsObjects, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + sessionsObjects.size() + " sessions");
                    for (Sessions session : sessionsObjects) {
                        sessionsData.add(session);
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        return sessionsData;
    }

    public List<Date> sessionHeaderFetch(){
        Log.d("test", "session fetch entry");
        ParseQuery<Sessions> query = ParseQuery.getQuery(Sessions.class);
        final List<Date> sessionHeaders = null;
        query.findInBackground(new FindCallback<Sessions>() {
            @Override
            public void done(List<Sessions> sessionsObjects, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("test", "Retrieved " + sessionsObjects.size() + " sessions");
                    for (Sessions session : sessionsObjects) {
                        sessionHeaders.add(session.getNetsDate());
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
        Log.d("test", "session last value");
        return sessionHeaders;
    }
}

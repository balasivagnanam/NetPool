package netpool.lab.barracks.netpool;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bala on 29/12/2014.
 */
public class DataHelper {

    ParseIO parseFetcher = new ParseIO();

    public ArrayList<Date> getAllDateHeaders(){
        ArrayList<Date> allHeaders = parseFetcher.sessionHeaderFetch();
        Log.d("test", "DH header list size" + allHeaders.size());
        Set<Date> uniqueHeaders = new HashSet<Date>(allHeaders);
        ArrayList<Date> uniqueList = new ArrayList<Date>();
        Log.d("test", "Retrieved " + " sessions in DH");
        Log.d("test", "DH header set size" + uniqueHeaders.size());
        for (Date headers: uniqueHeaders) {
            uniqueList.add(headers);
        }
   //     return uniqueList;
        Log.d("test", "DH header size" + uniqueList.size());

        return uniqueList;
        //return null;

    }

    public HashMap<Date,ArrayList<Sessions>> getAllListDate(){
        ArrayList<Date> headerList =  getAllDateHeaders();
        ArrayList<Sessions> sessionsList = new ArrayList<Sessions>();
        HashMap<Date,ArrayList<Sessions>> sessionDataWithHeader = new HashMap<Date,ArrayList<Sessions>>();
        for (Date headers : headerList){
            sessionsList = parseFetcher.sessionFetch(headers);
            sessionDataWithHeader.put(headers,sessionsList);
        }
        Log.d("test", "DH content size" + sessionDataWithHeader.size());
        return sessionDataWithHeader;
    }

}

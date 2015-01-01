package netpool.lab.barracks.netpool;

import android.util.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bala on 29/12/2014.
 */
public class DataHelper {

    ParseIO parseFetcher = new ParseIO();

    public List<Date> getAllDateHeaders(){
        List<Date> allHeaders = parseFetcher.sessionHeaderFetch();
        Set<Date> uniqueHeaders = new HashSet<Date>(allHeaders);
        List<Date> uniqueList = null;
        Log.d("test", "Retrieved " + " sessions" + uniqueHeaders.toString());
        for (Date headers: uniqueHeaders) {
            uniqueList.add(headers);
        }
        return uniqueList;
    }

    public HashMap<Date,List<Sessions>> getAllListDate(){
        List<Date> headerList =  getAllDateHeaders();
        List<Sessions> sessionsList = null;
        HashMap<Date,List<Sessions>> sessionDataWithHeader = null;
        for (Date headers : headerList){
            sessionsList = parseFetcher.sessionFetch(headers);
            sessionDataWithHeader.put(headers,sessionsList);
        }
        return sessionDataWithHeader;
    }

}

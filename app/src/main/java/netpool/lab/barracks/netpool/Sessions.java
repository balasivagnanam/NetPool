package netpool.lab.barracks.netpool;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Bala on 30/12/2014.
 */

@ParseClassName("Sessions")
public class Sessions extends ParseObject {
    public Sessions(){

    }

    public String sessionId;
    public String location;
    public String netNo;
    public String userId;
    public int slots;
    public int openSlots;
    public Date netsDate;

    public String getSessionId() {
        return getString("SessionId");
    }

    public void setSessionId(String sessionId) {
        put("SessionId", sessionId);
    }

    public String getLocation() {
        return getString("Location");
    }

    public void setLocation(String location) {
        put("Location", location);
    }

    public String getNetNo() {
        return getString("NetNo");
    }

    public void setNetNo(String netNo) {
        put("NetNo", netNo);
    }

    public String getUserId() {
        return getString("UserId");
    }

    public void setUserId(String userId) {
        put("UserId", userId);
    }

    public int getSlots() {
        return getInt("Slots");
    }

    public void setSlots(int slots) {
        put("Slots", slots);
    }

    public int getOpenSlots() {
        return getInt("OpenSlots");
    }

    public void setOpenSlots(int openSlots) {
        put("OpenSlots", openSlots);
    }

    public Date getNetsDate() {
        return getDate("NetsDate");
    }

    public void setNetsDate(Date netsDate) {
        put("NetsDate", netsDate);
    }
}

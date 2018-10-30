package cs.dal.easymeeting;

public class MeetingInfoItem {

    private String weekday;
    private String date;
    private String state;
    private String name;
    private String time;
    private String location;

    public MeetingInfoItem(String weekday, String date, String state, String name, String time, String location) {
        this.weekday = weekday;
        this.date = date;
        this.state = state;
        this.name = name;
        this.time = time;
        this.location = location;
    }


    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

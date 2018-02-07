package com.example.fs_sournary.networkingsample.sample1.data;

/**
 * Created by fs-sournary.
 * Data: 1/30/18.
 * Description:
 */

public class Event {

    /**
     * Title of the earthquake event
     */
    private String title;

    /**
     * Time that the earthquake happened (in milliseconds)
     */
    private long time;

    /**
     * Whether or not a tsunami alert was issued (1 if it was issued, 0 if no alert was issued)
     */
    private int tsunamiAlert;

    /**
     * Constructs a new {@link Event}.
     *
     * @param eventTitle        is the title of the earthquake event
     * @param eventTime         is the time the earhtquake happened
     * @param eventTsunamiAlert is whether or not a tsunami alert was issued
     */
    public Event(String eventTitle, long eventTime, int eventTsunamiAlert) {
        title = eventTitle;
        time = eventTime;
        tsunamiAlert = eventTsunamiAlert;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getTsunamiAlert() {
        return tsunamiAlert;
    }

    public void setTsunamiAlert(int tsunamiAlert) {
        this.tsunamiAlert = tsunamiAlert;
    }
}

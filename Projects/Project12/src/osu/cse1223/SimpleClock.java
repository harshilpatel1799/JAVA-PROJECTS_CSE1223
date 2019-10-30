/**
 * SimpleClock.java
 *
 * A class that implements a simple
 *
 * @author Jeremy Morris
 * @author Harshil Patel
 * @version 20180415
 *
 */
package osu.cse1223;
public class SimpleClock {

    /* -------- Private member variables --------------------- */
    private int hours;
    private int minutes;
    private int seconds;
    private boolean morning;

    /* -------- Constructor --------------------------------- */
    /**
     * The constructor should set the initial value of the clock to 12:00:00AM.
     */
    public SimpleClock() {
    	hours = 12;
    	minutes = 0;
    	seconds = 0;
    	morning = true;
    }

    /* --------- Instance methods ------------------------- */

    /**
     * Sets the time showing on the clock.
     * 
     * @param hh
     *            - the hours to display
     * @param mm
     *            - the minutes to display
     * @param ss
     *            - the seconds to display
     * @param morning
     *            - true for AM, false for PM
     */
    public void set(int hh, int mm, int ss, boolean morning) {
    	hours=hh;
    	minutes=mm;
    	seconds=ss;
    	this.morning=morning;
    }

    /**
     * Advances the clock by 1 second. Make sure when implementing this method
     * that the seconds "roll over" correctly - 11:59:59AM should become
     * 12:00:00PM for example.
     */
    public void tick() {
    	seconds++;
    	if (seconds==60) {minutes++;seconds=0;}
    	if (minutes==60) {hours++;minutes=0;}
    	if (hours==13) {hours=0;}
    	if (hours==12&&minutes==0&&seconds==0) {morning=!morning;}
        
    }

    /**
     * Returns a string containing the current time formatted as a digital clock
     * format. For example, midnight should return the string "12:00:00AM" while
     * one in the morning would return the string "1:00:00AM" and one in the
     * afternoon the string "1:00:00PM".
     *
     * @return - the current time formatted in AM/PM format
     */
    public String time() {
    	String output="";
    	//  HOURS
    	if(hours<10) {output=output+"0"+hours+":";}
    	else {output=output+hours+":";}
    	//   MINUTES
    	if(minutes<10) {output=output+"0"+minutes+":";}
    	else {output=output+minutes+":";}
    	//   SECONDS
    	if(seconds<10) {output=output+"0"+seconds+":";}
    	else {output=output+seconds+":";}
    	// AM OR PM
    	if(morning==true) {output=output+"AM";}
    	else {output=output+"PM";}
    	return output;
    }

}
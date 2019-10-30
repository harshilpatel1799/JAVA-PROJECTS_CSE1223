/*
 * Project12.java
 *
 *   A program that tests the SimpleClock class.  This program instantiates a
 *   new SimpleClock object, sets it to 11:59:00PM and then repeatedly ticks
 *   seconds to show the passage of an hours worth of time.  YOU DO NOT NEED
 *   TO MODIFY THIS CLASS.  Make your modifications to the SimpleClock.java
 *   file instead.
 *
 *   See the write-up for Project 12 for more details.
 *
 * @author Jeremy Morris
 * @version 20161212
 *
 */
package osu.cse1223;
public class Project12 {

    public static void main(String[] args) {
        SimpleClock clock = new SimpleClock();
        System.out.println("Clock starts at time: " + clock.time());
        clock.set(11, 59, 00, false);
        System.out.println("Clock has been set to time: " + clock.time());
        for (int j = 0; j < 60; j++) {
            for (int i = 0; i < 60; i++) {
                clock.tick();
                System.out.println("TICK: " + clock.time());
            }
        }
        System.out.println("Clock finally reads: " + clock.time());
    }

}
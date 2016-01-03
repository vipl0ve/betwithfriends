package com.android.viplove.betwithfriends.bet;

import java.util.ArrayList;

/**
 * Created by Viplove Prakash on 10-Nov-15.
 */
public class Bet {
    private int betId;
    private String betName;
    private String betDetails;
    private int eventCount;
    private double eventProbabilitySum;
    private String eventOddString, eventProbabilityString, eventNameString;
    private ArrayList<String> eventNameCollection = new ArrayList<String>();
    private ArrayList<Double> eventProbabilityCollection = new ArrayList<Double>();
    private ArrayList<Double> eventOddsCollection = new ArrayList<Double>();

    public Bet() {
        int betId = 0;
        String betName = null;
        String betDetails = null;
        int eventCount = 0;
        double eventProbabilitySum = 0;
        String eventOddString = null;
        String eventProbabilityString = null;
        String eventNameString = null;

    }

    /*Get & Set Methods*/
    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public String getBetName() {
        return betName;
    }

    public void setBetName(String betName) {
        this.betName = betName;
    }

    public String getBetDetails() {
        return betDetails;
    }

    public void setBetDetails(String betDetails) {
        this.betDetails = betDetails;
    }

    public int getEventCount() {
        return eventCount;
    }

    public void setEventCount(int eventCount) {
        this.eventCount = eventCount;
    }

    public double getEventProbabilitySum() {
        return eventProbabilitySum;
    }

    public void setEventProbabilitySum(double eventProbabilitySum) {
        this.eventProbabilitySum = eventProbabilitySum;
    }

    public String getEventOddString() {
        return eventOddString;
    }

    public void setEventOddString(String eventOddString) {
        this.eventOddString = eventOddString;
    }

    public String getEventProbabilityString() {
        return eventProbabilityString;
    }

    public void setEventProbabilityString(String eventProbabilityString) {
        this.eventProbabilityString = eventProbabilityString;
    }

    public String getEventNameString() {
        return eventNameString;
    }

    public void setEventNameString(String eventNameString) {
        this.eventNameString = eventNameString;
    }

    public ArrayList<String> getEventNameCollection() {
        return eventNameCollection;
    }

    public void setEventNameCollection(ArrayList<String> eventNameCollection) {
        this.eventNameCollection = eventNameCollection;
    }

    public ArrayList<Double> getEventProbabilityCollection() {
        return eventProbabilityCollection;
    }

    public void setEventProbabilityCollection(ArrayList<Double> eventProbabilityCollection) {
        this.eventProbabilityCollection = eventProbabilityCollection;
    }

    public ArrayList<Double> getEventOddsCollection() {
        return eventOddsCollection;
    }

    public void setEventOddsCollection(ArrayList<Double> eventOddsCollection) {
        this.eventOddsCollection = eventOddsCollection;
    }

    public void addNewBet(String betName, double... eventProbabilities) {
        int eventCount = eventProbabilities.length;
        double eventProbabilitySum = 0;
        this.betId = createBetId();
        this.betName = betName;
        String eventOddString = "", eventProbabilityString = "";
        double[] eventOdds = new double[eventCount];

        for (int i = 0; i < eventCount; i++) {
            eventProbabilitySum = (double) (eventProbabilitySum + eventProbabilities[i]);
            eventProbabilityString = eventProbabilityString + "" + eventProbabilities[i] + ":";
        }

        for (int i = 0; i < eventCount; i++) {
            double eventTempOdds = (double) (eventProbabilitySum / eventProbabilities[i]);
            eventOdds[i] = eventTempOdds;
            eventOddString = eventOddString + "" + eventTempOdds + ":";
        }

        for (int i = 0; i < eventCount; i++) {
            this.eventProbabilityCollection.add(i, eventProbabilities[i]);
            this.eventOddsCollection.add(i, eventOdds[i]);
        }
        this.eventCount = eventOddsCollection.size();
        this.eventProbabilitySum = eventProbabilitySum;
        this.eventOddString = eventOddString;
        this.eventProbabilityString = eventProbabilityString;
    }

    public void addNewBet(String betName, String event1Name, String event2Name, String event3Name, double... eventProbabilities) {
        int eventCount = eventProbabilities.length;
        double eventProbabilitySum = 0;
        this.betId = createBetId();
        this.betName = betName;
        String eventOddString = "", eventProbabilityString = "", eventNameString = "";
        double[] eventOdds = new double[eventCount];
        String[] eventNames = new String[eventCount];
        eventNames[0] = event1Name;
        eventNames[1] = event2Name;
        eventNames[2] = event3Name;

        for (int i = 0; i < eventCount; i++) {
            eventProbabilitySum = (double) (eventProbabilitySum + eventProbabilities[i]);
            eventProbabilityString = eventProbabilityString + "" + eventProbabilities[i] + ":";
        }

        for (int i = 0; i < eventCount; i++) {
            double eventTempOdds = (double) (eventProbabilitySum / eventProbabilities[i]);
            eventOdds[i] = eventTempOdds;
            eventOddString = eventOddString + "" + eventTempOdds + ":";
        }

        for (int i = 0; i < eventCount; i++) {
            this.eventNameCollection.add(i, eventNames[i]);
            this.eventProbabilityCollection.add(i, eventProbabilities[i]);
            this.eventOddsCollection.add(i, eventOdds[i]);
            eventNameString = eventNameString + "" + eventNames[i] + ":";
        }
        this.eventCount = eventOddsCollection.size();
        this.eventProbabilitySum = eventProbabilitySum;
        this.eventNameString = eventNameString;
        this.eventOddString = eventOddString;
        this.eventProbabilityString = eventProbabilityString;
    }

    private int createBetId() {
        double rand = (double) Math.random();
        int randNo = (int) Math.round(rand * 1000000);
        return randNo;
    }

}

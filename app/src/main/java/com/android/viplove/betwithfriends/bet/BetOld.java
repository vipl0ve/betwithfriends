package com.android.viplove.betwithfriends.bet;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Viplove Prakash on 10-Nov-15.
 */
public class BetOld {
    private int betId;
    private String betName;
    private String betDetails;
    private ArrayList<String> eventNameCollection = new ArrayList<String>();
    private ArrayList<Double> eventProbabilityCollection = new ArrayList<Double>();
    private ArrayList<Double> eventOddsCollection = new ArrayList<Double>();
    private int eventCount;
    private double eventProbabilitySum = 0;

    public BetOld(String betName, double... eventProbabilities) {
        super();
        int eventCount = 0;
        double eventProbabilitySum = 0;
        this.betId = createBetId();
        this.betName = betName;
        eventCount = eventProbabilities.length;
        double[] eventOdds = new double[eventCount];

        for (int i = 0; i < eventCount; i++) {
            eventProbabilitySum = (eventProbabilitySum + eventProbabilities[i]);
        }

        for (int i = 0; i < eventCount; i++) {
            double eventTempOdds = (double) (eventProbabilitySum / eventProbabilities[i]);
            eventOdds[i] = eventTempOdds;
        }

        for (int i = 0; i < eventCount; i++) {
            this.eventProbabilityCollection.add(i, eventProbabilities[i]);
            this.eventOddsCollection.add(i, eventOdds[i]);
        }
        this.eventCount = eventOddsCollection.size();
        this.eventProbabilitySum = eventProbabilitySum;
    }

    public BetOld(String betName, String event1Name, String event2Name, String event3Name, double... eventProbability) {
        super();
        int eventCount = 0;
        double totalEventProbability = 0;
        this.betId = createBetId();
        this.betName = betName;
        eventCount = eventProbability.length;
        double[] eventOdds = new double[eventCount];
        String[] eventNames = new String[eventCount];
        eventNames[0] = event1Name;
        eventNames[1] = event2Name;
        eventNames[2] = event3Name;

        for (int i = 0; i < eventCount; i++) {
            totalEventProbability = (totalEventProbability + eventProbability[i]);
        }

        for (int i = 0; i < eventCount; i++) {
            double eventTempOdds = (double) (totalEventProbability / eventProbability[i]);
            eventOdds[i] = eventTempOdds;
        }

        for (int i = 0; i < eventCount; i++) {
            this.eventNameCollection.add(i, eventNames[i]);
            this.eventProbabilityCollection.add(i, eventProbability[i]);
            this.eventOddsCollection.add(i, eventOdds[i]);
        }
        this.eventCount = eventOddsCollection.size();
    }

    private int createBetId() {
        double rand = (double) Math.random();
        int randNo = (int) Math.round(rand * 1000000);
        return randNo;
    }

    public int getBetId() {
        return this.betId;
    }

    public BetOld getBet(int betId) {
        if (this.betId == betId) {
            return this;
        } else {
            return null;
        }
    }

    public ArrayList<Double> getAllEventOdds(int betId) {
        ListIterator<Double> oddsIterator = null;
        if (this.betId == betId) {
            oddsIterator = eventOddsCollection.listIterator();
            while (oddsIterator.hasNext()) {
                System.out.println(oddsIterator.next());
            }
        } else {
            System.out.println("The Bet is currently unavailable\n");
        }
        return eventOddsCollection;
    }

    public double getEventOdds(int betId, int eventNo) {
        double tempOdds = 0.00;
        int i = eventNo - 1;
        if (this.betId == betId) {
            if (eventNo <= eventOddsCollection.size() && eventNo > 0) {
                tempOdds = eventOddsCollection.get(i);
            } else {
                System.out.println("Invalid Event No");
            }
        } else {
            System.out.println("The Bet is currently unavailable\n");
        }
        return tempOdds;
    }

    public String displayAllEventsOdds(int betId) {
        String displayMessage;
        if (this.betId == betId) {
            displayMessage = "Bet " + this.betName + " all events " + eventOddsCollection.size()
                    + " odds are - \n";
            int i = 0, j = 0;
            while (i < eventOddsCollection.size()) {
                j = i + 1;
                if (eventOddsCollection.get(i) > 1) {
                    displayMessage = displayMessage + "Event " + j + " " + eventNameCollection.get(i)
                            + " Odds For " + eventOddsCollection.get(i) + "\n";
                } else if (eventOddsCollection.get(i) < 1) {
                    displayMessage = displayMessage + "Event " + j + " " + eventNameCollection.get(i)
                            + " Odds Against " + eventOddsCollection.get(i) + "\n";
                } else {
                    displayMessage = displayMessage + "Event " + j + " " + eventNameCollection.get(i)
                            + " Odds Evens " + eventOddsCollection.get(i) + "\n";
                }
                i++;
            }

        } else {
            displayMessage = "The Bet is currently unavailable\n";
        }
        System.out.println(displayMessage);
        return (displayMessage);
    }

    public String displayEventOdds(int betId, int eventNo) {
        String displayMessage;
        int i = eventNo - 1;
        if (this.betId == betId) {
            if (eventNo <= eventOddsCollection.size() && eventNo > 0) {
                displayMessage = "Bet " + this.betName + " event " + eventNo
                        + " odds is - \n";
                if (eventOddsCollection.get(i) > 1) {
                    displayMessage = displayMessage + "Event " + eventNo + " " + eventNameCollection.get(i)
                            + " Odds For " + eventOddsCollection.get(i) + "\n";
                } else if (eventOddsCollection.get(i) < 1) {
                    displayMessage = displayMessage + "Event " + eventNo + " " + eventNameCollection.get(i)
                            + " Odds Against " + eventOddsCollection.get(i) + "\n";
                } else {
                    displayMessage = displayMessage + "Event " + eventNo + " " + eventNameCollection.get(i)
                            + " Odds Evens " + eventOddsCollection.get(i) + "\n";
                }
            } else {
                displayMessage = "The Event No is invalid\n";
            }
        } else {
            displayMessage = "The Bet is currently unavailable\n";
        }
        System.out.println(displayMessage);
        return (displayMessage);
    }

    public String addNewEvent(int betId, String eventName, double eventProbability) {
        double eventProbabilitySum = this.eventProbabilitySum + eventProbability;
        double tempOdds = (double) (eventProbabilitySum) / eventProbability;
        int existingEventCount = eventOddsCollection.size();

        this.eventNameCollection.add(existingEventCount, eventName);
        this.eventProbabilityCollection.add(existingEventCount, eventProbability);
        this.eventOddsCollection.add(existingEventCount, tempOdds);
        this.eventCount = eventOddsCollection.size();
        this.eventProbabilitySum = eventProbabilitySum;

        String displayMessage = ("Bet " + betId + "\nNew event is added at pos: " + (existingEventCount + 1)
                + " with odds " + tempOdds + "\n");
        System.out.println(displayMessage);
        return displayMessage;
    }

    public void editExistingEvent(int betId, int eventNo, String eventNewName, double eventNewProbability) {
        double eventProbabilitySum;
        double tempOdds, tempNewOdds;
        double eventExistingProbability;
        String displayMessage;
        if (this.betId == betId) {
            if (eventNo <= eventOddsCollection.size() && eventNo > 0) {

                eventExistingProbability = this.eventProbabilityCollection.get(eventNo - 1);
                tempOdds = this.eventOddsCollection.get(eventNo - 1);
                eventProbabilitySum = this.eventProbabilitySum + eventNewProbability - eventExistingProbability;
                tempNewOdds = (double) (eventProbabilitySum / eventNewProbability);

                this.eventNameCollection.set((eventNo - 1), eventNewName);
                this.eventProbabilityCollection.set((eventNo - 1), eventNewProbability);
                this.eventOddsCollection.set((eventNo - 1), tempNewOdds);
                this.eventCount = eventOddsCollection.size();
                displayMessage = "Bet " + betId + "\nEvent " + eventNo + " odds are updated from " + tempOdds + " to " + tempNewOdds + "\n";
            } else {
                displayMessage = "The Event No is invalid\n";
            }
        } else {
            displayMessage = "The Bet is currently unavailable\n";
        }
        System.out.println(displayMessage);
    }

    public void deleteExistingEvent(int betId, int eventNo) {
        double eventProbabilitySum;
        double tempOdds;
        double eventExistingProbability;
        String displayMessage;
        if (this.betId == betId) {
            if (eventNo <= eventOddsCollection.size() && eventNo > 0) {
                eventExistingProbability = this.eventProbabilityCollection.get(eventNo - 1);
                tempOdds = this.eventOddsCollection.get(eventNo - 1);
                eventProbabilitySum = this.eventProbabilitySum - eventExistingProbability;

                this.eventNameCollection.remove(eventNo - 1);
                this.eventProbabilityCollection.remove(eventNo - 1);
                this.eventOddsCollection.remove(eventNo - 1);
                this.eventCount = eventOddsCollection.size();
                this.eventProbabilitySum = eventProbabilitySum;

                for (int i = 0; i < this.eventCount; i++) {
                    double tempEventOdds = (double) (eventProbabilitySum / this.eventProbabilityCollection.get(eventNo - 1));
                    this.eventProbabilityCollection.set((eventNo - 1), tempEventOdds);
                }

                displayMessage = "Bet " + betId + "\nEvent " + eventNo + " with odds " + tempOdds + "is deleted\n";
            } else {
                displayMessage = "The Event No is invalid\n";
            }
        } else {
            displayMessage = "The Bet is currently unavailable\n";
        }
        System.out.println(displayMessage);
    }
}

package com.android.viplove.betwithfriends.bet;

import java.util.ArrayList;

/**
 * Created by Viplove Prakash on 10-Nov-15.
 */
public class BetStake {
    private Bet selectedBet;
    private int selectedEventNo;
    private ArrayList<Double> selectedBetAllEventOdds;
    private double selectedEventOdds;
    private double totalStakeAmount;
    private double totalReturnAmount;
    private double totalProfitAmount;

    public BetStake() {
        Bet selectedBet = null;
        int selectedEventNo = 0;
        ArrayList<Double> selectedBetAllEventOdds = null;
        double selectedEventOdds = 0;
        double totalStakeAmount = 0;
        double totalReturnAmount = 0;
        double totalProfitAmount = 0;
    }

    public void addBetStake(Bet bet, int eventNo, double stakeAmount) {
        this.selectedBet = bet;
        this.selectedEventNo = eventNo;
        this.totalStakeAmount = stakeAmount;
        this.selectedBetAllEventOdds = this.selectedBet.getEventOddsCollection();
        this.selectedEventOdds = this.selectedBetAllEventOdds.get(this.selectedEventNo - 1);

        this.totalReturnAmount = (double) (this.totalStakeAmount * this.selectedEventOdds);
        this.totalProfitAmount = (double) (this.totalReturnAmount - this.totalStakeAmount);
    }

    public Bet getSelectedBet() {
        return selectedBet;
    }

    public void setSelectedBet(Bet selectedBet) {
        this.selectedBet = selectedBet;
    }

    public int getSelectedEventNo() {
        return selectedEventNo;
    }

    public void setSelectedEventNo(int selectedEventNo) {
        this.selectedEventNo = selectedEventNo;
    }

    public ArrayList<Double> getSelectedBetAllEventOdds() {
        return selectedBetAllEventOdds;
    }

    public void setSelectedBetAllEventOdds(ArrayList<Double> selectedBetAllEventOdds) {
        this.selectedBetAllEventOdds = selectedBetAllEventOdds;
    }

    public double getSelectedEventOdds() {
        return selectedEventOdds;
    }

    public void setSelectedEventOdds(double selectedEventOdds) {
        this.selectedEventOdds = selectedEventOdds;
    }

    public double getTotalStakeAmount() {
        return totalStakeAmount;
    }

    public void setTotalStakeAmount(double totalStakeAmount) {
        this.totalStakeAmount = totalStakeAmount;
    }

    public double getTotalReturnAmount() {
        return totalReturnAmount;
    }

    public void setTotalReturnAmount(double totalReturnAmount) {
        this.totalReturnAmount = totalReturnAmount;
    }

    public double getTotalProfitAmount() {
        return totalProfitAmount;
    }

    public void setTotalProfitAmount(double totalProfitAmount) {
        this.totalProfitAmount = totalProfitAmount;
    }

    public double getStakeOdds() {
        System.out.println(this.selectedEventOdds);
        return (this.selectedEventOdds);
    }

    public double getTotalStake() {
        System.out.println(this.totalStakeAmount);
        return (this.totalStakeAmount);
    }
}

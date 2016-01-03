package com.android.viplove.betwithfriends.bet;

import java.text.DecimalFormat;

/**
 * Created by Viplove Prakash on 10-Nov-15.
 */
public class BetOddsFormat {

    private String odds;
    private String american_Odds;
    //private String moneyline_Odds;	//same as American Odds
    private String decimal_Odds;
    //private String european_Odds;		//same as Decimal Odds
    private String fractional_Odds;
    private String hongKong_Odds;
    private String indonesian_Odds;
    private String malay_Odds;
    private String iprobability_Odds;

    DecimalFormat defaultFormat = new DecimalFormat("#.00");
    DecimalFormat americanformat = new DecimalFormat("#");
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    DecimalFormat hongkongFormat = new DecimalFormat("#0.0000");
    DecimalFormat indoFormat = new DecimalFormat("#0.0000");
    DecimalFormat malayFormat = new DecimalFormat("#0.0000");
    DecimalFormat impliedprobabilityFormat = new DecimalFormat("#0.00");

	/*public BetOddsFormat(String odds) {
        this.odds = odds;
	}

	public String getEventOdds() {
		return odds;
	}*/

    public String changeOddsIntoAmericanOdds(double odds) {
        double temp_odds;
        if (odds > 1) {
            temp_odds = (100 * odds);
            american_Odds = "+" + americanformat.format(temp_odds);

        } else if (odds < 1) {
            temp_odds = (100 / odds);
            american_Odds = "-" + americanformat.format(temp_odds);

        } else if (odds == 1) {
            temp_odds = (100 * odds);
            american_Odds = "+/-" + americanformat.format(temp_odds);
        }
        return american_Odds;
    }

/*	public double changeAmericanOddsIntoOdds(String odds) {
		double temp_odds = Double.valueOf(odds.startsWith("+")) - 1;
		return temp_odds;
	}*/

    public String changeOddsIntoDecimalOdds(double odds) {
        double temp_odds = odds + 1;
        decimal_Odds = decimalFormat.format(temp_odds);
        return decimal_Odds;
    }

    public double changeDecimalOddsIntoOdds(String odds) {
        double temp_odds = Double.valueOf(odds) - 1;
        return temp_odds;
    }

    public String changeOddsIntoFractionalOdds(double odds) {
        int num, denom;
        String s = String.valueOf(odds);
        int digitsDec = s.length() - 1 - s.indexOf('.');
        denom = 1;
        for (int i = 0; i < digitsDec; i++) {
            odds *= 10;
            denom *= 10;
        }
        num = (int) Math.round(odds);
        fractional_Odds = num + "/" + denom;
        return fractional_Odds;
    }

    public String changeOddsIntoHongKongOdds(double odds) {
        hongKong_Odds = hongkongFormat.format(odds);
        return hongKong_Odds;
    }

    public String changeOddsIntoIndonesianOdds(double odds) {
        double temp_odds;
        if (odds > 1) {
            temp_odds = (odds);
            indonesian_Odds = indoFormat.format(temp_odds);

        } else if (odds < 1) {
            temp_odds = (1 / odds);
            indonesian_Odds = "-" + indoFormat.format(temp_odds);

        } else if (odds == 1) {
            temp_odds = (odds);
            indonesian_Odds = indoFormat.format(temp_odds);
        }
        return indonesian_Odds;
    }

    public String changeOddsIntoMalayOdds(double odds) {
        double temp_odds;
        if (odds > 1) {
            temp_odds = (1 / odds);
            malay_Odds = "-" + malayFormat.format(temp_odds);

        } else if (odds < 1) {
            temp_odds = (odds);
            malay_Odds = malayFormat.format(temp_odds);

        } else if (odds == 1) {
            temp_odds = (odds);
            malay_Odds = malayFormat.format(temp_odds);
        }
        return malay_Odds;
    }

    public String changeOddsIntoImpliedProbability(double odds) {
        double temp_odds;
        temp_odds = 100 / (odds + 1);
        iprobability_Odds = impliedprobabilityFormat.format(temp_odds) + "%";
        return iprobability_Odds;
    }
}

package com.android.viplove.betwithfriends.users;

/**
 * Created by Viplove Prakash on 10-Nov-15.
 */
public class BetUser {
    private String userId;
    private String userName;
    private int userAge;
    private String userGender;
    private String userMobile;
    private String userEmail;
    private String userCountry;
    private String userPassword;

    private String userFaceBookId;
    private String userGoogleId;
    private String userWebId;

    private int userOddsFormatSetting;

    public BetUser() {
        String userId = null;
        String userName = null;
        int userAge = 0;
        String userGender = null;
        String userMobile = null;
        String userEmail = null;
        String userCountry = null;
        String userPassword = null;
        int userOddsFormatSetting = 0;

    }

    public void addNewUser(String userName, int userAge, String userGender, String userMobile, String userEmail, String userCountry, String userPassword) {
        this.userId = userEmail;
        this.userName = userName;
        this.userAge = userAge;
        this.userGender = userGender;
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userCountry = userCountry;
        this.userPassword = userPassword;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserOddsFormatSetting() {
        return userOddsFormatSetting;
    }

    public void setUserOddsFormatSetting(int userOddsFormatSetting) {
        this.userOddsFormatSetting = userOddsFormatSetting;
    }

    public String getUserFaceBookId() {
        return userFaceBookId;
    }

    public void setUserFaceBookId(String userFaceBookId) {
        this.userFaceBookId = userFaceBookId;
    }

    public String getUserGoogleId() {
        return userGoogleId;
    }

    public void setUserGoogleId(String userGoogleId) {
        this.userGoogleId = userGoogleId;
    }

    public String getUserWebId() {
        return userWebId;
    }

    public void setUserWebId(String userWebId) {
        this.userWebId = userWebId;
    }
}

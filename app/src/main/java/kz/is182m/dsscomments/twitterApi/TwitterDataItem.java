package kz.is182m.dsscomments.twitterApi;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TwitterDataItem {



    /*negativeSelectedWords": [
            "навальный"
            ],
            "positiveSelectedWords": [],
            "negativeWordCount": 1,
            "positiveWordCount": 0,
            "negativePercent": 0.1111111111111111,
            "positivePercent": 0,
            "normalizedWords*/


    @SerializedName("negativePercent")
    @Expose
    double negativePercent;
    @SerializedName("positivePercent")
    @Expose
    double positivePercent;
    @SerializedName("neutralPercent")
    @Expose
    double neutralPercent;
    @SerializedName("negativeWordCount")
    @Expose
    Integer negativeWordCount;
    @SerializedName("positiveWordCount")
    @Expose
    Integer positiveWordCount;
    @SerializedName("positiveSelectedWords")
    @Expose
    List<String> positiveSelectedWords;
    @SerializedName("negativeSelectedWords")
    @Expose
    List<String> negativeSelectedWords;
    @SerializedName("normalizedWords")
    @Expose
    List<String> normalizedWords;
    @SerializedName("originalWords")
    @Expose
    List<String> originalWords;


    @SerializedName("text")
    @Expose
    private String text;

    public TwitterDataItem(double negativePercent, double positivePercent, double neutralPercent, Integer negativeWordCount, Integer positiveWordCount, List<String> positiveSelectedWords, List<String> negativeSelectedWords, List<String> normalizedWords, List<String> originalWords, String text, String userName, String date) {
        this.negativePercent = negativePercent;
        this.positivePercent = positivePercent;
        this.neutralPercent = neutralPercent;
        this.negativeWordCount = negativeWordCount;
        this.positiveWordCount = positiveWordCount;
        this.positiveSelectedWords = positiveSelectedWords;
        this.negativeSelectedWords = negativeSelectedWords;
        this.normalizedWords = normalizedWords;
        this.originalWords = originalWords;
        this.text = text;
        this.userName = userName;
        this.date = date;
    }

    public double getNeutralPercent() {
        return neutralPercent;
    }

    public void setNeutralPercent(double neutralPercent) {
        this.neutralPercent = neutralPercent;
    }

    public Integer getNegativeWordCount() {
        return negativeWordCount;
    }

    public void setNegativeWordCount(Integer negativeWordCount) {
        this.negativeWordCount = negativeWordCount;
    }

    public Integer getPositiveWordCount() {
        return positiveWordCount;
    }

    public void setPositiveWordCount(Integer positiveWordCount) {
        this.positiveWordCount = positiveWordCount;
    }

    public List<String> getPositiveSelectedWords() {
        return positiveSelectedWords;
    }

    public void setPositiveSelectedWords(List<String> positiveSelectedWords) {
        this.positiveSelectedWords = positiveSelectedWords;
    }

    public List<String> getNegativeSelectedWords() {
        return negativeSelectedWords;
    }

    public void setNegativeSelectedWords(List<String> negativeSelectedWords) {
        this.negativeSelectedWords = negativeSelectedWords;
    }

    public List<String> getNormalizedWords() {
        return normalizedWords;
    }

    public void setNormalizedWords(List<String> normalizedWords) {
        this.normalizedWords = normalizedWords;
    }

    public List<String> getOriginalWords() {
        return originalWords;
    }

    public void setOriginalWords(List<String> originalWords) {
        this.originalWords = originalWords;
    }

    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("date")
    @Expose
    private String date;







    public TwitterDataItem(String text, String userName, String created_at, double negative, double positive) {
        this.text = text;
        this.userName = userName;
        this.date = created_at;
        this.negativePercent = negative;
        this.positivePercent = positive;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getNegativePercent() {
        return negativePercent;
    }

    public void setNegativePercent(double negativePercent) {
        this.negativePercent = negativePercent;
    }

    public double getPositivePercent() {
        return positivePercent;
    }

    public void setPositivePercent(double positivePercent) {
        this.positivePercent = positivePercent;
    }

}

package kz.is182m.dsscomments.http;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

 /*   {
        "negativeSelectedWords": [],
        "positiveSelectedWords": [
        "привет",
                "мир",
                "добросердечность"
    ],
        "negativeWordCount": 0,
            "positiveWordCount": 3,
            "negativePercent": 0,
            "positivePercent": 1
    }*/
 @SerializedName("negativeSelectedWords")
 @Expose
    private List<String> negativeSelectedWords;

    @Override
    public String toString() {
        return "Data{" +
                "negativeSelectedWords=" + negativeSelectedWords +
                ", positiveSelectedWords=" + positiveSelectedWords +
                ", negativeWordCount=" + negativeWordCount +
                ", positiveWordCount=" + positiveWordCount +
                ", negativePercent=" + negativePercent +
                ", positivePercent=" + positivePercent +
                '}';
    }

    @SerializedName("positiveSelectedWords")
    @Expose
    private List<String> positiveSelectedWords;
    @SerializedName("negativeWordCount")
    @Expose
    private Integer negativeWordCount;
    @SerializedName("positiveWordCount")
    @Expose
    private Integer positiveWordCount;
    @SerializedName("negativePercent")
    @Expose
    private Double negativePercent;
    @SerializedName("positivePercent")
    @Expose
    private Double positivePercent;

    public Data(List<String> negativeSelectedWords, List<String> positiveSelectedWords, Integer negativeWordCount, Integer positiveWordCount, Double negativePercent, Double positivePercent) {
        this.negativeSelectedWords = negativeSelectedWords;
        this.positiveSelectedWords = positiveSelectedWords;
        this.negativeWordCount = negativeWordCount;
        this.positiveWordCount = positiveWordCount;
        this.negativePercent = negativePercent;
        this.positivePercent = positivePercent;
    }

    public Data() {
    }

    public List<String> getNegativeSelectedWords() {
        return negativeSelectedWords;
    }

    public void setNegativeSelectedWords(List<String> negativeSelectedWords) {
        this.negativeSelectedWords = negativeSelectedWords;
    }

    public List<String> getPositiveSelectedWords() {
        return positiveSelectedWords;
    }

    public void setPositiveSelectedWords(List<String> positiveSelectedWords) {
        this.positiveSelectedWords = positiveSelectedWords;
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

    public Double getNegativePercent() {
        return negativePercent;
    }

    public void setNegativePercent(Double negativePercent) {
        this.negativePercent = negativePercent;
    }

    public Double getPositivePercent() {
        return positivePercent;
    }

    public void setPositivePercent(Double positivePercent) {
        this.positivePercent = positivePercent;
    }
}

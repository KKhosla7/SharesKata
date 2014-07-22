package in.blogspot.pythonicway.shareskata;

import java.math.BigDecimal;

/**
 * Created by Karan Khosla on 22/7/14.
 */
public class SharePriceHistoryRecords {

    private int year;
    private String month;
    private String companyName;
    private double sharePrice;

    public SharePriceHistoryRecords() {
    }

    public SharePriceHistoryRecords(int year, String month, String companyName, double sharePrice) {
        this.year = year;
        this.month = month;
        this.companyName = companyName;
        this.sharePrice = sharePrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }

    @Override
    public String toString() {
        return "SharePriceHistoryRecords{" +
                "year=" + year +
                ", month='" + month + '\'' +
                ", companyName='" + companyName + '\'' +
                ", sharePrice=" + sharePrice +
                '}';
    }
}

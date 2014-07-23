package in.blogspot.pythonicway.shareskata;

import in.blogspot.pythonicway.shareskata.io.SharePriceHistoryRecordsConsumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Karan Khosla on 22/7/14.
 */
public class SharePriceListings {

    public void listCompaniesWithHighestSharePrice(List<SharePriceHistoryRecords> listOfRecords) {
        System.out.println("Listing All Companies When Share Price Was Higher.");
        Map<String, SharePriceHistoryRecords> shareRecordMap = new HashMap<String, SharePriceHistoryRecords>();

        for (SharePriceHistoryRecords newRecord : listOfRecords) {
            SharePriceHistoryRecords previousRecord = shareRecordMap.get(newRecord.getCompanyName());
            if (previousRecord == null || newRecord.getSharePrice() > previousRecord.getSharePrice())
                shareRecordMap.put(newRecord.getCompanyName(), newRecord);
        }
        for (String name : shareRecordMap.keySet()) {
            SharePriceHistoryRecords company = shareRecordMap.get(name);
            System.out.println(company.getYear() + " [ " + company.getMonth() + " ]  -  " + company.getCompanyName() + ": " + company.getSharePrice());
        }
    }

    public static void main(String[] args) {

        // Turn Intermediary Data into List of Share Price History Records

        List<SharePriceHistoryRecords> sharePriceHistoryRecords = SharePriceHistoryRecordsConsumer.readFileIntoList("test_shares_data.csv");

        // Listing Companies According to Month & Year When Share Price is High.

        SharePriceListings listings = new SharePriceListings();
        listings.listCompaniesWithHighestSharePrice(sharePriceHistoryRecords);
    }
}
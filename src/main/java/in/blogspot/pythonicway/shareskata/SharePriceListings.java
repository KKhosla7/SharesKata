package in.blogspot.pythonicway.shareskata;

import in.blogspot.pythonicway.shareskata.io.CSVFileReader;
import java.util.List;

/**
 * Created by Karan Khosla on 22/7/14.
 */
public class SharePriceListings {

    public void listHighestSharePriceCompaniesByMonthYear(List<SharePriceHistoryRecords> listOfRecords) {
        for (SharePriceHistoryRecords obj : listOfRecords) {
            System.out.println(obj);
        }

    }


    public static void main(String[] args) {

        // Turn Intermediary Data into List of Share Price History Records

        List<SharePriceHistoryRecords> sharePriceHistoryRecords = CSVFileReader.readFileIntoList("test_shares_data.csv");

        // Listing Companies According to Month & Year When Share Price is High.

        SharePriceListings listings = new SharePriceListings();
        listings.listHighestSharePriceCompaniesByMonthYear(sharePriceHistoryRecords);
    }

}

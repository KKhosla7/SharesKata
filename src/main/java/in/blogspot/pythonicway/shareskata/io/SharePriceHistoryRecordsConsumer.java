package in.blogspot.pythonicway.shareskata.io;

import in.blogspot.pythonicway.shareskata.SharePriceHistoryRecords;
import in.blogspot.pythonicway.shareskata.exceptions.ContentException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karan Khosla on 22/7/14.
 */
public class SharePriceHistoryRecordsConsumer {


    public static List<SharePriceHistoryRecords> readFileIntoList(final String filePath) {
        List<SharePriceHistoryRecords> records = new ArrayList<SharePriceHistoryRecords>();
        BufferedReader buffer = null;
        try {
            fileChecker(filePath);
            buffer = new BufferedReader(new FileReader(filePath));

            String[] header = buffer.readLine().split(",");

            String recordsLineByLine;
            while ( (recordsLineByLine = buffer.readLine()) != null) {
                String[] dataSplit = recordsLineByLine.split(",");

                if (dataSplit.length == header.length) {
                    int year = Integer.parseInt(dataSplit[0]);
                    String month = dataSplit[1];

                    for (int index = 2; index < dataSplit.length; index++) {
                        String companyName = header[index];
                        double price = Double.parseDouble(dataSplit[index]);
                        records.add(new SharePriceHistoryRecords(year, month, companyName, price));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ContentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            safeClose(buffer);
        }
        return records;
    }

    private static void fileChecker(final String filePath) throws FileNotFoundException, ContentException {
        File sharesData = new File(filePath);
        if (!sharesData.exists())
            throw new FileNotFoundException("File does not Exist: " + filePath);
        if (!sharesData.isFile())
            throw new FileNotFoundException("Can Read a File not Directory: " + filePath);
        if (!sharesData.canRead())
            throw new FileNotFoundException("Don't have permissions to read file: " + filePath);
        if (sharesData.length() == 0)
            throw new ContentException("File is Empty: : " + filePath);
    }


    public static void safeClose(Closeable resource) {
        if (resource != null)
            try {
                resource.close();
            } catch (IOException e) {
                // Not Required
            }
    }

}

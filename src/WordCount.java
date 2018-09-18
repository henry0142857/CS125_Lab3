import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WordCount {
    /**
     * Retrieve contents from a URL and return them as a string.
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int singleWordCount(final String text, final String word) {
        if (text == null || word == null || text.length() < 1 || word.length() < 1) {
            System.out.println("Error!");
            return 0;
        }
        int count = 0;
        for (int i = 0; i < text.length() - word.length(); i++) {
            String sub = text.substring(i, i + word.length());
            if (sub.compareToIgnoreCase(word) == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] vargin) {
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String text = urlToString(url);
        System.out.println(singleWordCount(text,"Prince"));
    }
}

/*
http://erdani.com/tdpl/hamlet.txt
https://www.bls.gov/tus/charts/chart9.txt
http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt
 */

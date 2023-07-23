package glassdoorcrawler;

import org.jsoup.Jsoup;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Document doc = Jsoup.connect("https://www.glassdoor.com/Job/index.htm")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1")
                    .timeout(30000)
                    .get();
            Path filePath = Paths.get("C:/Users/rbhat/Documents/GlassDoor scraping project/document.txt");
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            Files.write(filePath, doc.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

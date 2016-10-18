package daniyar.com.nauapp.News_Fragment;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by yernar on 17/10/16.
 */
//flickly snickly

class NewsParser {

    public static ArrayList<News> parseNews(String html, String Url) {
        ArrayList<News> arrayList = new ArrayList<>();

        Document doc = Jsoup.parse(html, Url);
        Elements content = doc.getElementsByClass("fusion-post-large");

        for(Element post : content) {
            String title = post.getElementsByClass("entry-title").get(0).getElementsByTag("a").get(0).text();
            String description = post.getElementsByClass("reading-box-description").get(0).text();
            String imageSrc = post.getElementsByClass("attachment-blog-large").get(0).attr("src");
           // String Date = post.getElementsByClass("fusion-alignLeft").get(3).text();
            arrayList.add(new News(imageSrc, title, description, "20 October 2016"));
        }

        return arrayList;
    }
    public static ArrayList<News> parseNews(String html) {
        return parseNews(html, null);
    }

    public static ArrayList<News> parseNews(byte[] html, String baseUrl) {
        return parseNews(bytesToString(html), baseUrl);
    }

    public static ArrayList<News> parseNews(byte[] html) {
        return parseNews(bytesToString(html), null);
    }

    public static String bytesToString(byte[] bytes){
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e){
            return null;
        }
    }
}

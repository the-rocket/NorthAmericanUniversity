package daniyar.com.nauapp.News_Fragment;


import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Daniyar Kaiyrbolatov on 17/10/16.
 */

class NewsParser {

    private static final String TAG = NewsParser.class.getSimpleName();
    private static final String defaultDate = "DD MM YY";

    public static ArrayList<News> parseNews(String html, String Url) {
        ArrayList<News> arrayList = new ArrayList<>();

        Document doc = Jsoup.parse(html, Url);
        Elements content = doc.getElementsByClass("fusion-post-large");

        //it is needed to extract dates of publication, they are located under class .updated
        Elements dates = doc.select("span.updated");

        for(Element post : content) {
            String title = post.getElementsByClass("entry-title").get(0).getElementsByTag("a").get(0).text();
            String description = post.getElementsByClass("reading-box-description").get(0).text();
            String imageSrc = post.getElementsByClass("attachment-blog-large").get(0).attr("src");
            arrayList.add(new News(imageSrc, title, description, defaultDate));
        }
        //but not only dates, author uses, .updated class, for other things too. updated class tag is <span>
        try {
            int i = 0;
            for (Element date : dates) {
                String newsDate = date.nextElementSibling().getElementsByTag("span").html();
                Log.d("DATA:", newsDate);
                //updating default dates of news
                arrayList.get(i++).setNewsDate(newsDate);
            }
        } catch (Exception e) {
            Log.d(TAG, e.getMessage());
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

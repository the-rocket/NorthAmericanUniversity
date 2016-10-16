package daniyar.com.nauapp;

import android.media.Image;

/**
 * Created by yernar on 12/10/16.
 */

class news {

    private Image NewsImage;
    private String NewsDescription;
    private String NewsTitle;
    private int NewsDate;

    news(int dr, String s, String s1, int i) {
        this.NewsTitle = s;
        this.NewsDescription = s1;
        this.NewsDate = i;
    }

    public void setNewsImage(Image img) {
        this.NewsImage = img;
    }
    public void setNewsDescription(String Description) {
        this.NewsDescription = Description;
    }
    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }
    public void setNewsDate(int Date) {
        this.NewsDate = Date;
    }

    public Image getNewsImage() {
        return NewsImage;
    }
    public String getNewsDescription() {
        return NewsDescription;
    }
    public String getNewsTitle() {
        return NewsTitle;
    }
    public int getNewsDate() {
        return NewsDate;
    }

}

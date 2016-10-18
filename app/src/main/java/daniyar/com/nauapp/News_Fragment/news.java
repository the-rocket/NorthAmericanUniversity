package daniyar.com.nauapp.News_Fragment;

/**
 * Created by yernar on 12/10/16.
 */

class News {

    private String NewsImageUrl;
    private String NewsDescription;
    private String NewsTitle;
    private String NewsDate;

    News(String imageUrl, String s, String s1, String i) {
        this.NewsImageUrl = imageUrl;
        this.NewsTitle = s;
        this.NewsDescription = s1;
        this.NewsDate = i;
    }

    public void setNewsImageUrl(String img) {
        this.NewsImageUrl = img;
    }
    public void setNewsDescription(String Description) {
        this.NewsDescription = Description;
    }
    public void setNewsTitle(String NewsTitle) {
        this.NewsTitle = NewsTitle;
    }
    public void setNewsDate(String Date) {
        this.NewsDate = Date;
    }

    public String getNewsImageUrl() {
        return NewsImageUrl;
    }
    public String getNewsDescription() {
        return NewsDescription;
    }
    public String getNewsTitle() {
        return NewsTitle;
    }
    public String getNewsDate() {
        return NewsDate;
    }

}

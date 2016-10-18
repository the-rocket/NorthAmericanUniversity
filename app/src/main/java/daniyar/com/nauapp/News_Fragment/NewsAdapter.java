package daniyar.com.nauapp.News_Fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import daniyar.com.nauapp.R;


/**
 * Created by yernar on 12/10/16.
 */

class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> myArrayList;
    private Context context;

    NewsAdapter(List<News> newsArray) {
        this.myArrayList = newsArray;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageNews;
        TextView titleNews;
        TextView descriptionNews;
        TextView dateNews;

        ViewHolder(View itemView) {
            super(itemView);
            imageNews = (ImageView) itemView.findViewById(R.id.imageNews);
            titleNews = (TextView) itemView.findViewById(R.id.titleNews);
            descriptionNews = (TextView) itemView.findViewById(R.id.descriptionNews);
            dateNews = (TextView) itemView.findViewById(R.id.dateNews);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        News one = myArrayList.get(position);
        Glide.with(context).load(one.getNewsImageUrl()).error(android.R.drawable.alert_dark_frame).into(holder.imageNews);
        holder.titleNews.setText(one.getNewsTitle());
        holder.descriptionNews.setText(one.getNewsDescription());
        holder.dateNews.setText(one.getNewsDate());
    }

    @Override
    public int getItemCount() {
        if (myArrayList == null)
            return -1;
        return myArrayList.size();
    }
}

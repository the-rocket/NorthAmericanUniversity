package daniyar.com.nauapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by yernar on 12/10/16.
 */

class RecyclerNewsAdapter extends RecyclerView.Adapter<RecyclerNewsAdapter.ViewHolder> {

    private List<news> myArrayList;
    private Context context;

    RecyclerNewsAdapter(List<news> newsArray) {
        this.myArrayList = newsArray;
    }
    public void insertItem(news something) {
        myArrayList.add(something);
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
        news one = myArrayList.get(position);
        Glide.with(context).load("http://www.na.edu/wp-content/uploads/2016/05/talgat-Y.jpg").error(android.R.drawable.alert_dark_frame).into(holder.imageNews);
        holder.titleNews.setText(one.getNewsTitle());
        holder.descriptionNews.setText(one.getNewsDescription());
        holder.dateNews.setText(Integer.toString(one.getNewsDate()) + "October 2016");
    }

    @Override
    public int getItemCount() {
        if (myArrayList == null)
            return -1;
        return myArrayList.size();
    }
}

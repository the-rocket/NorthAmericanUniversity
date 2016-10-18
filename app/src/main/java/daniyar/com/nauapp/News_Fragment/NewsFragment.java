package daniyar.com.nauapp.News_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import daniyar.com.nauapp.R;


/**
 * Created by yernar on 30/09/16.
 */

public class NewsFragment extends Fragment {

    private ArrayList<News> NewsList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    //private String path;

    RecyclerView newsRecyclerView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void loadData(final OnLoadListener onLoadListener, final int page) {
            //final String
            //path = String.format(Locale.ROOT, "category/headlines/page/%d" + page);
            final String path = "category/headlines/page/" + Integer.toString(page)+"/";

        try {
            HttpClient.get(path, null, new AsyncHttpResponseHandler() {

                @Override
                public void onStart() {
                    super.onStart();
                    onLoadListener.OnStart();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    try {
                        ArrayList<News> newData = NewsParser.parseNews(responseBody, HttpClient.getAbsoluteUrl(path));
                        onLoadListener.OnSuccess(newData);
                    } catch (Exception e) {
                        onFailure(statusCode, headers, responseBody, e);
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    onLoadListener.OnFailure(error);
                }
            });
        } catch(Exception e) {
            Log.d("News_Fragment.activity", e.toString());
        }
    }

    public void initView() {
        adapter = new NewsAdapter(NewsList);
        newsRecyclerView.hasFixedSize();
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        newsRecyclerView.setAdapter(adapter);
        loadData(new OnLoadListener() {
            @Override
            public void OnStart() {
                Toast.makeText(getContext(), "Started loading", Toast.LENGTH_LONG).show();
            }

            @Override
            public void OnSuccess(ArrayList<News> newData) {
                //NewsList.clear();
                Toast.makeText(getContext(), "Success loading", Toast.LENGTH_LONG).show();
                NewsList.addAll(newData);
                adapter = new NewsAdapter(NewsList);
                newsRecyclerView.setAdapter(adapter);
            }

            @Override
            public void OnFailure(Throwable error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }, 1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        newsRecyclerView = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        initView();

        return view;
    }

    interface OnLoadListener {
        void OnStart();

        void OnSuccess(ArrayList<News> newData);

        void OnFailure(Throwable error);
    }
}

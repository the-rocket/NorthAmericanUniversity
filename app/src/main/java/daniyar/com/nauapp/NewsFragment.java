package daniyar.com.nauapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yernar on 30/09/16.
 */

public class NewsFragment extends Fragment {

    private List<news> NewsList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    //@BindView(R.id.newsRecyclerView)
    RecyclerView newsRecyclerView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ButterKnife.bind(getActivity());
        initDataset();
        try {
            init();
        } catch (Exception e) {
            Log.d("exception", e.toString());
        }
    }

    public void init() {
    //    initView();
    }

    public void initView() {
        adapter = new RecyclerNewsAdapter(NewsList);
        newsRecyclerView.hasFixedSize();
        newsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        newsRecyclerView.setAdapter(adapter);

    }

    public void initDataset() {
        news one = new news(1, "Title something about", "Description of something about Talgat earned gold medal in Judo", 20);
        NewsList.add(one);
        NewsList.add(one);
        NewsList.add(one);
      //  adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.news_fragment, container, false);
        newsRecyclerView = (RecyclerView) view.findViewById(R.id.newsRecyclerView);
        initDataset();
        initView();
        return view;
    }
}

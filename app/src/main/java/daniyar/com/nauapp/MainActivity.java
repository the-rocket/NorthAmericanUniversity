package daniyar.com.nauapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import daniyar.com.nauapp.Moodle_Fragment.MoodleFragment;
import daniyar.com.nauapp.News_Fragment.NewsFragment;
import daniyar.com.nauapp.Student_Fragment.StudentFragment;


public class MainActivity extends BaseActivity {

    private String MoodleFragment = "Moodle";
    private String NewsFragment = "News";
    private String StudentFragment = "Student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    public void init() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabs = (TabLayout) findViewById(R.id.tabs);

        initViews();

    }

    public void initViews() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MoodleFragment(), MoodleFragment);
        adapter.addFragment(new NewsFragment(), NewsFragment);
        adapter.addFragment(new StudentFragment(), StudentFragment);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }

    protected int getLayout() {
        return R.layout.activity_main;
    }

}

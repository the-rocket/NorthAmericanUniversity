package daniyar.com.nauapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import daniyar.com.nauapp.Fragments.MoodleFragment;
import daniyar.com.nauapp.Fragments.NewsFragment;
import daniyar.com.nauapp.Fragments.StudentFragment;

public class MainActivity extends AppCompatActivity {

    private String MoodleFragment = "Moodle";
    private String NewsFragment = "News";
    private String StudentFragment = "Student";

    TabLayout tabs;
    ViewPager viewPager;

    @BindView(R.id.tool) Toolbar tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(tool);
        tabs = (TabLayout) findViewById(R.id.tabs);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MoodleFragment(), "Moodle");
        adapter.addFragment(new NewsFragment(), "News");
        adapter.addFragment(new StudentFragment(), "Student");
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
    }
}

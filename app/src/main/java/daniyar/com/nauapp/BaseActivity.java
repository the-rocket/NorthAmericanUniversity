//package daniyar.com.nauapp;
//
//import android.os.Bundle;
//import android.support.annotation.LayoutRes;
//import android.support.annotation.Nullable;
//import android.support.design.widget.TabLayout;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///**
// * Created by yernar on 24/09/16.
// */
//
//public abstract class BaseActivity extends AppCompatActivity {
//
//    private String MoodleFragment = "Moodle";
//    private String NewsFragment = "News";
//    private String StudentFragment = "Student";
//
//    @BindView(R.id.viewPager) ViewPager viewPager;
//    @BindView(R.id.toolbar) Toolbar toolbar;
//    @BindView(R.id.tabs) TabLayout tabs;
////    @BindView(R.id.tabMoodle) Tab tabMoodle;
////    @BindView(R.id.tabNews) TabLayout.Tab tabNews;
////    @BindView(R.id.tabStudent) TabLayout.Tab tabStudent;
//
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(getLayout());
//        ButterKnife.bind(this);
//
//        init();
//
//    }
//
//    public void init() {
//        //setSupportActionBar(toolbar);
//        initViews();
//    }
//
//    public void initViews() {
//      //  if (getSupportActionBar() != null) {
//            //toolbar.setTitle("NauApp");
//        //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////        tabMoodle.setText("Moodle");
////        tabNews.setText("News");
////        tabStudent.setText("Student");
//        }
//
//    }
//
//
//    //protected abstract void setSupportActionBar(CoordinatorLayout toolbar);
//
////    protected abstract @LayoutRes int getLayout();
//
//}

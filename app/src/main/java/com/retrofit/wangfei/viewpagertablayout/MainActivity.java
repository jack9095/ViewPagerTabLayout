package com.retrofit.wangfei.viewpagertablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.retrofit.wangfei.viewpagertablayout.adapter.SectionsPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android Studio
 * User: fei.wang
 * Date: 2016-04-14
 * Time: 9:57
 * QQ: 929728742
 * Description: ViewPager和TabLayout结合使用
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.container)
    ViewPager mViewpager;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),this);
        mViewpager.setOffscreenPageLimit(3);//设置viewpager预加载页面数
        mViewpager.setAdapter(sectionsPagerAdapter);  // 给Viewpager设置适配器

        mViewpager.setCurrentItem(1); // 设置当前显示在哪个页面

        mTabLayout.setupWithViewPager(mViewpager);

        // AppBar的监听
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int maxScroll = appBarLayout.getTotalScrollRange();
                float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
                toolbar.setBackgroundColor(Color.argb((int) (percentage * 255), 19, 121, 214));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.toolbar, R.id.tabs, R.id.container, R.id.fab})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar:
                break;
            case R.id.tabs:
                break;
            case R.id.container:
                break;
            case R.id.fab:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
        }
    }
}

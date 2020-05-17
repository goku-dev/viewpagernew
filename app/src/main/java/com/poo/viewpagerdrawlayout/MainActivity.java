package com.poo.viewpagerdrawlayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.poo.viewpagerdrawlayout.adapter.StoryAdapter;
import com.poo.viewpagerdrawlayout.entity.StoryEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = CommonUtils.class.getName();
    private List<StoryEntity> listData;
    private StoryAdapter adapter;
    private TextView tvPage;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        tvPage = findViewById(R.id.tv_page);

        viewPager = findViewById(R.id.vp_new);
        adapter = new StoryAdapter(this, listData);
        //lắng nghe sự thay đổi page
        viewPager.addOnPageChangeListener(new StoryPageChangeAdapter() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tvPage.setText(String.format("%s/%s", position + 1, listData.size()));
            }
        });

       viewPager.setAdapter(adapter);
        initData();




    }

    private void initData() {
        int currentPositionStory = CommonUtils.getInstance().getPositionStory();
        tvPage.setText(currentPositionStory+"/"+listData.size());
        viewPager.setCurrentItem(currentPositionStory);
    }

    private void initView() {
        listData = CommonUtils.getInstance().getStories();
        Log.i(TAG, "" + listData.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CommonUtils.getInstance().savePositionStory(viewPager.getCurrentItem());

    }




}

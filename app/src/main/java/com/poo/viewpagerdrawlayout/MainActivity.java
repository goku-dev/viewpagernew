package com.poo.viewpagerdrawlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.poo.viewpagerdrawlayout.adapter.StoryAdapter;
import com.poo.viewpagerdrawlayout.entity.StoryEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = CommonUtils.class.getName();
    private List<StoryEntity> listData;
    private StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        ViewPager viewPager = findViewById(R.id.vp_new);
        adapter = new StoryAdapter(this, listData);
        viewPager.setAdapter(adapter);
    }

    private void initView() {
       listData =CommonUtils.getInstance().getStories();
        Log.i(TAG,""+listData.toString());
    }
}

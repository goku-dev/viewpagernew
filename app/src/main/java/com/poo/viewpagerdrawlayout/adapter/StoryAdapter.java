package com.poo.viewpagerdrawlayout.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.poo.viewpagerdrawlayout.R;
import com.poo.viewpagerdrawlayout.entity.StoryEntity;

import java.util.List;

public class StoryAdapter extends PagerAdapter {
    private Context context;
    private List<StoryEntity> listData;

    public StoryAdapter(Context context, List<StoryEntity> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup viewPager, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_view, null);

        TextView tvName = itemView.findViewById(R.id.tv_name);
        TextView tvContent = itemView.findViewById(R.id.tv_content);


        StoryEntity entity = listData.get(position);


        tvName.setText(entity.getName());
        tvContent.setText(entity.getContent());

        viewPager.addView(itemView);
        return itemView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup viewPager, int position, @NonNull Object object) {
        viewPager.removeView((View) object);
    }
}

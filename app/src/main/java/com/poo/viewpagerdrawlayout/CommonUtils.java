package com.poo.viewpagerdrawlayout;

import android.util.Log;

import com.poo.viewpagerdrawlayout.entity.StoryEntity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    private static final String STORY_PATH = "Story.txt";
    private static final String TAG = CommonUtils.class.getName() ;
    private static CommonUtils instance;

    private CommonUtils() {
    }

    public static CommonUtils getInstance() {
        if (instance == null) {
            instance = new CommonUtils();
        }
        return instance;
    }

    public List<StoryEntity> getStories() {
        List<StoryEntity> listStorys = new ArrayList<>();
        try {
            InputStream in = App.getInstance().getAssets().open(STORY_PATH);
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            String name = null, content = null;
            String line = buf.readLine();
            while (line != null) {
                if (name == null) {
                    name = line;

                } else if (line.contains("','0');")) {
                    StoryEntity story = new StoryEntity(name, content);
                    listStorys.add(story);
                    name="";
                    content="";
                } else {
                    content += line+"\n";

                }
                line = buf.readLine();
            }
            buf.close();
            in.close();
            Log.i(TAG,"list"+listStorys.size());
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listStorys;
    }
}

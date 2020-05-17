package com.poo.viewpagerdrawlayout.entity;

import androidx.annotation.NonNull;

public class StoryEntity {
    private String name,content;

    public StoryEntity(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @NonNull
    @Override
    public String toString() {
        return name+"\n"+content;
    }
}

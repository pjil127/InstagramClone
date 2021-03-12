package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("iOiQm5uBuRI93paUDnmoHNJwohQxbheMbkfnQBt7")
                .clientKey("oW5xlPmRlWuAldQHEnaMCp6rgncQ0PUkhXIrkV9Q")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

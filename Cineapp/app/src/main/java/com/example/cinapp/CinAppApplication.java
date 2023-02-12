package com.example.cinapp;

import android.app.Application;

import com.example.cinapp.data.persistance.Entity.AppDatabase;
import com.example.cinapp.data.persistance.MediaDatabase;

public class CinAppApplication extends Application {

        @Override
        public void onCreate() {
            super.onCreate();
            AppDatabase.initialize(this);
        }
}

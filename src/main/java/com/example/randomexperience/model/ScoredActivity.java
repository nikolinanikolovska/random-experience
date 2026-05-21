package com.example.randomexperience.model;

public class ScoredActivity {

    private Activity activity;
    private int score;

    public ScoredActivity(Activity activity, int score) {
        this.activity = activity;
        this.score = score;
    }

    public Activity getActivity() {
        return activity;
    }

    public int getScore() {
        return score;
    }
}
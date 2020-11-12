package com.timac.ui_testing;


import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_isActivityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_visibility_title_nextButton() {
        onView(withId(R.id.activity_main_title))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btn_next_activity))
                .check(matches(isDisplayed()));     // Method 1 to test Visibility
    }

    @Test
    public void button_nextActivity() {
        onView(withId(R.id.btn_next_activity))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))); // Method 2 to test Visibility
    }

    @Test
    public void test_isTitleTextDisplayed() {
        onView(withId(R.id.activity_main_title))
                .check(matches(withText(R.string.text_mainactivity)));
    }
}
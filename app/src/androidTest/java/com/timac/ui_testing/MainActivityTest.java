package com.timac.ui_testing;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void test_navSecondaryActivity() {
        onView(withId(R.id.btn_next_activity))
                .perform(click());
        onView(withId(R.id.secondary))
                .check(matches(isDisplayed()));
    }

    @Test
    public void test_backPress_toMainActivity() {
        onView(withId(R.id.btn_next_activity))
                .perform(click());
        onView(withId(R.id.secondary))
                .check(matches(isDisplayed()));
        onView(withId(R.id.btn_back_activity))
                .perform(click());      //Method 1
        onView(withId(R.id.main))
                .check(matches(isDisplayed()));
    }

    @Test
    public void test_backPress_toMainActivity_method2() {
        onView(withId(R.id.btn_next_activity))
                .perform(click());
        pressBack();
        onView(withId(R.id.main))
                .check(matches(isDisplayed()));
    }
}
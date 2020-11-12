package com.timac.ui_testing;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SecondaryActivityTest {

    @Rule
    public ActivityScenarioRule<SecondaryActivity> activityRule =
            new ActivityScenarioRule<>(SecondaryActivity.class);

    @Test
    public void test_isActivityInView() {
        onView(withId(R.id.secondary)).check(matches(isDisplayed()));
    }

    @Test
    public void test_visibility_title_backButton() {
        onView(withId(R.id.activity_secondary_title))
                .check(matches(isDisplayed()));

        onView(withId(R.id.btn_back_activity))
                .check(matches(isDisplayed()));
    }
    @Test
    public void test_isTitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title))
                .check(matches(withText(R.string.text_secondaryactivity)));
    }

}
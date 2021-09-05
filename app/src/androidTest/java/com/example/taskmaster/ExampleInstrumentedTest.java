package com.example.taskmaster;

import android.content.Context;

import androidx.test.espresso.Espresso;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSettingsBtnAndSettingsPage() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.taskmaster", appContext.getPackageName());

        onView(withId(R.id.settingsButton)).perform(click());
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("mohammad"),
                closeSoftKeyboard());
        onView(withId(R.id.btnPersonName)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.settingsText)).check(matches(withText("mohammad  tasks ")));
    }
    @Test public void testBtnAddTaskAndAllTask(){

        onView(withId(R.id.addTask)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.allTask)).perform(click());


    }
    @Test public void testRecycleViewerOnIPressInTask1InHomePage(){
        onView(withId(R.id.title1)).perform(click());

        onView(withId(R.id.taskTitle)).check(matches(withText("task 1")));
        onView(withId(R.id.taskBody)).check(matches(withText("body")));
        onView(withId(R.id.taskState)).check(matches(withText("in progress")));
    }
}
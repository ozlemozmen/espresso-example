package com.ozlem.espressoexample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {

    private String newString;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        newString = "espresso test";
    }

    @Test
    public void tests() {

        onView(withId(R.id.ev1))
                .perform(typeText(newString), closeSoftKeyboard());
        onView(withId(R.id.button1)).perform(click());
        onView(withId(R.id.ev1))
                .check(matches(withText("new string: " + newString)));


        onView(allOf(withId(R.id.ev1), withText("new string: " + newString)))
                .check(matches(withText("new string: " + newString)));


        onView(allOf(withId(R.id.ev1), not(withText("a"))))
                .check(matches(withText("new string: " + newString)));


    }



}
package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.inputmethod.InputMethodManager;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<CreateContactAcitivity> mActivityRule = new ActivityTestRule<>(CreateContactAcitivity.class);
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.

        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    @Test
    public void check(){
        onView(withId(R.id.name)).perform(typeText("Lile"));
        onView(withId(R.id.bn)).perform(typeText("123456789"));
        onView(withId(R.id.pb)).perform(typeText("Fisher"));
        onView(withId(R.id.addr)).perform(typeText("Halifax"));
        onView(withId(R.id.pt)).perform(typeText("NS"));


    }
    @Test
    public void check2(){
        onView(withId(R.id.name)).perform(typeText("Vivian"));
        onView(withId(R.id.bn)).perform(typeText("99999999"));
        onView(withId(R.id.pb)).perform(typeText("Processor"));
        onView(withId(R.id.addr)).perform(typeText("fdsrf"));
        onView(withId(R.id.pt)).perform(typeText("YT"));


    }
    @Test
    public void check3(){
        onView(withId(R.id.name)).perform(typeText("Tom"));
        onView(withId(R.id.bn)).perform(typeText("888888888"));
        onView(withId(R.id.pb)).perform(typeText("Distributor"));
        onView(withId(R.id.addr)).perform(typeText("sfdrw"));
        onView(withId(R.id.pt)).perform(typeText("NT"));


    }
}

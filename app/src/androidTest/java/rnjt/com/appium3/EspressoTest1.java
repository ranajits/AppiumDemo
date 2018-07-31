package rnjt.com.appium3;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest1 extends ActivityInstrumentationTestCase2<MainActivity> {

        public EspressoTest1() {
            super(MainActivity.class);
        }

        @Before
         public void setUp() throws Exception {
            super.setUp();
            injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        }

        @Test
        public void test1ChatId() {
            getActivity();
            onView(withText("Hello world")/*withId(R.id.anuja)*/).check(matches(isDisplayed()));
        }

        @After
        public void tearDown() throws Exception {
            super.tearDown();
        }
}
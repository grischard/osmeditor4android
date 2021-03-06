package de.blau.android;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import de.blau.android.presets.Preset;

/**
 * This is just a convenient way of generating the default preset dump
 * 
 * @author simon
 *
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class TaginfoDump {

    @Rule
    public ActivityTestRule<Main> mActivityRule = new ActivityTestRule<>(Main.class);

    /**
     * Pre-test setup except this isn't really a test
     */
    @Before
    public void setup() {
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        Main main = mActivityRule.getActivity();
        TestUtils.grantPermissons(device);
        TestUtils.dismissStartUpDialogs(device, main);
    }

    /**
     * Write out the current preset in taginfo format
     */
    @Test
    public void dump() {
        Assert.assertTrue(Preset.generateTaginfoJson(InstrumentationRegistry.getInstrumentation().getTargetContext(), "taginfo.json"));
    }
}

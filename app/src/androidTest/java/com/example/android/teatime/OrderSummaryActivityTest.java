/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.teatime;

import android.app.Activity;
import android.content.Intent;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static android.app.Instrumentation.ActivityResult;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.intent.matcher.IntentMatchers.isInternal;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class) // annotation to specify AndroidJUnitRunner class as the default test runner
public class OrderSummaryActivityTest {

    private static final String emailMessage =
            "I just ordered a delicious tea from TeaTime. Next time you are craving a tea, check them out!";

    // rule that indicates we want to use Espresso-Intents APIs in functional UI tests
    @Rule
    public IntentsTestRule<OrderSummaryActivity> mActivityRule = new IntentsTestRule<>(
            OrderSummaryActivity.class);

    // block all external intents
    @Before
    public void stubAllExternalIntents() {
        intending(not(isInternal())).respondWith(new ActivityResult(Activity.RESULT_OK, null));
    }

    // verifies that the intent sent by clicking the send email
    // button matches the intent sent by the application
    @Test
    public void clickSendEmailButton_SendsEmail() {
        // click on the send email button
        onView(withId(R.id.send_email_button)).perform(click());
        // assert the given matcher matches one and only one
        // intent sent by the application.
        intended(allOf(
                hasAction(Intent.ACTION_SENDTO),
                hasExtra(Intent.EXTRA_TEXT, emailMessage)));
    }
}
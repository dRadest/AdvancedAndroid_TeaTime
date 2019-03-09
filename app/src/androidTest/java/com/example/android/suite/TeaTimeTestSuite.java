package com.example.android.suite;

import com.example.android.teatime.IdlingResourceMenuActivityTest;
import com.example.android.teatime.MenuActivityScreenTest;
import com.example.android.teatime.OrderActivityBasicTest;
import com.example.android.teatime.OrderSummaryActivityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        OrderActivityBasicTest.class,
        MenuActivityScreenTest.class,
        OrderSummaryActivityTest.class,
        IdlingResourceMenuActivityTest.class})
public class TeaTimeTestSuite {
}

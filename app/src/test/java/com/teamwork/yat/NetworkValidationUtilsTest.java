package com.teamwork.yat;

import android.content.Context;

import com.teamwork.yat.ui.utils.NetworkValidationUtils;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.Assert.assertTrue;

public class NetworkValidationUtilsTest {

    @Test
    public void testNetworkAvailable() {
        Context context = Mockito.mock(Context.class);
        assertTrue(NetworkValidationUtils.isNetworkAvailable(context));
    }

}

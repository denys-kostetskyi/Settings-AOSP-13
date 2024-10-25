package com.android.settings;

import android.content.Context;
import android.util.Log;
import com.android.settings.core.BasePreferenceController;
import androidx.annotation.VisibleForTesting;
import androidx.preference.Preference;

public class CustomSettingsController extends BasePreferenceController {
    
    private static final String TAG = "CustomSettingsController";

    @VisibleForTesting
    static final String KEY_CUSTOM_GENERAL_SETTINGS_CATEGORY = "custom_general_settings_category";

    public CustomSettingsController(Context context) {
        super(context, KEY_CUSTOM_GENERAL_SETTINGS_CATEGORY);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }
}

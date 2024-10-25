package com.android.settings;

import android.os.Bundle;
import android.util.Log;
import android.content.Context;
import android.provider.SearchIndexableResource;

import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.search.Indexable;
import com.android.settingslib.search.SearchIndexable;
import com.android.settingslib.search.SearchIndexableRaw;
import android.app.settings.SettingsEnums;
import android.provider.SearchIndexableResource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SearchIndexable(forTarget = SearchIndexable.ALL)
public class CustomSettingsFragment extends DashboardFragment {

    private static final String TAG = "CustomSettingsFragment";

    private static List<AbstractPreferenceController> buildPreferenceControllers(Context context) {
        final List<AbstractPreferenceController> controllers = new ArrayList<>();
        controllers.add(new CustomSettingsController(context));
        return controllers;
    }

    @Override
    public int getMetricsCategory() {
        return SettingsEnums.SETTINGS_SYSTEM_CATEGORY;
    }
    
    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    protected int getPreferenceScreenResId() {
        return R.xml.custom_settings_fragment;
    }

    @Override
    protected List<AbstractPreferenceController> createPreferenceControllers(Context context) {
        return buildPreferenceControllers(context);
    }

    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = new BaseSearchIndexProvider() {
        @Override
        public List<SearchIndexableResource> getXmlResourcesToIndex(Context context, boolean enabled) {
            final SearchIndexableResource sir = new SearchIndexableResource(context);
            sir.xmlResId = R.xml.custom_settings_fragment;
            Log.d(TAG, "getXmlResourcesToIndex called! " + sir.toString());
            return Arrays.asList(sir);
        }

        @Override
        public List<AbstractPreferenceController> createPreferenceControllers(Context context) {
            return buildPreferenceControllers(context);
        }
    };
}

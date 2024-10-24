package com.android.settings;

import android.os.Bundle;
import android.content.Context;
import android.provider.SearchIndexableResource;

import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

import com.android.settings.R;
import com.android.settings.dashboard.DashboardFragment;
import com.android.settings.search.BaseSearchIndexProvider;
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

    public static final SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = new BaseSearchIndexProvider() {
        /*@Override
        public List<SearchIndexableResource> getXmlResourcesToIndex(Context context, boolean enabled) {
            final SearchIndexableResource sir = new SearchIndexableResource(context);
            sir.xmlResId = R.xml.custom_settings_fragment;
            return Arrays.asList(sir);
        }*/

        @Override
        public List<SearchIndexableRaw> getRawDataToIndex(Context context, boolean enabled) {
            final List<SearchIndexableRaw> result = new ArrayList<>();
            SearchIndexableRaw data = new SearchIndexableRaw(context);
            data.title = context.getString(R.string.custom_general_settings);
            data.screenTitle = context.getString(R.string.custom_general_settings);
            data.keywords = context.getString(R.string.custom_general_settings_keywords);
            data.key = "custom_general_settings_category";
            result.add(data);
            return result;
        }
    };
}

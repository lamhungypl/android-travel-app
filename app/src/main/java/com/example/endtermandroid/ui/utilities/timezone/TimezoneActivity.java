//package com.lhypl.drawerapp.ui.utilities.timezone;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.AutoCompleteTextView;
//import android.widget.TextClock;
//
//import com.lhypl.drawerapp.R;
//import com.lhypl.drawerapp.adapters.TimezoneAdapter;
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.Objects;
//import java.util.TimeZone;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//public class TimezoneActivity extends AppCompatActivity implements TimezoneView{
//
//    @BindView(R.id.clockAnalog)
//    CustomClock mAnalogClock;
//
//    @BindView(R.id.clockDigital)
//    TextClock mTextClock;
//
//    @BindView(R.id.inputTimezone)
//    AutoCompleteTextView mAutoCompleteTextViewTimezone;
//
//    public static Intent getStartIntent(Context context) {
//        return new Intent(context, TimezoneActivity.class);
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timezone);
//        ButterKnife.bind(this);
//        setTitle("World clock");
//
//        // AutoCompleteTextView initialization
//        TimezoneAdapter mAdapter = new TimezoneAdapter(this, Arrays.asList(TimeZone.getAvailableIDs()));
//        this.mAutoCompleteTextViewTimezone.setAdapter(mAdapter);
//        this.mAutoCompleteTextViewTimezone.setOnItemClickListener((parent, view, position, id) -> TimezoneActivity.this.onItemAutocompleteItemSelected());
//
//        // Analog Clock Initialization
//        mAnalogClock.init(TimezoneActivity.this, R.drawable.clock_face,
//                R.drawable.clock_hours_hand, R.drawable.clock_minutes_hand,
//                0, false, false);
//
//        mAnalogClock.setScale(1f);
//        // analog clock size
//
//        // Initialize data with default timezone
//        this.setSelectedText(TimeZone.getDefault());
//
//
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    /**
//     * This function gets the time from the time zone that user have chosen.
//     *TimezoneAdapter
//     * @param timezone
//     */
//    private void setSelectedText(TimeZone timezone) {
//        this.mTextClock.setTimeZone(timezone.getID());
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.HOUR, -2);
//        this.mAnalogClock.setTime(calendar);
//        this.mAnalogClock.setTimezone(timezone);
//    }
//
//    /**
//     * Method triggered when the user selects
//     * a timezone from the list
//     */
//    private void onItemAutocompleteItemSelected() {
//
//
//    }
//
//
//
//
//}

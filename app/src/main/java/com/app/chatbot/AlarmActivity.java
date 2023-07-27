package com.app.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    Button addTimeBtn, setTimeBtn, cencelTimeBtn;
    TimePicker time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        time = findViewById(R.id.timePick);
        addTimeBtn = findViewById(R.id.addTime);
        setTimeBtn = findViewById(R.id.setTime);
        cencelTimeBtn = findViewById(R.id.cencelTime);

        addTimeBtn.setOnClickListener((v)-> addTime());
        cencelTimeBtn.setOnClickListener((v)-> cancelTime());
    }

    private void addTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),
                time.getHour(),
                time.getMinute(),0);
        setTime(cal.getTimeInMillis());
    }

    private void setTime(long timeInMillis) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent);
        Toast.makeText(this, "Your Alarm is Set", Toast.LENGTH_LONG).show();
    }

    void cancelTime(){
        finish();
        System.exit(0);
    }
}
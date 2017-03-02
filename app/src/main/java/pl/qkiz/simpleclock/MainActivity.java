package pl.qkiz.simpleclock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView TimeTxtView = (TextView) findViewById(R.id.textView3);
        TimeTxtView.setText(czas());
        Thread TimeThread = new Thread() {
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView TimeTxtView = (TextView) findViewById(R.id.textView3);
                                TimeTxtView.setText(czas());
                            }
                        });
                    }
                } catch (InterruptedException e) {}
            }
        };
        TimeThread.start();


    }
    public String czas() {
        Calendar TimeNow = Calendar.getInstance();
        String TimeFormat = "HH:mm:ss";
        CharSequence TimeSeq = DateFormat.format(TimeFormat,TimeNow);
        String TimeResult = TimeSeq.toString();
        return TimeResult;
    }
}

package com.myweb.autocall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AutoCallActivity extends AppCompatActivity {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_call);
        mContentView = findViewById(R.id.start);

        final Button startButton = (Button) findViewById(R.id.start_button);
        final TextView startInfo = (TextView) findViewById(R.id.start_info);
        final EditText time = (EditText) findViewById(R.id.time);
        final CheckBox sendMessage = (CheckBox) findViewById(R.id.send_message);
        final EditText message = (EditText) findViewById(R.id.message);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButton.getText().equals("开始")) {
                    startInfo.setText("程序启动，开始自动拨号！"+ sendMessage.isChecked() + message.getText());
                    startButton.setText("停止");
                } else {
                    startInfo.setText("程序停止，停止自动拨号！" + time.getText());
                    startButton.setText("开始");
                }
            }
        });
    }
}

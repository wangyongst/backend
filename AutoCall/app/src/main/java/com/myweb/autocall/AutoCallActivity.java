package com.myweb.autocall;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

public class AutoCallActivity extends AppCompatActivity {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_call);
        mContentView = findViewById(R.id.start);

        File file = new File("AutoCall");
        if (!file.exists()) {
            file.mkdir();
        }
        final Button startButton = (Button) findViewById(R.id.start_button);
        final TextView startInfo = (TextView) findViewById(R.id.start_info);
        final EditText time = (EditText) findViewById(R.id.time);
        final CheckBox sendMessage = (CheckBox) findViewById(R.id.send_message);
        final EditText message = (EditText) findViewById(R.id.message);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startButton.getText().equals("开始")) {

                    String phoneNumber = null;
                    try {
                        phoneNumber = ExcelUtil.gePhoneNumbertXlsData().getNumber();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (phoneNumber == null) {
                        startInfo.setText("读取电话号码失败，程序结束！");
                        startButton.setText("开始");
                        return;
                    }
                    startInfo.setText("程序启动，开始自动拨号！");
                    startButton.setText("停止");

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:" + phoneNumber);
                    intent.setData(data);
                    startInfo.setText("正在拨打号码：" + phoneNumber);
                    startActivity(intent);
                    OpenSpeaker();
                } else {
                    startInfo.setText("程序停止，停止自动拨号！");
                    startButton.setText("开始");
                }
            }
        });
    }

    public void OpenSpeaker() {

        try {
            AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            audioManager.setMode(AudioManager.ROUTE_SPEAKER);
            audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
            if (!audioManager.isSpeakerphoneOn()) {
                audioManager.setSpeakerphoneOn(true);
                audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL,
                        audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL),
                        AudioManager.STREAM_VOICE_CALL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playAudio() {
        AudioManager am = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                    // Pause playback (during incoming call)
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    // Resume playback (incoming call ends)
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                am.unregisterMediaButtonEventReceiver(RemoteControlReceiver);
//                am.abandonAudioFocus(afChangeListener);
                    // Stop playback (when any other app playing music  in that situation current app stop the audio)
                }
            }
        };
    }


    //关闭扬声器

    public void CloseSpeaker() {

        try {
            AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            if (audioManager != null) {
                if (audioManager.isSpeakerphoneOn()) {
                    audioManager.setSpeakerphoneOn(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

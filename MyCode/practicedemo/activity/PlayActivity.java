package net.cyq.italker.practicedemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hussar.core.HussarPlayer;
import com.hussar.core.IHussarPlayer;

import net.cyq.italker.practicedemo.R;

public class PlayActivity extends AppCompatActivity {
    private static String path = "http://120.25.226.186:32812/resources/videos/minion_01.mp4";
    private HussarPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        player = (HussarPlayer) findViewById(R.id.player);
        player.setAutoFullScreen(true);
        player.setConfig(IHussarPlayer.ConfigKey.CONFIG_PLAYER_FIRST_HIGHT_WARTER_MARK_MS, 2 * 1000);//设置首次缓冲时间
        player.getLayoutParams().height = getScreenWidth(this) * 9 / 16;
        player.setHussarPlayerListener(new IHussarPlayer.IHussarPlayerListener() {
            @Override
            public void onPrepared() {

            }

            @Override
            public void onRenderStart() {

            }

            @Override
            public void onStart() {

            }

            @Override
            public void onPause() {

            }

            @Override
            public void onBufferingStart(IHussarPlayer.HussarBufferType hussarBufferType) {

            }

            @Override
            public void onBuffering(int i) {

            }

            @Override
            public void onBufferingEnd() {

            }

            @Override
            public void onSeekComplete(int i) {

            }

            @Override
            public void onCompletion() {

            }

            @Override
            public boolean onError(int i, int i1) {
                return false;
            }
        });

        player.setHussarViewListener(new IHussarPlayer.IHussarViewListener() {
            @Override
            public void onButtonClickEvent(IHussarPlayer.HussarPlayerButtonEvent buttonEvent) {
                switch (buttonEvent) {
                    case HussarPlayerButtonPause:
                        Log.d("test", "HussarPlayerButtonPause");
                        break;
                    case HussarPlayerButtonPlay:
                        Log.d("test", "HussarPlayerButtonPlay");
                        break;
                    case HussarPlayerButtonSeek:
                        Log.d("test", "HussarPlayerButtonSeek");
                        break;
                    case HussarPlayerButtonStop:
                        Log.d("test", "HussarPlayerButtonStop");
                        break;
                }
            }
        });

        player.initWithURL(path);

//        player.getPlaybackTime();
    }

    /**
     * 获取屏幕宽度xp
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null) {
            player.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.onPause();
        }
    }
}

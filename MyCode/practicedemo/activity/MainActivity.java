package net.cyq.italker.practicedemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.cyq.italker.practicedemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_pic_scan)
    Button picScanBtn;

    @BindView(R.id.btn_BRVAH)
    Button BRVAH;

    @BindView(R.id.btn_play)
    Button playDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        picScanBtn.setOnClickListener(this);
        BRVAH.setOnClickListener(this);
        playDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_pic_scan:
                intent.setClass(this, PicScanActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_BRVAH:
                intent.setClass(this, BRVAHActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_play:
                intent.setClass(this, PlayActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

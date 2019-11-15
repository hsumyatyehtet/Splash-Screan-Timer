package hmyh.test.splashactivitycircleindicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SplashPagerAdapter adapter;
    private int[] image;
    private TabLayout indicator;
    private ImageView ivClose;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_main);

        viewPager = findViewById(R.id.viewPager);
        indicator = findViewById(R.id.indicator);

        ivClose = findViewById(R.id.iv_cloase);

        image = new int[]{R.drawable.splash_one, R.drawable.splash_two, R.drawable.splash_three};

        adapter = new SplashPagerAdapter(SplashActivity.this, image);
        viewPager.setAdapter(adapter);
        indicator.setupWithViewPager(viewPager, true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 1500, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(splashIntent);
                SplashActivity.this.finish();
            }
        }, Integer.MAX_VALUE);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private class SliderTimer extends TimerTask {

        @Override
        public void run() {
            SplashActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() < image.length - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}

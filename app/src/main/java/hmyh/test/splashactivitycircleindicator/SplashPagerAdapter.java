package hmyh.test.splashactivitycircleindicator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SplashPagerAdapter extends PagerAdapter {

    int[] image;
    LayoutInflater inflater;
    Context context;
    int position = 3;

    public SplashPagerAdapter(SplashActivity activity, int[] image) {
        this.context = activity;
        this.image = image;
    }

    @Override
    public int getCount() {
        return image.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.splash_item_slider, null);
        imageView = itemView.findViewById(R.id.splash_item_image);
        imageView.setImageResource(image[position]);

        container.addView(itemView, 0);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

//    @Override
//    public float getPageWidth(int position) {
//        return .20f;
//    }
}

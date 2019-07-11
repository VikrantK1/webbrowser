package com.vikrant.webbrowser;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class imageViewAdapter extends PagerAdapter {
    Context mcontext;
    imageViewAdapter(Context mcontext)
    {
        this.mcontext=mcontext;
    }
    @Override
    public int getCount() {
        return imgid.length;
    }

    private Integer []imgid={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7};


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       ImageView imageView=new ImageView(mcontext);
       imageView.setScaleType(ImageView.ScaleType.FIT_XY);
       imageView.setImageResource(imgid[position]);
        container.addView(imageView,0);

     return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView)object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((ImageView)object);
    }
}

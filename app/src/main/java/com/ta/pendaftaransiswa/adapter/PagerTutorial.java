package com.ta.pendaftaransiswa.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ta.pendaftaransiswa.R;
import com.ta.pendaftaransiswa.model.TutorialModel;

import java.util.List;

public class PagerTutorial extends PagerAdapter {
    private List<TutorialModel> models;
    private Context context;
    private LayoutInflater layoutInflater;

    public PagerTutorial(List<TutorialModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_tutorial, container, false);
        ImageView imageView;
        imageView = view.findViewById(R.id.imgTutorial);


        imageView.setImageResource(models.get(position).getGambar());
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

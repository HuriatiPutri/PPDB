package com.ta.pendaftaransiswa;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ta.pendaftaransiswa.adapter.PagerTutorial;
import com.ta.pendaftaransiswa.model.TutorialModel;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivity extends AppCompatActivity {

    List<TutorialModel> modelList;
    PagerTutorial adapter;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        modelList = new ArrayList<>();

        modelList.add(new TutorialModel(R.mipmap.tutorial1));
        modelList.add(new TutorialModel(R.mipmap.tutorial2));
        modelList.add(new TutorialModel(R.mipmap.tutorial3));
        modelList.add(new TutorialModel(R.mipmap.tutorial4));

        adapter = new PagerTutorial(modelList, getApplicationContext());
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        skip = findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

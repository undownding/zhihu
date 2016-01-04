package me.undownding.zhihu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.undownding.zhihu.api.ZhihuApi;
import me.undownding.zhihu.binding.RecyclerViewUtil;
import me.undownding.zhihu.model.StoryList;
import retrofit.RestAdapter;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.recyclyer_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Not work ???
//        ButterKnife.bind(this);
        toolbar = ButterKnife.findById(this, R.id.toolbar);
        recyclerView = ButterKnife.findById(this, R.id.recyclyer_view);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerViewUtil.Companion.initRecyclerView(recyclerView);
    }

    public void onClick(View view) {
        // do nothing
    }
}

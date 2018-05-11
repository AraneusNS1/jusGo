package com.logicchip.blog_14_floatingsearchview;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private SearchView searchViewQuery;
    private ImageButton imageViewSearchMenu;
    private CoordinatorLayout cordinatorLayoutActivityA;
    private RecyclerView recycleViewNews;
    private RecyclerView.Adapter mAdapter;
    private NestedScrollView nestedScrollView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchViewQuery = (SearchView)findViewById(R.id.searchViewQuery);
        imageViewSearchMenu = (ImageButton) findViewById(R.id.imageViewSearchMenu);
        cordinatorLayoutActivityA = (CoordinatorLayout) findViewById(R.id.cordinatorLayoutActivityA);
        //nestedScrollView=(NestedScrollView)findViewById(R.id.nestedScrollView);


        EditText searchEditText = (EditText) searchViewQuery.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(ResourcesCompat.getColor(getResources(),R.color.colorPrimaryText,null));
        searchEditText.setHintTextColor(ResourcesCompat.getColor(getResources(),R.color.colorSecondaryText,null));

        ImageView searchImage = (ImageView) searchViewQuery.findViewById(android.support.v7.appcompat.R.id.search_mag_icon);
        searchImage.setVisibility(View.GONE);
        ViewGroup linearLayoutSearchView =(ViewGroup) searchImage.getParent();
        linearLayoutSearchView.removeView(searchImage);
        linearLayoutSearchView.addView(searchImage);
        searchImage.setAdjustViewBounds(true);
        searchImage.setMaxWidth(0);
        searchImage.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        searchImage.setImageDrawable(null);

        /*
        recycleViewNews = (RecyclerView)findViewById(R.id.recycleView);
        recycleViewNews.setHasFixedSize(true);
        recycleViewNews.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AdapterForRecycle(this);
        recycleViewNews.setAdapter(mAdapter);
        recycleViewNews.setNestedScrollingEnabled(false);
*/

    }


    public void PopupShowMenu(View view){
        PopupMenu popup = new PopupMenu(this, imageViewSearchMenu);
        popup.getMenuInflater().inflate(R.menu.menu_main, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int i = item.getItemId();
                if(i == R.id.action_settings){
                    SnackBarMessage("Click");
                    return true;
                }else{
                    return onMenuItemClick(item);
                }



            }
        });
        popup.show();
    }

    public void SnackBarMessage(String message){
        Snackbar.make(cordinatorLayoutActivityA, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package top.wuhaojie.zhd.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;
import top.wuhaojie.zhd.home.main.MainFragment;
import top.wuhaojie.zhd.home.theme.ThemeFragment;

public class HomeActivity extends BaseActivity implements HomeView {

    HomePresenter mHomePresenter;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;
    @BindView(R.id.rv_nav)
    RecyclerView mRvNav;
    private HomeNavigationAdapter mHomeNavigationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomePresenter = new HomePresenter(this);
        mHomePresenter.bindView(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        mHomeNavigationAdapter = new HomeNavigationAdapter(this);
        mHomeNavigationAdapter.setListener(mHomePresenter);

        mRvNav.setLayoutManager(new LinearLayoutManager(this));
        mRvNav.setAdapter(mHomeNavigationAdapter);

        MainFragment mainFragment = MainFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, mainFragment)
                .commit();
        mCurrFragment = mainFragment;

        mHomePresenter.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mHomePresenter.onOptionsItemSelected(item);
    }


    private Fragment mCurrFragment;

    private void switchFragment(FragmentManager fragmentManager, Fragment fragment) {
        if (fragment.isAdded()) {
            fragmentManager
                    .beginTransaction()
                    .hide(mCurrFragment)
                    .show(fragment)
                    .commit();
        } else {
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment, fragment)
                    .hide(mCurrFragment)
                    .show(fragment)
                    .commit();
        }
        mCurrFragment = fragment;
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_home;
    }

    @Override
    public void setNavAdapterList(ArrayList<HomeNavigationAdapter.Item> list) {
        mHomeNavigationAdapter.setList(list);
    }

    @Override
    public void switch2Main() {
        switchFragment(getSupportFragmentManager(), MainFragment.newInstance());
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.app_name));
        }
    }

    @Override
    public void switch2Theme(HomeNavigationAdapter.Others o) {
        ThemeFragment.Argument argument = new ThemeFragment.Argument(o.color, o.thumbnail, o.description, o.id, o.name);
        switchFragment(getSupportFragmentManager(), ThemeFragment.newInstance(argument));
    }

    @Override
    public void closeDrawer() {
        mDrawer.closeDrawer(GravityCompat.START);
    }
}

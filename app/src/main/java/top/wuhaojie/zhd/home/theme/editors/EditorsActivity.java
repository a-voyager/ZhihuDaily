package top.wuhaojie.zhd.home.theme.editors;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.base.BaseActivity;
import top.wuhaojie.zhd.home.theme.adapter.EditorsAdapter;

public class EditorsActivity extends BaseActivity implements EditorsView {


    @BindView(R.id.rv_editors)
    RecyclerView mRvEditors;
    private EditorsAdapter mEditorsAdapter;

    @Override
    public void setEditorsList(ArrayList<EditorsAdapter.Item> items) {
        mEditorsAdapter.setList(items);
    }

    public static class Argument implements Parcelable {
        String url;
        String bio;
        int id;
        String avatar;
        String name;

        public Argument(String url, String bio, int id, String avatar, String name) {
            this.url = url;
            this.bio = bio;
            this.id = id;
            this.avatar = avatar;
            this.name = name;
        }

        Argument(Parcel in) {
            url = in.readString();
            bio = in.readString();
            id = in.readInt();
            avatar = in.readString();
            name = in.readString();
        }

        public static final Creator<Argument> CREATOR = new Creator<Argument>() {
            @Override
            public Argument createFromParcel(Parcel in) {
                return new Argument(in);
            }

            @Override
            public Argument[] newArray(int size) {
                return new Argument[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(url);
            dest.writeString(bio);
            dest.writeInt(id);
            dest.writeString(avatar);
            dest.writeString(name);
        }

    }

    private EditorsPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new EditorsPresenter(this);
        mPresenter.bindView(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mEditorsAdapter = new EditorsAdapter(this, EditorsAdapter.MODE_VERTICAL);
        mRvEditors.setLayoutManager(new LinearLayoutManager(this));
        mRvEditors.setAdapter(mEditorsAdapter);

        mPresenter.onCreate(savedInstanceState, getIntent());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_editors;
    }
}

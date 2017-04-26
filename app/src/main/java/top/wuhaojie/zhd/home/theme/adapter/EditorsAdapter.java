package top.wuhaojie.zhd.home.theme.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wuhaojie.lib.image.ImageLoader;
import top.wuhaojie.zhd.R;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/26 11:17
 * Version: 1.0
 */

public class EditorsAdapter extends RecyclerView.Adapter {


    public static final int MODE_HORIZONTAL = 0;
    public static final int MODE_VERTICAL = 1;

    private Context mContext;
    private int mMode = 0;
    private LayoutInflater mInflater;

    public EditorsAdapter(Context context, int mode) {
        mContext = context;
        mMode = mode;
        mInflater = LayoutInflater.from(context);
    }

    public static class Item {
        public String url;
        public String bio;
        public int id;
        public String avatar;
        public String name;

        public Item(String url, String bio, int id, String avatar, String name) {
            this.url = url;
            this.bio = bio;
            this.id = id;
            this.avatar = avatar;
            this.name = name;
        }
    }

    private List<Item> mList = new ArrayList<>();

    public void setList(List<Item> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View v = null;
        switch (mMode) {
            case MODE_HORIZONTAL:
                v = mInflater.inflate(R.layout.item_editor_h, parent, false);
                holder = new HorizontalHolder(v);
                break;
            case MODE_VERTICAL:
                v = mInflater.inflate(R.layout.item_editor_v, parent, false);
                holder = new VerticalHolder(v);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (mMode) {
            case MODE_HORIZONTAL:
                ((HorizontalHolder) holder).setView(mList.get(position));
                break;
            case MODE_VERTICAL:
                ((VerticalHolder) holder).setView(mList.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class HorizontalHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_avatar)
        ImageView mIvAvatar;

        HorizontalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setView(Item it) {
            ImageLoader.get().load(it.avatar, mIvAvatar, ImageLoader.OPTION_CENTER_CROP | ImageLoader.OPTION_CIRCLE_CROP);
        }

    }


    class VerticalHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.iv_avatar)
        ImageView mIvAvatar;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_description)
        TextView mTvDescription;

        VerticalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setView(Item item) {
            ImageLoader.get().load(item.avatar, mIvAvatar, ImageLoader.OPTION_CENTER_CROP | ImageLoader.OPTION_CIRCLE_CROP);
            mTvName.setText(item.name);
            mTvDescription.setText(item.bio);
        }

    }


}

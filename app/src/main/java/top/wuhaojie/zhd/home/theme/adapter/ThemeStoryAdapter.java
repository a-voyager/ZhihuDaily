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
 * Date: 2017/04/27 16:15
 * Version: 1.0
 */

public class ThemeStoryAdapter extends RecyclerView.Adapter {


    private LayoutInflater mInflater;

    public ThemeStoryAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public static class Item {
        int type;
        int id;
        String title;
        String image;

        public Item(int type, int id, String title, String image) {
            this.type = type;
            this.id = id;
            this.title = title;
            this.image = image;
        }
    }

    private List<Item> mList = new ArrayList<>();

    public void setList(List<Item> list) {
        mList.clear();
        mList.addAll(list);
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_normal_list_main, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Holder) holder).setView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.iv_icon)
        ImageView mIvIcon;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setView(Item item) {
            mTvTitle.setText(item.title);
            if (item.type == 2) {
                mIvIcon.setVisibility(View.VISIBLE);
                ImageLoader.get().load(item.image, mIvIcon);
            } else {
                mIvIcon.setVisibility(View.GONE);
            }
        }

    }


}

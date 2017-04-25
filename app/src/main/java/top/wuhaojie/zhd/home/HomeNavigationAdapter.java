package top.wuhaojie.zhd.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wuhaojie.zhd.R;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/25 19:21
 * Version: 1.0
 */

public class HomeNavigationAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private final LayoutInflater mLayoutInflater;
    static final int TYPE_HOME = 1;
    static final int TYPE_SUBSCRIBED = 2;
    static final int TYPE_OTHERS = 3;


    public HomeNavigationAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    static class Item<T> {
        int type;
        T data;

        public Item(int type, T data) {
            this.type = type;
            this.data = data;
        }
    }

    static class Home {
    }

    static class Subscribed {
    }

    static class Others {
        int color;
        String thumbnail;
        String description;
        int id;
        String name = "HHH";
    }


    private List<Item> mList = new ArrayList<>();

    public void setList(List<Item> list) {
        initList();
        mList.addAll(list);
        list.clear();
        notifyDataSetChanged();
    }

    private void initList() {
        mList.clear();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case TYPE_HOME:
                view = mLayoutInflater.inflate(R.layout.item_nav_home, parent, false);
                holder = new HomeHolder(view);
                break;
            case TYPE_SUBSCRIBED:
                break;
            case TYPE_OTHERS:
                view = mLayoutInflater.inflate(R.layout.item_nav_others, parent, false);
                holder = new OthersHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_SUBSCRIBED:
                break;
            case TYPE_OTHERS:
                OthersHolder h = (OthersHolder) holder;
                h.setView((Others) mList.get(position).data);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;
    }


    public interface OnNavItemClickListener {
        void onHomeItemClick();
    }

    private OnNavItemClickListener mListener;

    private class HomeHolder extends RecyclerView.ViewHolder {

        HomeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(v -> {
                if (mListener != null) mListener.onHomeItemClick();
            });
        }
    }

    private class SubscribedHolder extends RecyclerView.ViewHolder {

        SubscribedHolder(View itemView) {
            super(itemView);
        }
    }

    class OthersHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.btn_nav_follow)
        Button mBtnNavFollow;

        OthersHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(Others o) {
            mTvTitle.setText(o.name);
        }

    }

}

package top.wuhaojie.zhd.home.main.adapter;

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
 * Created by wuhaojie on 17-2-11.
 */

public class MainContentListAdapter extends RecyclerView.Adapter {

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;
    private final LayoutInflater mLayoutInflater;


    public static class Item {
        public String title;
        public String imgUrl;
        public int id;
    }

    private List<Item> mList = new ArrayList<>();
    private Context mContext;

    public MainContentListAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<Item> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void append(List<Item> list) {
        int oldIndex = mList.size() - 1;
        int count = list.size();
        mList.addAll(list);
        notifyItemRangeInserted(oldIndex, count);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL) {
            View v = mLayoutInflater.inflate(R.layout.item_normal_list_main, parent, false);
            return new NormalViewHolder(v);
        } else {
            View v = mLayoutInflater.inflate(R.layout.item_footer_list_main, parent, false);
            return new FooterViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_NORMAL) {
            NormalViewHolder h = (NormalViewHolder) holder;
            h.setView(mList.get(position));
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == mList.size()) return TYPE_FOOTER;
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }


    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    class NormalViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.iv_icon)
        ImageView mIvIcon;

        NormalViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onItemClick(mList.get(getAdapterPosition()));
            });
        }

        public void setView(Item item) {
            mTvTitle.setText(item.title);
            ImageLoader.get().load(item.imgUrl, mIvIcon);
        }

    }

    class FooterViewHolder extends RecyclerView.ViewHolder {

        FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

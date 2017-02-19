package top.wuhaojie.zhd.home.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.wuhaojie.lib.image.ImageLoader;
import top.wuhaojie.zhd.R;
import top.wuhaojie.zhd.utils.BannerImageLoader;

/**
 * Created by wuhaojie on 17-2-11.
 */

public class MainContentListAdapter extends RecyclerView.Adapter {

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_HEADER = 2;
    private final LayoutInflater mLayoutInflater;


    public static class Item {
        public String title;
        public String imgUrl;
        public int id;
    }

    private List<Item> mStoryList = new ArrayList<>();
    private List<Item> mBannerList = new ArrayList<>();

    private Context mContext;

    public MainContentListAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setStoryList(List<Item> storyList) {
        mStoryList.clear();
        mStoryList.addAll(storyList);
        notifyDataSetChanged();
    }


    public void setBannerList(List<Item> bannerList) {
        mBannerList.clear();
        mBannerList.addAll(bannerList);
        notifyItemChanged(0);
    }

    public void append(List<Item> list) {
        int oldIndex = mStoryList.size() - 1;
        int count = list.size();
        mStoryList.addAll(list);
        notifyItemRangeInserted(oldIndex, count);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL) {
            View v = mLayoutInflater.inflate(R.layout.item_normal_list_main, parent, false);
            return new NormalViewHolder(v);
        } else if (viewType == TYPE_FOOTER) {
            View v = mLayoutInflater.inflate(R.layout.item_footer_list_main, parent, false);
            return new FooterViewHolder(v);
        } else {
            View v = mLayoutInflater.inflate(R.layout.item_header_list_main, parent, false);
            return new HeaderViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_NORMAL) {
            NormalViewHolder h = (NormalViewHolder) holder;
            h.setView(mStoryList.get(position - 1));
        }else if(itemViewType ==TYPE_HEADER){
            HeaderViewHolder h = (HeaderViewHolder) holder;
            h.setBannerListItem(mBannerList);
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) return TYPE_HEADER;
        if (position == mStoryList.size() + 1) return TYPE_FOOTER;
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return mStoryList.size() + 2;
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
                    mOnItemClickListener.onItemClick(mStoryList.get(getAdapterPosition()));
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


    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.banner_hot)
        Banner mBanner;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mBanner
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                    .setDelayTime(4000)
                    .setImageLoader(new BannerImageLoader())
                    .isAutoPlay(true)
                    .start();
            setBannerListItem(mBannerList);
        }

        void setBannerListItem(List<Item> list) {

            ArrayList<String> images = new ArrayList<>();
            ArrayList<String> titles = new ArrayList<>();
            ArrayList<String> ids = new ArrayList<>();

            for (Item item : list) {
                images.add(item.imgUrl);
                titles.add(item.title);
                ids.add(item.id + "");
            }

            mBanner
                    .setImages(images)
                    .setBannerTitles(titles)
                    .start();
        }

    }


}

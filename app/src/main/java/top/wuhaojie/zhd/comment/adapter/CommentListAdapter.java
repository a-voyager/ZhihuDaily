package top.wuhaojie.zhd.comment.adapter;

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
import top.wuhaojie.zhd.utils.StringUtils;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/09 10:42
 * Version: 1.0
 */

public class CommentListAdapter extends RecyclerView.Adapter {

    public static final int TYPE_INDEX = 0;
    public static final int TYPE_NO_LONG_COMMENT = 1;
    public static final int TYPE_LONG_COMMENT = 2;
    public static final int TYPE_SHORT_COMMENT = 3;


    private LayoutInflater mLayoutInflater;

    public CommentListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    private List<Item<?>> mList = new ArrayList<>();

    public void setList(List<Item<?>> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void appendList(ArrayList<Item<?>> items) {
        int lastPosition = mList.size() - 1;
        mList.addAll(items);
        notifyItemRangeInserted(lastPosition + 1, items.size());
    }

    public void removeList(int size) {
        int num = size;
        while (num > 0) {
            mList.remove(mList.size() - 1);
            num--;
        }
        notifyItemRangeRemoved(mList.size(), size);
    }

    public int getListSize() {
        return mList.size();
    }

    public static class Item<T> {
        int type;

        T data;

        public Item(int type, T data) {
            this.type = type;
            this.data = data;
        }

    }

    public static class IndexData {

        String title;
        boolean clickable;

        public IndexData(String title, boolean clickable) {
            this.title = title;
            this.clickable = clickable;
        }
    }

    public static class LongCommentData {
        String id;
        String author;
        String avatar;
        String content;
        int likes;
        long time;

        public LongCommentData(String id, String author, String avatar, String content, int likes, long time) {
            this.id = id;
            this.author = author;
            this.avatar = avatar;
            this.content = content;
            this.likes = likes;
            this.time = time;
        }
    }

    public static class ShortCommentData {
        String id;
        String author;
        String avatar;
        String content;
        int likes;
        long time;

        public ShortCommentData(String id, String author, String avatar, String content, int likes, long time) {
            this.id = id;
            this.author = author;
            this.avatar = avatar;
            this.content = content;
            this.likes = likes;
            this.time = time;
        }
    }


//    ----- Example -----
//    {
//        mList.add(new Item<IndexData>(TYPE_INDEX, new IndexData("条短评")));
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view = null;
        switch (viewType) {
            case TYPE_INDEX:
                view = mLayoutInflater.inflate(R.layout.item_index_list_comment, parent, false);
                holder = new IndexHolder(view);
                break;
            case TYPE_NO_LONG_COMMENT:
                view = mLayoutInflater.inflate(R.layout.item_no_comment_list_comment, parent, false);
                holder = new NoneCommentHolder(view);
                break;
            case TYPE_SHORT_COMMENT:    // the same as long
                view = mLayoutInflater.inflate(R.layout.item_long_comment_list_comment, parent, false);
                holder = new ShortCommentHolder(view);
                break;
            case TYPE_LONG_COMMENT:
                view = mLayoutInflater.inflate(R.layout.item_long_comment_list_comment, parent, false);
                holder = new LongCommentHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item<?> item = mList.get(position);
        switch (item.type) {
            case TYPE_INDEX:
                ((IndexHolder) holder).setView((IndexData) item.data);
                break;
            case TYPE_NO_LONG_COMMENT:
                break;
            case TYPE_SHORT_COMMENT:
                ((ShortCommentHolder) holder).setView((ShortCommentData) item.data);
                break;
            case TYPE_LONG_COMMENT:
                ((LongCommentHolder) holder).setView((LongCommentData) item.data);
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

    public interface OnIndexClickListener {
        void onClick(View v, boolean folded);
    }

    private OnIndexClickListener mOnIndexClickListener;

    public void setOnIndexClickListener(OnIndexClickListener onIndexClickListener) {
        mOnIndexClickListener = onIndexClickListener;
    }

    class IndexHolder extends RecyclerView.ViewHolder {

        View mView;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.iv_arrow)
        ImageView mIvArrow;
        boolean mFolded = true;

        IndexHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mView = itemView;
        }

        void setView(IndexData data) {
            mTvTitle.setText(data.title);
            mIvArrow.setVisibility(View.INVISIBLE);
            refreshArrow();
            if (data.clickable) {
                mIvArrow.setVisibility(View.VISIBLE);
                mView.setOnClickListener(v -> {
                    mFolded = !mFolded;
                    refreshArrow();
                    if (mOnIndexClickListener != null)
                        mOnIndexClickListener.onClick(v, mFolded);
                });
            }
        }

        private void refreshArrow() {
            if (!mFolded) {
                mIvArrow.setRotation(180);
            } else {
                mIvArrow.setRotation(0);
            }
        }

    }

    class NoneCommentHolder extends RecyclerView.ViewHolder {

        NoneCommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    class LongCommentHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_avatar_comment)
        ImageView mIvAvatarComment;
        @BindView(R.id.tv_author)
        TextView mTvAuthor;
        @BindView(R.id.tv_likes)
        TextView mTvLikes;
        @BindView(R.id.tv_content_comment)
        TextView mTvContentComment;
        @BindView(R.id.tv_time_comment)
        TextView mTvTimeComment;

        LongCommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setView(LongCommentData data) {
            ImageLoader.get().load(data.avatar, mIvAvatarComment, ImageLoader.OPTION_CENTER_CROP | ImageLoader.OPTION_CIRCLE_CROP);
            mTvAuthor.setText(data.author);
            mTvLikes.setText(String.valueOf(data.likes));
            mTvContentComment.setText(data.content);
            mTvTimeComment.setText(StringUtils.dateTimeString(data.time));
        }

    }

    class ShortCommentHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_avatar_comment)
        ImageView mIvAvatarComment;
        @BindView(R.id.tv_author)
        TextView mTvAuthor;
        @BindView(R.id.tv_likes)
        TextView mTvLikes;
        @BindView(R.id.tv_content_comment)
        TextView mTvContentComment;
        @BindView(R.id.tv_time_comment)
        TextView mTvTimeComment;

        ShortCommentHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(ShortCommentData data) {
            ImageLoader.get().load(data.avatar, mIvAvatarComment, ImageLoader.OPTION_CENTER_CROP | ImageLoader.OPTION_CIRCLE_CROP);
            mTvAuthor.setText(data.author);
            mTvLikes.setText(String.valueOf(data.likes));
            mTvContentComment.setText(data.content);
            mTvTimeComment.setText(StringUtils.dateTimeString(data.time));
        }
    }

}

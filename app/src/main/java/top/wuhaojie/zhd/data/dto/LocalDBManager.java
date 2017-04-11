package top.wuhaojie.zhd.data.dto;

import android.content.Context;
import android.support.annotation.Nullable;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/11 16:04
 * Version: 1.0
 */

public class LocalDBManager {

    private static final String DB_NAME = "web_cache_db";
    private DaoMaster mWritableDaoMaster;
    private DaoMaster mReadableDaoMaster;

    private LocalDBManager(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, DB_NAME);
        mWritableDaoMaster = new DaoMaster(helper.getWritableDb());
        mReadableDaoMaster = new DaoMaster(helper.getReadableDb());
    }

    private static volatile LocalDBManager mInstance;

    public static LocalDBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (LocalDBManager.class) {
                if (mInstance == null) {
                    mInstance = new LocalDBManager(context);
                }
            }
        }
        return mInstance;
    }

    public void insert(WebCache cache) {
        DaoSession session = mWritableDaoMaster.newSession();
        session.getWebCacheDao().insert(cache);
    }

    @Nullable
    public WebCache queryLastOne() {
        DaoSession session = mReadableDaoMaster.newSession();
        QueryBuilder<WebCache> queryBuilder = session.getWebCacheDao().queryBuilder();
        List<WebCache> result = queryBuilder.orderDesc(WebCacheDao.Properties.TimeStamp).limit(1).list();
        if (result == null || result.size() == 0) return null;
        return result.get(0);
    }


    public void deleteAll() {
        // TODO: 17-4-11
    }

    public List<WebCache> queryAll() {
        // TODO: 17-4-11
        return null;
    }

}

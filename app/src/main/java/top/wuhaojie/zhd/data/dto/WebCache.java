package top.wuhaojie.zhd.data.dto;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/11 15:59
 * Version: 1.0
 */
@Entity
public class WebCache {

    @Id(autoincrement = true)
    Long id;

    int type;

    String extra;

    String content;

    @Index
    long timeStamp;

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Generated(hash = 1777811283)
    public WebCache(Long id, int type, String extra, String content, long timeStamp) {
        this.id = id;
        this.type = type;
        this.extra = extra;
        this.content = content;
        this.timeStamp = timeStamp;
    }

    @Generated(hash = 4527785)
    public WebCache() {
    }

}

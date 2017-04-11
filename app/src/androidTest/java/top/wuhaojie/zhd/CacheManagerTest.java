package top.wuhaojie.zhd;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import top.wuhaojie.zhd.data.CacheManager;
import top.wuhaojie.zhd.entities.LatestMessageResponse;
import top.wuhaojie.zhd.utils.JsonUtils;

/**
 * Author: wuhaojie
 * E-mail: w19961009@126.com
 * Date: 2017/04/11 16:46
 * Version: 1.0
 */

@RunWith(AndroidJUnit4.class)
public class CacheManagerTest {

    String data = "{\"date\":\"20170411\",\"stories\":[{\"images\":[\"https:\\/\\/pic3.zhimg.com\\/v2-23e57858f194d83c580a78040fd30122.jpg\"],\"type\":0,\"id\":9351458,\"ga_prefix\":\"041116\",\"title\":\"暴力强迫亚裔乘客下机，美联航和安保错在哪里？\"},{\"images\":[\"https:\\/\\/pic4.zhimg.com\\/v2-34f136c0fcd8e1a8acc5290da2c6aa6f.jpg\"],\"type\":0,\"id\":9350239,\"ga_prefix\":\"041115\",\"title\":\"油价太低，沙特想用这个「五年计划」帮自己转型\"},{\"images\":[\"https:\\/\\/pic1.zhimg.com\\/v2-4fd23a8d08fa000756d29c0e4b8733b8.jpg\"],\"type\":0,\"id\":9351251,\"ga_prefix\":\"041114\",\"title\":\"拿下 3 座金像奖的《一念无明》，是好故事遇到了好演员\"},{\"images\":[\"https:\\/\\/pic4.zhimg.com\\/v2-5b946f47cfac87b737132ecdc9c2e3d7.jpg\"],\"type\":0,\"id\":9350829,\"ga_prefix\":\"041113\",\"title\":\"「小姐姐」这词早就有了，怎么现在突然火起来？\"},{\"images\":[\"https:\\/\\/pic4.zhimg.com\\/v2-db169c898f21ebaf3174eea0cdeefecb.jpg\"],\"type\":0,\"id\":9350658,\"ga_prefix\":\"041113\",\"title\":\"声音混合后还分得清，光线混合后你就看不出来了\"},{\"images\":[\"https:\\/\\/pic4.zhimg.com\\/v2-59d4116232025e87f690299aafea44bb.jpg\"],\"type\":0,\"id\":9349227,\"ga_prefix\":\"041112\",\"title\":\"大误 · 末日烧书指南\"},{\"images\":[\"https:\\/\\/pic1.zhimg.com\\/v2-44703bdf8c08d23d5b7912b924bff484.jpg\"],\"type\":0,\"id\":9349500,\"ga_prefix\":\"041110\",\"title\":\"你做的这个生意，能赚到钱吗？\"},{\"images\":[\"https:\\/\\/pic2.zhimg.com\\/v2-5a06bca9f570faf802a444d959b655f9.jpg\"],\"type\":0,\"id\":9350180,\"ga_prefix\":\"041109\",\"title\":\"「嫖娼」「吸毒」不是犯罪，这些名词你不一定理解对了\"},{\"images\":[\"https:\\/\\/pic2.zhimg.com\\/v2-0dc8dbef4074f3c7c8e66872a7428945.jpg\"],\"type\":0,\"id\":9347710,\"ga_prefix\":\"041108\",\"title\":\"日本经济这 20 多年来发展停滞是出了什么问题？\"},{\"images\":[\"https:\\/\\/pic4.zhimg.com\\/v2-ce03b708ae69b5ae65de017efb4185db.jpg\"],\"type\":0,\"id\":9349466,\"ga_prefix\":\"041107\",\"title\":\"想要真的留住回忆，可以试试少拍一些照片\"},{\"title\":\"学着认出路边的花花草草叫什么名字，是件很有成就感的事\",\"ga_prefix\":\"041107\",\"images\":[\"https:\\/\\/pic1.zhimg.com\\/v2-18f9f0236ccb5b45f0dce66bf86a4448.jpg\"],\"multipic\":true,\"type\":0,\"id\":9336099},{\"images\":[\"https:\\/\\/pic2.zhimg.com\\/v2-7dc1ddddc00408a3e7bcaf4f3b25cc71.jpg\"],\"type\":0,\"id\":9350115,\"ga_prefix\":\"041107\",\"title\":\"《歌手》总决赛前最后一战，谁是你心中的全场最佳？\"},{\"images\":[\"https:\\/\\/pic2.zhimg.com\\/v2-c9df002d275388a9a3b6ce1a78b41c21.jpg\"],\"type\":0,\"id\":9348843,\"ga_prefix\":\"041106\",\"title\":\"瞎扯 · 如何正确地吐槽\"}],\"top_stories\":[{\"image\":\"https:\\/\\/pic4.zhimg.com\\/v2-b58dd928c1cfaec9d4470af2497111e7.jpg\",\"type\":0,\"id\":9351458,\"ga_prefix\":\"041116\",\"title\":\"暴力强迫亚裔乘客下机，美联航和安保错在哪里？\"},{\"image\":\"https:\\/\\/pic4.zhimg.com\\/v2-191fe1bbb755d772468d7601fb548c97.jpg\",\"type\":0,\"id\":9351251,\"ga_prefix\":\"041114\",\"title\":\"拿下 3 座金像奖的《一念无明》，是好故事遇到了好演员\"},{\"image\":\"https:\\/\\/pic1.zhimg.com\\/v2-02bc168dc73a045bbdb5cbdd3935a2d0.jpg\",\"type\":0,\"id\":9350829,\"ga_prefix\":\"041113\",\"title\":\"「小姐姐」这词早就有了，怎么现在突然火起来？\"},{\"image\":\"https:\\/\\/pic1.zhimg.com\\/v2-ca109833011961b56d7fee6008f75448.jpg\",\"type\":0,\"id\":9349466,\"ga_prefix\":\"041107\",\"title\":\"想要真的留住回忆，可以试试少拍一些照片\"},{\"image\":\"https:\\/\\/pic2.zhimg.com\\/v2-47fe5a0966e87c37f4e720ceaf88d495.jpg\",\"type\":0,\"id\":9350115,\"ga_prefix\":\"041107\",\"title\":\"《歌手》总决赛前最后一战，谁是你心中的全场最佳？\"}]}";


    @Test
    public void saveLatestMessages() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        LatestMessageResponse latestMessageResponse = JsonUtils.fromJson(data, LatestMessageResponse.class);
        CacheManager.saveLatestMessages(context, latestMessageResponse);
    }

    @Test
    public void hasLatestMessages() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        LatestMessageResponse latestMessages = CacheManager.getLatestMessages(context);
        System.out.println(latestMessages);
    }

    @Test
    public void getLatestMessages() throws Exception {

    }


}

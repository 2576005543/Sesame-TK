package tkaxv7s.xposed.sesame.task.model.reserve;

import tkaxv7s.xposed.sesame.hook.ApplicationHook;
import tkaxv7s.xposed.sesame.util.RandomUtil;

public class ReserveRpcCall {
    private static final String VERSION = "20230501";
    private static final String VERSION2 = "20230522";
    private static final String VERSION3 = "20231031";

    private static String getUniqueId() {
        return String.valueOf(System.currentTimeMillis()) + RandomUtil.nextLong();
    }

    public static String queryTreeItemsForExchange() {
        return ApplicationHook.requestString("alipay.antforest.forest.h5.queryTreeItemsForExchange",
                "[{\"cityCode\":\"370100\",\"itemTypes\":\"\",\"source\":\"chInfo_ch_appcenter__chsub_9patch\",\"version\":\""
                        + VERSION2 + "\"}]");
    }

    public static String queryTreeForExchange(String projectId) {
        return ApplicationHook.requestString("alipay.antforest.forest.h5.queryTreeForExchange",
                "[{\"projectId\":\"" + projectId + "\",\"version\":\"" + VERSION
                        + "\",\"source\":\"chInfo_ch_appcenter__chsub_9patch\"}]");
    }

    public static String exchangeTree(String projectId) {
        int projectId_num = Integer.parseInt(projectId);
        return ApplicationHook.requestString("alipay.antmember.forest.h5.exchangeTree",
                "[{\"projectId\":" + projectId_num + ",\"sToken\":\"" + System.currentTimeMillis() + "\",\"version\":\""
                        + VERSION + "\",\"source\":\"chInfo_ch_appcenter__chsub_9patch\"}]");
    }

    /* 净滩行动 */

    public static String queryCultivationList() {
        return ApplicationHook.requestString("alipay.antocean.ocean.h5.queryCultivationList",
                "[{\"source\":\"ANT_FOREST\",\"version\":\"" + VERSION3 + "\"}]");
    }

    public static String queryCultivationDetail(String cultivationCode, String projectCode) {
        return ApplicationHook.requestString("alipay.antocean.ocean.h5.queryCultivationDetail",
                "[{\"cultivationCode\":\"" + cultivationCode + "\",\"projectCode\":\"" + projectCode
                        + "\",\"source\":\"ANT_FOREST\",\"uniqueId\":\"" + getUniqueId() + "\"}]");
    }

    public static String oceanExchangeTree(String cultivationCode, String projectCode) {
        return ApplicationHook.requestString("alipay.antocean.ocean.h5.exchangeTree",
                "[{\"cultivationCode\":\"" + cultivationCode + "\",\"projectCode\":\"" + projectCode
                        + "\",\"source\":\"ANT_FOREST\",\"uniqueId\":\"" + getUniqueId() + "\"}]");
    }

}

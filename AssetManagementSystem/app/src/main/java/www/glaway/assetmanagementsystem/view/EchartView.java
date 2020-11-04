package www.glaway.assetmanagementsystem.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.github.abel533.echarts.json.GsonOption;
import com.orhanobut.logger.Logger;

public class EchartView extends WebView {
    private static final String TAG = EchartView.class.getSimpleName();

    public EchartView(Context context) {
        this(context, null);
    }

    public EchartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EchartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        WebSettings webSettings = getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
        loadUrl("file:///android_asset/echarts.html");
    }

    /**刷新图表
     * java调用js的loadEcharts方法刷新echart
     * 不能在第一时间就用此方法来显示图表，因为第一时间html的标签还未加载完成，不能获取到标签值
     * @param option
     */
    public void refreshEchartsWithOption(GsonOption option) {
        if (option == null) {
            return;
        }
        String optionString = option.toString();
        optionString = "{\n" +
                "    \"tooltip\": {\n" +
                "        \"trigger\": \"item\",\n" +
                "        \"formatter\": \"{a} <br/>{b}: {c} ({d}%)\"\n" +
                "    },\n" +
                "    \"legend\": {\n" +
                "        \"orient\": \"vertical\",\n" +
                "        \"left\": 10,\n" +
                "        \"data\": [\"直接访问\", \"邮件营销\", \"联盟广告\", \"视频广告\", \"搜索引擎\"]\n" +
                "    },\n" +
                "    \"series\": [\n" +
                "        {\n" +
                "            \"name\": \"访问来源\",\n" +
                "            \"type\": \"pie\",\n" +
                "            \"radius\": [\"50%\", \"70%\"],\n" +
                "            \"avoidLabelOverlap\": false,\n" +
                "            \"label\": {\n" +
                "                \"show\": false,\n" +
                "                \"position\": \"center\"\n" +
                "            },\n" +
                "            \"emphasis\": {\n" +
                "                \"label\": {\n" +
                "                    \"show\": true,\n" +
                "                    \"fontSize\": \"30\",\n" +
                "                    \"fontWeight\": \"bold\"\n" +
                "                }\n" +
                "            },\n" +
                "            \"labelLine\": {\n" +
                "                \"show\": false\n" +
                "            },\n" +
                "            \"data\": [\n" +
                "                {\"value\": 335, \"name\": \"直接访问\"},\n" +
                "                {\"value\": 310, \"name\": \"邮件营销\"},\n" +
                "                {\"value\": 234, \"name\": \"联盟广告\"},\n" +
                "                {\"value\": 135, \"name\": \"视频广告\"},\n" +
                "                {\"value\": 1548, \"name\": \"搜索引擎\"}\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
//        Logger.d(optionString);
        String call = "javascript:loadEcharts('" + optionString + "')";
        loadUrl(call);
    }
}
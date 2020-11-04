package www.glaway.assetmanagementsystem.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.bartwell.exfilepicker.ExFilePicker;
import ru.bartwell.exfilepicker.data.ExFilePickerResult;
import www.glaway.assetmanagementsystem.R;
import www.glaway.assetmanagementsystem.util.EchartOptionUtil;
import www.glaway.assetmanagementsystem.util.PermissionUtil;
import www.glaway.assetmanagementsystem.util.ZipUtil;
import www.glaway.assetmanagementsystem.view.EchartView;
import www.glaway.assetmanagementsystem.view.MyMarkerView;

public class MainActivity extends BaseActivity implements OnChartValueSelectedListener {


    @BindView(R.id.lineChart)
    EchartView lineChart;
    @BindView(R.id.chart1)
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        lineChart.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
//                refreshLineChart();
//            }
//        });
//        initDataMPAndroidChart();
        if (PermissionUtil.isGetPermissions()){
            PermissionUtil.applyPermissions(PermissionUtil.PERMISSIONS_STORAGE, new PermissionUtil.PermissionCallBack() {
                @Override
                public void Callback(boolean call) {
                    if (call){
//                        openFile();
                        zipFile();
                    }
                }
            });
        }

    }

    /**
     * 压缩文件
     */

    public void zipFile(){
        ZipUtil.writeFile("1","1111111110");
        ZipUtil.writeFile("2","2222222220");
        ZipUtil.writeFile("3","3333333330");
        try {
            ZipUtil.zip();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件
     */

    private void openFile() {
        ExFilePicker exFilePicker = new ExFilePicker();
        exFilePicker.setCanChooseOnlyOneItem(true);// 单选
        exFilePicker.setQuitButtonEnabled(true);
        exFilePicker.setStartDirectory(Environment.getExternalStorageDirectory().getPath());
        exFilePicker.setChoiceType(ExFilePicker.ChoiceType.FILES);
        exFilePicker.start(this, 1);

    }


    /**
     * 画图PhilJay:MPAndroidChart:v3.0.3
     */
    private void initDataMPAndroidChart() {

        chart = findViewById(R.id.chart1);
        chart.setOnChartValueSelectedListener(this);

        ViewGroup.LayoutParams layoutParams = chart.getLayoutParams();
        chart.getDescription().setEnabled(true);
        Description description = chart.getDescription();
        description.setText("分析");
        description.setPosition(layoutParams.width / 2, 10);
        description.setTextColor(Color.RED);
        chart.setDescription(description);

//        chart.setDrawBorders(true);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawBarShadow(false);

        chart.setDrawGridBackground(false);

        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        mv.setChartView(chart); // For bounds control
        chart.setMarker(mv); // Set the marker to the chart

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(true);
        l.setTypeface(tfLight);
        l.setYOffset(0f);
        l.setXOffset(10f);
        l.setYEntrySpace(0f);
        l.setXEntrySpace(90f);
        l.setTextSize(8f);

        XAxis xAxis = chart.getXAxis();
        xAxis.setTypeface(tfLight);
        xAxis.setGranularity(1f);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);

//        XAxis.XAxisPosition position = xAxis.getPosition();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "glaway" + String.valueOf((int) value);
            }
        });

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setTypeface(tfLight);
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(false);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        chart.getAxisRight().setEnabled(false);

        ArrayList<BarEntry> values1 = new ArrayList<>();
        ArrayList<BarEntry> values2 = new ArrayList<>();
        ArrayList<BarEntry> values3 = new ArrayList<>();

//        float randomMultiplier = seekBarY.getProgress() * 100000f;

//        for (int i = startYear; i < endYear; i++) {
        for (int i = 0; i < 6; i++) {
            values1.add(new BarEntry(i, (float) (Math.random() * 10f)));
            values2.add(new BarEntry(i, (float) (Math.random() * 10f)));
            values3.add(new BarEntry(i, (float) (Math.random() * 10f)));
        }

        BarDataSet set1, set2, set3;

        if (chart.getData() != null && chart.getData().getDataSetCount() > 0) {

            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet) chart.getData().getDataSetByIndex(1);
            set3 = (BarDataSet) chart.getData().getDataSetByIndex(2);
//            set4 = (BarDataSet) chart.getData().getDataSetByIndex(3);
            set1.setValues(values1);
            set2.setValues(values2);
            set3.setValues(values3);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();

        } else {
            // create 4 DataSets
            set1 = new BarDataSet(values1, "总数量");
            set1.setColor(Color.rgb(43, 65, 141));
            set2 = new BarDataSet(values2, "一致数量");
            set2.setColor(Color.rgb(111, 146, 101));
            set3 = new BarDataSet(values3, "不一致数量");
            set3.setColor(Color.rgb(166, 123, 87));

            BarData data = new BarData(set1, set2, set3);
            data.setValueFormatter(new LargeValueFormatter());
            data.setValueTypeface(tfLight);

            chart.setData(data);
        }

        float groupSpace = 0.01f;
        float barSpace = 0.03f; // x4 DataSet
        float barWidth = 0.3f; // x4 DataSet
//        int groupCount = seekBarX.getProgress() + 1;
        int groupCount = 5 + 1;

        // specify the width each bar should have
        chart.getBarData().setBarWidth(barWidth);

        // restrict the x-axis range
        chart.getXAxis().setAxisMinimum(2000);

        // barData.getGroupWith(...) is a helper that calculates the width each group needs based on the provided parameters
        chart.getXAxis().setAxisMaximum(2000 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        chart.groupBars(2000, groupSpace, barSpace);
        chart.invalidate();
    }

    /**
     * echarts画图
     */
    private void refreshLineChart() {
        Object[] x = new Object[]{
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        Object[] y = new Object[]{
                820, 932, 901, 934, 1290, 1330, 1320
        };
        lineChart.refreshEchartsWithOption(EchartOptionUtil.getLineChartOptions(x, y));
    }

    /**
     * 二维码识别
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == 200) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
        if (requestCode == 1) {
            ExFilePickerResult result = ExFilePickerResult.getFromIntent(data);
            if (result != null && result.getCount() > 0) {
                String path = result.getPath();
                Logger.d(path);

                List<String> names = result.getNames();
                for (int i = 0; i < names.size(); i++) {
                    File f = new File(path, names.get(i));
                    try {
                        Uri uri = Uri.fromFile(f); //这里获取了真实可用的文件资源
                        HashMap<String, String> stringStringHashMap = ZipUtil.readFile(uri.getPath());
//                        Logger.d( stringStringHashMap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void OpenQRcode() {
        if (PermissionUtil.isGetPermissions()) {
            PermissionUtil.applyPermissions(PermissionUtil.PERMISSIONS_SCANQRCODE, new PermissionUtil.PermissionCallBack() {
                @Override
                public void Callback(boolean call) {
                    if (call) {

                        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                        startActivityForResult(intent, 200);
                        //开启摄像头，拍照完的图片保存在对应路径下
//                        Intent intent = new Intent(MainActivity.this, MyCaptureActivity.class);
//                        startActivityForResult(intent, 105);
                    }

                }
            });
        }
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}

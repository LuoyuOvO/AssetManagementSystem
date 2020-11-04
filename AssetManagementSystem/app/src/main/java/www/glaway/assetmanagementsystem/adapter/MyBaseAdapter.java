package www.glaway.assetmanagementsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 基础适配器
 */
public abstract class MyBaseAdapter extends BaseAdapter {


    protected Context context;
    protected List<Object> dataList;
    protected LayoutInflater inflater;
    protected AdapterCallback adapterCallback;

    public enum CallType {
        Info, Delete, Add, Hide, Show
    }

    /**
     * @param context
     * @param objectList -- 数据必须是list集合
     */
    public MyBaseAdapter(Context context, Object objectList) {
        this.context = context;
        this.dataList = (List) objectList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);

    /**
     * 回调接口
     */
    public interface AdapterCallback {
        void callback(CallType type, Object call);
    }

    public void setAdapterCallback(AdapterCallback adapterCallback) {
        this.adapterCallback = adapterCallback;
    }
}

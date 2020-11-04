package www.glaway.assetmanagementsystem;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;
import www.glaway.assetmanagementsystem.dao.DaoMaster;
import www.glaway.assetmanagementsystem.dao.DaoSession;

public class AssetManagementSystemApplication extends Application {


    private static AssetManagementSystemApplication mApp;
    private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        //配置数据库
        initGreenDao();
        SQLiteStudioService.instance().start(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        ZXingLibrary.initDisplayOpinion(this);
    }


    private void initGreenDao() {
        //创建数据库mydb.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mApp, "assetmanagementsystem.db");
        //获取可写数据库
        SQLiteDatabase database = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        //获取Dao对象管理者
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }


}

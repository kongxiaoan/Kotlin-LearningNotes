package cn.tcm.kotlin_learningnotes;

import android.app.Application;

import com.liulishuo.filedownloader.FileDownloader;

/**
 * Created by mr.kong on 2017/12/18.
 */

public class FileApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		/**
		 * 仅仅是缓存Application的Context，不耗时
		 */
		FileDownloader.init(getApplicationContext());
	}
}

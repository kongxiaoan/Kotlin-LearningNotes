package cn.tcm.kotlin_learningnotes;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloadQueueSet;
import com.liulishuo.filedownloader.FileDownloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr.kong on 2017/12/18.
 */

public class DownloderHelper {

	/**
	 * 启动单任务下载
	 *
	 * @param url
	 */
	public void createDownloadTask(String url) {
		FileDownloader.getImpl().create(url)
				.setPath("")
				.setListener(new FileDownloadListener() {
					@Override
					protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

					}

					@Override
					protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {

					}

					@Override
					protected void completed(BaseDownloadTask task) {

					}

					@Override
					protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

					}

					@Override
					protected void error(BaseDownloadTask task, Throwable e) {

					}

					@Override
					protected void warn(BaseDownloadTask task) {

					}
				})
				.start();
	}

	/**
	 * 启动多任务下载
	 */
	public void createDownlodTask(String[] urls) {
		boolean serial = false;
		boolean parallel = false;
		FileDownloader.getImpl().create(urls[0])
				.setCallbackProgressTimes(0) //由于是队列任务， 假设了现在不需要每个任务都回调FileDownloadListener#progress 只关系每个任务是否完成，所以这里这样设置可以有效的减少ipc
				.setListener(queueTarget)
				.ready();
		if (serial) {
			//串行执行该队列
			FileDownloader.getImpl().start(queueTarget, true);
		} else if (parallel) {
			//并列执行该队列
			FileDownloader.getImpl().start(queueTarget, false);
		}
	}

	final FileDownloadQueueSet queueSet = new FileDownloadQueueSet(new FileDownloadListener() {
		@Override
		protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

		}

		@Override
		protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {

		}

		@Override
		protected void completed(BaseDownloadTask task) {

		}

		@Override
		protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

		}

		@Override
		protected void error(BaseDownloadTask task, Throwable e) {

		}

		@Override
		protected void warn(BaseDownloadTask task) {

		}
	});

	final List<BaseDownloadTask> tasks = new ArrayList<>();

	public void createDownloadTask() {
		boolean serial = true;
		boolean paeallel = true;
		for (int i = 0; i < 100; i++) {
			tasks.add(FileDownloader.getImpl().create("").setTag(i + 1));
		}
		queueSet.disableCallbackProgressTimes();
		if (serial) {
			//串行执行该任务队列
			queueSet.downloadSequentially(tasks);
			/**
			 * 如果任务不是一个List 可以考虑使用下面的方式
			 * 可读性更强
			 */
			queueSet.downloadSequentially(
					FileDownloader.getImpl().create("").setPath(""),
					FileDownloader.getImpl().create("").addHeader(""),
					FileDownloader.getImpl().create("").setPath("")
			);
		}
		if (paeallel) {
			//并且执行该任务队列
			queueSet.downloadTogether(tasks);
			queueSet.downloadTogether(
					FileDownloader.getImpl().create("").setPath(""),
					FileDownloader.getImpl().create("").setPath(""),
					FileDownloader.getImpl().create("").setSyncCallback(true)
			);
		}
	}

	private final FileDownloadListener queueTarget = new FileDownloadListener() {

		@Override
		protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {

		}

		@Override
		protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {

		}

		@Override
		protected void completed(BaseDownloadTask task) {

		}

		@Override
		protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

		}

		@Override
		protected void error(BaseDownloadTask task, Throwable e) {

		}

		@Override
		protected void warn(BaseDownloadTask task) {

		}
	};

}

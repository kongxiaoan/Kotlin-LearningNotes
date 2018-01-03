package cn.tcm.kotlin_utils

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.tcm.kotlin_utils.bean.EventBusSticky
import kotlinx.android.synthetic.main.activity_main2.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class Main2Activity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main2)
		EventBus.getDefault().register(this)

		button3.setOnClickListener {
			//手动获取粘性事件
			val stickyEvent = EventBus.getDefault().getStickyEvent(EventBusSticky::class.java)
			if (stickyEvent != null) {
				text.text = stickyEvent.name
				//删除事件
				EventBus.getDefault().removeStickyEvent(stickyEvent)
			}
		}
	}

	/**
	 * 订阅方式获取粘性事件
	 */
	@Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
	public fun onStickyEvent(eventBusSticky: EventBusSticky) {
		text.text = eventBusSticky.name
	}

	override fun onDestroy() {
		super.onDestroy()
		//移除所有的粘性事件
		EventBus.getDefault().removeAllStickyEvents()
		//注释注解
		EventBus.getDefault().unregister(this)
	}
}

package cn.tcm.kotlin_utils

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import cn.tcm.kotlin_utils.bean.EventBusSticky
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus

class MainActivity : AppCompatActivity(), View.OnClickListener {
	override fun onClick(v: View) {
		when (v.id) {
			R.id.button2 -> { //发送
				sendStickyEvent()
			}
		}
	}

	private fun sendStickyEvent() {
		EventBus.getDefault().postSticky(EventBusSticky("sticky消息test"))
		val intent = Intent(this, Main2Activity::class.java)
		startActivity(intent)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		initClick() //使用另一种点击事件的方法
	}

	private fun initClick() {
		button2.setOnClickListener(this)
	}


}

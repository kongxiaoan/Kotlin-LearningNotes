package cn.tcm.kotlin_socketdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.net.Socket
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * 五层：物理层、数据链路层、网络层（负责根据IP找到目的地址的主机）、运输层（通过端口把数据传到目的主机的目的进程 实现进程间的通信）、应用层
 * 端口号：16位 即允许一个IP主机有2的16次方65535个不同的端口 （0 -1023） 分配给了系统的端口号
 * 1024-49151 ：登记端口号 主要是让第三方应用使用 （但是必须在Java（互联网数字分配机构）按照规定手续登记）
 * 49151-65535 ： 短暂端口号，留给客户进程选择暂时使用，同时只能有一个进程使用
 */
class MainActivity : AppCompatActivity() {
	//延迟加载 （当组件在使用的时候进行初始化） 为了方便使用此处直接采用线程池进行线程管理 而没有一个个开线程
	private lateinit var mThreadPool: ExecutorService
	//祝线程Handler
	//用于将从服务器获取的消息显示
	private lateinit var mMainHandler: Handler
	private var response: String = ""
	/**
	 * 接收服务器消息 变量
	 */
	// 输入流对象
	private lateinit var ist: InputStream
	// 输入流读取器对象
	private lateinit var isr: InputStreamReader
	private lateinit var br: BufferedReader
	/**
	 * 发送消息到服务器 变量
	 */
	// 输出流对象
	private lateinit var outputStream: OutputStream
	private lateinit var socket: Socket
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		mThreadPool = Executors.newCachedThreadPool()
		//去除警告（不建议这么写） 并且匿名初始化
		mMainHandler = @SuppressLint("HandlerLeak") object : Handler() {
			override fun handleMessage(msg: Message) {
				super.handleMessage(msg)
				when (msg.what) {
					0 -> {
						//项目build中添加apply plugin: 'kotlin-android-extensions' 之后在
						//Activity中直接使用组件ID名称即可（不需要findViewById()）(但是在Fragment中使用会出问题)
						receive_message.text = response
					}
				}
			}
		}
		/**
		 * 创建客户端 / 服务器的连接
		 * 使用lambda的书写方式
		 */
		connect.setOnClickListener {
			mThreadPool.execute {
				socket = Socket("", 8989)
				//Kotlin 中" + " 连接字符串时 只能为字符串 + /如果其他的类型在前面 添加+ 其他 会报错
				Log.e("connect success :", "" + socket.isConnected)
			}
		}
		/**
		 * 接收服务器消息
		 */
		receive.setOnClickListener {
			mThreadPool.execute {
				ist = socket.getInputStream()
				isr = InputStreamReader(ist)
				br = BufferedReader(isr)
				response = br.readLine()
				val obtain = Message.obtain()
				obtain.what = 0
				mMainHandler.sendMessage(obtain)
			}
		}
		/**
		 * 发送消息
		 */
		send.setOnClickListener {
			mThreadPool.execute {
				outputStream = socket.getOutputStream()
				outputStream.write((edit.text.toString() + "\n").toByteArray())
				//数据的结尾加上换行符才可让服务器端的readline()停止阻塞
				outputStream.flush()
			}
		}
		/**
		 * 断开
		 */
		disconnect.setOnClickListener {
			outputStream.close()
			br.close()
			socket.close()
		}
	}
}

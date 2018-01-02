package cn.tcm.kotlin_learningnotes

import android.app.Application

/**
 * Created by mr.kong on 2017/12/18.
 *  使用AndRemission 特性
 *  1、链式调用 ，一句话申请权限 省去复杂的逻辑判断
 *  2、支持注解回调结果 支持Listener回调的结果
 *  3、拒绝一次某权限之后，再次申请权限时可以使用Rationale 向用户说明申请该权限的目的
 *  在用户同意后在继续申请 避免用户勾选不在提示而导致不能再次申请该权限
 *  4、就算用户拒绝权限并勾选不在提示，可使用SettingDialog提示用户去设置中授权
 *  5、RationaleDialog 和 SettingDialog 允许开发者自定义
 *  6、AndPermission 自带默认对话框除可自定义外 也支持国际化
 *  7、支持在任何地方申请权限 不仅限于Activity 和Fragment
 */
class KotlinApplication : Application() {
	override fun onCreate() {
		super.onCreate()
	}
}
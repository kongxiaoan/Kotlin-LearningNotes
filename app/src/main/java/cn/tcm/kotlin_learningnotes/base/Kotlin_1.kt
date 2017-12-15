package cn.tcm.kotlin_learningnotes.base

/**
 * Created by mr.kong on 2017/12/15.
 * 玩kotlin之前 必须要知道的事
 *
 * 定义变量
 * 数据类型介绍
 * 字符串模版介绍
 * 修饰符 包名
 */
class Kotlin_1 {
	//语法是一门语言的灵魂所在了 对于一个熟练掌握Java的人来说kotlin是特别简单的
	//1、变量 & 常量
	/**
	 * 变量：使用关键字var 进行声明
	 * 常量: val 声明
	 * 在kotlin中将声明变量常量都限定了定义该类型的关键字，这也是和Java的区别之一
	 * 也是kotlin的特点之一 正因为是有限定的关键字声明，从而可以没有指定的类型 而是在运行de
	 * 过程中自己去指定类型
	 * 两种声明的方式
	 * 1、var/val 变量名：类型（可省略） = 值（如果是类型省略的时候，会根据实际值的类型确定属性的类型）
	 * kotlin中是不运行存在null类型存在的，当然，如果非得要，也是可以的
	 * 2、var/val 变量名：类型（不可省略）？ = null
	 * val / var 的区别
	 * val 声明的变量是可读的 但是不可写的 ，就是说不能改变他的值
	 * var 可读可写
	 * 一般在开发中全局的声明并且会发生变化的变量一般用var 局部变量大多数使用val
	 */
	val a: String? = null //定义的可为null的静态变量
	var b: String = ""    //定义的字符串变量b
	var c = 0 // 整型
	/**
	 * kotlin 的基本数据类型
	 */
	val int: Int = 0 //整型
	val long: Long = 0 //长整型
	val double: Double = 0.0 //双精度浮点型
	val float: Float = 2F //单精度浮点型
	//....
	/**
	 * 会发现kotlin 中基本数据类型都是以对象的形式出现的
	 * 这也就意味着他们拥有自己的属性和方法 这就更加简单了基本数据类型了
	 */
	//最常用的字符串String
	var str: String = ""
	/**
	 * kotlin 中字符串可以想PHP一样 可以使用模版
	 * 包含模版表达式 可求值的代码片段 并将器结果连接到字符串中
	 * 一个模版表达式由一个$ 和简单的名称组成
	 */
	val i = 10
	val s = "i = $i" //=> i = 10
	//一个模版表达式由$和大括号扩起来的表达式组成
	val ss = "abcd"
	val str1 = "$ss.length is ${ss.length}" //=> abcd.length is 4

	//修饰符 和java 一样 就不解释了
	//包名 package
	//引包 import

}
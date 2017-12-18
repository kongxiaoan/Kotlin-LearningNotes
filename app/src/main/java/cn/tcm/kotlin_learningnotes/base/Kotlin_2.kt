package cn.tcm.kotlin_learningnotes.base

import java.lang.Integer.parseInt

/**
 * Created by mr.kong on 2017/12/15.
 * 类的定义
 * 函数的定义
 * if判断语句
 * when / for / while
 * 返回/跳转语句
 *
 */
class Kotlin_2 {
	/**
	 * 类的定义
	 * class 类名 这个就不用介绍了
	 */
	/**
	 * 函数
	 * 修饰符 + fun + 函数名（参数..） ：返回值（有返回值时）{
	 * }
	 */
	fun a() {

	}

	private fun b(a: Int, b: Int): Int {
		return a + b
	}

	/**
	 * 接下来介绍一下kotlin 的控制流
	 */
	//1、if 表达式
	//在kotlin 中if 就是一个表达式 会返回一个值 所以就不需要三元运算了
	//传统写法
	fun iF(a: Int, b: Int) {
		var max = 8
		if (max < 8) max = 6

		var max1: Int
		if (a > b) {
			max = a
		} else {
			max = b
		}

		//作为表达式时可以写成
		val max2 = if (a > b) a else b

		//if 的分支可以是代码快 最后表达是作为该快的zhi
		val max3 = if (a > b) {
			print("a")
			a
		} else {
			print("b")
			b
		}


		//note : 在开发中 经常用的还是和Java一样的普通的用法
	}

	//when()  ---> 和Java中的switch() 一样
	//取代switch() 之后操作更加简单 kotlin 完全兼容lambda表达式的书写
	fun test(a: Int) {
		when (a) {
			1 -> {
				println("is 1")
			}
			2 -> {
				println("is 2")
			}
			else -> {
				println("not is 1 or 2")
			}
		}

		//可以将多个条件放在一起
		when (a) {
			1, 2 -> {
				println("is 1 and 2")
			}
			else -> {
				println("not is 1 or 2")
			}
		}

		//可以用任意的表达式作为分之条件
		var str = "1"
		when (a) {
			parseInt(str) -> print("str is 1")
			else -> print("str not's 1")
		}

		//也可以检测一个值在不在一个区间或者集合中 in !in 在不在某一区间关键字
		when (a) {
			in 1..10 -> print("a is in the range")
			!in 10..20 -> print("")
			else -> print("")
		}


	}

	/**
	 * 还可以检测某个值是不是一个特定的类型的值
	 * 检测是一个字符串 并且是以nima 开头
	 *
	 * 当if 或者有判断逻辑在 某个表达式要作为一个特定的值时
	 * 一定要有else
	 */
	fun hasPresfix(a: Any) = when (a) {
		is String -> a.startsWith("nima")
		else -> false
	}

	/**
	 * for 循环
	 *
	 */
	fun forTest() {
		//kotlin 中for循环的写法挺多的
		//1、for循环可以对任意可以进行遍历的对象进行遍历 这相当于C# 语言中的foreach 循环
		val mList = ArrayList<String>()
		for (item in mList) print(item)
		//有循环体 并且指明类型的
		for (item: String in mList) {
			//循环体
		}

		//对数组类for 循环 ，通过索引遍历
		//写法1
		for (i in mList.indices) {
			print(mList[i])
		}
		//写法2
		for (i in 0..mList.size) {
			print(mList[i]) //需要说明的是kotlin 中集合的get/set方法都可以写成 []
		}

		//写法3
		for (i in 0 until mList.size) { // --> i in 0.. mList.size - 1

		}
		//还可以在区间上遍历
		for ((index, value) in mList.withIndex()) {
			print("$index is $value")
		}
		//当然还有一些常见的写法 在后面的例子中慢慢介绍
	}
	//while 循环
	/**
	 * kotlin 中是保留了while 循环的 他和Java的使用是一样的 没有做改变
	 */

	/**
	 * kotlin 中同样支持返回和跳转 含义（功能和Java的一样）
	 * return
	 * break
	 * continue
	 * 在用法上有改动 一般when 中条件语句后面不需要想switch一样添加break
	 */
	fun returnAndBreak() {
		//其他使用场景和Java一样 按照他的功能使用即可
		val s = Kotlin_2_TestBean().name ?: return //如果这个属性是null 直接return

		//break and continue
		//在kotlin中任何的表达式都可以使用标签标记
		/**
		 * 标签的格式
		 * 标识符 + @
		 * eg:kpa@
		 * 为什么说标签呢？ Java中也有标签 我们使用的时候一般是配合跳转功能完成达到某个条件和响应的操作
		 */
		kpa@ for (i in 0..10) {
			for (j in 0..10) {
				if (i == 3) break@kpa //当条件满足后跳出指定的循环
			}
		}
		/**
		 * 具体在后面的场景中介绍
		 */

	}


}
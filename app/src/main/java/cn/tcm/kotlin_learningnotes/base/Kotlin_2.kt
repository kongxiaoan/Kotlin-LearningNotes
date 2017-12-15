package cn.tcm.kotlin_learningnotes.base

import java.lang.Integer.parseInt

/**
 * Created by mr.kong on 2017/12/15.
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
	 * 首先要说明的是for循环可以对任意可以进行遍历的对象进行遍历
	 */
	fun forTest() {

	}


}
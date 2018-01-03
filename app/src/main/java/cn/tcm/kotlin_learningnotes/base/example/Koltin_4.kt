package cn.tcm.kotlin_learningnotes.base.example

/**
 * Created by mr.kong on 2018/1/3.
 * Kotlin 集合操作
 */
class Koltin_4 {
	fun test() {
		val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
		val mutableList = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
		//总数操作
		println(list.any { it % 2 == 1 }) //判断集合是否有满足条件的元素
		println(list.all { it % 2 == 1 })  //判断集合中的元素是否全都满足条件
		println(list.count { it % 2 == 1 })  //查询集合中满足条件的元素个数
		println(list.fold(10) { total, next -> total + next }) //在给定初始值的基础上 从第一项到最后一项进行累加
		println(list.foldRight(10) { total, next -> total + next }) //在给定初始值的基础上 从最后一项到第一项进行累加
		list.forEach { value -> if (value > 8) println("大于8 of is $value") }
		list.forEachIndexed { index, value -> if (value > 8) println("value of $index is $value") } //遍历集合 同时得到元素index
		println(list.max()) //查询最大的元素 如果没有则返回null
		println(list.maxBy { -it }) //获取方法处理后返回结果最大值对应的那个元素的初始值 没有则返回null
		println(list.min())
		println(list.minBy { -it })
		println(list.none { it % 2 == 10 }) //判断集合中是否都不满足条件 是 返回true
		println(list.reduce { total, next -> total + next }) //没有给定初始值 从第一项累加到最后一项
		println(list.reduceRight { total, next -> total + next })
		println(list.sumBy { it % 2 }) //获取方法处理后返回结果值的总结

		//过滤操作
		println(list.drop(4)) //返回去掉前n个元素的列表
		println(list.dropWhile { it < 9 }) //返回从第一项起 去掉满足条件的元素 直到不满足条件的一项止
		println(list.dropLastWhile { it < 9 }) //返回从最后一项起 去掉满足条件的元素 直到不满足条件的一项止
		println(list.filter { it % 2 == 0 }) //过滤掉不满足条件的元素
		println(list.filterNot { it % 2 == 0 }) //过滤掉所有满足条件的元素
		println(list.filterNotNull()) //过滤掉所有值为null的元素
		println(list.slice(listOf(0, 4, 8))) //过滤掉非指定下标的元素，即保留下标对应的元素过滤List中指定下标的元素（比如这里只保留下标为1，3，4的元素），当过滤list中有元素值大于目标List大小时会出现异常；
		println(list.take(2)) //返回从第一个元素开始的n个元素
		println(list.takeLast(2)) //返回从最后一个开始的n个元素
		println(list.takeWhile { it < 3 }) //返回不满足条件的下标前面的所有元素的集合

		//映射操作
		println(list.flatMap { listOf(it, it + 1) }) //合并两个集合 可以在合并的时候对迭代元素值it进行想要的操作
		println(list.groupBy { if(it % 2 == 0) "even" else "odd" }) //将集合中的元素按照指定的条件进行返祖 返回Map
		println(list.map { it * 2 }) //将集合中的元素通过某个方法转换后的结果存到一个集合中
		println(list.mapIndexed { index, it -> index + it }) // 除了得到转换后的结果 还可以拿到index
		println(list.mapNotNull { it * 2 }) //执行方法过滤前过滤为null的元素

		//元素操作
		println(list.contains(2)) //是否包含指定元素
		println(list.elementAt(1)) //查找下标对应的元素
		println(list.elementAtOrElse(10,{2 * it})) // 查找下标对应的元素 如果越界会根据给定的值返回
		println(list.elementAtOrNull(10)) // 查找下标对应的元素 越界返回null

		println(list.first{it % 2 == 0}) // 返回符合条件的第一个元素
		println(list.firstOrNull() {it % 2 == 0}) //返回符合条件的第一个元素 没有返回null

	}
}
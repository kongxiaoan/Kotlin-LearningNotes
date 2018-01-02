package cn.tcm.kotlin_learningnotes.base.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr.kong on 2017/12/18.
 * Kotlin_3 型变的例子
 */

public class Java_1 {
	/**
	 *
	 */
	public void test() {
		List<String> strings = new ArrayList<>();
		List<Object> objects;//= strings;//java 禁止这样
		//objects.add(1); //把一个正数放入字符串序列
		String s = strings.get(0);// ClassCastException 异常

	}


}

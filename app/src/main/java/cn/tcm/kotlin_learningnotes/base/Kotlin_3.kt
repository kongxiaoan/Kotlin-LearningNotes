package cn.tcm.kotlin_learningnotes.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

/**
 * Created by mr.kong on 2017/12/18.
 * 类与继承
 * 主构造函数
 * 次构造函数
 * 创建类的实例
 * 继承
 * 覆盖方法/属性
 * this/super 使用
 * 抽象类
 * 数据类
 * 扩展函数 扩展属性
 * 密封类
 * 泛型
 * 枚举类
 */
class Kotlin_3 {
	/**
	 * 定义声明类的关键字class
	 * 可以声明一个没有类体的类
	 * class Demo
	 * 省去打括号
	 */

	//kotlin 构造函数
	/**
	 * 有一个主构造函数 和一个或多个次构造函数 主构造函数是类头的一部分
	 * 类名（可选的参数类型）
	 */
	class Demo constructor(name: String) {

	}

	//如果没有注解或者可见性修饰符 constructor可以省略
	class Demo1(name: String) {

	}

	/**
	 * 主构造函数不能包含任何的代码 初始化的时候全部放在init() 关键字 作为前缀的
	 * 初始化快中
	 * 主构造的参数可以在初始化块中使用 也可以在类体内声明的属性初始化器中使用
	 */
	class Demo2(name: String) {
		init {
			name.toUpperCase()
			print("初始化块")
		}
	}

	//构造函数有注解或可见性修饰符 constructor 关键字是必需的，并且这些修饰符在它前面
	class Demo3 private @JvmOverloads constructor(name: String) {

	}

	//次构造函数 //constructor
	class Demo4 {
		constructor(name: String) {
			print(name)
		}
	}

	/**
	 * 如果类有一个主构造函数 每个次构造函数需要委托给主构造函数 可以直接委托或者通过别的次构造函数间接委托
	 * 委托到同一个类的另一个构造函数用 this 关键字即可
	 * 初始化块中的代码实际上会成为主构造函数的一部分 委托给主构造函数会作为次构造函数的第一条语句 因此所有初始化块中的代码
	 * 都会在次构造函数体之前执行 即使该类没有主构造函数 这种委托仍会隐式发生 并且仍会执行初始化块
	 *
	 */
	class Demo5(name: String) {
		init {
			print("初始化块")
		}

		constructor(name: String, testBean: Kotlin_2_TestBean) : this(name) {
		}
	}

	//创建类的实列
	fun test() {
		val demo = Demo("kpa")
		//kotlin 中初始化对象不实用new关键字
	}

	////////////////////////////////////////继承///////////////////////////////////////////
	//1、kotlin如同Java一样都有一个基类 kotlin -> Any
	class Demo6 //Any 隐士继承

	//要清楚的是Any除了equals()、hashCode()和toString()外没有任何成员
	//定义一个显示的超类 kotlin 中继承是：
	open class Demo7(a: Int) //open 和Java的final 相反 是表示该类可以被其他类继承

	class Demo8(a: Int) : Demo7(1) {
	}

	/**
	 * 如果该类有一个主构造函数，其基类型可以（并且必须） 用（基类型的）主构造函数参数就地初始化。

	如果类没有主构造函数 那么每个次构造函数必须使用 super 关键字初始化其基类型 或委托给另一个构造函数做到这一点。
	注意，在这种情况下 不同的次构造函数可以调用基类型的不同的构造函数：
	 */
	class Demo9 : View {
		constructor(context: Context?) : super(context)
		constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
		constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
	}
	//kotlin 一贯遵守Effective Java 中提到的 要么为继承而设计 并且提供文档 要么就禁止继承
	//默认的类都是final 的

	//覆盖的方法
	//覆盖属性

	open class Base {
		open val name: String
			get() {
				return ""
			}

		open fun v() {} //将要被复写的方法也要使用open关键字修饰
	}

	/**
	 * 复写的方法
	 */
	class Demo10 : Base() {
		override val name: String
			/**
			 * 属性覆盖与方法覆盖类似；在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。
			 * 每个声明的属性可以由具有初始化器的属性或者具有 getter 方法的属性覆盖。
			 */
			get() = super.name//覆盖属性

		override fun v() {
			super.v()
		}
	}
	//在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现
	// ：super@Outer：

	class Demo11 : Base() {
		override fun v() {
			super.v()
		}

		inner class Demo12 { //inner 声明内部类
			fun v() {
				super@Demo11.v()
			}
		}
	}

	//抽象类

	abstract class Demo13 {
		abstract fun a() //抽象方法
		fun b() {  //已经实现的方法

		}
	}

	/**
	 * 与Java不同的是 kotlin 中没有static 但是有相关的定义
	 */

	companion object {
		val TYPE: Int = 0 //静态常量
		fun type(): Int { //静态方法
			return 0
		}
	}

	//=======================================数据类=========================================
	/**
	 * 只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。
	 * 在 Kotlin 中，这叫做 数据类
	 * 使用data 关键字
	 */
	data class Demo14(val name: String, val age: Int)
	/**
	 * 编译器自动从主构造函数中声明的所有属性导出以下成员：
	equals()/hashCode() 对；
	toString() 格式是 "User(name=John, age=42)"；
	componentN() 函数 按声明顺序对应于所有属性；
	 */
	/**
	 * 数据类满足的条件
	 *  主构造函数需要至少有一个参数；
	主构造函数的所有参数需要标记为 val 或 var；
	数据类不能是抽象、开放、密封或者内部的；
	 */
	//存在copy() ---> 复制数据
	fun test1() {
		val demo = Demo14("kpa", 100)
		val copy = demo.copy(age = 100)
	}

//	扩展函数和扩展属性

	//	1、扩展函数和扩展属性的 可以在不修改原来类的条件下 使用函数和属性 表现得就像是属于这个类一样的
//	当前的对象不存在某个属性（直接想用的某个属性） 使用扩展属性
//	eg:TextView 设置扩展属性leftMargin
	var TextView.leftMargin: Int
		get() :Int {
			return (layoutParams as ViewGroup.MarginLayoutParams).leftMargin
		}
		set(value) {
			(layoutParams as ViewGroup.MarginLayoutParams).leftMargin = value
		}

	//	使用
//	textview.leftMargin = 20
//
//	扩展函数

	//toast("扩展函数")

	//	扩展函数
	fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

	//===============================密封类====================================
	/**
	 * 密封类就是用来表示受限的结构 当一个值为有限集中类型、而不能有任何其他类型时
	 * 在某种意义上他就是枚举类的扩展 而枚举类型的扩展也是受限制的 单每一个枚举常量只存在一个示例
	 * 密封类的子类可以包含状态的多个示例
	 */
	sealed class Demo15 {
		data class Demo16(val name: String) : Demo15()
		data class Demo17(val age: Int, val name: String) : Demo15()
		object NotNUmber : Demo15()
	}

	//泛型
	/**
	 * 和Java一样
	 */
	class Demo18<T>(t: T) {
		val value = t
	}

	//使用
	fun test2() {
		val demo18 = Demo18<String>("nihao")
		val demo181 = Demo18(1) // 通过参数推断出泛型的类型
	}

	//型变
	/**
	 * kotlin 中没有Java的通配符类型
	 * 但是它有两个东西 声明处型变与类型投影
	 * 在Java中有通配符 在Effective Java 中描述为 ： 利用有限制通配符来提升API的灵活性
	 * 首先 java中的泛型是不型变的 这就以为者List<String> 并不是 List<Object> 的子类型
	 * 他只要没有型变 就没比Java的数组好到哪儿去
	 * 看一个例子
	 * Java_1
	 */
	/**
	 * // Java
	interface Collection<E> …… {
	void addAll(Collection<E> items);
	}
	 */
	// Java
	//	void copyAll(Collection<Object> to, Collection<String> from) {
	//		to.addAll(from); // ！！！对于这种简单声明的 addAll 将不能编译：
	//		//       Collection<String> 不是 Collection<Object> 的子类型
	//	}
	//

}


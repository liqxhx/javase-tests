package jni;

/**
 * Created by qhli on 2017/9/21.
 *
 * java side:
 * cd /Users/qhli/src/java/javase-tests/
 * mvn compile
 * cd /Users/qhli/src/java/javase-tests/target/classes
 * #生成头文件：com_qhli_demo_javase_jni_JNITest.h
 * javah -jni com.qhli.demo.javase.jni.JNITest
 *
 * cpp size:
 * 写cpp或c端实现
 * vi Hello.app/Hello.c (#include "JNITest.h")
 * 写好cpp或c端实现后保存退出
 * 编译生成目标文件
 * gcc -Wall -g -c Hello.c -o Hello.o -I/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/jdk1.7.0_67.jdk/Contents/Home/include/darwin
 * 生成共享库文件
 * gcc -shared -fPIC Hello.o -o libHello.so
 *
 * 运行程序
 *
 */
public class JNITest {

//    System.load 和 System.loadLibrary详解
//    相同点
//    它们都可以用来装载库文件，不论是JNI库文件还是非JNI库文件。
//    在任何本地方法被调用之前必须先用这个两个方法之一把相应的JNI库文件装载。
//
//    System.load
//    System.load 参数必须为库文件的绝对路径，可以是任意路径，例如：
//            System.load("C:\\Documents and Settings\\TestJNI.dll"); //Windows
//              System.load("/usr/lib/TestJNI.so"); //Linux
//
//    System.loadLibrary
//    System.loadLibrary 参数为库文件名，不包含库文件的扩展名。
//            System.loadLibrary ("TestJNI"); //加载Windows下的TestJNI.dll本地库
//System.loadLibrary ("TestJNI"); //加载Linux下的libTestJNI.so本地库
//    注意：TestJNI.dll 或 libTestJNI.so 必须是在JVM属性java.library.path所指向的路径中。
//
//    本地库的依赖库
//    如果你要载入的库文件静态链接到其它动态链接库，如TestJNI.dll 静态链接到dependency.dll，必须注意：
//            1）如果你选择System.load("D:\\lib\\TestJNI.dll");
//    那么即使你把dependency.dll同样放在D:\\lib下，load还是会因为找不到依赖的dll而失败。
//    因为jvm在载入TestJNI.dll会先去载入TestJNI.dll所依赖的库文件dependency.dll，而dependency.dll并不位于java.library.path所指定的目录下，所以jvm找不到dependency.dll。
//    你有两个方法解决这个问题：
//    一是把D:\\lib加入到java.library.path的路径中。
//            二是先调用System.load("D:\\lib\\dependency.dll"); 让jvm先载入dependency.dll，
//            然后再调用System.load("D:\\lib\\TestJNI.dll");
//
//2）如果你选择System. loadLibrary ("TestJNI");
//    那么你只要把dependency.dll放在任何java.library.path包含的路径中即可
    static{
        // 下面两行同时放天，以第一条为准
        System.load("/Users/qhli/src/java/javase-tests/target/classes/libHello.so");
//        `System.load("/Users/qhli/src/java/javase-tests/src/main/resources/jni/Hello.so");

    }

    public native static void Hello();

    public static void main(String[] args) {
        Hello();
    }
}

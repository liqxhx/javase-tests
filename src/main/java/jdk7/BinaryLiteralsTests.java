package jdk7;

import org.junit.Test;

/**
 * 二进制字面值（Binary Literals
 * 在java7里，整形(byte,short,int,long)类型的值可以用二进制类型来表示了，
 * 在使用二进制的值时，需要在前面加上ob或oB
 * 数字变量对下划线_的支持
 * 可以在数值类型的变量里添加下滑线，除了以下的几个地方不能添加：
 * 数字的开头和结尾
 * 小数点前后
 * F或者L前
 * 需要出现string类型值的地方(针对用0x或0b表示十六进制和二进制，参考第一点)，比如0x101，不能用0_x101
 * 可以提升代码的可读性
 */
public class BinaryLiteralsTests {
    @Test
    public void test1() {
        //b 大小写都可以
        int a = 0b01111_00000_11111_00000_10101_01010_10;
        short b = (short) 0b01100_00000_11111_0;
        byte c = (byte) 0B0000_0001;


    }
}

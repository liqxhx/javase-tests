package awesomebits;

import org.junit.Test;

/**
 * https://github.com/keon/awesome-bits
 */
public class BitsTest {

    /**
     * 转小写
     *
     */
    @Test
    public void testToLowerCase(){
        char chA = 'A';
        char cha = 'a';
        System.out.println(chA);
        System.out.println((char)(chA | ' ') );

        System.out.println(cha);
        System.out.println((char)(cha | ' ') );
    }




    /**
     * 大写转小写，小写转大写
     */
    @Test
    public void testInverCase(){
        char chA = 'B';
        char cha = 't';
        System.out.println(chA);
        System.out.println((char)(chA ^ ' ') );

        System.out.println(cha);
        System.out.println((char)(cha ^ ' ') );
    }

    /**
     * 设置第n位为1 ，从0开始
     * x | (1<<n)
     */
    @Test
    public void setNBit(){
        int num = 0x0000;

        System.out.println(Integer.toBinaryString(num));

        int n = 4;
        System.out.println(Integer.toBinaryString(num | (1<<0)));
        System.out.println(Integer.toBinaryString(num | (1<<1)));
        System.out.println(Integer.toBinaryString(num | (1<<2)));
        System.out.println(Integer.toBinaryString(num | (1<<3)));
        System.out.println(Integer.toBinaryString(num | (1<<4)));
        System.out.println(Integer.toBinaryString(num | (1<<5)));
        System.out.println(Integer.toBinaryString(num | (1<<6)));
        System.out.println(Integer.toBinaryString(num | (1<<7)));

    }


    @Test
    public void unsetNBit(){
        int num = 0xffff;

        System.out.println(Integer.toBinaryString(num));

        System.out.println(Integer.toBinaryString(num & ~(1<<0)));
        System.out.println(Integer.toBinaryString(num & ~(1<<1)));
        System.out.println(Integer.toBinaryString(num & ~(1<<2)));
        System.out.println(Integer.toBinaryString(num & ~(1<<3)));
        System.out.println(Integer.toBinaryString(num & ~(1<<4)));
        System.out.println(Integer.toBinaryString(num & ~(1<<5)));
        System.out.println(Integer.toBinaryString(num & ~(1<<6)));
        System.out.println(Integer.toBinaryString(num & ~(1<<7)));

    }

    @Test
    public void toggleNBit(){

        int num = 0xffff;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(num ^ (1 << 1)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 2)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 3)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 4)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 5)));

        num = 0x0000;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(num ^ (1 << 1)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 2)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 3)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 4)));
        System.out.println(Integer.toBinaryString(num ^ (1 << 5)));
    }

}

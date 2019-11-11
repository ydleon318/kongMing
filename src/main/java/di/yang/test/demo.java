package di.yang.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demo {
    @DataProvider(name = "db1")
    public Object[] [] prod(){
       return new Object[][]{
               {"hhhhhh","222222","333333"}
       };
    }
//    @Test
//    public void test01(){
//        System.out.printf("test1111111");
//    }
    @Test(dataProvider = "db1")
    public void test02(String data,String data2,String data3){
        System.out.printf(data+data2+data3);
    }
}

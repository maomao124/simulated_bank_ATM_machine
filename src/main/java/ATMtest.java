/**
 * Project name(项目名称)：模拟银行ATM机
 * Package(包名): PACKAGE_NAME
 * Class(类名): ATMtest
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/10
 * Time(创建时间)： 21:13
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ATMtest
{
    public static void main(String[] args)
    {
        System.out.println("测试的账户为123，密码为555");
        ATM atm=new ATM();
        atm.startTime=System.nanoTime();   //获取开始时间
        atm.welcome();
        try
        {
            atm.load_sys();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

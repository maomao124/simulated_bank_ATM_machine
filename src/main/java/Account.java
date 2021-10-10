/**
 * Project name(项目名称)：模拟银行ATM机
 * Package(包名): PACKAGE_NAME
 * Class(类名): Account
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/10
 * Time(创建时间)： 20:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Account
{
    private String number = null;      //卡号
    private String name = null;      //用户姓名
    private String password = null;       //密码
    private double money = 0.0;       //余额

    public Account(String number, String name, String password, double money)
    {
        this.number = number;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    protected String getNumber()
    {
        return number;
    }

    protected void setNumber(String number)
    {
        this.number = number;
    }

    protected String getName()
    {
        return name;
    }

    protected void setName(String name)
    {
        this.name = name;
    }

    protected String getPassword()
    {
        return password;
    }

    public double getMoney()
    {
        return money;
    }

    protected void sub_balance(double mon)     //余额减少
    {
        money = money - mon;
    }

    protected void add_balance(double money)   //余额增加
    {
        this.money =this.money+money;
    }
}

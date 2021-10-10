import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Project name(项目名称)：模拟银行ATM机
 * Package(包名): PACKAGE_NAME
 * Class(类名): ATM
 * Author(作者）: mao
 * Author QQ：1296193245
 * Date(创建日期)： 2021/10/10
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ATM
{
    long startTime;
    Account act;

    public ATM()
    {
        act = new Account("123", "mao", "555", 5000);
    }

    //欢迎界面
    protected void welcome()
    {
        String str = "---------------------------------------------------";
        System.out.println(str);
        System.out.println("""
                1.取款.
                2.查询.
                3.存款.
                4.退出系统.""");
        System.out.println(str);
    }

    //登录系统
    protected void load_sys() throws Exception
    {
        String card;
        String pwd;
        int counter = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("请输入您的卡号：");
            card = br.readLine();
            System.out.println("请输入密码：");
            pwd = br.readLine();
            if (!isright(card, pwd))
            {
                System.err.println("输入的卡号或者密码有误！！！");
                if (counter < 2)
                {
                    System.out.println("您还有" + (2 - counter) + "次机会");
                }
                counter++;
            }
            else
            {
                System.out.println("账户和密码正确");
                sysopter();
            }
        }
        while (counter < 3);
        System.out.println("再见");
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
        System.exit(0);
    }

    //操作提示
    protected void sysopter() throws Exception
    {
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入要操作的序号(1-4)：");
        num = br.read();
        if (num == 49)
        {
            betbalance();
        }
        else if (num == 50)
        {
            inqu_info();
        }
        else if (num == 51)
        {
            addbalance();
        }
        else
        {
            exit_sys();
        }
        System.exit(1);
    }

    //信息查询
    protected void inqu_info() throws Exception
    {
        System.out.println("--------------------------------");
        System.out.println("账号：" + act.getNumber());
        System.out.println("姓名：" + act.getName());
        System.out.println("余额：" + act.getMoney());
        sysopter();
    }

    //取款
    public void betbalance() throws Exception
    {
        String str = null;
        String str1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("请输入取款数目：");
            str = br.readLine();
            double qu = Double.valueOf(str).doubleValue();
            //str转double型
            if (qu > act.getMoney())
            {
                System.err.println("余额不足！请输入要取的数目：");
            }
            else
            {
                act.sub_balance(qu);
                System.out.println("取款成功，您的账户余额为：" + act.getMoney());
                welcome();
                sysopter();
            }
        }
        while (true);
    }

    //存款
    public void addbalance() throws Exception
    {
        String str = null;
        String str1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("请输入存款数目：");
            str = br.readLine();
            double qu = Double.valueOf(str).doubleValue();
            //str转double型
            act.add_balance(qu);
            System.out.println("取款成功!您的账户余额为：" + act.getMoney());
            welcome();
            sysopter();
        }
        while (true);
    }

    //判断卡内是否有钱
    protected boolean isbalance()
    {
        if (act.getMoney() <= 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    //卡号密码是否正确
    protected boolean isright(String card, String pwd)
    {
        if (act.getNumber().equals(card) && act.getPassword().equals(pwd))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //结束系统
    protected void exit_sys()
    {
        System.out.println("感谢您使用本系统，再见！");

        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
        System.exit(1);
    }
}

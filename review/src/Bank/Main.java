package Bank;

import java.util.Arrays;
import java.util.Scanner;

class Person {
    // 存钱
    public void save(BankCard card) {
        System.out.println("请输入存款金额：");
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        card.setMoney(card.getMoney()+money);
    }
    // 取钱
    public void withdraw(BankCard card) {
        System.out.println("请输入取款金额：");
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextDouble();
        if(card.getMoney() >= money) {//判断取款金额是否小于卡内的钱数
            card.setMoney(card.getMoney()-money);
        }else {
            System.out.println("余额不足，请存钱！");
        }
    }
    //转账
    public void transfer(BankCard srcCard,BankCard[] bankCards,int usedsize) {
        int count = 1;//设定一个计数器，超过三次则不能进入
        while(count <= 3) {
            System.out.println("请输入对方账户id:");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            for (int i = 0; i < usedsize; i++) {
                //遍历银行内的账号，找到目标账号
                if(bankCards[i].getId() == id && bankCards[i].getId() != srcCard.getId()) {
                    System.out.println("请输入转账金额:");
                    double money = scanner.nextDouble();
                    if(money <= srcCard.getMoney()) {//判断转账金额是否小于卡内余额
                        bankCards[i].setMoney(bankCards[i].getMoney()+money);
                        srcCard.setMoney(srcCard.getMoney()-money);
                        return;
                    } else {
                        System.out.println("余额不足，请存钱！");
                    }
                }
            }
            count++;
            System.out.println("请输入对方正确的账户id"+ "您还有"+
                    (3-count)+"次机会！");
        }
    }
    //查询当前账户的余额
    public void getBalance(BankCard card) {
        System.out.println("当前账户余额为："+card.getMoney());
    }
}

 class BankCard {
    private int id;//银行卡id
    private int password;//银行卡密码
    private double money;//卡内钱

    public BankCard (int id,int password) {//含有参数的构造函数
        this.id = id;
        this.password = password;
    }
    //一系列的get、set方法将id、password、money对象进行初始化
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
}

 class Bank {
    private BankCard[] bankCards;
    private int usedSize;
    public Bank() {
        this(10);
    }
    public Bank(int size) {
        this.bankCards = new BankCard[size];
        this.usedSize = 0;//初始长度为0
    }
    // 用户登录
    public BankCard login(int id,int password) {
        for (int i = 0; i < this.bankCards.length; i++) {
            if(bankCards[i].getId() == id && bankCards[i].getPassword()==password) {
                System.out.println("登录成功");
                return bankCards[i];
            }
        }
        System.out.println("登录失败！您可能还未注册或者是密码和账号有误！");
        return null;
    }

    // 用户注册
    public void register(int id,int password) {
        for (int i = 0; i < this.usedSize; i++) { //查看是否已经注册过
            if(bankCards[i].getId() == id && bankCards[i].getPassword() == password) {
                System.out.println("您已经注册过了！");
                return;
            }
        }
        if(isFull()) { //查看当前银行卡数组是否已经注册满，满了进行扩容
            incBackCard();
        }
        this.bankCards[this.usedSize++] = new BankCard(id,password);
    }
    public boolean isFull() {
        return this.usedSize == this.bankCards.length;
    }
    //原数组的2倍扩容
    public void incBackCard() {
        this.bankCards = Arrays.copyOf(this.bankCards,2*this.bankCards.length);
    }
    //登录成功的操作
    public void operateLoginSuccess(Person person,int n,BankCard card){
        switch (n) {
            case 1:person.save(card);break;
            case 2:person.withdraw(card);break;
            case 3:person.getBalance(card);break;
            case 4:person.transfer(card,this.bankCards,this.usedSize); break;
            default:break;
        }
    }

    public void operate(Person person) {
        int count = 0;
        while (count<2) {
            System.out.println("========欢迎来到小金库系统========");
            System.out.println("1.登陆  2.注册  3.退出");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if(n == 3){
                return;
            }
            System.out.println("请输入账号：");
            int id = scanner.nextInt();
            System.out.println("请输入密码：");
            int password = scanner.nextInt();

            switch (n) {
                case 1:
                    BankCard card = login(id, password);
                    if(card != null){//登陆成功
                        //登陆成功的操作内容
                        System.out.println("========登录成功========");
                        while (true) {
                            System.out.println("========请输入你的操作========");
                            System.out.println("1 存钱  2 取钱   3 查看余额  4 转账 5 退卡");
                            n = scanner.nextInt();
                            if(n == 5){
                                break;
                            }
                            operateLoginSuccess(person,n, card);
                        }
                    }else{//登陆失败
                        count++;
                    }
                    break;
                case 2:
                    register(id, password);
                    break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Bank bank = new Bank();
        bank.operate(person);
    }
}
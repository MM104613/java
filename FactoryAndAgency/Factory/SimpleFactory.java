package FactoryAndAgency.Factory;
//简单工厂
//1.一个抽象产品类   2.具体产品类  3.一个工厂
import java.util.Scanner;

interface Computer1{                                       //电脑接口
    public abstract  void printComputer();
}
class MacBookComputer implements Computer1{
    public void printComputer(){                                   //子类实现接口并覆写
        System.out.println("这是苹果");
    }
}
class SurFaceComputer implements Computer1{
    public void printComputer(){                                        //子类实现接口并覆写
        System.out.println("这是微软");
    }
}
class AlienWareComputer implements Computer1{
    public void printComputer(){                                         //子类实现接口并覆写
        System.out.println("这是外星人电脑");
    }
}
class FactoryComputer{
   public static Computer1 createComputer(String answer){
       switch(answer){
           case"mac":{                                                   //生产电脑工厂
               return new MacBookComputer();
           }
           case"surface":{
               return new SurFaceComputer();
           }
           case"alienWare":{
               return new AlienWareComputer();
           }
           default:
               return null;
       }
   }
}
 class  client{
    public static void buyComputer (Computer1 computer){
        computer.printComputer();
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
        System.out.println("请输入你想要的电脑型号：(mac/surface/alienWare)");
        Scanner scanner = new Scanner(System.in);
        String answer= scanner.nextLine();
        Computer1 computer = FactoryComputer.createComputer(answer);
        if(computer ==null){
            System.out.println("工厂不能生产指定类型的电脑"+answer);
        }else{
            client.buyComputer(computer);
        }
     }
}

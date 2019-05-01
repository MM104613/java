package Abstract;  // 模板设计模式
import java.util.Scanner;

    abstract  class CaffeineBeverage{
        final void prepareRecipe(){
            boilWater();
            brew();
            pourInCup();
            if(customerWantsCondiments()){
                addCondiments();
            }
        }
        public abstract void brew();
        public abstract void addCondiments();
        public  void boilWater(){

            System.out.println("烧水");
        }
        public void  pourInCup(){

            System.out.println("倒入杯中");
        }
        public boolean customerWantsCondiments(){
            return true;
        }
    }
    class Coffee extends CaffeineBeverage{
        public void brew() {
            System.out.println("咖啡过滤");
        }
        public void addCondiments() {
            System.out.println("加糖和牛奶");
        }
        public  boolean customerWantsCondiments(){
            String answer = getUserInput();
            if(answer.equals("y")){
                return true;
            }else{
                return false;
            }
        }
        private  String  getUserInput(){
            String answer = null;
            System.out.println("请问你想要在咖啡中加入糖和牛奶吗？ （y/n）");
            Scanner scanner = new Scanner(System.in);
            answer = scanner.nextLine();
            return answer;
        }
    }
    class Tea extends CaffeineBeverage{

        public void brew(){
            System.out.println("泡茶");
        }
        public void addCondiments(){
            System.out.println("加柠檬");
        }
        public boolean customerWantsCondiments(){
            String answer=getUserInput();
            if(answer.equals("y")){
                return true;
            }else{
                return false;
            }
        }
        private  String getUserInput(){
            String answer=null;
            System.out.println("请问你想要在茶中加入柠檬吗？（y/n）");
            Scanner scanner=new Scanner(System.in);
            answer = scanner.nextLine();
            return answer;
        }
    }
public class TemplateDesign {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea(); //向上转型 给父类实例化对象
        CaffeineBeverage coffee = new Coffee();

        System.out.println("Making tea...");
        tea.prepareRecipe();

        System.out.println("Making coffee...");
        coffee.prepareRecipe();
    }
}
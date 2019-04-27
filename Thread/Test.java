abstract  class CaffeineBeverage{
    final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    public abstract void brew();
    public abstract void addCondiments();
    public  void boilWater(){
        System.out.println("boiling water");
    }
    public void  pourInCup(){
        System.out.println("pouring into cup");
    }
}
class Coffee extends CaffeineBeverage{
    public void brew() {
        System.out.println("Dripping Coffee Through Filter");
    }
    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
class Tea extends CaffeineBeverage{

    public void brew(){
        System.out.println("Steeping the tea");
    }
    public void addCondiments(){
        System.out.println("add lemon");
    }
}
public class Test {
    public static void main(String[] args) {
       CaffeineBeverage drink1= new Coffee();//向上转型
       drink1.prepareRecipe();
       CaffeineBeverage drink2=new Tea();
       drink2.prepareRecipe();
    }
}

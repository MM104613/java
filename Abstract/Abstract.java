package Abstract;//抽象类的模板设计模式，想要的coffe还是tea

abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        //如果顾客想要加调料才调用
        /*if (customerWantsCondiments()) {
            addCondiments();
        }*/
    }

    public abstract void brew(); // 抽象方法 留个子类子类中实现

    public abstract void addCondiments();// 抽象方法 留个子类子类中实现

    public void boilWater() {
        System.out.println("boiling water");
    }

    public void pourInCup() {
        System.out.println("pouring into cup");
    }
}

class Coffee extends CaffeineBeverage {
    public void brew() {
        System.out.println("Dripping Coffee Through Filter");
    }

    public void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

class Tea extends CaffeineBeverage {

    public void brew() {
        System.out.println("Steeping the tea");
    }

    public void addCondiments() {
        System.out.println("add lemon");
    }

    /*public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if(answer)
    }
*/
    /*private String getUserInput() {
        System.out.println("你想要在茶中加入柠檬吗（y/n）");

    }*/
}

public class Abstract {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea(); //向上转型 给父类实例化对象
        CaffeineBeverage coffee = new Coffee();

        System.out.println("Making tea...");
        tea.prepareRecipe();

        System.out.println("Making coffee...");
        coffee.prepareRecipe();
    }
}

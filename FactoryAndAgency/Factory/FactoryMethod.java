package FactoryAndAgency.Factory;

//工厂方法
// 各有各的工厂去制作商品   符合开闭原则 直接扩展
//1.一个抽象产品类   2.多个具体产品类   3. 一个抽象工厂  4.多个具体工厂-每一个具体产品对应一个具体工厂
interface Computer2 {
    public abstract void printComputer();
}

class MacComputer implements Computer2 {
    public void printComputer() {
        System.out.println("这是苹果");
    }
}

class surfaceComputer implements Computer2 {
    public void printComputer() {
        System.out.println("这是微软");
    }
}

interface ComputerFactory {
    public abstract Computer2 createComputer();
}

class MacComputerFactory implements ComputerFactory {
    public Computer2 createComputer() {
        return new MacComputer();
    }
}

class SurfaceComputerFactory implements ComputerFactory {
    public Computer2 createComputer() {
        return new surfaceComputer();
    }
}

class Client {
    public void buyComputer(Computer2 computer) {
        computer.printComputer();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Client client = new Client();
        ComputerFactory factory1 = new MacComputerFactory();
        ComputerFactory factory2 = new SurfaceComputerFactory();
        client.buyComputer(factory1.createComputer());
        client.buyComputer(factory2.createComputer());
    }
}

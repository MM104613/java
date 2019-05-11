package FactoryAndAgency.Factory;
//抽象工厂
interface Computer3 {
    public abstract void printComputer();
}

class macComputer implements Computer3 {
    public void printComputer() {
        System.out.println("这是苹果");
    }
}

class SurfaceComputer implements Computer3 {
    public void printComputer() {
        System.out.println("这是微软");
    }
}

interface OperatingSystem {
    public abstract void printSystem();
}

class MacSystem implements OperatingSystem {
    public void printSystem() {
        System.out.println("这是苹果操作系统");
    }
}

class SurfaceSystem implements OperatingSystem {
    public void printSystem() {
        System.out.println("这是微软操作系统");
    }
}

interface ProductionFactory {
    Computer3 createComputer();
    OperatingSystem createSystem();
}

class AppleFactory implements ProductionFactory {
    public Computer3 createComputer() {
        return new macComputer();
    }

    public OperatingSystem createSystem() {
        return new MacSystem();
    }
}

class SurfaceFactory implements ProductionFactory {
    public Computer3 createComputer() {
        return new SurfaceComputer();
    }

    public OperatingSystem createSystem() {
        return new SurfaceSystem();
    }
}

class Client1{
    public void buyComputer(Computer3 computer){
        computer.printComputer();
    }
    public void use(OperatingSystem system){
        system.printSystem();
    }
}
public class AbstractFactory {
    public static void main(String[] args) {
        Client1 client = new Client1();
        ProductionFactory factory1 = new AppleFactory();
        ProductionFactory factory2 = new SurfaceFactory();
        Computer3 computer1 = factory1.createComputer();
        OperatingSystem system1 = factory1.createSystem();
        Computer3 computer2 = factory2.createComputer();
        OperatingSystem system2 = factory2.createSystem();
        client.buyComputer(computer1);
        client.use(system1);
        client.buyComputer(computer2);
        client.use(system2);
    }
}

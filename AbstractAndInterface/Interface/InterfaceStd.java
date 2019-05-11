package Interface;
interface Car{
    public void stopCar();
    public void spaceCar();
}
class Park{
    public void care(Car car){
        car.spaceCar();
        car.stopCar();
    }
}
class bus implements Car{
    public void stopCar(){
        System.out.println("公交车停车");
    }
    public void spaceCar(){
        System.out.println("公交车空位");
    }
}
class truck implements Car{
   public void spaceCar(){
       System.out.println("大卡车空位");
   }
   public void stopCar(){
       System.out.println("大卡车停车");
   }
}
class moto implements Car{
    public void spaceCar(){
        System.out.println("摩托车空位");
    }
    public void stopCar(){
        System.out.println("摩托车停车");
    }
}
class litterCar implements Car{
    public void spaceCar(){
        System.out.println("小轿车空位");
    }
    public void stopCar(){
        System.out.println("小轿车停车");
    }
}

public class InterfaceStd {
    public static void main(String[] args) {
        Park park = new Park();
        park.care(new litterCar());
        park.care(new truck());
        park.care(new moto());
        park.care(new bus());

    }
}

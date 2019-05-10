package Fanxing;
class Point{
    private Object x;
    private Object y;
    public void setX(Object x){
        this.x = x;
    }
    public Object getX(){
        return x;
    }
    public void setY(Object y){
        this.y= y;
    }
    public Object getY(){
        return y;
    }
}
public class Fan {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(10);
        point.setY(20);
        int x=(Integer) point.getX();
        int y = (Integer)point.getY();
        System.out.println("x="+x+",y="+y);
    }
}

public class Car {
    // Object Creation 
    String model ="THAR";
    void drive(){
        System.out.println("Driving Mode on");
    }
    public Car(String model){
        this.model = model;
    }



    
    // class Diagram





    public static void main(String[] args) {
        Car car = new Car("Ferrari"); 
        System.out.println(car.model);
        car.drive();
    }
}

import java.util.*;

abstract class Floor{
    int current_capacity;
    int max_capacity;
    int four_wheelers;
    int max_four_wheelers;
    int two_wheelers;
    int max_two_wheelers;

    abstract void display_board(); // displays the no of empty slots for parking in order of (total, 4w, 2w)
    abstract void exit(); // does all the funcitons when a vehicle exits
    abstract void payment(); // gives price for parking
    abstract void update(); // updates the counter of vehicle that exits/enters
}

class Normal_Floor extends Floor{
    int current_capacity=0;
    int max_capacity = 100;
    int four_wheelers = 0;
    int max_four_wheelers = 60;
    int two_wheelers = 0;
    int max_two_wheelers = 40;

    void display_board(){
        System.out.println("Total Empty Slots: " + (this.max_capacity - this.current_capacity));
        System.out.println("Total Empty Slots: " + (this.max_four_wheelers - this.four_wheelers));
        System.out.println("Total Empty Slots: " + (this.max_two_wheelers - this.two_wheelers));
    }

}



public class Parking {
    public static void main(String[] args){
        System.out.println("ParkingLot");
    }
}

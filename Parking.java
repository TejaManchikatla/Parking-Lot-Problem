import java.util.*;

abstract class Vehicle{

    String VehicleNumber;
	Boolean EV;
	Boolean ChargeRequired;
    Boolean Handicapped;

}

class Two_Wheeler extends Vehicle{

    Two_Wheeler(String VehicleNumber, Boolean EV,Boolean ChargeRequired, Boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Compact_4_W extends Vehicle{

    Compact_4_W(String VehicleNumber, Boolean EV,Boolean ChargeRequired, Boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Normal_4_W extends Vehicle{

    Normal_4_W(String VehicleNumber, Boolean EV,Boolean ChargeRequired, Boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Heavy_4_W extends Vehicle{

    Heavy_4_W(String VehicleNumber, Boolean EV,Boolean ChargeRequired, Boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}



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

class Ground_Floor extends Floor{
    int current_capacity=0;
    int max_capacity = 100;
    int handicapped_vehicles = 0;
    int max_handicapped_vehicles = 50;
    int EV_4_wheelers = 0;
    int max_EV_4_Wheelers = 30;
    int EV_2_wheelers = 0;
    int max_EV_2_Wheelers = 20;

    void display_board(){
        System.out.println("Total Empty Slots: " + (max_capacity - current_capacity));
        System.out.println("No. of Handicapped slots available: " + (max_handicapped_vehicles - handicapped_vehicles));
        System.out.println("No. of 4W EV slots available: " + (max_EV_4_Wheelers-EV_4_wheelers));
        System.out.println("No. of 2W EV slots available: " + (max_EV_2_Wheelers-EV_2_wheelers));
    }
     void exit(Vehicle v){
        int rate= payment(v);
        this.current_capacity--;
        if (v.VehicleType=="Two_Wheeler"){
            this.two_wheelers--;
        }
        else{
            this.four_wheelers--;
        }
        if(v.Handicapped){
            handicapped_vehicles--;
        }
    };
    int payment(Vehicle v){};
    void update(){};
}

class Normal_Floor extends Floor{
    int current_capacity=0;
    int max_capacity = 100;
    int compact_4_wheelers = 0;
    int max_compact_4_wheelers = 15;
    int normal_4_wheelers = 0;
    int max_normal_4_wheelers = 35;
    int large_4_wheelers = 0;
    int max_large_4_wheelers = 10;
    int two_wheelers = 0;
    int max_two_wheelers = 30;

    void display_board(){
        System.out.println("Total Empty Slots: " + (this.max_capacity - this.current_capacity));
        System.out.println("Total Empty Compact 4W Slots: " + (this.max_compact_4_wheelers - this.compact_4_wheelers));
        System.out.println("Total Empty Normal 4W Slots: " + (this.max_normal_4_wheelers - this.normal_4_wheelers));
        System.out.println("Total Empty Large 4W Slots: " + (this.max_large_4_wheelers - this.large_4_wheelers));
        System.out.println("Total Empty 2W Slots: " + (this.max_two_wheelers - this.two_wheelers));
    }
    void exit(Vehicle v){
        int rate= payment(v);
        this.current_capacity--;
        if (v.VehicleType=="Two_Wheeler"){
            this.two_wheelers--;
        }
        else{
            this.four_wheelers--;
        }
        if(v.VehicleType=="Compact_4_W"){
            this.compact_4_wheelers--;
        }
        else if (v.VehicleType=="Normal_4_W"){
           this.normal_4_wheelers-; 
        }
        else{
            this.large_4_wheelers--;
        }
     }
    int payment(Vehicle v){};
    void update(){};
    
}



public class Parking {
    public static void main(String[] args){
        int i;

        // array to store the objects of normal-floors
        Normal_Floor[] floors = new Normal_Floor[5]; //building of 1 ground and 5 normal floors

        // object for ground floor
        Ground_Floor ground = new Ground_Floor();

        //Initializing things for each floor(creating objects of floors)
        for(i=0; i<5; i++) floors[i] = new Normal_Floor();

        //displaying ground-floor data
        System.out.println("-----  Ground Floor   -----");
        ground.display_board();

        //running a loop to check data on every floor
        for(i=0; i<5; i++){
            System.out.println("-----  Floor ("+(i+1)+")   -----"); // prints the floor number
            floors[i].display_board(); // its data
        }

        Compact_4_W c1 = new Compact_4_W("Sdf", true, true, false);
        Compact_4_W c2 = new Compact_4_W("Ssdfaf", true, true, false);

        System.out.println(c1.VehicleNumber);
        System.out.println(c2.VehicleNumber);
    }
}

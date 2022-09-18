import java.util.*;

class Vehicle{

	String VehicleType;
	String VehicleNumber;
	Boolean EV;
	Boolean ChargeRequired;
    
	Vehicle(String VehicleType, String VehicleNumber, Boolean EV){
		this.VehicleType = VehicleType;
		this.VehicleNumber = VehicleNumber;
		this.EV=EV;
	}


	void getChargeRequired(Boolean ChargeRequired){
		this.ChargeRequired = ChargeRequired;
	}


	public static String Vehicle_number_in_Capitals(String VehicleNumber){
		int i=0;
        String str="";
		while(i<VehicleNumber.length()){
			if(VehicleNumber.charAt(i)<123 && VehicleNumber.charAt(i)>96){
				str = str + (VehicleNumber.charAt(i)-32);
			}
			else{
				str = str + (VehicleNumber.charAt(i));
			}
		}
        return str;
	}


	void TicketGeneration(String VehicleType, String VehicleNumber, Boolean EV){

        String EV_Yes_No = (EV)?("YES"):("NO");

		System.out.println("Ticket is Generated");
		System.out.println("Vehicle Type: "+ VehicleType);
		System.out.println("Vehicle Number: "+ Vehicle_number_in_Capitals(VehicleNumber));
		System.out.println("EV Type: "+ EV_Yes_No);
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
    int four_wheelers = 0;
    int max_four_wheelers = 60;
    int two_wheelers = 0;
    int max_two_wheelers = 40;
    int number_of_4W_EV_slots_available = 30;
    int number_of_2W_EV_slots_available = 30;

    void display_board(){
        System.out.println("Total Empty Slots: " + (max_capacity - current_capacity));
        System.out.println("Total Empty 4W Slots: " + (this.max_four_wheelers - this.four_wheelers));
        System.out.println("Total Empty 2W Slots: " + (this.max_two_wheelers - this.two_wheelers));
        System.out.println("No. of 4W EV slots available: " + number_of_4W_EV_slots_available);
        System.out.println("No. of 2W EV slots available: " + number_of_2W_EV_slots_available);
    }
    void exit(){};
    void payment(){};
    void update(){};
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
        System.out.println("Total Empty 4W Slots: " + (this.max_four_wheelers - this.four_wheelers));
        System.out.println("Total Empty 2W Slots: " + (this.max_two_wheelers - this.two_wheelers));
    }
    void exit(){};
    void payment(){};
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
            System.out.println("-----  Floor ("+i+1+")   -----"); // prints the floor number
            floors[i].display_board(); // its data
        }

    }
}

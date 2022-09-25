import java.util.*;
import java.lang.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

// class EV with method EV_Charge to calculate Charging price 
class EV{
	static int EV_Charge(String VehicleNumber,boolean ChargeRequired) {
		if(ChargeRequired==true) {
			Scanner scn = new Scanner(System.in);
			System.out.println("Watts used by "+VehicleNumber+": ");
			int Watts = scn.nextInt();
			return 10*Watts;
		}
		return 0;
	}
}
// class checkAvailability is to check wether there are availability of slots in any of floor of given type
class checkAvailability{
    boolean checkAvailabilityCompact(boolean ComFirst,boolean ComSecond,boolean ComThird,boolean ComFour,boolean ComFive){
        return (ComFirst | ComSecond | ComThird | ComFour | ComFive);
    }
    
    boolean checkAvailabilityNormal(boolean NorFirst,boolean NorSecond,boolean NorThird,boolean NorFour,boolean NorFive){
        return (NorFirst | NorSecond | NorThird | NorFour | NorFive);
    }
    
    boolean checkAvailabilityHeavy(boolean LarFirst,boolean LarSecond,boolean LarThird,boolean LarFour,boolean LarFive){
        return (LarFirst | LarSecond | LarThird | LarFour | LarFive);
    }
    
    boolean checkAvailability2W(boolean twoWFirst,boolean twoWSecond,boolean twoWThird,boolean twoWFour,boolean twoWFive){
        return (twoWFirst | twoWSecond | twoWThird | twoWFour | twoWFive);
    }
    
    boolean checkAvailabilityHandi(boolean HanFirst,boolean HanSecond,boolean HanThird,boolean HanFour,boolean HanFive){
        return (HanFirst | HanSecond | HanThird | HanFour | HanFive);
    }
    
    boolean checkAvailabilityEV2W(boolean EV2First,boolean EV2Second,boolean EV2Third,boolean EV2Four,boolean EV2Five){
        return (EV2First | EV2Third | EV2Four | EV2Five | EV2Second);
    }
    
    boolean checkAvailabilityEV4W(boolean EV4First,boolean EV4Second,boolean EV4Third,boolean EV4Four,boolean EV4Five){
        return (EV4First || EV4Third || EV4Four || EV4Five || EV4Second);
    }
} 


// Vehicle is an abstract class that extends to classes such as Two_Wheeler, Compact_4_W, Normal_4_W, Heavy_4_W
// EV_4_W and EV_2_W and Handicapped 
abstract class Vehicle{

    String Vehicle_Type;  // 2 Wheeler or Compact 4 W or Normal 4 W or Heavy 4 W
    String VehicleNumber;  // 
	boolean EV;  // boolean if Vehicle is Ev or not
	boolean ChargeRequired; // Does it require charging
    boolean Handicapped; // boolean if its handicapped or not

}

class Two_Wheeler extends Vehicle{

    //Constructor
    Two_Wheeler(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Compact_4_W extends Vehicle{

    //Constructor
    Compact_4_W(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Normal_4_W extends Vehicle{

    //Constructor
    Normal_4_W(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Heavy_4_W extends Vehicle{

    //Constructor
    Heavy_4_W(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Handicapped extends Vehicle{

    //Constructor
    Handicapped(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
        this.Vehicle_Type = Vehicle_Type;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class EV_4_W extends Vehicle{

    //Constructor
    EV_4_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class EV_2_W extends Vehicle{

    //Constructor
    EV_2_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}



// Abstract class Floor extending to each floor
abstract class Floor{
    int current_capacity; //current no of vehicles in each floor
    int max_capacity; // constant
    int compact_4_wheelers;
    int max_compact_4_wheelers;
    int normal_4_wheelers;
    int max_normal_4_wheelers;
    int large_4_wheelers;
    int max_large_4_wheelers;
    int two_wheelers;
    int max_two_wheelers;

    abstract void display_board(); // displays the no of empty slots for parking in order of (total, 4w, 2w)
    abstract void exit(Vehicle v); // does all the functions when a vehicle exits
    abstract int payment(Vehicle v); // gives price for parking
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
    boolean handicappedStatus[]=new boolean[50];
    boolean EV4Status[]=new boolean[30];
    boolean EV2Status[]=new boolean[20];
    
    void display_board(){
        System.out.println("Total Empty Slots: " + (max_capacity - current_capacity));
        System.out.println("No. of Handicapped slots available: " + (max_handicapped_vehicles - handicapped_vehicles));
        System.out.println("No. of 4W EV slots available: " + (max_EV_4_Wheelers-EV_4_wheelers));
        System.out.println("No. of 2W EV slots available: " + (max_EV_2_Wheelers-EV_2_wheelers));
    }
// Checking wether there are empty slots in EV_4_Wheelers Section
    boolean EV4checking(){
        if(this.max_EV_4_Wheelers>this.EV_4_wheelers){
            return true;
        }
        return false;
    }
    
// Checking wether there are empty slots in EV_2_Wheelers Section
    boolean EV2checking(){
        if(this.max_EV_2_Wheelers>this.EV_2_wheelers){
            return true;
        }
        return false;
 
    }
    
// Checking wether there are empty slots in Handicapped Section
    boolean HandicappedChecking(){
        if(this.max_handicapped_vehicles>this.handicapped_vehicles){
            return true;
        }
        return false;

    }

    int EV4PlaceChecking(){
        for(int i=0;i<30;i++){
            if(this.EV4Status[i]==false) {
                this.EV4Status[i]=true;
                return i;
            }
        }
        return -1;
    }
    
    int EV2PlaceChecking(){
        for(int i=0;i<20;i++){
            if(this.EV2Status[i]==false) {
                this.EV2Status[i]=true;
                return i;
            }
        }
        return -1;
    }
    
    int handicappedPlaceChecking(){
        for(int i=0;i<50;i++){
            if(this.handicappedStatus[i]==false){
                this.handicappedStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    void exit(Vehicle v){
        int rate= payment(v);
        this.current_capacity--;
        if (v.Vehicle_Type=="Two_Wheeler"){
            this.two_wheelers--;
        }
        else{
            //this.four_wheelers--;
        }
        if(v.Handicapped){
            handicapped_vehicles--;
        }
    }
    int payment(Vehicle v){
        return 0;
    }
    void update(){}

    //Below are the arrays of a specfic vehicle representing the vehicles' slot in that floor
    EV_4_W[] EV_4_Wheelers_array = new EV_4_W[30];
    EV_2_W[] EV_2_Wheelers_array = new EV_2_W[20];
    Handicapped[] Handicapped_array = new Handicapped[30];

    

    //Below functions are called in Entry class when we know the Vehicle Type that entered
    //The functions below create an object of that vehicle to store in its respective array of vehicles
    void ObjectCreation_for_EV_4_W(String Vehicle_Number, boolean chargeRequired){
        EV_4_Wheelers_array[this.EV4PlaceChecking()] = new EV_4_W(Vehicle_Number, true, chargeRequired, false);
    }
    void ObjectCreation_for_EV_2_W(String Vehicle_Number, boolean chargeRequired){
        EV_2_Wheelers_array[this.EV2PlaceChecking()] = new EV_2_W(Vehicle_Number, true, chargeRequired, false);
    }
    void ObjectCreation_for_Handicapped(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired){
        Handicapped_array[this.handicappedPlaceChecking()] = new Handicapped(Vehicle_Type, Vehicle_Number, EV, chargeRequired, true);
    }

}

class Normal_Floor extends Floor{
    int current_capacity=0;
    int max_capacity = 100;
    int compact_4_wheelers = 0;
    int max_compact_4_wheelers = 25;
    int normal_4_wheelers = 0;
    int max_normal_4_wheelers = 35;
    int heavy_4_wheelers = 0;
    int max_heavy_4_wheelers = 10;
    int two_wheelers = 0;
    int max_two_wheelers = 30;
    boolean normal4WheelerStatus[]=new boolean[35];
    boolean compact4WheelerStatus[]=new boolean[25];
    boolean heavy4WheelerStatus[]=new boolean[10];
    boolean twoWheelerStatus[]=new boolean[30];
    
	// Checking wether there are empty slots in Compact_4_Wheelers Section
	boolean compactChecking(){
        if(this.max_compact_4_wheelers>this.compact_4_wheelers){
            return true;
        }
        // else if(NormalChecking()){
        //     return true;
        // }
        return false;
    }
    // Checking wether there are empty slots in Large_4_Wheelers Section
    boolean heavyChecking(){
        if(this.max_heavy_4_wheelers>this.heavy_4_wheelers){
            return true;
        }
        return false;
    }
    // Checking wether there are empty slots in Normal_4_Wheelers Section
    boolean normalChecking(){
        if(this.max_normal_4_wheelers>this.normal_4_wheelers){
            return true;
        }
        // else if(LargeChecking()){
        //     return true;
        // }
        return false;
    }
    // Checking wether there are empty slots in 2_Wheelers Section
    boolean twoWheelerChecking(){
        if(this.max_two_wheelers>this.two_wheelers){
            return true;
        }
        // else if(CompactChecking()){
        //     return true;
        // }
        return false;
    }


    //Displays all the info about a particular floor
    void display_board(){
        System.out.println("Total Empty Slots: " + (this.max_capacity - this.current_capacity));
        System.out.println("Total Empty Compact 4W Slots: " + (this.max_compact_4_wheelers - this.compact_4_wheelers));
        System.out.println("Total Empty Normal 4W Slots: " + (this.max_normal_4_wheelers - this.normal_4_wheelers));
        System.out.println("Total Empty Large 4W Slots: " + (this.max_heavy_4_wheelers - this.heavy_4_wheelers));
        System.out.println("Total Empty 2W Slots: " + (this.max_two_wheelers - this.two_wheelers));
    }

    int compactPlaceChecking(){
        for(int i=0;i<25;i++){
            if(this.compact4WheelerStatus[i]==false){
                compact4WheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    
    int normalPlaceChecking(){
        for(int i=0;i<35;i++){
            if(this.normal4WheelerStatus[i]==false){
                normal4WheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }

    int heavyPlaceChecking(){
        for(int i=0;i<25;i++){
            if(this.heavy4WheelerStatus[i]==false){
                heavy4WheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    
    int twoWheelerPlaceChecking(){
        for(int i=0;i<25;i++){
            if(this.twoWheelerStatus[i]==false){
                twoWheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    
    void exit(Vehicle v){
        int rate= payment(v);
        this.current_capacity--;
        if (v.Vehicle_Type=="Two_Wheeler"){
            this.two_wheelers--;
        }
        else{
           // this.four_wheelers--;
        }
        if(v.Vehicle_Type=="Compact_4_W"){
            this.compact_4_wheelers--;
        }
        else if (v.Vehicle_Type=="Normal_4_W"){
           this.normal_4_wheelers--; 
        }
        else{
            this.large_4_wheelers--;
        }

        int EV_Charging_price = EV.EV_Charge(v.Vehicle_Type, v.ChargeRequired);
     }
    int payment(Vehicle v){
        return 0;
    };
    void update(){};



    //Below are the arrays of a specfic vehicle representing the vehicles' slot in that floor
    Two_Wheeler[] two_Wheeler_array = new Two_Wheeler[30];
    Compact_4_W[] Compact_4_W_array = new Compact_4_W[25];
    Normal_4_W[] Normal_4_W_array = new Normal_4_W[35];
    Heavy_4_W[] Heavy_4_W_array = new Heavy_4_W[10];


    //Below functions are called in Entry class when we know the Vehicle Type that entered
    //The functions below create an object of that vehicle to store in its respective array of vehicles
    void ObjectCreation_for_Two_Wheeler(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired){
        two_Wheeler_array[twoWheelerPlaceChecking()] = new Two_Wheeler(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false);
    }
    void ObjectCreation_for_Compact_4_W(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired){
        Compact_4_W_array[compactPlaceChecking()] = new Compact_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false);
    }
    void ObjectCreation_for_Normal_4_W(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired){
        Normal_4_W_array[normalPlaceChecking()] = new Normal_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false);
    }
    void ObjectCreation_for_Heavy_4_W(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired){
        Heavy_4_W_array[heavyPlaceChecking()] = new Heavy_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false);
    }

    
}

//Dont know why Entry class. Maybe to show OOPS concept.
//Fuck this shit. This shit is ass.
//I wish I was a Jew, where's the gas?
class Entry{


    public static void entry(Ground_Floor ground, Normal_Floor f1, Normal_Floor f2, Normal_Floor f3, Normal_Floor f4, Normal_Floor f5) {

        //Info we take during a vehicle entry
        String Vehicle_Number;
        int Vehicle_type=0;
        boolean EV;
        boolean chargeRequired;
        boolean Handicapped;
        


        //Taking user input. Why?? Fuck life. Hate life. Kill yourself
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to IIT-TP Parking");
		System.out.print("Please provide the following information:\n1. Enter Vehicle Number:");
		
        Vehicle_Number=sc.next(); //Input Vehicle_Number as a String

		System.out.println("What is your Vehicle Type?(enter choice number)\n1. 2-Wheeler.\n2. 4-wheeler Compact.\n3. 4-wheeler normal\n 4. 4-wheeler heavy");
		
        int check=0;

        //While loop until we get a valid option from user
		while(check==0) {			

			if(check==0) Vehicle_type=sc.nextInt(); //Inputs vehicle Type

			if(Vehicle_type>4 || Vehicle_type<1) 
				System.out.println("Enter Valid option");
			else check = 1; //Terminates while loop once we have our valid option
		}


		System.out.print("2. If the vehicle is EV? (Enter true) else (Enter false)");
		EV = sc.nextBoolean();


		if(EV) {
			System.out.println("2.1 Do you require charging?" );
			chargeRequired = sc.nextBoolean();
		}
        else chargeRequired = false;


		System.out.println("3. Handicapped? (Enter true or false)");
		Handicapped = sc.nextBoolean();		

        //Ticket printed is displayed
        PrintTicket(Vehicle_Number,Vehicle_type, EV, chargeRequired, Handicapped);

        //converting int vehicleType to string for using somwhere
        String Vehicle_Type = give_Vehicle_Type(Vehicle_type);

        
        //with all the info we have about the entered vehicle
        //We now decide which floor the Vehicle may go to
        // If (EV and chargeRequired) or Handicapped  only in ground floor
        // Else take user's choice and update floor data
        if(chargeRequired && (Vehicle_type==4 || Vehicle_type==2 || Vehicle_type==3)){
            ground.ObjectCreation_for_EV_4_W(Vehicle_Number, chargeRequired);
        }
        else if(chargeRequired && Vehicle_type==1){
            ground.ObjectCreation_for_EV_2_W(Vehicle_Number, chargeRequired);
        }
        else if(Handicapped){
            ground.ObjectCreation_for_Handicapped(Vehicle_Type, Vehicle_Number, EV, chargeRequired);
        }
        else{
            int floor = forfloors(f1, f2, f3, f4, f5);
            if(floor==1){
               ObjectCreation(f1, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired);
            }
            else if(floor==2){
                ObjectCreation(f2, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired);
            }
            else if(floor==3){
                ObjectCreation(f3, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired);
            }
            else if(floor==4){
                ObjectCreation(f4, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired);
            }
            else if(floor==5){
                ObjectCreation(f5, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired);
            }
        }

        
    }

    //To avoid multiple lines in above 10 lines. Wrote a normal function and called it whenever necessary
    //Just created object in the array of particular vehicle in the particular floor
    public static void ObjectCreation(Normal_Floor f,int Vehicle_type,String Vehicle_Type, String Vehicle_Number, boolean EV, boolean chargeRequired){
        if(Vehicle_type==1) f.ObjectCreation_for_Two_Wheeler(Vehicle_Type, Vehicle_Number, EV, chargeRequired);
        else if(Vehicle_type==2) f.ObjectCreation_for_Compact_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired);
        else if(Vehicle_type==3) f.ObjectCreation_for_Normal_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired);
        else if(Vehicle_type==4) f.ObjectCreation_for_Heavy_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired);
    }


    //method that converts int Vehicle_type to String Vehicle_Type for storage in respective Vehicle object
    public static String give_Vehicle_Type(int Vehicle_type){
        if(Vehicle_type==1) return "Two Wheeler";
        if(Vehicle_type==2) return "Compact 4 Wheeler";
        if(Vehicle_type==3) return "Normal 4 Wheeler";
        return "Heavy 4 Wheeler";
    }

    //Showing user about the data of each floor and asking in which floor he(Yes 'he'. Women should stay in kitchen) would like to park
	public static int forfloors(Normal_Floor f1, Normal_Floor f2, Normal_Floor f3, Normal_Floor f4, Normal_Floor f5){
        int floor;
        Scanner sc  = new Scanner(System.in);
        
        System.out.println("-----  Floor ("+1+")   -----"); // prints the floor number
        f1.display_board(); // its data
        System.out.println("-----  Floor ("+2+")   -----"); // prints the floor number
        f1.display_board(); // its data
        System.out.println("-----  Floor ("+3+")   -----"); // prints the floor number
        f1.display_board(); // its data
        System.out.println("-----  Floor ("+4+")   -----"); // prints the floor number
        f1.display_board(); // its data
        System.out.println("-----  Floor ("+5+")   -----"); // prints the floor number
        f1.display_board(); // its data


        System.out.print("Which Floor?");
        floor = sc.nextInt();
        return floor;
    }



    //Prints ticket with all the info when the vehicle enters
	static void PrintTicket(String Vehicle_Number,int Vehicle_type, boolean EV, boolean chargeRequired, boolean Handicapped) {
		
        System.out.println("|------IIT-TP PARKING------|");
		System.out.print("Vehicle Number:"+Vehicle_Number);


		if(Vehicle_type==1) System.out.print("\n 2-wheeler");
		else if(Vehicle_type==2)System.out.print("\n 4-wheeler compact");
		else if(Vehicle_type==3)System.out.print("\n 4-wheeler normal");
		else if(Vehicle_type==4)System.out.print("\n 4-wheeler heavy");


		System.out.println("\nEV:"+EV+"\nEV charging:"+chargeRequired+"\nHandicapped:"+Handicapped);

		System.out.println(java.time.LocalDateTime.now());

		if(EV || Handicapped) System.out.println("Parking in Ground floor only");
		else System.out.println("Parking in levels one to five");
		System.out.println("Price for first 2 hours = ₹50\nPrce per extra hour = ₹20");
	}
}


public class Parking {
	

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int i;
        
        //clock object for storing time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));  


        // array to store the objects of normal-floors
        Normal_Floor[] floors = new Normal_Floor[5]; //building of 1 ground and 5 normal floors

        //Initializing things for each floor(creating objects of floors)
        for(i=0; i<5; i++) floors[i] = new Normal_Floor();

        // object for ground floor
        Ground_Floor ground = new Ground_Floor();

        


        //For object calling inside the entry() method
        //Declared in main and used in entry to avoid override of things
        Entry.entry(ground, floors[0], floors[1], floors[2], floors[3], floors[4]);
        Entry.entry(ground, floors[0], floors[1], floors[2], floors[3], floors[4]);

        //To check if its working
        System.out.println(ground.EV_2_Wheelers_array[0].VehicleNumber);
        System.out.println(ground.EV_2_Wheelers_array[1].VehicleNumber);
        //Successfully completed

        //FUCK CODING!!!!!!

      



        
        

        
        
       
    }
}

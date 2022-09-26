import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
// class EV with method EV_Charge to calculate Charging price 
class EV{
	// gives the price of EV charge used by the vehicle
	static int EV_Charge(String VehicleNumber,boolean ChargeRequired,int Watts) { // Watts is total number of charge used by vehicle
		if(ChargeRequired) {
			return 10*Watts; //returns total price of charging
		}
		return 0;
	}
}
// class checkAvailability is to check whether there are availability of slots in any of floor of given type
class checkAvailability{
    public static boolean checkAvailabilityCompact(boolean ComFirst,boolean ComSecond,boolean ComThird,boolean ComFour,boolean ComFive){ // takes input from all floors for Compact type of vehicle
        return (ComFirst | ComSecond | ComThird | ComFour | ComFive); // gives output of whether slot is empty or not
    }
    
    public static boolean checkAvailabilityNormal(boolean NorFirst,boolean NorSecond,boolean NorThird,boolean NorFour,boolean NorFive){ // takes input from all floors for Normal type of vehicle
        return (NorFirst | NorSecond | NorThird | NorFour | NorFive); // gives output of whether slot is empty or not
    }
    
    public static boolean checkAvailabilityHeavy(boolean LarFirst,boolean LarSecond,boolean LarThird,boolean LarFour,boolean LarFive){ // takes input from all floors for Heavy type of vehicle
        return (LarFirst | LarSecond | LarThird | LarFour | LarFive); // gives output of whether slot is empty or not
    }
    
    public static boolean checkAvailability2W(boolean twoWFirst,boolean twoWSecond,boolean twoWThird,boolean twoWFour,boolean twoWFive){ // takes input from all floors for Two wheeler type of vehicle
        return (twoWFirst | twoWSecond | twoWThird | twoWFour | twoWFive); // gives output of whether slot is empty or not
    }
    
    public static boolean checkAvailabilityHandi(boolean HanFirst){ // takes input from gorund floor for Handicapped type
        return (HanFirst); // gives output of whether slot is empty or not
    }
    
    public static boolean checkAvailabilityEV2W(boolean EV2First){ // takes input from gorund floor for EV2 Wheeler type of vehicle
        return (EV2First); // gives output of whether slot is empty or not
    }
    
    public static boolean checkAvailabilityEV4W(boolean EV4First){ // takes input from gorund floor for EV4 Wheeler type of vehicle
        return (EV4First); // gives output of whether slot is empty or not
    }
} 

// Vehicle is an abstract class that extends to classes such as Two_Wheeler, Compact_4_W, Normal_4_W, Heavy_4_W
// EV_4_W and EV_2_W and Handicapped 
abstract class Vehicle{
    SimpleDateFormat intime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
    Date datein =new Date();
    String Vehicle_Type;  // 2 Wheeler or Compact 4 W or Normal 4 W or Heavy 4 W
    String VehicleNumber;  // Stores vehicel number in a string
	boolean EV;  // boolean if Vehicle is Ev or not
	boolean ChargeRequired; // Does it require charging
    boolean Handicapped; // boolean if its handicapped or not
    
}

// This is the class used to store details of a TWO wheeler vehicle
class Two_Wheeler extends Vehicle{

	//Constructor
    Two_Wheeler(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

// This is the class used to store details of a COMPACT four wheeler vehicle
class Compact_4_W extends Vehicle{

    //Constructor
    Compact_4_W(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

// This is the class used to store details of a NORMAL four wheeler vehicle
class Normal_4_W extends Vehicle{

    //Constructor
    Normal_4_W(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

// This is the class used to store details of a HEAVY four wheeler vehicle
class Heavy_4_W extends Vehicle{

    //Constructor
    Heavy_4_W(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.Vehicle_Type = Vehicle_Type;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

// This is the class used to store details of a HANDICAPPED type of vehicle
class Handicapped extends Vehicle{

    //Constructor
    Handicapped(String Vehicle_Type, String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.VehicleNumber = VehicleNumber;
        this.Vehicle_Type = Vehicle_Type;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

// This is the class used to store details of a EV(normal, compact, heavy) four wheeler vehicle
class EV_4_W extends Vehicle{

    //Constructor
    EV_4_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

// This is the class used to store details of a EV TWO wheeler vehicle
class EV_2_W extends Vehicle{

    //Constructor
    EV_2_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped,SimpleDateFormat intime){
    	this.intime=intime;
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}
// Abstract class Floor extending to each floor
// Contains all common details between floors
abstract class Floor{
    int compact_4_wheelers; //current no of vehicles in each floor
    int max_compact_4_wheelers;// constant
    int normal_4_wheelers;
    int max_normal_4_wheelers;// constant
    int large_4_wheelers;
    int max_large_4_wheelers;// constant
    int two_wheelers;
    int max_two_wheelers;// constant

    abstract void display_board(); // displays the no of empty slots for parking in order of (total, 4w, 2w)
    abstract int exit(String Vehicle_type, String Vehicle_Number); // does all the functions when a vehicle exits
}

// contains all the contents of ground floor of the building
class Ground_Floor extends Floor{

    int handicapped_vehicles = 0;
    private final int max_handicapped_vehicles = 50;
    int EV_4_wheelers = 0;
    private final int max_EV_4_Wheelers = 30;
    int EV_2_wheelers = 0;
    private final int max_EV_2_Wheelers = 20;

    boolean handicappedStatus[]=new boolean[50];
    boolean EV4Status[]=new boolean[30];
    boolean EV2Status[]=new boolean[20];
    
	 // displays the no of empty slots for parking in order of (total, 4w, 2w)
    void display_board(){
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
// returning empty slot position if present
    int EV4PlaceChecking(){
        for(int i=0;i<30;i++){
            if(this.EV4Status[i]==false) {
                this.EV4Status[i]=true;
                return i;
            }
        }
        return -1;
    }
// returning empty slot position if present
    int EV2PlaceChecking(){
        for(int i=0;i<20;i++){
            if(this.EV2Status[i]==false) {
                this.EV2Status[i]=true;
                return i;
            }
        }
        return -1;
    }
// returning empty slot position if present
    int handicappedPlaceChecking(){
        for(int i=0;i<50;i++){
            if(this.handicappedStatus[i]==false){
                this.handicappedStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
	
// this method scans entry ticket and gives you price and payment options
// also updates capactiy of building 
    public int exit(String Vehicle_type, String Vehicle_number){
    	SimpleDateFormat outtime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss"); // Gets the time at exit
    	Date dateout=new Date();
    	outtime.setTimeZone(TimeZone.getTimeZone("IST"));
    	long timeout =dateout.getTime();
        int i; 
        int totalPrice=0; // price gets updated in this varaible at every stage
	    
        if(Vehicle_type.equals("EV2W") ) {
        	for(i=0;i< 20; i++) {
        		if(EV_2_Wheelers_array[i].VehicleNumber.equals(Vehicle_number)) { // Checking position of object in the array of EV2W in ground floor
        			break;
        		}
        	}
		// updating total number of EV2W and it's position
        	this.EV_2_wheelers--; 
        	EV2Status[i]=false;
        	
        	long intime = EV_2_Wheelers_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	
		// Updating price according to time of entry and exit
        	if(durationinhours <= 1) {
        		totalPrice= (int)rate + EV.EV_Charge(EV_2_Wheelers_array[i].VehicleNumber,true,3);} // 3 is number of Watts of charge used by Vehicle
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice= (int)rate+EV.EV_Charge(EV_2_Wheelers_array[i].VehicleNumber,true,3); // 3 is number of Watts of charge used by Vehicle
        	}
    		File Data = new File("Data.txt"); // enetering values to a file to store data
    		try {
    			Data.createNewFile();
    			FileWriter Fwriter = new FileWriter(Data,true);
    			Fwriter.write("  "+EV_2_Wheelers_array[i].VehicleNumber+"          2-Wheeler                 yes                "+EV_2_Wheelers_array[i].Handicapped+"               "+totalPrice+"\n");
    			Fwriter.close();
    		}catch(IOException e) {}
        }
	   
        else if(Vehicle_type.equals("EV4W") ) {
        	for(i=0;i< 30; i++) {
        		if(EV_4_Wheelers_array[i].VehicleNumber.equals(Vehicle_number)) { // Checking position of object in the array of EV4W in ground floor
        			break;
        		}
        	}
		
		// updating total number of EV4W and it's position
        	this.EV_4_wheelers--;
        	EV4Status[i]=false;
        	long intime = EV_4_Wheelers_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
		
		// Updating price according to time of entry and exit
        	if(durationinhours <= 1) {totalPrice= (int)rate+EV.EV_Charge(EV_4_Wheelers_array[i].VehicleNumber,true,3);} // 3 is number of Watts of charge used by Vehicle
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice= (int)rate+EV.EV_Charge(EV_4_Wheelers_array[i].VehicleNumber,true,3); // 3 is number of Watts of charge used by Vehicle
        	}
    		File Data = new File("Data.txt"); // enetering values to a file to store data
    		try {
    			Data.createNewFile();
    			FileWriter Fwriter = new FileWriter(Data,true);
    			Fwriter.write("  "+EV_4_Wheelers_array[i].VehicleNumber+"          4-Wheeler                 yes                "+EV_4_Wheelers_array[i].Handicapped+"               "+totalPrice+"\n");
    			Fwriter.close();
    		}catch(IOException e) {}
        }
        else if(Vehicle_type.equals("HV") ) {
        	for(i=0;i< 50; i++) {
        		if(Handicapped_array[i].VehicleNumber.equals(Vehicle_number)) { // Checking position of object in the array of Handicapped in ground floor
        			break;
        		}
        	}
		
		// updating total number of Handicapped and it's position
        	this.handicapped_vehicles--;
        	handicappedStatus[i]=false;
        	long intime = Handicapped_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
		
		// Updating price according to time of entry and exit
        	if(durationinhours <= 1) {totalPrice =  (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice= (int)rate;
        	}
    		File Data = new File("Data.txt"); // enetering values to a file to store data
    		try {
    			Data.createNewFile();
    			FileWriter Fwriter = new FileWriter(Data,true);
    			Fwriter.write("  "+Handicapped_array[i].VehicleNumber+"          Handicapped                 "+Handicapped_array[i].ChargeRequired+"                yes               "+totalPrice+"\n");
    			Fwriter.close();
    		}catch(IOException e) {}
        }
        return totalPrice;
    }

    //Below are the arrays of a specfic vehicle representing the vehicles' slot in that floor
    private EV_4_W[] EV_4_Wheelers_array = new EV_4_W[30];
    private EV_2_W[] EV_2_Wheelers_array = new EV_2_W[20];
    private Handicapped[] Handicapped_array = new Handicapped[30];

    

    //Below functions are called in Entry class when we know the Vehicle Type that entered
    //The functions below create an object of that vehicle to store in its respective array of vehicles
    void ObjectCreation_for_EV_4_W(String Vehicle_Number, boolean chargeRequired,SimpleDateFormat intime){
        EV_4_Wheelers_array[this.EV4PlaceChecking()] = new EV_4_W(Vehicle_Number, true, chargeRequired, false,intime);
        this.EV_4_wheelers++;
    }
    void ObjectCreation_for_EV_2_W(String Vehicle_Number, boolean chargeRequired,SimpleDateFormat intime){
        EV_2_Wheelers_array[this.EV2PlaceChecking()] = new EV_2_W(Vehicle_Number, true, chargeRequired, false,intime);
        this.EV_2_wheelers++;
    }
    void ObjectCreation_for_Handicapped(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired,SimpleDateFormat intime){
        Handicapped_array[this.handicappedPlaceChecking()] = new Handicapped(Vehicle_Type, Vehicle_Number, EV, chargeRequired, true,intime);
        this.handicapped_vehicles++;
    }

}

class Normal_Floor extends Floor{
    int compact_4_wheelers = 0;
    private final int max_compact_4_wheelers = 25;
    int normal_4_wheelers = 0;
    private final int max_normal_4_wheelers = 35;
    int heavy_4_wheelers = 0;
    private final int max_heavy_4_wheelers = 10;
    int two_wheelers = 0;
    private final int max_two_wheelers = 30;

    boolean normal4WheelerStatus[]=new boolean[35];
    boolean compact4WheelerStatus[]=new boolean[25];
    boolean heavy4WheelerStatus[]=new boolean[10];
    boolean twoWheelerStatus[]=new boolean[30];
    
	// Checking whether there are empty slots in Compact_4_Wheelers Section
	boolean compactChecking(){
        if(this.max_compact_4_wheelers>this.compact_4_wheelers){
            return true;
        }
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
        return false;
    }
    // Checking wether there are empty slots in 2_Wheelers Section
    boolean twoWheelerChecking(){
        if(this.max_two_wheelers>this.two_wheelers){
            return true;
        }
        return false;
    }


    //Displays all the info about a particular floor
    void display_board(){
        System.out.println("Total Empty Compact 4W Slots: " + (this.max_compact_4_wheelers - this.compact_4_wheelers));
        System.out.println("Total Empty Normal 4W Slots: " + (this.max_normal_4_wheelers - this.normal_4_wheelers));
        System.out.println("Total Empty Large 4W Slots: " + (this.max_heavy_4_wheelers - this.heavy_4_wheelers));
        System.out.println("Total Empty 2W Slots: " + (this.max_two_wheelers - this.two_wheelers));
    }

	//Checks empty place for Compact vehicle in a particular floor 
    int compactPlaceChecking(){
        for(int i=0;i<25;i++){
            if(this.compact4WheelerStatus[i]==false){
                compact4WheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    
	//Checks empty place for Normal vehicle in a particular floor
    int normalPlaceChecking(){
        for(int i=0;i<35;i++){
            if(this.normal4WheelerStatus[i]==false){
                normal4WheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }

	//Checks empty place for Heavy vehicle in a particular floor
    int heavyPlaceChecking(){
        for(int i=0;i<25;i++){
            if(this.heavy4WheelerStatus[i]==false){
                heavy4WheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    
	//Checks empty place for Two wheeler vehicle in a particular floor
    int twoWheelerPlaceChecking(){
        for(int i=0;i<25;i++){
            if(this.twoWheelerStatus[i]==false){
                twoWheelerStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
    
	
	// this method scans entry ticket and gives you price and payment options
	// also updates capactiy of building 
    public int exit(String Vehicle_type, String Vehicle_number){
    	SimpleDateFormat outtime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
    	Date dateout=new Date();
    	outtime.setTimeZone(TimeZone.getTimeZone("IST"));
    	long timeout =dateout.getTime();
        int i;
        int totalPrice=0;
        if(Vehicle_type.equals("2W") ) {
        	for(i=0;i< 30; i++) {
        		if(two_Wheeler_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
		
		// updating total number of two wheeler and it's position
        	this.two_wheelers--;
        	twoWheelerStatus[i]=false;
        	long intime = two_Wheeler_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	
		// Updating price according to time of entry and exit
		if(durationinhours <= 1) {totalPrice = (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice= (int)rate;
        	}
			File Data = new File("Data.txt"); // enetering values to a file to store data
			try {
				Data.createNewFile();
				FileWriter Fwriter = new FileWriter(Data,true);
				Fwriter.write("  "+two_Wheeler_array[i].VehicleNumber+"          2-Wheeler                 no                no               "+totalPrice+"\n");
				Fwriter.close();
			}catch(IOException e) {}
        }
        else if(Vehicle_type.equals("C4W") ) {
        	for(i=0;i< 25; i++) {
        		if(Compact_4_W_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
		
		// updating total number of COMPACT four wheeler and it's position
        	this.compact_4_wheelers--;
        	compact4WheelerStatus[i]=false;
        	long intime = Compact_4_W_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
		
		// Updating price according to time of entry and exit
        	if(durationinhours <= 1) {totalPrice= (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice= (int)rate;
        	}
    		File Data = new File("Data.txt"); // enetering values to a file to stroe data
    		try {
    			Data.createNewFile();
    			FileWriter Fwriter = new FileWriter(Data,true);
    			Fwriter.write("  "+Compact_4_W_array[i].VehicleNumber+"          4-Wheeler(C)                 no                no               "+totalPrice+"\n");
    			Fwriter.close();
    		}catch(IOException e) {}
        }
        else if(Vehicle_type.equals("N4W") ) {
        	for(i=0;i< 35; i++) {
        		if(Normal_4_W_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
		
		// updating total number of NORMAL four wheeler and it's position
        	this.normal_4_wheelers--;
        	normal4WheelerStatus[i]=false;
        	long intime = Normal_4_W_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
		
		// Updating price according to time of entry and exit
        	if(durationinhours <= 1) {totalPrice = (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice = (int)rate;
        	}
    		File Data = new File("Data.txt"); // enetering values to a file to stroe data
    		try {
    			Data.createNewFile();
    			FileWriter Fwriter = new FileWriter(Data,true);
    			Fwriter.write("  "+Normal_4_W_array[i].VehicleNumber+"          4-Wheeler(N)                 no                no               "+totalPrice+"\n");
    			Fwriter.close();
    		}catch(IOException e) {}
        }
        else if(Vehicle_type.equals("H4W") ) {
        	for(i=0;i< 10; i++) {
        		if(Heavy_4_W_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
		
		// updating total number of HEAVY four wheeler and it's position
        	this.heavy_4_wheelers--;
        	heavy4WheelerStatus[i]=false;
        	long intime = Heavy_4_W_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
		
		// Updating price according to time of entry and exit
        	if(durationinhours <= 1) {totalPrice = (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    totalPrice = (int)rate;
        	}
    		File Data = new File("Data.txt"); // enetering values to a file to stroe data
    		try {
    			Data.createNewFile();
    			FileWriter Fwriter = new FileWriter(Data,true);
    			Fwriter.write("  "+Heavy_4_W_array[i].VehicleNumber+"          4-Wheeler(H)                 no                no               "+totalPrice+"\n");
    			Fwriter.close();
    		}catch(IOException e) {}
        }
        return totalPrice;
    }

    //Below are the arrays of a specific vehicle representing the vehicles' slot in that floor
    private Two_Wheeler[] two_Wheeler_array = new Two_Wheeler[30];
    private Compact_4_W[] Compact_4_W_array = new Compact_4_W[25];
    private Normal_4_W[] Normal_4_W_array = new Normal_4_W[35];
    private Heavy_4_W[] Heavy_4_W_array = new Heavy_4_W[10];

    //Below functions are called in Entry class when we know the Vehicle Type that entered
    //The functions below create an object of that vehicle to store in its respective array of vehicles
    void ObjectCreation_for_Two_Wheeler(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired,SimpleDateFormat intime){
        two_Wheeler_array[twoWheelerPlaceChecking()] = new Two_Wheeler(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false,intime);
        this.two_wheelers++;
    }
    void ObjectCreation_for_Compact_4_W(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired,SimpleDateFormat intime){
        Compact_4_W_array[compactPlaceChecking()] = new Compact_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false,intime);
        this.compact_4_wheelers++;
    }
    void ObjectCreation_for_Normal_4_W(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired,SimpleDateFormat intime){
        Normal_4_W_array[normalPlaceChecking()] = new Normal_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false,intime);
        this.normal_4_wheelers++;
    }
    void ObjectCreation_for_Heavy_4_W(String Vehicle_Type, String Vehicle_Number,boolean EV, boolean chargeRequired,SimpleDateFormat intime){
        Heavy_4_W_array[heavyPlaceChecking()] = new Heavy_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired, false,intime);
        this.heavy_4_wheelers++;
    }
   
}

// This class contains all methods for entrance of a vehicle
class Entry {

//Method used to note the details of vehicle entered
    public static void entry(Ground_Floor ground, Normal_Floor f1, Normal_Floor f2, Normal_Floor f3, Normal_Floor f4, Normal_Floor f5) {

        //Info we take during a vehicle entry
        String Vehicle_Number;
        int Vehicle_type=0;
        boolean EV;
        boolean chargeRequired;
        boolean Handicapped;

        //Taking user input. 
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to IIT-TP Parking");
		System.out.println("Please provide the following information:\n1. Enter Vehicle Number:");
		
        Vehicle_Number=sc.next(); //Input Vehicle_Number as a String

		System.out.println("What is your Vehicle Type?(enter choice number)\n1. 2-Wheeler.\n2. 4-wheeler Compact.\n3. 4-wheeler normal\n4. 4-wheeler heavy");
		
        int check=0; // flag used to check whether optin is valid or not

        //While loop until we get a valid option from user
		while(check==0) {			

			if(check==0) Vehicle_type=sc.nextInt(); //Inputs vehicle Type

			if(Vehicle_type>4 || Vehicle_type<1) 
				System.out.println("Enter Valid option");
			else check = 1; //Terminates while loop once we have our valid option
		}
		
// Following if else ladder stops the entry method if accomodation is full
		if(Vehicle_type==2) {
			if(checkAvailability.checkAvailabilityCompact(f1.compactChecking(),f2.compactChecking(),f3.compactChecking(),f4.compactChecking(),f5.compactChecking())){ 				
			}
			else {
				return;
			}
		}
		
		else if(Vehicle_type==3) {
			if(checkAvailability.checkAvailabilityNormal(f1.normalChecking(),f2.normalChecking(),f3.normalChecking(),f4.normalChecking(),f5.normalChecking())) {
				
			}
			else {
				return;
			}
		}
		
		else if(Vehicle_type==4) {
			if(checkAvailability.checkAvailabilityHeavy(f1.heavyChecking(),f2.heavyChecking(),f3.heavyChecking(),f4.heavyChecking(),f5.heavyChecking())) {
				
			}
			else {
				return;
			}
		}

		System.out.print("2. If the vehicle is EV? (Enter true) else (Enter false)");
		EV = sc.nextBoolean(); // Whether EV or not


		if(EV) {
			System.out.println("2.1 Do you require charging?" ); // Takes input for charging required or not
			chargeRequired = sc.nextBoolean();
		}
        else chargeRequired = false;


		System.out.println("3. Handicapped? (Enter true or false)");
		Handicapped = sc.nextBoolean();	//Whether Handicapped or not

        //Ticket printed is displayed
        PrintTicket(Vehicle_Number,Vehicle_type, EV, chargeRequired, Handicapped);

        //converting int vehicleType to string for using somwhere
        String Vehicle_Type = give_Vehicle_Type(Vehicle_type);

        SimpleDateFormat sd1= new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
        Date date = new Date();
        sd1.setTimeZone(TimeZone.getTimeZone("IST"));
        
	//with all the info we have about the entered vehicle
        
	//We now decide which floor the Vehicle may go to
        
	// If (EV and chargeRequired) or Handicapped  only in ground floor
        
	// Else take user's choice and update floor data
        
	int floor=0; // we get floor of vehicle if it's not EV nor Handicapped and store in this variable
        if(chargeRequired && (Vehicle_type==4 || Vehicle_type==2 || Vehicle_type==3)){
            ground.ObjectCreation_for_EV_4_W(Vehicle_Number, chargeRequired,sd1);
        }
        else if(chargeRequired && Vehicle_type==1){
            ground.ObjectCreation_for_EV_2_W(Vehicle_Number, chargeRequired,sd1);
        }
        else if(Handicapped){
            ground.ObjectCreation_for_Handicapped(Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
        }
        else{
            floor = forfloors(f1, f2, f3, f4, f5);
            if(floor==1){
               ObjectCreation(f1, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired, sd1);
            }
            else if(floor==2){
                ObjectCreation(f2, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
            }
            else if(floor==3){
                ObjectCreation(f3, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
            }
            else if(floor==4){
                ObjectCreation(f4, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
            }
            else if(floor==5){
                ObjectCreation(f5, Vehicle_type, Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
            }
        }
        
    }

	//To avoid multiple lines in above 10 lines. Wrote a normal function and called it whenever necessary
    //Just created object in the array of particular vehicle in the particular floor
    public static void ObjectCreation(Normal_Floor f,int Vehicle_type,String Vehicle_Type, String Vehicle_Number, boolean EV, boolean chargeRequired, SimpleDateFormat sd1){
        if(Vehicle_type==1) f.ObjectCreation_for_Two_Wheeler(Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
        else if(Vehicle_type==2) f.ObjectCreation_for_Compact_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
        else if(Vehicle_type==3) f.ObjectCreation_for_Normal_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
        else if(Vehicle_type==4) f.ObjectCreation_for_Heavy_4_W(Vehicle_Type, Vehicle_Number, EV, chargeRequired,sd1);
    }

    //method that converts int Vehicle_type to String Vehicle_Type for storage in respective Vehicle object
    public static String give_Vehicle_Type(int Vehicle_type){
        if(Vehicle_type==1) return "Two Wheeler";
        if(Vehicle_type==2) return "Compact 4 Wheeler";
        if(Vehicle_type==3) return "Normal 4 Wheeler";
        return "Heavy 4 Wheeler";
    }

    //Showing user about the data of each floor and asking in which floor his/her vehicle would like to be parked
	public static int forfloors(Normal_Floor f1, Normal_Floor f2, Normal_Floor f3, Normal_Floor f4, Normal_Floor f5){
        int floor;
        Scanner sc  = new Scanner(System.in);
        
        System.out.println("-----  Floor ("+1+")   -----"); // prints the floor number
        f1.display_board(); // its data
        System.out.println("-----  Floor ("+2+")   -----"); // prints the floor number
        f2.display_board(); // its data
        System.out.println("-----  Floor ("+3+")   -----"); // prints the floor number
        f3.display_board(); // its data
        System.out.println("-----  Floor ("+4+")   -----"); // prints the floor number
        f4.display_board(); // its data
        System.out.println("-----  Floor ("+5+")   -----"); // prints the floor number
        f5.display_board(); // its data

        System.out.print("From sensor at entry\nWhich Floor?\n"); // Sensor input saying vehicle entered which floor 
        floor = sc.nextInt();
        return floor;
    }

    //Prints ticket with all the info when the vehicle enters
	static void PrintTicket(String Vehicle_Number,int Vehicle_type, boolean EV, boolean chargeRequired, boolean Handicapped) {
		
        System.out.println("|------IIT-TP PARKING------|");
		System.out.println();
		System.out.println("Vehicle Number:"+Vehicle_Number);

		if(Vehicle_type==1) System.out.print("\n 2-wheeler");
		else if(Vehicle_type==2)System.out.print("\n 4-wheeler compact");
		else if(Vehicle_type==3)System.out.print("\n 4-wheeler normal");
		else if(Vehicle_type==4)System.out.print("\n 4-wheeler heavy");

		System.out.println();
		System.out.println("\nEV:"+EV+"\nEV charging:"+chargeRequired+"\nHandicapped:"+Handicapped);
		System.out.println();
		System.out.println(java.time.LocalDateTime.now());
		System.out.println();
		if(EV || Handicapped) System.out.println("Parking in Ground floor only");
		else System.out.println("Parking in levels one to five");
		System.out.println();
		System.out.println("Price for first 2 hours = ₹50\nPrce per extra hour = ₹20");
		System.out.println();
	}
}

// Exit class contains methods to make exit of vehicles 
class Exit {
	
	// Method used update vehicle position and floor capacity
	public static void exit(Ground_Floor ground, Normal_Floor f1, Normal_Floor f2, Normal_Floor f3, Normal_Floor f4, Normal_Floor f5) {
		int floor,price=0;
		String Vehicle_Type, Vehicle_Number;
		Scanner sc= new Scanner(System.in);

		System.out.println();
		//The QR code is scanned at the exit gate of the floor
		//Since each floor has its own exit, we are taking it as an input from user. Instead in application 
		//this is not needed.
		System.out.print("Enter floor:");
		floor = sc.nextInt(); // Taking floor input from a sensor
		sc.nextLine();
		
		//The scanner scans the Ticket and gets the below info automatically
		if(floor==0){
			System.out.println("Type 'EV2W' for EV 2 Wheeler.");
			System.out.println("Type 'EV4W' for EV 4 Wheeler.");
			System.out.println("Type 'HV' for Handicapped Vehicle.");
		}
		else{
			System.out.println("Type '2W' for 2 Wheeler.");
			System.out.println("Type 'C4W' for Compact 4 Wheeler.");
			System.out.println("Type 'N4W' for Normal 4 Wheeler.");
			System.out.println("Type 'H4W' for Heavy 4 Wheeler.");
		}
		
		System.out.print("Enter Vehicle Type:");
		Vehicle_Type = sc.nextLine(); // Taking Vehicle type form user
		
		System.out.print("\nEnter Vehicle Number:");
		Vehicle_Number=sc.nextLine(); // Taking Vehcle Number from user
		
		// Since, each floor has it's own exit, we take floor as an input from sensor above activate it's exit function
		if(floor==0) {
			price = ground.exit(Vehicle_Type, Vehicle_Number);
			System.out.println("Total Price :" + price);
		}
		else if(floor==1) {
			price = f1.exit(Vehicle_Type, Vehicle_Number);
			System.out.println("Total Price :" + price);
		}
		else if(floor==2) {
			price = f2.exit(Vehicle_Type, Vehicle_Number);
			System.out.println("Total Price :" + price);
		}
		else if(floor==3) {
			price = f3.exit(Vehicle_Type, Vehicle_Number);
			System.out.println("Total Price :" + price);
		}
		else if(floor==4) {
			price = f4.exit(Vehicle_Type, Vehicle_Number);
			System.out.println("Total Price :" + price);
		}
		else if(floor==5) {
			price = f5.exit(Vehicle_Type, Vehicle_Number);
			System.out.println("Total Price :" + price);
		}
		
		int pay=0,GivenCash=0; // 'pay' is for which type of payment method used by user to pay
		boolean flag=true; // flag is a boolean to make sure that payment is done
		
		while(flag){
			System.out.println( "If you want to pay in CASH (PRESS 1) or CARD (PRESS 2) or UPI (PRESS 3)");
			pay=sc.nextInt();
			// Cash method
			if(pay==1) { 
				System.out.println("Cash received from customer : ");
				GivenCash=sc.nextInt();
				if(GivenCash>=price) { // If cash given is less than price we ask them to try again
					System.out.println("Return: "+ (GivenCash-price));
					flag=false;
				}	
				else{
					System.out.println("Please give correct amount");	
				}
			}
			// Credit Card method
			else if(pay==2){
				System.out.println("Scan your card here.");
				System.out.println("Scanning completed. Please enter amount :");
				GivenCash=sc.nextInt(); // Input from bank servers
				if(GivenCash==price){ //For card to be payment method amount of money given should be tallyed to price of the ticket
					System.out.println("Your TRANSACTION is SUCEESFUL");
					flag=false;
				}
				else{
					System.out.println("Your TRANSACTION has DECLINED\nPlease try again");
				}
			}
			// UPI method
			else if(pay==3){
				System.out.println("Scan this QR code");
				System.out.println("Scanning completed. Please enter amount :");
				GivenCash=sc.nextInt(); // Input from server of UPI's  
				if(GivenCash==price){ //For UPI to be payment method amount of money given should be tallyed to price of the ticket
					System.out.println("Your TRANSACTION is SUCEESFUL");
					flag=false;
				}
				else{
					System.out.println("Your TRANSACTION has DECLINED\nPlease try again");
				}
			}
		}
		System.out.println("Thanks for Coming to our parking lot");
	}
	
}

public class Parking {

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int i;
        
        //Here we are using file handling and creating a .txt file.
        //we are using try and catch method to remove different types of exception.
        //we are using .createNewFile method which creates the file if it is not already present
        //if already present it remains unchanged
        //createNewFile is boolean return type
        //we FileWriter class to append data to the file
		File Data = new File("Data.txt");
		try {
			if(Data.createNewFile()){
				FileWriter Fwriter = new FileWriter(Data,true);
				Fwriter.write("Vehicle Number     Vehicle Type     EV Charge reqiured     Handicapped     Rate\n");
				Fwriter.close();
			}
		}catch(IOException e) {}
        
        // array to store the objects of normal-floors
        Normal_Floor[] floors = new Normal_Floor[5]; //building of 1 ground and 5 normal floors

        //Initialising things for each floor(creating objects of floors)
        for(i=0; i<5; i++) floors[i] = new Normal_Floor();

        // object for ground floor
        Ground_Floor ground = new Ground_Floor();

        //For object calling inside the entry() method
        //Declared in main and used in entry to avoid override of things
        int choice;
        while(true) {
        	System.out.println("Enter valid option :\n1.Vehicle Entry.\n2.Vehicle Exit.\n3.Close Parking lot.\n4.Print Data.");
        	choice = sc.nextInt();
        	switch(choice) {
        	case 1:
        		Entry.entry(ground, floors[0], floors[1], floors[2], floors[3], floors[4]);
        		break;
        	case 2:
        		Exit.exit(ground, floors[0], floors[1], floors[2], floors[3], floors[4]);
        		break;
        	case 3:
        		System.out.println("Parking lot closed !!!");
        		System.exit(0);
        	case 4:
        		//we are Scanner(Object) to read and print file data
        		//here .hasNext() returns true if there is data present after pointer and print data using scanner_name.nextLine
        		try{
        			Scanner Fscn = new Scanner(Data);
        			while(Fscn.hasNext()) {
        				System.out.println(Fscn.nextLine());
        			}
        			Fscn.close();
        		}catch(IOException e) {}
        		break;
        		
        	default :
        		System.out.println("Invalid choice!!! Please make a valid choice. \n\n");
        	}
        }
    }
}

// Credits : Group 10 
// 1.Teja Manchikatla CS21B031
// 2.Chetan Moturi CS21B017
// 3.A Shree Balaji CS21B008
// 4.K.E.Nanda Kishore CS21B025
// 5. Andaluri SPVM Aditya CS21B021

//995th line..!! AND YOU KNOW WHY!!
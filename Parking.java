import java.util.*;
import java.lang.*;
import java.text.*;
// class EV with method EV_Charge to calculate Charging price 
class EV{
	static int EV_Charge(String VehicleNumber,boolean ChargeRequired,int Watts) {
		if(ChargeRequired) {
			return 10*Watts;
		}
		return 0;
	}
}
// class checkAvailability is to check whether there are availability of slots in any of floor of given type
class checkAvailability{
    public static boolean checkAvailabilityCompact(boolean ComFirst,boolean ComSecond,boolean ComThird,boolean ComFour,boolean ComFive){
        return (ComFirst | ComSecond | ComThird | ComFour | ComFive);
    }
    
    public static boolean checkAvailabilityNormal(boolean NorFirst,boolean NorSecond,boolean NorThird,boolean NorFour,boolean NorFive){
        return (NorFirst | NorSecond | NorThird | NorFour | NorFive);
    }
    
    public static boolean checkAvailabilityHeavy(boolean LarFirst,boolean LarSecond,boolean LarThird,boolean LarFour,boolean LarFive){
        return (LarFirst | LarSecond | LarThird | LarFour | LarFive);
    }
    
    public static boolean checkAvailability2W(boolean twoWFirst,boolean twoWSecond,boolean twoWThird,boolean twoWFour,boolean twoWFive){
        return (twoWFirst | twoWSecond | twoWThird | twoWFour | twoWFive);
    }
    
    public static boolean checkAvailabilityHandi(boolean HanFirst){
        return (HanFirst);
    }
    
    public static boolean checkAvailabilityEV2W(boolean EV2First){
        return (EV2First);
    }
    
    public static boolean checkAvailabilityEV4W(boolean EV4First){
        return (EV4First);
    }
} 


// Vehicle is an abstract class that extends to classes such as Two_Wheeler, Compact_4_W, Normal_4_W, Heavy_4_W
// EV_4_W and EV_2_W and Handicapped 
abstract class Vehicle{
    SimpleDateFormat intime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
    Date datein =new Date();
    String Vehicle_Type;  // 2 Wheeler or Compact 4 W or Normal 4 W or Heavy 4 W
    String VehicleNumber;  // 
	boolean EV;  // boolean if Vehicle is Ev or not
	boolean ChargeRequired; // Does it require charging
    boolean Handicapped; // boolean if its handicapped or not
    
}

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
    abstract int exit(String Vehicle_type, String Vehicle_Number); // does all the functions when a vehicle exits
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
       // System.out.println("Total Empty Slots: " + (max_capacity - current_capacity));
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

	// returning empty slot positiion
    int EV4PlaceChecking(){
        for(int i=0;i<30;i++){
            if(this.EV4Status[i]==false) {
                this.EV4Status[i]=true;
                return i;
            }
        }
        return -1;
    }
    
	// returning empty slot positiion
    int EV2PlaceChecking(){
        for(int i=0;i<20;i++){
            if(this.EV2Status[i]==false) {
                this.EV2Status[i]=true;
                return i;
            }
        }
        return -1;
    }
    
	// returning empty slot positiion
    int handicappedPlaceChecking(){
        for(int i=0;i<50;i++){
            if(this.handicappedStatus[i]==false){
                this.handicappedStatus[i]=true;
                return i;
            }
        }
        return -1;
    }
	
    public int exit(String Vehicle_type, String Vehicle_number){
    	SimpleDateFormat outtime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
    	Date dateout=new Date();
    	outtime.setTimeZone(TimeZone.getTimeZone("IST"));
    	long timeout =dateout.getTime();
    	//this.current_capacity--;
        int i;
	    //  int EV_Charge(String VehicleNumber,boolean ChargeRequired)
        if(Vehicle_type.equals("EV2W") ) {
        	for(i=0;i< 20; i++) {
        		if(EV_2_Wheelers_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.EV_2_wheelers--;
        	EV2Status[i]=false;
        	
        	long intime = EV_2_Wheelers_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	if(durationinhours <= 1) {return (int)rate + EV.EV_Charge(EV_2_Wheelers_array[i].VehicleNumber,true,3);} // 3 is number of Watts of charge used by Vehicle
        	else {
        	    rate=20+((durationinhours-1)*10)
        	    return (int)rate+EV.EV_Charge(EV_2_Wheelers_array[i].VehicleNumber,true,3); // 3 is number of Watts of charge used by Vehicle
        	}
        }
        else if(Vehicle_type.equals("EV4W") ) {
        	for(i=0;i< 30; i++) {
        		if(EV_4_Wheelers_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.EV_4_wheelers--;
        	EV4Status[i]=false;
        	long intime = EV_4_Wheelers_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	if(durationinhours <= 1) {return (int)rate+EV.EV_Charge(EV_4_Wheelers_array[i].VehicleNumber,true,3);}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    return (int)rate+EV.EV_Charge(EV_4_Wheelers_array[i].VehicleNumber,true,3); // 3 is number of Watts of charge used by Vehicle
        	}
        }
        else if(Vehicle_type.equals("h") ) {
        	for(i=0;i< 50; i++) {
        		if(Handicapped_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.handicapped_vehicles--;
        	handicappedStatus[i]=false;
        	long intime = Handicapped_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	if(durationinhours <= 1) {return (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    return (int)rate;
        	}
        }
        return 0;
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
    
	// Checking whether there are empty slots in Compact_4_Wheelers Section
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
    
    public int exit(String Vehicle_type, String Vehicle_number){
    	SimpleDateFormat outtime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
    	Date dateout=new Date();
    	outtime.setTimeZone(TimeZone.getTimeZone("IST"));
    	long timeout =dateout.getTime();
        int i;
        if(Vehicle_type.equals("2W") ) {
        	for(i=0;i< 30; i++) {
        		if(two_Wheeler_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.two_wheelers--;
        	twoWheelerStatus[i]=false;
        	long intime = two_Wheeler_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	
		if(durationinhours <= 1) {return (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    return (int)rate;
        	}
        	
        }
        else if(Vehicle_type.equals("C4W") ) {
        	for(i=0;i< 25; i++) {
        		if(Compact_4_W_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.compact_4_wheelers--;
        	compact4WheelerStatus[i]=false;
        	long intime = Compact_4_W_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	if(durationinhours <= 1) {return (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    return (int)rate;
        	}
        }
        else if(Vehicle_type.equals("N4W") ) {
        	for(i=0;i< 35; i++) {
        		if(Normal_4_W_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.normal_4_wheelers--;
        	normal4WheelerStatus[i]=false;
        	long intime = Normal_4_W_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	if(durationinhours <= 1) {return (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    return (int)rate;
        	}
        }
        else if(Vehicle_type.equals("H4W") ) {
        	for(i=0;i< 10; i++) {
        		if(Heavy_4_W_array[i].VehicleNumber.equals(Vehicle_number)) {
        			break;
        		}
        	}
        	this.heavy_4_wheelers--;
        	heavy4WheelerStatus[i]=false;
        	long intime = Heavy_4_W_array[i].datein.getTime();
        	long duration = (timeout - intime)/1000 ;
        	float durationinhours =(float)duration/3600;
        	float rate=20;
        	if(durationinhours <= 1) {return (int)rate;}
        	else {
        	    rate=20+((durationinhours-1)*10);
        	    return (int)rate;
        	}
        }
        return 0;
    }
    int payment(Vehicle v){
        return 0;
    };
    void update(){};



    //Below are the arrays of a specific vehicle representing the vehicles' slot in that floor
    Two_Wheeler[] two_Wheeler_array = new Two_Wheeler[30];
    Compact_4_W[] Compact_4_W_array = new Compact_4_W[25];
    Normal_4_W[] Normal_4_W_array = new Normal_4_W[35];
    Heavy_4_W[] Heavy_4_W_array = new Heavy_4_W[10];


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

//Dont know why Entry class. Maybe to show OOPS concept.
//Fuck this shit. This shit is ass.
//I wish I was a Jew, where's the gas?
class Entry {


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
		

//		if(Vehicle_type==2) {
//			if(checkAvailability.checkAvailabilityCompact(f1.compactChecking(),f2.compactChecking(),f3.compactChecking(),f4.compactChecking(),f5.compactChecking())) {
//				
//			}
//			else {
//				return;
//			}
//		}
//		
//		if(Vehicle_type==3) {
//			if(checkAvailability.checkAvailabilityNormal(f1.normalChecking(),f2.normalChecking(),f3.normalChecking(),f4.normalChecking(),f5.normalChecking())) {
//				
//			}
//			else {
//				return;
//			}
//		}
//		
//		if(Vehicle_type==4) {
//			if(checkAvailability.checkAvailabilityHeavy(f1.heavyChecking(),f2.heavyChecking(),f3.heavyChecking(),f4.heavyChecking(),f5.heavyChecking())) {
//				
//			}
//			else {
//				return;
//			}
//		}

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

        SimpleDateFormat sd1= new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
        Date date = new Date();
        sd1.setTimeZone(TimeZone.getTimeZone("IST"));
        //with all the info we have about the entered vehicle
        //We now decide which floor the Vehicle may go to
        // If (EV and chargeRequired) or Handicapped  only in ground floor
        // Else take user's choice and update floor data
        int floor=0;
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

class Exit {
	
	public static void exit(Ground_Floor ground, Normal_Floor f1, Normal_Floor f2, Normal_Floor f3, Normal_Floor f4, Normal_Floor f5) {
		int floor;
		String Vehicle_Type, Vehicle_Number;
		Scanner sc= new Scanner(System.in);
		floor = sc.nextInt();
		sc.nextLine();
		int price=0;
		Vehicle_Type = sc.nextLine();
		Vehicle_Number=sc.nextLine();
		if(floor==0) {
			price = ground.exit(Vehicle_Type, Vehicle_Number);
			System.out.println(price);
		}
		else if(floor==1) {
			price = f1.exit(Vehicle_Type, Vehicle_Number);
			System.out.println(price);
		}
		else if(floor==2) {
			price = f2.exit(Vehicle_Type, Vehicle_Number);
			System.out.println(price);
		}
		else if(floor==3) {
			price = f3.exit(Vehicle_Type, Vehicle_Number);
			System.out.println(price);
		}
		else if(floor==4) {
			price = f4.exit(Vehicle_Type, Vehicle_Number);
			System.out.println(price);
		}
		else if(floor==5) {
			price = f5.exit(Vehicle_Type, Vehicle_Number);
			System.out.println(price);
		}
		int pay=0,GivenCash=0;
		boolean flag=true;
		while(flag){
			System.out.println( "If you want to pay in CASH (PRESS 1) or CARD (PRESS 2) or UPI (PRESS 3)");
			pay=sc.nextInt();
			if(pay==1) {
				System.out.println("How much cash given in rupees: ");
				GivenCash=sc.nextInt();
				if(GivenCash>=price) {
					System.out.println("Return: "+ (GivenCash-price));
					flag=false;
				}	
			}
			else if(pay==2){
				System.out.println("Scan your card here");
				GivenCash=sc.nextInt();
				if(GivenCash==price){
					System.out.println("Your TRANSACTION is SUCEESFUL");
					flag=false;
				}
				else{
					System.out.println("Your TRANSACTION has DECLINED\nPlease try again");
				}
			}
			else if(pay==3){
				System.out.println("Scan this QR code");
				GivenCash=sc.nextInt();
				if(GivenCash==price){
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

public class Main {
	

    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int i;
        
        //clock object for storing time
        SimpleDateFormat stime = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
        Date sdate = new Date();
        stime.setTimeZone(TimeZone.getTimeZone("IST"));
        System.out.println(sdate.getTime());

        // array to store the objects of normal-floors
        Normal_Floor[] floors = new Normal_Floor[5]; //building of 1 ground and 5 normal floors

        //Initialising things for each floor(creating objects of floors)
        for(i=0; i<5; i++) floors[i] = new Normal_Floor();

        // object for ground floor
        Ground_Floor ground = new Ground_Floor();

        


        //For object calling inside the entry() method
        //Declared in main and used in entry to avoid override of things
        Entry.entry(ground, floors[0], floors[1], floors[2], floors[3], floors[4]);
        

        //To check if its working
        Exit.exit(ground, floors[0], floors[1], floors[2], floors[3], floors[4]);
 
        //Successfully completed

        
        //ground.display_board();

        //FUCK CODING!!!!!!

    }
}

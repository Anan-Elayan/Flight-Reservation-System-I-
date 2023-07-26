/**
 * Anan Alian
 * 1211529
 */
import java.util.Scanner;

public class Flight {

    //Create array of seats
    private static Seat[][] flightSeat = new Seat[9][];
    public static int number;

    public static void main(String[] args) {
        //initialize seats
        flightSeat[0] = new Seat[2];
        flightSeat[0][0] = new Seat(11);
        flightSeat[0][1] = new Seat(12);

        flightSeat[1] = new Seat[2];
        flightSeat[1][0] = new Seat(21);
        flightSeat[1][1] = new Seat(22);

        flightSeat[2] = new Seat[2];
        flightSeat[2][0] = new Seat(31);
        flightSeat[2][1] = new Seat(32);

        flightSeat[3] = new Seat[4];
        flightSeat[3][0] = new Seat(41);
        flightSeat[3][1] = new Seat(42);
        flightSeat[3][2] = new Seat(43);
        flightSeat[3][3] = new Seat(44);

        flightSeat[4] = new Seat[4];
        flightSeat[4][0] = new Seat(51);
        flightSeat[4][1] = new Seat(52);
        flightSeat[4][2] = new Seat(53);
        flightSeat[4][3] = new Seat(54);

        flightSeat[5] = new Seat[4];
        flightSeat[5][0] = new Seat(61);
        flightSeat[5][1] = new Seat(62);
        flightSeat[5][2] = new Seat(63);
        flightSeat[5][3] = new Seat(64);

        flightSeat[6] = new Seat[4];
        flightSeat[6][0] = new Seat(71);
        flightSeat[6][1] = new Seat(72);
        flightSeat[6][2] = new Seat(73);
        flightSeat[6][3] = new Seat(74);

        flightSeat[7] = new Seat[4];
        flightSeat[7][0] = new Seat(81);
        flightSeat[7][1] = new Seat(82);
        flightSeat[7][2] = new Seat(83);
        flightSeat[7][3] = new Seat(84);

        flightSeat[8] = new Seat[4];
        flightSeat[8][0] = new Seat(91);
        flightSeat[8][1] = new Seat(92);
        flightSeat[8][2] = new Seat(93);
        flightSeat[8][3] = new Seat(94);

        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        //call to function to display menu
        displays_a_menu();
        System.out.println("----------------------------------------------");
        System.out.println(" enter the number  1----5 : ");
        //User enters seat number
        number = input.nextInt();

        // Read user choice, and determine which function will be call
        while (number != 5) {
            switch (number) {
                case 1:
                    // Call Reserve_Seat function
                    Reserve_seat();
                    break;
                case 2:
                    // Call Delete specific seat function
                    Delete_reserved_seat();
                    break;
                case 3:
                    // Call delete all seats function
                    Delete_all_reserved_seats();
                    break;
                case 4:
                    // Call print out flight seats map
                    Print_out_flight_seats_map();
                    break;
                default:
                    // wrong choice
                    System.out.println("please enter valid choice ");
            }

            System.out.println("----------------------------------------------");
            displays_a_menu();
            System.out.println("----------------------------------------------");
            System.out.println(" enter the number  1----5 : ");
            number = input.nextInt();
        }

        System.out.println("\nTHANK YOU _^_");
    }

    // This function displays the selection menu
    public static void displays_a_menu() {
        System.out.println(" 1.Reserve a new empty seat.");
        System.out.println(" 2.Delete a reserved seat.");
        System.out.println(" 3.Delete all reserved seats");
        System.out.println(" 4.Print out flight seats map.");
        System.out.println(" 5.Quit.");
    }

    //the function print flight map
    public static void Print_out_flight_seats_map() {
        for (int i = 0; i < flightSeat.length; i++) {
            for (int j = 0; j < flightSeat[i].length; j++) {
                if (i<=2) {
                    if(j==0){
                        System.out.print("\t\t\t\t\t");
                    }else{
                        System.out.print("\t\t");
                    }
                    flightSeat[i][j].printInfo();
                }else{
                    if(j>0){
                        System.out.print("\t\t");
                    }
                    flightSeat[i][j].printInfo();
                }
                //flightSeat[i][j].printInfo();
            }
            System.out.println();
        }
    }

    // In this function all reserved seats are deleted
    public static void Delete_all_reserved_seats() {
        if (checkStatusForAllSeats(true)) {
            System.out.println("All seats are empty !! \n");
            return;
        }
        for (int i = 0; i < flightSeat.length; i++) {
            for (int j = 0; j < flightSeat[i].length; j++) {
                flightSeat[i][j].setReserved(false);
            }
        }
        System.out.println("All seats have been removed successfully\n");
    }

    //in this function to check Status all seat (reserved or not)
    public static boolean checkStatusForAllSeats(boolean x) {
        for (int i = 0; i < flightSeat.length; i++) {
            for (int j = 0; j < flightSeat[i].length; j++) {
                if (flightSeat[i][j].getReserved() == x) {
                    return false;
                }
            }
        }
        return true;
    }

    //Is this function a specific seat is deleted
    public static void Delete_reserved_seat() {
        // to check if the all seats was not reserved
        if (checkStatusForAllSeats(true)) {      //check Status all seat
            System.out.println("All seats are not reserved (empty)\n ");
            return;
        }
        Scanner input = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the seat number you want to delete: ");
            number = input.nextInt();
            if (Seat.isValid(number)) {
                for (int i = 0; i < flightSeat.length; i++) {
                    for (int j = 0; j < flightSeat[i].length; j++) {
                        if (flightSeat[i][j].getSeat_number() == number) {
                            if (flightSeat[i][j].getReserved()) {
                                // the seat was reserved successfully, and break from loops
                                flightSeat[i][j].setReserved(false);
                                System.out.println("Seat " + flightSeat[i][j].getSeat_number() + " removed successfully\n ");
                                temp = false;

                            } else {

                                System.out.println("The seat " + flightSeat[i][j].getSeat_number() + " you want to delete is not reserved\n ");

                            }

                        }
                    }

                }
            } else
                System.out.println("The seat number is incorrect\n");
        }
    }

    // Reserve seat
    public static void Reserve_seat() {
        //check Status all seat
        if (checkStatusForAllSeats(false)) {
            System.out.println("All seats are reserved\n");
            return;
        }
        Scanner input = new Scanner(System.in);
        boolean temp = true;
        while (temp) {
            System.out.println("Enter the seat number you want to reserve : ");
            number = input.nextInt();
            if (Seat.isValid(number)) {
                for (int i = 0; i < flightSeat.length; i++) {
                    for (int j = 0; j < flightSeat[i].length; j++) {
                        if (flightSeat[i][j].getSeat_number() == number) {
                            if (flightSeat[i][j].getReserved()) {
                                System.out.println("The seat you want to reserve is reserved \n Please Try again !!");

                            } else {
                                // seat was reserved successfully
                                flightSeat[i][j].setReserved(true);
                                System.out.println("Seat " + flightSeat[i][j].getSeat_number() + " has been successfully reserved\n ");
                                temp = false;
                            }
                        }
                    }
                }
            } else
                System.out.println("The seat number entered is incorrect\nPlease Try again !!\n");
        }
    }
}










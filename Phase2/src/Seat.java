/**
 * Anan Alian
 * 1211529
 */
public class Seat {
    // Data field
    private int seat_number;
    private boolean reserved;

    //constructor with all args
    public Seat(int seat_number, boolean reserved) {
        this.seat_number = seat_number;
        this.reserved = reserved;
    }

    //the constructor ,the user enter the number of seat
    public Seat(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public boolean getReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;

    }

    //Checks if the seat is one of the plane seats
    public static boolean isValid(int seat_number) {
        if (seat_number <= 10) {
            return false;
        }
        else if (seat_number == 11 || seat_number == 12) {
            return true;
        } else if (seat_number == 21 || seat_number == 22) {
            return true;
        } else if (seat_number == 31 || seat_number == 32) {
            return true;
        } else if (seat_number > 40 && seat_number < 100) {
            seat_number %= 10;
            return (seat_number == 1 || seat_number == 2 || seat_number == 3 || seat_number == 4);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "seat_number = " + seat_number + ", reserved = " + reserved;
    }

    //Displays the information of the seat
    public void printInfo() {
        String seat_Status = (this.reserved ? "Reserve":"Empty");
        System.out.print("seat " +this.getSeat_number() + ": "+ seat_Status);
    }
}

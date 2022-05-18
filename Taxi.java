import java.util.*;

public class Taxi {
    public long taxiNum;
    public int fuel;
    public int speed;
    public String destination;
    private int basicDistance;
    public int destinationDistance;
    private int basicCharge;
    private int extraCharge;
    TaxiState state;

    Taxi() {
        extraCharge = 3000;
        basicCharge = 3300;
        basicDistance = 2000;
    }


    public void drivingMode(int fuel, int taxiNum) {
        this.fuel = fuel;
        this.taxiNum = taxiNum;
        if(fuel < 10){
            state = TaxiState.운행불가;
            System.out.println("운행 불가능");
            return;
        }
        state = TaxiState.일반;
        System.out.println("운행 시작! 택시 번호는: " + taxiNum);

    }

    public void getPassengers(String destination, int destinationDistance) {
        this.destination = destination;
        this.destinationDistance = destinationDistance;
        if(!TaxiState.일반.equals(state)){
            System.out.println("탑승 불가");
        }
        state = TaxiState.운행중;
        System.out.println("손님 탑승! 운행을 시작합니다.");
        System.out.println("목적지는: " + destination + " 목적지까지의 거리는 " + destinationDistance + "m 입니다.");
    }

    public void changeSpeed(int speed) {
        this.speed = speed;
        System.out.println("현재 속도: " + speed);
        Scanner sc = new Scanner(System.in);
        speed += sc.nextInt();
        System.out.println("현재 속도: " + speed);
    }

    public void getExtraCharge() {
        if(basicDistance < destinationDistance) {
            basicCharge += extraCharge;
            System.out.println("추가요금은: " + extraCharge + "원 입니다.");
        }
    }

    public void takeCharge() {
        System.out.println("택시 요금은 : " + basicCharge + "원 입니다.");
    }
}

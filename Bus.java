import java.util.Scanner;
import java.util.UUID;

public class Bus {
    int maxPassengers = 30;
    int nowPassengers = 0;
    int getPassengers;
    int fee = 1500;
    int getFee = 0;
    int fuel;
    int speed;
    boolean state;
    String busNum;

    Bus() {
        this.busNum = UUID.randomUUID().toString();
        System.out.println(busNum);
    }

    public void run(int fuel) {
        this.fuel = fuel;
        changeState();
    }

    public void changeState() {
        this.state = true;
        System.out.println("운행!");

        if(fuel < 10){
            System.out.println("주유가 필요합니다.");
            System.out.println("차고지행!");
            state = false;
        }
    }

    public void takePassengers(int getPassengers) {
        if(!state) return;
        this.getPassengers = getPassengers;
        if ((this.getPassengers + nowPassengers) > maxPassengers) {
            while ((this.getPassengers + nowPassengers) <= maxPassengers) {
                this.getPassengers -= 1;
            }
            System.out.println("승객 초과! 다음 버스를 이용해주세요!");
            nowPassengers += this.getPassengers;
            getFee += this.getPassengers * fee;
            System.out.println("현재 승객: " + nowPassengers + " 받은 요금: " + getFee);
        } else {
            nowPassengers += getPassengers;
            getFee += getPassengers * fee;
            System.out.println("현재 승객: " + nowPassengers + " 받은 요금: " + getFee);
        }
    }

    public void changeSpeed(int speed) {
        if(!state) return;
        this.speed = speed;
        if (fuel < 10)
            System.out.println("주유가 필요합니다.");

        System.out.println("현재 속도: " + speed + "km");
        Scanner sc = new Scanner(System.in);
        speed += sc.nextInt();
        System.out.println("현재 속도: " + speed + "km");
    }
}

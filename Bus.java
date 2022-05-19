package springAssignment;

import java.util.Scanner;
import java.util.UUID;

public class Bus {
    UUID busNum;
    int fuelValue;
    int speed;
    int fee;
    int getFee;
    int maxPassengers;
    int getPassengers;
    boolean isDrive;

    Bus() {
        this.busNum = UUID.randomUUID();
        this.fuelValue = 100;
        this.speed = 0;
        this.fee = 1000;
        this.maxPassengers = 30;
        this.getPassengers = 0;
        this.getFee = 0;
        isDrive = false;
    }

    public void changeState() {
        if(fuelValue < 10){
            isDrive = !isDrive;
            System.out.println("차고지행!");
        }else if(!isDrive){
            isDrive = true;
            System.out.println("운행 시작!");
        }else if(isDrive){
            isDrive = false;
            System.out.println("운행 종료!");
        }
    }

    public void getDrive() {
        changeState();
        System.out.println("버스 번호: " + busNum);
    }

    public void changeSpeed() {
        if(!isDrive){
            System.out.println("현재 운행 중이 아닙니다.");
            return;
        }
        System.out.println("현재 속도: " + speed);
        Scanner sc = new Scanner(System.in);
        speed += sc.nextInt();
        System.out.println("현재 속도: " + speed);
    }

    public void getPassengers(int num) {
        if(!isDrive){
            System.out.println("현재 운행 중이 아닙니다.");
            return;
        }

        System.out.println("현재 승객: " + getPassengers + "  " +"추가 승객: " + num);
        if((getPassengers + num) > maxPassengers){
            getPassengers = maxPassengers;
            getFee = fee * num;
            System.out.println("다음 버스를 이용해주세요.");
            System.out.println(("받은 요금: " + getFee));
            System.out.println("현재 승객: " + getPassengers);
        }else{
            getPassengers += num;
            getFee = fee * num;
            System.out.println("현재 승객: " + getPassengers);
            System.out.println("받은 요금: " + getFee);
        }
    }
    
}

public class homework_230203 {
    static class Transportation {
        int number = 0;
        int charge = 1500;
        int fuelTank = 100;
        int speed = 0;
        int speedChange = 0;
        int maxPassenger = 30;
        int currentPassenger = 0;
        boolean status = true;

        public Transportation(int number) {
            this.number = number;
        }

        public void startDriving() {
            status = true;
        }

        public void change(int addSpeed) {
            speedChange = addSpeed;
            speed += speedChange;
        }

        public void changeDriving() {
            status = !status;
        }

        public void checkDriving() {
            if (status = true) {
                System.out.println("현재 : 운행중");
            } else {
                System.out.println("현재 : 차고지행");
            }
        }

        public void addPassenger(int newPassenger) {
            if ((currentPassenger + newPassenger) > maxPassenger) {
                System.out.println("최대 승객 수 초과!!!!!!!!!");
            } else {
                currentPassenger += newPassenger;
            }
        }

        public void getPassenger() {
            System.out.println("현재 승객의 수는 " + currentPassenger + "명입니다");
            System.out.println("잔여 객석의 수는 " + (maxPassenger - currentPassenger) + "석입니다");
        }

        public void getCharge() {
            System.out.println("현재 요금은 " + charge + "원입니다");
        }

        public void consumeFuel(int consume) {
            if (fuelTank - consume < 0) {
                System.out.println("해당 주파거리는 연료부족으로 주파할 수 없습니다");
            } else if (fuelTank - consume > 0) {
                fuelTank -= consume;
                System.out.println("현재 주유량은 " + fuelTank + "L입니다");
                if (fuelTank - consume <= 10) {
                    System.out.println("연료가 부족하므로 차고지로 향합니다");
                    changeDriving();
                }
            }
        }

        public void addFuel(int add) {
            fuelTank += add;
            System.out.println("현재 주유량은 " + fuelTank + "L입니다");
        }
    }

    public static void main(String[] args) {
        Transportation bus1 = new Transportation(1);
        Transportation bus2 = new Transportation(2);
        System.out.println("해당 버스의  버스번호는" + bus1.number);
        System.out.println("해당 버스의  버스번호는" + bus2.number);
        bus1.addPassenger(2);
        bus1.getPassenger();
        bus1.getCharge();/* 여기까지 ㅇㅋ */
        bus1.consumeFuel(50);
        bus1.changeDriving();
        bus1.addFuel(10);
        bus1.checkDriving();
        bus1.addPassenger(45);
        bus1.addPassenger(5);
        bus1.getPassenger();
        bus1.getCharge();
        bus1.consumeFuel(55);
        bus1.checkDriving();

    }
}

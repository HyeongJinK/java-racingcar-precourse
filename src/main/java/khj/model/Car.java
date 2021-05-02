package khj.model;

public class Car {
    private String name;
    private int move = 0;

    public Car(String carName) {
        this.name = carName;
    }

    public String getName() {
        return name;
    }

    public int getMove() {
        return this.move;
    }

    public void moveAndStop(int value) {
        if (value >= 4) {
            ++move;
        }
    }

    public void print() {
        String moveStr = createMoveStr();

        System.out.println(name + " : " + moveStr);
    }

    private String createMoveStr() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < move; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}

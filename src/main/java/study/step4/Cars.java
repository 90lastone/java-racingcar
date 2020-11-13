package study.step4;

import java.util.ArrayList;

public class Cars {
    private final ArrayList<Car> cars = new ArrayList<>();
    private final ArrayList<String> winnerNames = new ArrayList<>();

    /* 입력값 세팅 */
    public void split(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }
    /* 우승자 추출 */
    public void winner() {
        int max = getMaxScore();
        for (Car car : cars) {
            compareMaxScoreAddWinner(car, max);
        }
    }
    /* 최대스코어 비교 및 우승자 추가 */
    private void compareMaxScoreAddWinner(Car car, int max) {
        if (car.getScore() == max) {
            winnerNames.add(car.getName());
        }
    }
    /* 최대 스코어 추출 */
    private int getMaxScore() {
        int max = 0;
        for (Car car : cars) {
            max = compareMaxScore(car, max);
        }
        return max;
    }
    /* 최대 스코어 추출 비교 */
    private int compareMaxScore(Car car, int max) {
        if (car.getScore() > max) {
            max = car.getScore();
        }
        return max;
    }

    public int getSize() {
        return this.cars.size();
    }

    public String getIndexName(int i) {
        return this.cars.get(i).getName();
    }

    public Car getIndex(int i) {
        return this.cars.get(i);
    }

    public ArrayList<String> getWinnerNames() {
        return winnerNames;
    }
}

package study.step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final List<String> winnerNames = new ArrayList<>();

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
        int max = getMaxTotalScore();
        for (Car car : cars) {
            compareMaxTotalScoreAddWinner(car, max);
        }
    }
    /* 최대스코어 비교 및 우승자 추가 */
    private void compareMaxTotalScoreAddWinner(Car car, int max) {
        if (car.getTotalScore() == max) {
            winnerNames.add(car.getName());
        }
    }
    /* 최대 스코어 추출 */
    private int getMaxTotalScore() {
        int max = 0;
        for (Car car : cars) {
            max = compareMaxTotalScore(car, max);
        }
        return max;
    }
    /* 최대 스코어 추출 비교 */
    private int compareMaxTotalScore(Car car, int max) {
        if (car.getTotalScore() > max) {
            max = car.getTotalScore();
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

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}

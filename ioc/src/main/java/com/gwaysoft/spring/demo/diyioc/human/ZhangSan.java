package com.gwaysoft.spring.demo.diyioc.human;

import com.gwaysoft.spring.demo.diyioc.car.Car;

public class ZhangSan extends HumanWithCar {

    public ZhangSan(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}

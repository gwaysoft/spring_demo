package com.gwaysoft.spring.demo.diyioc.human;

import com.gwaysoft.spring.demo.diyioc.car.Car;

public class LiSi extends HumanWithCar {

    public LiSi(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.stop();
    }
}

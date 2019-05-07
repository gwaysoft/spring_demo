package com.gwaysoft.spring.demo.diyioc.human;

import com.gwaysoft.spring.demo.diyioc.car.Car;

public abstract class HumanWithCar implements Human {
    protected Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    @Override
    public abstract void goHome();
}

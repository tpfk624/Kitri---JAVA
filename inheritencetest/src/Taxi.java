/*
1. 요금
  기본요금(basicPrice)
    일반 : 3800
	심야 : 5000
  요금합(totalPrice)
  요금(price)
    일반 : 100/km
	심야 : 150/km
2. 요금 계산(calcPrice())
3. 심야할증 : 0시 ~ 6시
*/
import java.util.*;

public class Taxi extends Car {
	
	int basicPrice;
	int totalPrice;
	int price;
	int pricePerKm;

	public Taxi() {
		super();
	}

	public Taxi(String carName, String color, String maker) {
		super(carName, color, maker);
	}

	void initPrice() {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if(hour < 6) {
			basicPrice = 5000;
			pricePerKm = 150;

		} else {
			basicPrice = 3800;
			pricePerKm = 100;
		}
	}

	int calcPrice(int km) {
		price = basicPrice + (km * pricePerKm);
		return price;
	}

	void sumPrice() {
		totalPrice += price;
		price = 0;
		basicPrice = 0;
	}
	
	@Override  //다른 애를 오버라이딩하라
	public int speedUp(int speed){
		speed = super.speedUp(speed);   //상위클래스가 가지고있는 speedUp을 호출
		if(speed > 150)
			this.speed = 150; //적어도 자동차의 속도는 this를 넣어야함
		return speed;
	}

	@Override
	public String toString(){
		return super.toString() + "택시";
	}
}


package com.example.demo;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	private CarRepository carRepository;

	@Override
    public  void run(String...args) throws Exception{
		Car car = new Car();
		car.setName("Mercedes s600");
		ArrayList<String> images = new ArrayList<>();
		images.add("img1.jpg");
		images.add("img2.jpg");
		Car.Engine engine = new Car.Engine(220, "2.0");
		car.setEngine(engine);
		carRepository.save(car);
		Optional<Car> getCar = carRepository.findById(1);
		System.out.printf(getCar.get().toString());
	}


}

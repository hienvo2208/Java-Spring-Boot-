package com.example.demo;

import com.example.demo.entity.IdentityCard;
import com.example.demo.entity.Order;
import com.example.demo.entity.Person;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.IdentityCardRepository;
import com.example.demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
    private CarRepository carRepository;
	private PersonRepository personRepository;
	private IdentityCardRepository identityCardRepository;
	@Override
	public void run(String... args) throws Exception {
//		Car car = new Car();
//		car.setName("Ford Tourneo Titanium");
//		ArrayList<String> images = new ArrayList<String>();
//		images.add("img1.jpg");
//		images.add("img2.jpg");
//		car.setImages(images);
//		Car.Engine engine = new Car.Engine(220, "2.0 ecoboots");
//		car.setEngine(engine);
//
//		carRepository.save(car);
//
//		Optional<Car> getCar = carRepository.findById(1);
//		System.out.println(getCar.get().toString());

//
		IdentityCard idc = new IdentityCard();
		idc.setId("2208VDH");
		idc.setExpired(new Date());
		idc.setIssued(new Date());

//		// Lưu idc vào database
		identityCardRepository.save(idc);
////
////		// Tạo object User có tham chiếu đến object IdentityCard đã tạo
		Person person = new Person();
		person.setEmail("thanthihanh3179@gmail.com");
		person.setFullName("Than Thi Hanh");
		person.setPassword("123");
		person.setIdentityCard(idc);
////
		personRepository.save(person);

		Order order = new Order();
		order.setTotalMoney(100000);
		order.setPerson(person);
//
//		Optional<Person> rs = personRepository.findById(40);
//		System.out.println(rs.get().toString());
//		// Lưu user vào database

	}

}

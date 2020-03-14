package com.cd.java.puzzles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPuzzlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaPuzzlesApplication.class, args);

			FloydsPyramid floyd = new FloydsPyramid();
			floyd.printPyramid(10);
			floyd.reverseFloydTriangleNumbers(10);
			floyd.printPyramidStars(10);
			floyd.reverseFloydTriangle(10);
	}


}

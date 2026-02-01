package net.anandarachmat.xtramile_exams;

import lombok.extern.slf4j.Slf4j;

import net.anandarachmat.xtramile_exams.service.ExamAlgoService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
@Slf4j
class XtramileExamsApplicationTests {

	@Test
	void contextLoads() {
		this.examAlgo();
	}

	@Test
	void examAlgo() {
		Calendar cal = Calendar.getInstance();
		ExamAlgoService myTest = new ExamAlgoService(cal.getTime());

		// Soal-1
		List<Integer> numbers = List.of(10, 20, 30, 100, 40, 50);
		String result = myTest.calculateTwoLargestValue(numbers);
		// IO.println("The sum of the two largest unique numbers is: " + result);
		log.debug("The sum of the two largest unique numbers is: " + result);

		// Soal-2
		List<Integer> numbers2 = List.of(10, 20, 30, 10, 30, 50, 30, 20);
		List<String> listResultWithUniqueValues = myTest.findUniqueNumbers(numbers2);
		// IO.println("Unique values as List: " + listResultWithUniqueValues);
		log.debug("Unique values as List: " + listResultWithUniqueValues);
	}
}

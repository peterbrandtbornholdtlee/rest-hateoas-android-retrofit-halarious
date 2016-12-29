package com.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsTestAppApplicationTests {
	
	@Autowired
	MessageRepository messageRepository;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testRepository() {
		Message m = messageRepository.save(new Message("41988826911", "Teste SMS!"));
		
		Message dbM = messageRepository.findOne(m.getId());
		
		Assertions.assertThat(dbM).isNotNull();
		Assertions.assertThat(dbM.getId()).isEqualTo(m.getId());
		Assertions.assertThat(dbM.getTelefone()).isEqualTo(m.getTelefone());
		Assertions.assertThat(dbM.getBody()).isEqualTo(m.getBody());
	}

}

package wnderful.imgannotator.baseServiceTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wnderful.imgannotator.dao.entity.user.Administrator;
import wnderful.imgannotator.dao.repository.userRepository.AdministratorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelecommunicationsApplicationTests {
    @Autowired
	private AdministratorRepository administratorRepository;

    @Test
	public void contextLoads() {
        administratorRepository.save(new Administrator("lalala","qwerty","lalal@123.com"));
	}

	//切记：手动添加发起者+任务（任务名：default）

}

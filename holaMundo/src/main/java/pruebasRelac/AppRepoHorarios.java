package pruebasRelac;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cead.spring.model.Horario;
import com.cead.spring.repository.HorariosRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorariosRepository repo =  context.getBean("horariosRepository", HorariosRepository.class);
		
		List<Horario> lista = repo.findAll();
		
		
		for(Horario h: lista){
			System.out.println(h);
		}
		
		context.close();

	}

}

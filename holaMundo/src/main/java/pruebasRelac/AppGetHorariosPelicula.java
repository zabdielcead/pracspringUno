package pruebasRelac;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cead.spring.model.Pelicula;
import com.cead.spring.repository.PeliculasRepository;

public class AppGetHorariosPelicula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
		
		 
		Optional<Pelicula> optional = 	repo.findById(3);
		System.out.println(optional.get().getHorarios().size());
		 context.close();
	}

}

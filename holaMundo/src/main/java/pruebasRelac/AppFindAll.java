package pruebasRelac;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cead.spring.model.Pelicula;
import com.cead.spring.repository.PeliculasRepository;

public class AppFindAll {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		//Recuperar todas las entidades tipo pelicula 
		
		PeliculasRepository repo =  context.getBean("peliculasRepository", PeliculasRepository.class);
		List<Pelicula> lista = repo.findAll();
		
		for (Pelicula p: lista){
			System.out.println(p);
		}
		
		context.close();
		
	}	
}

package pruebasjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cead.spring.model.Noticia;
import com.cead.spring.repository.NoticiasRepository;

public class AppQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =  context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// keyword findBy
		//List<Noticia> lista = repo.findBy();
		//List<Noticia> lista = repo.findByEstatus("Inactiva"); //select * from Noticias where estatus = ?
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
		try{
			 List<Noticia> lista = null;
			 //lista = repo.findByFecha(format.parse("2017-09-01")); //select * from Noticias where fecha = ?
			 
			 
			 //and
			 //lista = repo.findByEstatusAndFecha("Activa", format.parse("2017-09-08")); // keyword and
			 

			 //or
			 //lista = repo.findByEstatusOrFecha("Inactiva", format.parse("2017-09-08")); // keyword or
			 
			 //between
			 lista = repo.findByFechaBetween( format.parse("2017-09-03"), format.parse("2017-09-06") );// keyword between
			 
			for (Noticia n: lista){
				System.out.println(n);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		context.close();

	}

}

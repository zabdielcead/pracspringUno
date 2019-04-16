package pruebasjpa;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cead.spring.model.Noticia;
import com.cead.spring.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		// CRUD REPOSITORY
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno: toy story 4");
		noticia.setDetalle("El mes de junio se entrega la ultima pelicula");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =  context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//insertar el registro
		//repo.save(noticia);
		
		
		
		//consultar un registro la clase OPTIONAL indica ue no puede tener un valor null en caso de que sea null no mandara nullpointer exception
		//Optional<Noticia> noticiaConsulta = repo.findById(1);		
		//System.out.println(noticiaConsulta.get());
		
		
		
		
		//update
		//primero buscamos la entidad
		 	//Optional<Noticia> noticiaConsulta = repo.findById(1);		
		//segundo modificamos la entidad y la guardamos 
//		 if(noticiaConsulta.isPresent()){
//			 Noticia noticiaUpdate = noticiaConsulta.get();
//			 System.out.println(noticiaConsulta);
//			 noticiaUpdate.setEstatus("Inactiva");
//			 repo.save(noticiaUpdate);
//		 }
		
		//verificar si existe un id true = existe    false = NoExiste
		//int idNoticia = 1;
		//System.out.println(repo.existsById(idNoticia));
		
		//delete
		//int idNoticia = 2;
		//if(repo.existsById(idNoticia)){
			//repo.deleteById(idNoticia); // si no existe y ejecutamos esta linea mandara una excepcion
		//}
		
		
		// count el numero de elementos de una tabla 
		//long num = repo.count();
		//System.out.println("se encontraron: "+ num + " registros");
		
		//recuperar toddas las entidades 
		//Iterable<Noticia> it = repo.findAll();
		//for(Noticia n : it){
			//System.out.println(n);
		//}
		
		// borrar todo  cuidado!!!!!!
		//repo.deleteAll();
		
		
		//recuperar varios registros por ID findALLByID
//		List<Integer> ids = new LinkedList<Integer>();
//		ids.add(1);
//		ids.add(4);
//		
//		Iterable<Noticia> it =  repo.findAllById(ids);
//		
//		for (Noticia n : it){
//			System.out.println(n);
//		}
		
	
		context.close();

	}

}

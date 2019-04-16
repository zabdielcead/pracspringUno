package pruebasjpa;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.cead.spring.model.Noticia;
import com.cead.spring.repository.NoticiasRepository;

public class AppspringJPA {
	
	/*
	 
	    INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (1,'La Liga de la Justicia','2017-09-01','El estreno en cines de la pel�cula \'La Liga de la Justicia\' se presenta como uno de los de mayor inter�s dentro del g�nero de superh�roes de c�mic','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (2,'Star Wars Episodio 8','2017-09-01','Llega un nuevo cartel de la pel�cula \'Star Wars Episodio 8\'. Con dos de sus personajes principales. Kylo y Rey, interpretados por Adam Driver y Daisy Ridl','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (3,'Blade Runner 2','2017-09-01','La actriz Robin Wright es una de las novedades m�s llamativas dentro del argumento de la secuela de Blade Runner.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (4,'Rocky Creed 2','2017-09-01','El proceso de rodaje de la pel�cula \'Rocky Creed 2\' comenz� hace unos d�as. Ahora podemos ver el nuevo e impactante aspecto de Sylvester Stallone','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (5,'Hellboy 3','2017-09-02','Con el rodaje de la pel�cula \'Hellboy 3\' a punto de dar comienzo, es el momento de ver la primera sinopsis del filme protagonizado por el actor David Harb','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (6,'Indiana Jones 5','2017-09-02','Hace unos meses se barajaba la posibilidad de que el actor Shia LaBeouf regresara, al menos a modo de cameo, a la saga Indiana Jones en su quinta entrega. ','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (7,'Aquaman','2017-09-02','El futuro del universo DC se basa en gran medida gracias a t�tulos como \'Aquaman\'. ','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (8,'Thor 3','2017-09-02','Contin�an las novedades de la pel�cula de Marvel \'Thor 3 Ragnarok\'. Ahora con un cartel de Hulk, personaje de gran relevancia en la tercera entrega ','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (9,'Los Vengadores 4','2017-09-03','Karen Gillan comparte vistazo de rodaje desde la tercera y cuarta pel�cula','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (10,'Star Wars Han Solo','2017-09-03','Primera imagen de de Paul Bettany en el rodaje','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (11,'Escuadr�n Suicida 2','2017-09-03','Margot Robbie confirma el rodaje para principios de 2018','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (12,'La Guerra del Planeta de los Simios','2017-09-04','La pel�cula de ciencia ficci�n \'La Guerra del Planeta de los Simios\' se sit�a en la carrera hacia los Oscar 2018 de Hollywood.','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (13,'Mal�fica 2','2017-09-04','El proyecto de \'Mal�fica 2\' cobra nueva vida con la llegada de Jez Butterworth para ocuparse de la nueva versi�n del gui�n. ','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (14,'Top Gun 2','2017-09-04','La pel�cula \'Top Gun 2\' retrasa su estreno en cines. Todo tras el cambio de guionista dentro de la producci�n protagonizada por Tom Cruise. ','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (15,'American Made','2017-09-04','El actor Tom Cruise encabeza los estrenos de cine del fin de semana con la cinta American Made','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (16,'Ant Man 2','2017-09-04','Llega la primera imagen oficial de la pel�cula \'Ant Man 2\' con la actriz Evangeline Lilly con el traje de la Avispa en la secuela de Marvel','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (17,'Secret Service 2','2017-09-05','Llega un nuevo v�deo de la pel�cula de acci�n \'Secret Service 2\'. Contando con un buen n�mero de escenas in�ditas de la adaptaci�n de la obra de Mark','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (18,'El Otro Guardaespaldas','2017-09-06','Confirma su �xito en los Estados Unidos repitiendo en lo m�s alto de la taquilla','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (19,'Valerian','2017-09-06','Lidera la taquilla de cine en Espa�a en su estreno','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (20,'Madre','2017-09-06','La pel�cula \'Madre\', dirigida por el cineasta Darren Aronofsky y protagonizada por Jennifer Lawrence y Javier Bardem, llega ahora con su cartel final','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (21,'Tony Gilroy dirigir� Matusal�n','2017-09-07','Warner Bros. Pictures ha iniciado las negociaciones con Tony Gilroy (High Wire Act) para que escriba y dirija un thriller conocido hasta el momento como Methuselah.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (22,'Guionista para Mal�fica 2','2017-09-07','Disney Pictures ha contratado a Jez Butterworth ( I Feel Good) para que re-escriba el gui�n de la secuela de Mal�fica.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (23,'Jon Bernthal se une a First Man','2017-09-07','Jon Bernthal (Baby Driver) se pondr� a las �rdenes de Damien Chazelle en la pel�cula de Universal Pictures y Amblin Entertainment First Man.','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (24,'Barry Seal: El traficante','2017-09-07','El proximo mes se estrena la pelicula Barry Seal: El traficante. Nuevamente veremos a Tom Cruise.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (25,'Ben Affleck podr�a dirigir Red Platoon','2017-09-08','Ben Affleck (Liga de la justicia) ha iniciado las conversaciones con Sony Pictures, Immersive Pictures y Smokehouse Pictures para dirigir el drama b�lico Red Platoon.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (26,'Disney prepara una pel�cula sobre Obi-Wan Kenobi','2017-09-08','Disney y Lucasfilm est� preparando un nuevo spin-off de Star Wars, esa vez centrado en el personaje de Obi-Wan Kenobi.','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (27,'Primer vistazo a Cable y Domino en Deadpool 2','2017-09-08','Se han publicado en las redes sociales las primeras fotograf�as de Zazie Beetz en el papel de Neena Thurman / Domino y Josh Brolin como Cable en la esperada Deadpool 2.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (28,'Pedro Pascal se une a The Equalizer 2','2017-09-08','Pedro Pascal (La Gran Muralla) participar� en la secuela de la pel�cula de Sony Pictures The Equalizer: El Protector.','Activa');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (29,'M�s reparto para Skyscraper','2017-09-08','Chin Han (Ghost In the Shell) acompa�ar� a Dwayne Johnson en el thriller de acci�n de Legendary Skyscraper.','Inactiva');
		INSERT INTO `Noticias` (`id`,`titulo`,`fecha`,`detalle`,`estatus`) VALUES (30,'Fecha para Wonder Woman 2','2017-09-08','Warner Bros. Pictures ha puesto fecha de estreno a la secuela de Wonder Woman, que volver� a estar protagonizada por Gal Gadot en el papel de la famosa hero�na.','Activa');
		
			 
	 
	 
	 */

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =  context.getBean("noticiasRepository", NoticiasRepository.class);
		// spring data JPA INTERFAZ JPAREPOSITORY
		
		//METODO FIND ALL
//		List<Noticia> lista =   repo.findAll();
//		for ( Noticia n : lista ){
//			System.out.println(n);
//		}
		
		// metodo deleteAllInBatch dee la interfaz JpaRepository -> es m{as eficiente por que ejecuta un query delete from Noticias
		//repo.deleteAllInBatch();
		
		
		//obtener todas las entidades ordenandas por un campo 
		//List<Noticia> lista =  repo.findAll(Sort.by("titulo").descending());		
		//for (Noticia n: lista){
			//System.out.println(n);
		//}
		
		
		
		//obtener todas las entidades ordenandas por 2 campos
		//List<Noticia> lista = repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
		//for (Noticia n: lista){
			//System.out.println(n);
		//}
		
		
		
		//obtener todas las entidades por paginacion
		//Page<Noticia> page= repo.findAll(PageRequest.of(1, 5)); //numero de pagina, tama�o registros a mostrar		
		
		
		//combiar paginacion y ordenamiento
		Page<Noticia> page= repo.findAll(PageRequest.of(0, 5, Sort.by("titulo"))); 
		
		for(Noticia n: page){
			System.out.println(n);
		}
		

		context.close();
	}

}

package pruebasjpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("root-context.xml");
		
		context.close();
	}

}

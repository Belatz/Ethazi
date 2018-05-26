package ethazi.pruebas;

import java.sql.SQLException;

import ethazi.datos.Conexion;

public class PruebasBD {

	public static void main(String[] args) throws SQLException {
			// Datos Usuario
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('11111111D','Aitor96','0101','Aitor','Fika','aitorperez@gmail.com','666666666')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('22222222L','Juan_','24681','Juan','Gran Via','juan69@hotmail.com','677777777')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('33333333K','Jon9L','AAAA','Pepe','Lehendakari Aguirre','jon01@yahoo.com','610000000')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('44444444A','Manuela','MAN','Manu','Maria Diaz de Haro','manuguapi@hotmail.com','600000001')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('55555555P','Kike','KK','Kike','Calle Pozas','kike69@hotmail.com','699999000')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('66666666Z','InfoPepe','abcd','Informática Pepino S.L','Av. Universidades 5', 'pepeinfor@gmail.com','987654321')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('77777777B','FrutMan','12345678','Fruterías Manoli','Calle Arenal 12','frutasmanoli@hotmail.com','611111111')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('88888888X','SuperPaco','2345','Supermercado Paquito','Calle Perdida S/N','superpaquitopaco@hotmail.com','900123456')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('99999999L','TallChema','0000','Talleres Mecánicos Chema','Calle Blas de Otero nº50','talleres chemita@yahoo.es','981234567')");

			// Datos Candidato
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Perez Lopez', 20/04/2000, 1, 1, 0,'Contable','Informática', 'mucha', 2, '11111111D')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Garcia Lopez',31/01/1990,0,0,1,'Programador','Inglés', 'mucha', 2, '22222222L')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Garcia Garcia',01/02/2002,1,1,1,'Limpiadora','Euskera y Ingles', 'mucha', 2, '33333333K')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Sanchez Iglesias',05/05/1995,0,0,0,'Director RRHH','Curso RCP', 'mucha', 2, '44444444A')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('López Vázquez',10/09/19960,1,0,1,'Secretaria','Mecanografía', 'mucha', 2, '55555555P')");

			// Datos Empresa
			Conexion.actualizar("INSERT INTO empresa VALUES ('Manoli Calvo','Dueña','77777777B')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Paco Garrido','Propietario','88888888X')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Iker Etxeberria','Jefe de Operaciones','99999999L')");

			//Datos Usuario
			Conexion.actualizar("INSERT INTO usuario VALUES ('11111111D','Aitor96','0101','Aitor','Fika','aitorperez@gmail.com','666666666')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('22222222L','Juan_','24681','Juan','Gran Via','juan69@hotmail.com','677777777')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('33333333K','Jon9L','AAAA','Pepe','Lehendakari Aguirre','jon01@yahoo.com','610000000')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('44444444A','Manuela','MAN','Manu','Maria Diaz de Haro','manuguapi@hotmail.com','600000001')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('55555555P','Kike','KK','Kike','Calle Pozas','juan69@hotmail.com','699999000')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('66666666Z','InfoPepe','abcd','Informática Pepiño S.L','Av. Universidades 5''pepeinfor@gmail.com','987654321')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('77777777B','FrutMan','12345678','Fruterías Manoli','Calle Arenal 12','frutasmanoli@hotmail.com','611111111')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('88888888X','SuperPaco','2345','Supermercado Paquito','Calle Perdida S/N','superpaquitopaco@hotmail.com','900123456')");
			Conexion.actualizar("INSERT INTO usuario VALUES ('99999999L','TallChema','0000','Talleres Mecánicos Chema','Calle Blas de Otero nº50','tallereschemita@yahoo.es','981234567')");
			
			//Datos Candidato
			Conexion.actualizar("INSERT INTO candidato VALUES ('Perez Lopez',20/04/2000,1,1,0,'Contable','Informática','He trabajado 7 años como responsable de finanzas en una multinacional',10.3,'11111111D')");
			Conexion.actualizar("INSERT INTO candidato VALUES ('Garcia Lopez',31/01/1990,0,0,1,'Programador','Inglés','Llevo un año en un proyecto de gestion de datos',5.6,'22222222L')");
			Conexion.actualizar("INSERT INTO candidato VALUES ('Garcia Garcia',01/02/2002,1,1,1,'Limpiadora','Euskera y Ingles',' ',1.9,'33333333K')");
			Conexion.actualizar("INSERT INTO candidato VALUES ('Sanchez Iglesias',05/05/1995,0,0,0,'Director RRHH','Curso RCP','LLevo 20 años como encargado de recursos humanos de una multinacional muy importante',2.2,'44444444A')");
			Conexion.actualizar("INSERT INTO candidato VALUES ('López Vázquez',10/09/19960,1,0,1,'Secretaria','Mecanografía','Secretaria con buen perfil se anuncia para trabajar en su empresa',25.8,'55555555P')");
			
			//Datos Empresa
			Conexion.actualizar("INSERT INTO empresa VALUES ('Pepe Rodríguez','Gerente','66666666Z')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Manoli Calvo','Dueña','77777777B')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Paco Garrido','Propietario','88888888X')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Iker Etxeberria','Jefe de Operaciones','99999999L')");
			
			//Datos conocimientos
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Programador')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Mecanico')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Dependiente')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Electricista')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Contabilidad')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Programacion en Java')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Programacion en C')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Programacion en C++')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Programacion en Python')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Especialista en electronica')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Especialista en mecanica general')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Marketing')");
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Contabilidad Avanzada')");
			
			//Datos ofertas 
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',0,'66666666Z',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',0,'99999999L',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#,1','99999999L',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar("INSERT INTO oferta VALUES ('Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',0,'88888888X',12)");
			
			//Datos solicitudes
			Conexion.actualizar("INSERT INTO solicitudes VALUES (1234,'11111111D','Buenos dias: Estaria encantado de colaborar con vosotros')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (1111,'11111111D','Buenos tardes: Estoy con muy poco dinero y tengo una gran urgencia de trabajar')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (2222,'22222222L','Tengo gran interes en trabajar con ustedes')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (5345,'33333333K','Buenos dias: Tengo gran interes en los proyectos que estan haciendo actualmente')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (2345,'44444444A',' ')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (2345,'11111111D','Estoy muy interesado en su oferta')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (1234,'11111111D','Buenos dias: Estaria encantado de colaborar con vosotros')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (1875,'11111111D','Buenos dias: Estoy muy interesado en su oferta')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (8955,'55555555P','Buenos tardes: Mi situacion economica no es muy buena y necesito trabajar')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (3256,'55555555P','Buenos tardes: Mi situacion economica no es muy buena y necesito trabajar')");
			
	}
}
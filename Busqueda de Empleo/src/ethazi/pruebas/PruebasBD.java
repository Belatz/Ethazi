package ethazi.pruebas;

import java.sql.SQLException;

import ethazi.aplicacion.Conexion;

public class PruebasBD {

	public static void main(String[] args) {
		Conexion conn = new Conexion();
		
		try 
		{
			//Datos Usuario
			conn.actualizar("INSERT INTO usuario VALUES '11111111D','Aitor96','0101','Aitor','Fika','aitorperez@gmail.com','666666666'");
			conn.actualizar("INSERT INTO usuario VALUES '22222222L','Juan_','24681','Juan','Gran Via','juan69@hotmail.com','677777777'");
			conn.actualizar("INSERT INTO usuario VALUES '33333333K','Jon9L','AAAA','Pepe','Lehendakari Aguirre','jon01@yahoo.com','610000000'");
			conn.actualizar("INSERT INTO usuario VALUES '44444444A','Manuela','MAN','Manu','Maria Diaz de Haro','manuguapi@hotmail.com','600000001'");
			conn.actualizar("INSERT INTO usuario VALUES '55555555P','Kike','KK','Kike','Calle Pozas','juan69@hotmail.com','699999000'");
			conn.actualizar("INSERT INTO usuario VALUES '66666666Z','InfoPepe','abcd','Informática Pepiño S.L','Av. Universidades 5''pepeinfor@gmail.com','987654321'");
			conn.actualizar("INSERT INTO usuario VALUES '77777777B','FrutMan','12345678','Fruterías Manoli','Calle Arenal 12','frutasmanoli@hotmail.com','611111111'");
			conn.actualizar("INSERT INTO usuario VALUES '88888888X','SuperPaco','2345','Supermercado Paquito','Calle Perdida S/N','superpaquitopaco@hotmail.com','900123456'");
			conn.actualizar("INSERT INTO usuario VALUES '99999999L','TallChema','0000','Talleres Mecánicos Chema','Calle Blas de Otero nº50','talleres chemita@yahoo.es','981234567'");
			
			//Datos Candidato
			conn.actualizar("INSERT INTO candidato VALUES 'Perez Lopez',20/04/2000,1,1,0,'Contable','Informática','11111111D'");
			conn.actualizar("INSERT INTO candidato VALUES 'Garcia Lopez',31/01/1990,0,0,1,'Programador','Inglés','22222222L'");
			conn.actualizar("INSERT INTO candidato VALUES 'Garcia Garcia',01/02/2002,1,1,1,'Limpiadora','Euskera y Ingles','33333333K'");
			conn.actualizar("INSERT INTO candidato VALUES 'Sanchez Iglesias',05/05/1995,0,0,0,'Director RRHH','Curso RCP','44444444A'");
			conn.actualizar("INSERT INTO candidato VALUES 'López Vázquez',10/09/19960,1,0,1,'Secretaria','Mecanografía','55555555P'");
			
			//Datos Empresa
			conn.actualizar("INSERT INTO empresa VALUES 'Pepe Rodríguez','Gerente','66666666Z'");
			conn.actualizar("INSERT INTO empresa VALUES 'Manoli Calvo','Dueña','77777777B'");
			conn.actualizar("INSERT INTO empresa VALUES 'Paco Garrido','Propietario','88888888X'");
			conn.actualizar("INSERT INTO empresa VALUES 'Iker Etxeberria','Jefe de Operaciones','99999999L'");
			
			//Datos conocimientos
			conn.actualizar("INSERT INTO conocimientos VALUES 'Programador'");
			conn.actualizar("INSERT INTO conocimientos VALUES 'Mecanico'");
			conn.actualizar("INSERT INTO conocimientos VALUES 'Dependiente'");
			conn.actualizar("INSERT INTO conocimientos VALUES 'Electricista'");
			conn.actualizar("INSERT INTO conocimientos VALUES 'Contabilidad'");
			
			//Datos ofertas
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#,1','99999999L',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12");
			conn.actualizar("INSERT INTO oferta VALUES 'Programacion','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12");
			
			//Datos solicitudes
			conn.actualizar("INSERT INTO oferta VALUES");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}

package ethazi.pruebas;

import java.sql.ResultSet;
import java.sql.SQLException;

import ethazi.datos.Conexion;
import ethazi.datos.Tablas;

public class PruebasBD {

	public static void insertar() throws SQLException {
		// Usuarios Dummy
		ResultSet rs = Conexion.consultar(
				"SELECT * FROM " + Tablas.C_USUARIO_TABLA + " WHERE " + Tablas.C_USUARIO_NICK + " LIKE '%Dummy%';");

		if (!rs.next()) {
			// Usuarios
			Conexion.actualizar("INSERT INTO " + Tablas.C_USUARIO_TABLA
					+ " VALUES ('00000000A','Dummy1','dummy', 'Dummy', 'aaa', 'aaa', '600000000');");
			Conexion.actualizar("INSERT INTO " + Tablas.C_USUARIO_TABLA
					+ " VALUES ('00000000B','Dummy2','dummy', 'Dummy', 'aaa', 'bbb', '600000000');");
			// Candidato
			Conexion.actualizar("INSERT INTO " + Tablas.C_CANDIDATO_TABLA
					+ " VALUES ('Dummy Dummy', '1998/08/19', 0, 0, 0, 'aaa', 'aaa', 'aaa', 0, '00000000A');");
			// Empresa
			Conexion.actualizar("INSERT INTO " + Tablas.C_EMPRESA_TABLA + " VALUES ('aaa', 'aaa', '00000000B');");
			// Conocimiento
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Dummy')");
			// Candidato - Conocimiento
			Conexion.actualizar("INSERT INTO " + Tablas.C_CANDI_CONO_TABLA + " VALUES ('00000000A', 'Dummy');");
			// Oferta
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Dummy','dummy dummy','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'00000000B',12)");
			// Oferta - Conocimiento
			ResultSet primeraOferta = Conexion
					.consultar("SELECT MIN(" + Tablas.C_OFERTA_CODIGO + ") FROM " + Tablas.C_OFERTA_TABLA + ";");
			primeraOferta.next();
			int codigo = primeraOferta.getInt("MIN(" + Tablas.C_OFERTA_CODIGO + ")");
			Conexion.actualizar("INSERT INTO " + Tablas.C_OFER_CONO_TABLA + " VALUES (" + codigo + ", 'Dummy');");

			System.out.println("Dummy1:dummy y Dummy2:dummy creados..");

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
					"INSERT INTO usuario VALUES ('55555555P','Kike','KK','Kike','Calle Pozas','juan70@hotmail.com','699999000')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('66666666Z','InfoPepe','abcd','Informatica Pepiño S.L','Av. Universidades 5','pepeinfor@gmail.com','987654321')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('77777777B','FrutMan','12345678','Fruterías Manoli','Calle Arenal 12','frutasmanoli@hotmail.com','611111111')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('88888888X','SuperPaco','2345','Supermercado Paquito','Calle Perdida S/N','superpaquitopaco@hotmail.com','900123456')");
			Conexion.actualizar(
					"INSERT INTO usuario VALUES ('99999999L','TallChema','0000','Talleres Mecánicos Chema','Calle Blas de Otero nº50','tallereschemita@yahoo.es','981234567')");

			// Datos Candidato
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Perez Lopez','2000/04/20',1,1,0,'Contable','Informática','He trabajado 7 años como responsable de finanzas en una multinacional',10.3,'11111111D')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Garcia Lopez','1990/01/30',0,0,1,'Programador','Inglés','Llevo un año en un proyecto de gestion de datos',5.6,'22222222L')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Garcia Garcia','2000/02/01',1,1,1,'Limpiadora','Euskera y Ingles',' ',1.9,'33333333K')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('Sanchez Iglesias','1995/05/05',0,0,0,'Director RRHH','Curso RCP','LLevo 20 años como encargado de recursos humanos de una multinacional muy importante',2.2,'44444444A')");
			Conexion.actualizar(
					"INSERT INTO candidato VALUES ('López Vázquez','1996/09/16',1,0,1,'Secretaria','Mecanografía','Secretaria con buen perfil se anuncia para trabajar en su empresa',25.8,'55555555P')");

			// Datos Empresa
			Conexion.actualizar("INSERT INTO empresa VALUES ('Pepe Rodríguez','Gerente','66666666Z')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Manoli Calvo','Dueña','77777777B')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Paco Garrido','Propietario','88888888X')");
			Conexion.actualizar("INSERT INTO empresa VALUES ('Iker Etxeberria','Jefe de Operaciones','99999999L')");

			// Datos conocimientos
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
			Conexion.actualizar("INSERT INTO conocimientos VALUES ('Contabilidad avanzada')");

			// Datos ofertas
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion1','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion2','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion3','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion4','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion5','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion6','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion7','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion8','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion9','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion10','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion11','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',0,'66666666Z',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion12','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion13','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion14','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion15','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion16','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',0,'99999999L',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion17','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'99999999L',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion18','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'88888888X',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion19','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'77777777B',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion20','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',1,'66666666Z',12)");
			Conexion.actualizar(
					"INSERT INTO oferta (TITULO, DESCRIPCION, LUGAR, SUELDO_MAX, SUELDO_MIN, EXPERIENCIA, ASPECTOS_VALORAR, ASPECTOS_IMPRES, VISIBLE, EMPRESA_NUMID, TIPO_CONTRATO) VALUES ('Programacion21','Se solicita un trabajador con un minimo de 3 años de experiencia','Bilbao',1500,800,3,'Conocimientos en C++, C y XQuery','Conocimientos en Java y C#',0,'88888888X',12)");

			// Datos solicitudes
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + codigo
					+ ",'11111111D','Buenos dias: Estaria encantado de colaborar con vosotros')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 1)
					+ ",'11111111D','Buenos tardes: Estoy con muy poco dinero y tengo una gran urgencia de trabajar')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 2)
					+ ",'22222222L','Tengo gran interes en trabajar con ustedes')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 3)
					+ ",'33333333K','Buenos dias: Tengo gran interes en los proyectos que estan haciendo actualmente')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 4)
					+ ",'11111111D','Estoy muy interesado en su oferta')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 5)
					+ ",'11111111D','Buenos dias: Estaria encantado de colaborar con vosotros')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 6)
					+ ",'11111111D','Buenos dias: Estoy muy interesado en su oferta')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 7)
					+ ",'55555555P','Buenos tardes: Mi situacion economica no es muy buena y necesito trabajar')");
			Conexion.actualizar("INSERT INTO solicitudes VALUES (" + (codigo + 8)
					+ ",'55555555P','Buenos tardes: Mi situacion economica no es muy buena y necesito trabajar')");

			// Datos candidato_conocimientos
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('11111111D','Mecanico')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('11111111D','Electricista')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('11111111D','Marketing')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('22222222L','Marketing')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('22222222L','Dependiente')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('33333333K','Contabilidad')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('33333333K','Contabilidad avanzada')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('44444444A','Programador')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('44444444A','Marketing')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('44444444A','Especialista en ')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('55555555P','Especialista en electronica')");
			Conexion.actualizar("INSERT INTO candidato_conocimientos VALUES ('55555555P','Programacion en Python')");
			
			// Datos oferta_conocimientos
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + codigo + ",'Mecanico')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + codigo + ",'Electricista')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 1) + ",'Dependiente')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 2) + ",'Contabilidad avanzada')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 3) + ",'Especialista en mecanica general')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 3) + ",'Especialista en electronica')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 4) + ",'Programacion en Python')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 5) + ",'Especialista en electronica')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 6) + ",'Marketing')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 7) + ",'Programacion en Java')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 7) + ",'Programacion en C')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 8) + ",'Programacion en C')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 9) + ",'Programacion en C++')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 9) + ",'Programacion en C')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 10) + ",'Programacion en Python')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 11) + ",'Contabilidad avanzada')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 12) + ",'Dependiente')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 13) + ",'Dependiente')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 14) + ",'Programador')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 15) + ",'Especialista en electronica')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 16) + ",'Marketing')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 16) + ",'Mecanico')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 16) + ",'Programacion')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 17) + ",'Mecanico')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 17) + ",'Dependiente')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 18) + ",'Contabilidad avanzada')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 19) + ",'Programacion en Java')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 20) + ",'Contabilidad')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 21) + ",'Marketing')");
			Conexion.actualizar("INSERT INTO oferta_conocimientos VALUES (" + (codigo + 21) + ",'Dependiente')");
		}
	}
}
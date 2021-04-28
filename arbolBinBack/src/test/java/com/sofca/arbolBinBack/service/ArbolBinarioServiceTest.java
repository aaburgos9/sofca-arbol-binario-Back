package com.sofca.arbolBinBack.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sofca.arbolBinBack.Entity.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
class ArbolBinarioServiceTest {

	
	@Autowired
	private ArbolBinarioService arbolBinarioService;
	@Autowired
	private IClienteService clienteService;
	
	// PROBAMOS QUE ENCUENTRE EL NODO SOLICITADO, USANDO DE BASE LOS DATOS DE DATA.SQL 
	@Test
	void t1_testGetNodo() {
		
		Cliente cliente = arbolBinarioService.getNodo("100");
		
		String nombreExpected = "Juanita";
		
		assertEquals(nombreExpected, cliente.getNombre());
	}

	// PROBAMOS EL ARBOL EN INORDEN CON LOS DATOS INICIALES DE DATA.SQL
	@Test
	void t2_testGetArbolBinarioInOrden() {
		
		List<String> expected = new ArrayList<String>();
		
		List<String> actual = new ArrayList<String>();
		
		expected.add("Julian");
		expected.add("Juanita");
		expected.add("Maria");
		expected.add("Ana");
		expected.add("Pedro");
		expected.add("Diego");
		expected.add("Juan");
		
		List<Cliente> clientes = arbolBinarioService.getArbolBinarioInOrden();
		
		for (Cliente cliente : clientes) {
			actual.add(cliente.getNombre());
		}
		
		assertEquals(expected, actual);
		
	}

	// PROBAMOS EL ARBOL EN PREORDEN CON LOS DATOS INICIALES DE DATA.SQL
	@Test
	void t3_testGetArbolBinarioPreOrden() {
		
		List<String> expected = new ArrayList<String>();
		
		List<String> actual = new ArrayList<String>();
		
		expected.add("Maria");
		expected.add("Julian");
		expected.add("Juanita");
		expected.add("Diego");
		expected.add("Ana");
		expected.add("Pedro");
		expected.add("Juan");
		
		List<Cliente> clientes = arbolBinarioService.getArbolBinarioPreOrden();
		
		for (Cliente cliente : clientes) {
			actual.add(cliente.getNombre());
		}
		
		assertEquals(expected, actual);
	}

	
	// PROBAMOS QUE SE GUARDE CORRECTAMENTE EL REGISTRO EN LA BASE DE DATOS
	// COMPROBAMOS QUE EL ARBOL SE CARGUE CORRECTAMENTE CON EL NUEVO NODO EN INORDEN
	@Test
	void t4_testGuardarRegistro() {
		
		Cliente newCliente = new Cliente("12", "test", "test@gmail.com", "test direccion");
		
		clienteService.save(newCliente);
		
		Cliente oldCliente = clienteService.findCliente(newCliente);
		
		
		// PROBAMOS QUE SE GUARDE CORRECTAMENTE EL REGISTRO
		assertEquals(oldCliente.toString(), newCliente.toString());
		

		// Y COMPROBAMOS QUE EL ARBOL SE CARGUE CORRECTAMENTE CON EL NUEVO NODO
		
		List<String> expected = new ArrayList<String>();
		
		List<String> actual = new ArrayList<String>();
		
		// NUEVO NODO A VERIFICAR
		expected.add("test");
		//
		expected.add("Julian");
		expected.add("Juanita");
		expected.add("Maria");
		expected.add("Ana");
		expected.add("Pedro");
		expected.add("Diego");
		expected.add("Juan");
		
		List<Cliente> clientes = arbolBinarioService.getArbolBinarioInOrden();
		
		for (Cliente cliente : clientes) {
			actual.add(cliente.getNombre());
		}
		
		assertEquals(expected, actual);
		
		
		
	}

}

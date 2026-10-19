package p3Arboles;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AVLTestSesion10PedidaPorNestor {

	
	@Test
	public void removeSigleLeftRotationTestAddCase(){
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(50));
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(25));
		
		assertTrue(arbol.removeNode(50));
	}
	
	@Test
	public void removeSigleLeftRotationTestRemoveCase(){
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(50));
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(15));
		assertTrue(arbol.addNode(35));
		assertTrue(arbol.addNode(60));
		assertTrue(arbol.addNode(10));
		assertTrue(arbol.addNode(37));
		
		assertTrue(arbol.removeNode(50));
	}
	
	@Test
	public void removeDoubleRightRotation(){
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(50));
		assertTrue(arbol.addNode(20));
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(10));
		assertTrue(arbol.addNode(60));
		assertTrue(arbol.addNode(25));
		
		assertTrue(arbol.removeNode(10));
	}
	
	@Test
	public void removeSigleRightRotationTestRemoveCase() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(50));
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(45));
		assertTrue(arbol.addNode(60));
		assertTrue(arbol.addNode(15));
		assertTrue(arbol.addNode(42));
		assertTrue(arbol.addNode(70));
		
		assertTrue(arbol.removeNode(30));
	}
	
	@Test
	public void removeDoubleLeftRotation() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(50));
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(45));
		assertTrue(arbol.addNode(60));
		assertTrue(arbol.addNode(20));
		assertTrue(arbol.addNode(47));
		
		assertTrue(arbol.removeNode(60));
	}
	
	@Test
	public void removeSingleRightRotationAddCase() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(50));
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(60));
		
		assertTrue(arbol.removeNode(40));
	}
}

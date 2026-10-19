package p3Arboles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeTest {

	@Test
	public void addNodeTest() {
		BSTree<Integer> arbol = new BSTree<Integer>();
		
		assertTrue(arbol.addNode(25));
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(32));
		assertTrue(arbol.addNode(2)); 
		assertTrue(arbol.addNode(50)); 
		assertTrue(arbol.addNode(15));
	}
	
	@Test
	public void searchNodeTest() {
		BSTree<Integer> arbol = new BSTree<Integer>();

		arbol.addNode(25);
		arbol.addNode(40);
		arbol.addNode(32);
		arbol.addNode(2);
		arbol.addNode(50);
		arbol.addNode(15);
		arbol.addNode(70);
		
		assertEquals(2, arbol.searchNode(2));
		assertEquals(15, arbol.searchNode(15));
		assertEquals(null, arbol.searchNode(100));

	}
	
	@Test
    public void preOrderTest() {
		BSTree<Integer> arbol = new BSTree<Integer>();

		arbol.addNode(25);
		arbol.addNode(40);
		arbol.addNode(32);
		arbol.addNode(10);
		arbol.addNode(50);
		arbol.addNode(15);
		arbol.addNode(70);


        assertEquals("25\t10\t15\t40\t32\t50\t70\t", arbol.preOrder());

    }
	
	@Test
    public void postOrderTest() {
		BSTree<Integer> arbol = new BSTree<Integer>();

		arbol.addNode(25);
		arbol.addNode(40);
		arbol.addNode(32);
		arbol.addNode(10);
		arbol.addNode(50);
		arbol.addNode(15);
		arbol.addNode(70);


        assertEquals("15\t10\t32\t70\t50\t40\t25\t", arbol.postOrder());

    }
	
	@Test
    public void inOrderTest() {
		BSTree<Integer> arbol = new BSTree<Integer>();

		arbol.addNode(25);
		arbol.addNode(40);
		arbol.addNode(32);
		arbol.addNode(10);
		arbol.addNode(50);
		arbol.addNode(15);
		arbol.addNode(70);


        assertEquals("10\t15\t25\t32\t40\t50\t70\t", arbol.inOrder());

    }
	
	@Test 
	public void removeTest() {
		BSTree<Integer> arbol = new BSTree<Integer>();

		arbol.addNode(25);
		arbol.addNode(40);
		arbol.addNode(10);
		arbol.addNode(45);
		arbol.addNode(35);
		
		assertTrue(arbol.removeNode(40));
		//System.out.println(arbol);

	}
	
	@Test
	public void addNodeAVLTestRightRotation() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(20));
		assertTrue(arbol.addNode(25));
		assertTrue(arbol.addNode(30));
		//System.out.print(arbol);
	}
	
	@Test
	public void addNodeAVLTestLeftRotation() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(20));
		assertTrue(arbol.addNode(15));
		assertTrue(arbol.addNode(10));
		//System.out.print(arbol);
	}
	
	@Test
	public void doubleRotationLeftTest() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(20));
		assertTrue(arbol.addNode(25));
		assertTrue(arbol.addNode(30));
		//System.out.print(arbol);
	}
	
	@Test
	public void doubleRotationRightTest() {
		AVLTree<Integer> arbol = new AVLTree<Integer>();
		
		assertTrue(arbol.addNode(30));
		assertTrue(arbol.addNode(20));
		assertTrue(arbol.addNode(25));
		assertTrue(arbol.addNode(40));
		assertTrue(arbol.addNode(35));
		assertTrue(arbol.addNode(37));
		System.out.print(arbol);
	}

}

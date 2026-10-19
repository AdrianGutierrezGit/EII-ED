package p3Arboles;

/**
* @author Prodesores ED (Español)
* @version 2024-25 distribuible
*/
public class BSTree <T extends Comparable<T>> extends AbstractTree <T>{

/**
 * getter del nodo raiz del arbol
 */
protected BSTNode<T> getRoot() {
	return (BSTNode<T>) super.getRoot();
}


/**
 * Se le pasa el objeto comparable que hay que insertar
 * devuelve true si lo inserta
 * Si ya existe, no lo inserta y devuelve false (implementado mas tarde). 
 * Si recibe un nodo nulo, no lo inserta y lanza una NullPointerException
 */
public boolean addNode(T node) {
	if(node == null){
		throw new NullPointerException("Element to insert is null.");
	}
	if(searchNode(node) == node) {
		return false;
	}
	setRoot(addNodeRecursive(node, getRoot()));
	return true;
}
	


private AbstractTreeNode<T> addNodeRecursive(T node, BSTNode<T> root) {
	if(root == null) {
		return new BSTNode<>(node);
	}else {
		int posicion = node.compareTo(root.getInfo());
		if(posicion < 0) {
			root.setLeft(addNodeRecursive(node, root.getLeft()));
		}else if(posicion > 0) {
			root.setRight(addNodeRecursive(node, root.getRight()));
		}
	}
	return root;
}


/**
* Se le pasa un objeto comparable que se busca
* Devuelve el objeto encontrado que cumple que es "equals" con el
* buscado, null si no lo encuentra por cualquier motivo
*/
public T searchNode(T node) {
	return searchNodeRecursivo(node, getRoot());
}


private T searchNodeRecursivo(T node, BSTNode<T> root) {
	if(root == null) {
		return null;
	}else {
		int posicion = node.compareTo(root.getInfo());
		if(posicion == 0) {
			return root.getInfo();
		}else if(posicion < 0) {
			return searchNodeRecursivo(node, root.getLeft());
		}else{
			return searchNodeRecursivo(node, root.getRight());
		}
	}
	
	
}


/**
* Genera un String con el recorrido en pre-orden (izquierda-derecha)
* (toString de los nodos con un tabulador detras de cada nodo)
*/
public String preOrder() {
	return preOrderRecursivo(getRoot());
}


private String preOrderRecursivo(BSTNode<T> root) {
	String cadena = "";
	if(root == null) {
		return "";
	}else {
		cadena = root.toString() + "\t";
		cadena += preOrderRecursivo(root.getLeft());
		cadena +=preOrderRecursivo(root.getRight());
		return cadena;
	}
		
}


/**
* Genera un String con el recorrido en post-orden (izquierda-derecha)
* (toString de los nodos con un tabulador detras de cada nodo)
*/
public String postOrder() {
   return postOrderRecursivo(getRoot());
}


private String postOrderRecursivo(BSTNode<T> root) {
	String cadena = "";
    if (root == null) {
    	return "";
    }else {
    	cadena += postOrderRecursivo(root.getLeft());
		cadena += postOrderRecursivo(root.getRight());
		cadena += root.toString() + "\t";
		return cadena;
    }
}

/**
* Genera un String con el recorrido en in-orden (izquierda-derecha)
* (toString de los nodos con un tabulador detras de cada nodo)
*/
public String inOrder() {
	return inOrderRecursivo(getRoot());
}


private String inOrderRecursivo(BSTNode<T> root) {
	String cadena = "";
	if (root == null) {
    	return "";
    }else {
    	cadena += inOrderRecursivo(root.getLeft());
        cadena += root.toString() + "\t";
		cadena += inOrderRecursivo(root.getRight());
		return cadena;
    }
}


/**
* Se le pasa el objeto que se quiere borrar que coincida con equals
* Si recibe un nodo nulo, lanza una NullPointerException
* Devuelve true si lo ha borrado, false caso contrario
*/
public boolean removeNode (T node){
	if(node == null) {
		throw new NullPointerException("Element to remove is null.");
	}
	if(getRoot() == null) {
		return false;
	}
	setRoot(removeNodeRecursivo(node, getRoot()));
	if(searchNode(node) == null) {
		return true;
	}
	return false;
	
}


private BSTNode<T> removeNodeRecursivo(T node, BSTNode<T> root) {
	if(root == null) {
		return null;
	}else {
		int posicion = node.compareTo(root.getInfo());
		if(posicion < 0) {
			root.setLeft(removeNodeRecursivo(node, root.getLeft()));
		}else if(posicion > 0) {
			root.setRight(removeNodeRecursivo(node, root.getRight()));
		}else if(posicion == 0) {
				if(root.getLeft() == null && root.getRight() == null) {
					return null;			
				}else if(root.getLeft() != null && root.getRight() != null) {
					T mayorDeLosMenores = getMax(root);
					removeNodeRecursivo(mayorDeLosMenores, getRoot());
					root.setInfo(mayorDeLosMenores);
				} else if(root.getLeft() != null || root.getRight() != null) {
					if(root.getLeft() != null) {
						return root.getLeft();
					}else {
						return root.getRight();
					}
				}
			}
		}
	return root;
}

public T getMax(BSTNode<T> theRoot) {
	if (theRoot == null) {
		return null;
	}else {
		return getMaxRec(theRoot.getLeft());
	}
}

private T getMaxRec(BSTNode<T> theRoot){
	if (theRoot.getRight () == null) {
		return theRoot.getInfo();
	}else {
		return getMaxRec(theRoot.getRight());
	}
}

}



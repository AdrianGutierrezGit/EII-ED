package p3Arboles;

/** 
* Clase derivada de BSTree añadiendo funcionalidad de AVL 
* @author Profesores ED (Español) 
* @version 2024-25 distribuible 
*/ 
public class AVLTree <T extends Comparable<T> >extends BSTree <T>{ 
 
/** 
* Constructor  
*/ 
public AVLTree() {
	
} 

public AVLNode<T> getRoot(){
	return (AVLNode<T>) super.getRoot();
 
}
/* (non-Javadoc) 
* @see BSTree#addNode(java.lang.Comparable) 
* Redefine inserción para funcionalidad AVL 
*/ 

public boolean addNode (T node){
	if(node == null) {
		throw new NullPointerException("Element to insert is null.");
	}
	if(searchNode(node) == node) {
		return false;
	}
	setRoot(addNodeRecursivo(node, getRoot()));
	return true;
} 
 
 
private AVLNode<T> addNodeRecursivo(T node, AVLNode<T> root) {
	if(root == null) {
		return new AVLNode<T>(node);
	}else {
		int position = node.compareTo(root.getInfo());
		if(position > 0) {
			 root.setRight(addNodeRecursivo(node, root.getRight()));
		}else if(position < 0) {
		     root.setLeft(addNodeRecursivo(node, root.getLeft()));
		}
	}
	return updateAndBalanceIfNecesary(root);
}


/** 
* se le pasa el arbol que se quiere actualizar Height, BF  
*      y balancear si fuese necesario 
* y devuelve la raiz del arbol por si ha cambiado 
*/ 
private AVLNode<T> updateAndBalanceIfNecesary (AVLNode<T> node){
	if(node == null) {
		return null;
	}
	node.updateHeight();
	if(node.getRight() != null) {
		if(node.getBF() == 2 && node.getRight().getBF() == 1) {
			AVLNode<T>  newNode = singleRightRotation(node);
			return newNode;
		}else if(node.getBF() == 2 && node.getRight().getBF() == -1) {
			AVLNode<T> newNode = doubleRightRotation(node);
			return newNode;
		} else if(node.getBF() == 2 && node.getRight().getBF() == 0) {
			AVLNode<T>  newNode = singleRightRotation(node);
			return newNode;
		}
	}
	if(node.getLeft() != null) {
		if(node.getBF() == -2 && node.getLeft().getBF() == -1) {
			AVLNode<T>  newNode = singleLeftRotation(node);
			return newNode;
		}else if(node.getBF() == -2 && node.getLeft().getBF() == 1) {
			AVLNode<T> newNode = doubleLeftRotation(node);
			return newNode;
		} else if(node.getBF() == -2 && node.getLeft().getBF() == 0) {
			AVLNode<T>  newNode = singleLeftRotation(node);
			return newNode;
		}
	}
	node.updateHeight();
	return node; 
}
 
 
/** 
* Se le pasa la raiz del arbol a balancear con rotacion simple 
* devuelve la raiz del nuevo arbol que ha cambiado 
*/ 
private AVLNode<T> singleLeftRotation (AVLNode<T> node){
	AVLNode<T> aux = node.getLeft();
	node.setLeft(aux.getRight());
	aux.setRight(node);
	node = null;
	aux.updateHeight();
	
	return aux;
} 
 
/** 
* Se le pasa la raiz del arbol a balancear con rotacion doble 
* devuelve la raiz del nuevo arbol que ha cambiado 
*/ 
private AVLNode<T> doubleLeftRotation(AVLNode<T> node) {
	AVLNode<T> aux = node.getLeft().getRight();
	node.getLeft().setRight(aux.getLeft());
	aux.setLeft(node.getLeft());
	node.setLeft(aux.getRight());
	aux.setRight(node);
	node = null;
	aux.updateHeight();
	return aux;
	
} 
 
 
/** 
* Se le pasa la raiz del arbol a balancear con rotacion simple 
* devuelve la raiz del nuevo arbol que ha cambiado 
*/ 
private AVLNode<T> singleRightRotation (AVLNode<T> node){
	AVLNode<T> aux = node.getRight();
	node.setRight(aux.getLeft());
	aux.setLeft(node);
	node = null;
	aux.updateHeight();
	
	return aux;
	
} 
 
 
/** 
* Se le pasa la raiz del arbol a balancear con rotacion doble 
* Devuelve la raiz del nuevo arbol que ha cambiado 
*/ 
private AVLNode<T> doubleRightRotation(AVLNode<T> node) {
	AVLNode<T> aux = node.getRight().getLeft();
	node.getRight().setLeft(aux.getRight());
	aux.setRight(node.getRight());
	node.setRight(aux.getLeft());
	aux.setLeft(node);
	node = null;
	aux.updateHeight();
	return aux;
	
} 
 
 
/* (non-Javadoc) 
* @see BSTree#removeNode(java.lang.Comparable) 
* Redefinición para incluir características AVL 
*/ 
public boolean removeNode (T node){
	if(node == null) {
		throw new NullPointerException("Element to remove is null.");
	}
	setRoot(removeNodeRecursivo(node, getRoot()));
	if(searchNode(node) == null) {
		return true;
	}
	return false;
} 

private AVLNode<T> removeNodeRecursivo(T node, AVLNode<T> root){
	if(root == null) {
		return null;
	}
	int position = node.compareTo(root.getInfo());
	if(position < 0) {
		root.setLeft(removeNodeRecursivo(node, root.getLeft()));
	} else if(position > 0) {
		root.setRight(removeNodeRecursivo(node, root.getRight()));
	} else if(position == 0) {
		if(root.getLeft() == null && root.getRight() == null) {
			return null;
		} else if(root.getLeft() != null && root.getRight() != null) {
			T mayorDeLosMenores = getMax(root); 
			root.setInfo(mayorDeLosMenores);
			root.setLeft(removeNodeRecursivo(mayorDeLosMenores, getRoot().getLeft()));
		} else if(root.getLeft() != null || root.getRight() != null) {
			if(root.getRight() != null) {
				root = root.getRight();
			}else {
				root = root.getLeft();
			}
		}
	}
	
	return updateAndBalanceIfNecesary(root);
	
}

public T getMax(AVLNode<T> theRoot) {
	if (theRoot == null) {
		return null;
	}else {
		return getMaxRec(theRoot.getLeft());
	}
}

private T getMaxRec(AVLNode<T> theRoot){
	if (theRoot.getRight () == null) {
		return theRoot.getInfo();
	}else {
		return getMaxRec(theRoot.getRight());
	}
}

}

 
 
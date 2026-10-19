package p3Arboles;

/**
* Clase derivada de BSTNode añadiendo funcionalidad de AVL
* @author Profesores ED (Español)
* @version 2024-25 distribuible
*
*/
public class AVLNode<T extends Comparable<T>> extends BSTNode<T>  {

/**
* Para almacenar la altura del nodo
*/
protected int height;

/**
* Para almacenar al Factor de balance.
* Puede no existir y calcularse cada vez a partir de la altura de los hijos.
*/
protected int balanceFactor;


/**
* Llama al padre y añade la informacion propia
* se le pasa la informacion que se mete en el nuevo nodo
*/
public AVLNode(T node){
	super(node);
	height = 0;
	balanceFactor = 0;
}



/**
* devuelve la altura del arbol del cual es raiz el nodo en cuestion
*/
public int getHeight() {
	return height;
}



/**
* Devuelve el factor de balance segun equilibrio del arbol del cual es raiz
*/
public int getBF() {
	return balanceFactor;
	
}



/**
* Actualiza la altura del nodo en el arbol utilizando la altura de los hijos
* y si es preciso actualiza el FB
*/
protected void updateHeight() {
	if(getLeft() == null && getRight() ==null) {
		height = 1;
		balanceFactor = 0;
	}
	if(getLeft() != null) {
		getLeft().updateHeight();
		height = getLeft().getHeight() + 1;
	}
	if(getRight() != null) {
		getRight().updateHeight();
		if(getRight().getHeight()  + 1 > height) {
			height = getRight().getHeight()  + 1;
		}
	}
	if(getLeft() != null && getRight() != null) {
		balanceFactor = getRight().getHeight() - getLeft().getHeight();
	}else if(getLeft() == null && getRight() != null) {
		balanceFactor = getRight().getHeight();
	}else if(getLeft() != null && getRight() == null){
		balanceFactor =  -getLeft().getHeight();
	}
}



/* (non-Javadoc)
* @see BSTNode#getLeft()
*/
public AVLNode<T> getLeft(){
return (AVLNode<T>) super.getLeft();
}


/* (non-Javadoc)
* @see BSTNode#getRight()
*/
public AVLNode<T> getRight() {
return (AVLNode<T>) super.getRight();
}

// No se necesitan los setters, valen los heredados


/* (non-Javadoc)
* @see BSTNode#toString()
* Añade factor de balance
*/
public String toString() {
return super.toString()+":BF="+ getBF();
}
}


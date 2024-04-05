package list;

import model.Product;

public class ProductList {

    // Una variable final significa que nunca sufrirá cambios.
    private final Product[] vecProducts;
    private final int maxQuantity;
    private int quantity;

    /**
     * Constructor de la clase ProductList.
     * @param maxQuantity Corresponde a la capacidad máxima que tendrá la lista.
     */
    public ProductList(int maxQuantity) {

        // Validación en el caso de que se envíe una cantidad menor o igual a 0.
        if (maxQuantity <= 0)
            throw new IllegalArgumentException("La capacidad de la lista no puede ser menor a 1.");

        this.maxQuantity = maxQuantity;
        this.vecProducts = new Product[maxQuantity];
        this.quantity = 0;
    }

    /**
     * Método que permite agregar un producto a la lista.
     * @param eanCode Código EAN del producto.
     * @param name Nombre del producto.
     * @param quantity Cantidad del producto.
     * @return Retorna un booleano que indica si se pudo agregar el producto o no.
     */
    public boolean addProduct(long eanCode, String name, int quantity){

        Product product = new Product(eanCode, name, quantity);

        // Aquí se llama al método addProduct(Product product) para evitar repetir código.
        return this.addProduct(product);

    }

    /**
     * Método que permite agregar un producto a la lista.
     * @param product Producto a agregar.
     * @return Retorna un booleano que indica si se pudo agregar el producto o no.
     */
    public boolean addProduct(Product product){

        // Validación en el caso de que la cantidad de productos sea igual a la cantidad máxima.
        if (this.quantity == this.maxQuantity){
            return false;
        }

        // Validación en el caso de que la cantidad de productos sea igual a 0 o si la lista está vacía.
        if (this.quantity == 0){
            this.vecProducts[this.quantity] = product;
            this.quantity++;
            return true;
        }

        // Validación en el caso de que el producto ya exista en la lista.
        if (this.searchProduct(product.getEanCode()) != -1){
            return false;
        }

        // Agrega el producto a la lista.
        this.vecProducts[this.quantity] = product;
        this.quantity++;
        return true;
    }

    /**
     * Método que permite buscar un producto en la lista.
     * @param eanCode Código EAN del producto.
     * @return Retorna la posición del producto en la lista.
     */
    public int searchProduct(long eanCode){

        // Validación en el caso de que la cantidad de productos sea igual a 0.
        if (this.quantity == 0){
            return -1;
        }

        // Búsqueda del producto en la lista.
        for (int i = 0; i < this.quantity; i++) {
            if (this.vecProducts[i].getEanCode() == eanCode){
                return i;
            }
        }

        // Retorna -1 si no se encuentra el producto.
        return -1;
    }

    /**
     * Método que permite obtener el los datos de un producto en la lista.
     * @param eanCode Código EAN del producto.
     * @return Retorna el nombre del producto.
     */
    public String getProduct(long eanCode){
        int position = this.searchProduct(eanCode);
        if (position == -1){
            return null;
        }
        // Se hace uso del método toString() de la clase Product.
        return this.vecProducts[position].toString();
    }

    /**
     * Método que permite obtener los datos de un producto en la lista.
     * @param position Posición del producto en la lista.
     * @return Retorna el nombre del producto.
     */
    public String getProduct(int position){
        if (position < 0 || position >= this.quantity){
            return null;
        }
        // Se hace uso del método toString() de la clase Product.
        return this.vecProducts[position].toString();
    }

    /**
     * Método que permite eliminar un producto de la lista.
     * @param eanCode Código EAN del producto.
     * @return Retorna un booleano que indica si se pudo eliminar el producto o no.
     */
    public boolean deleteProduct(long eanCode){
        int position = this.searchProduct(eanCode);
        if (position == -1){
            return false;
        }

        // El ciclo for se encarga de mover los productos una
        // posición hacia la izquierda desde la posición del producto a eliminar.
        for (int i = position; i < this.quantity - 1; i++) {
            this.vecProducts[i] = this.vecProducts[i + 1];
        }

        // Se disminuye la cantidad de productos en la lista.
        this.quantity--;
        return true;
    }

    /**
     * Método que permite eliminar un producto de la lista.
     * @param position Posición del producto en la lista.
     * @return Retorna un booleano que indica si se pudo eliminar el producto o no.
     */
    public boolean deleteProductByPos(int position){
        if (position < 0 || position >= this.quantity){
            return false;
        }

        // El ciclo for se encarga de mover los productos una
        // posición hacia la izquierda desde la posición del producto a eliminar.
        for (int i = position; i < this.quantity - 1; i++) {
            this.vecProducts[i] = this.vecProducts[i + 1];
        }

        // Se disminuye la cantidad de productos en la lista.
        this.quantity--;
        return true;
    }

    /**
     * Método que permite obtener los productos de la lista en orden descendente de ingreso.
     * @return Retorna un arreglo con los productos de la lista.
     */
    public String[] getProductsDescendent(){
        Product[] products = new Product[this.quantity];

        // Copia los productos originales al nuevo arreglo.
        for (int i = 0; i < this.quantity; i++) {
            products[i] = this.vecProducts[i];
        }

        /*
            Se puede hacer de esta forma también:
            System.arraycopy(this.vecProducts, 0, products, 0, this.quantity);
         */

        // Ordena los productos en orden descendente según su código EAN.
        for (int i = 0; i < this.quantity - 1; i++) {
            for (int j = 0; j < this.quantity - i - 1; j++) {
                if (products[j].getEanCode() < products[j + 1].getEanCode()) {
                    // Intercambia los productos
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }

        // Crea un arreglo de String con la representación de cada producto.
        String[] productStrings = new String[this.quantity];
        for (int i = 0; i < this.quantity; i++) {
            productStrings[i] = products[i].toString();
        }

        return productStrings;
    }

    /**
     * Método getter de la variable quantity.
     * @return Retorna la cantidad de productos en la lista.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Método setter de la variable quantity.
     * @param quantity Cantidad de productos en la lista.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

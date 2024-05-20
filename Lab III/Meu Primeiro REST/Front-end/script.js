document.addEventListener('DOMContentLoaded', () => {
    getProducts();

    document.getElementById('add-product').addEventListener('click', addProduct);
    document.getElementById('update-product').addEventListener('click', updateProduct);
});

async function getProducts(){
    try{
        let response = await await axios.get('http://localhost:8080/products');
        let products = response.data;

        if (response.status === 200){
            listProducts(products);
        }
        else{
            alert("Um erro ocorreu no sistema, tente novamente mais tarde.");
        }
    }
    catch(error){
        console.error();
    }

}

function listProducts(products) {
    const productUl = document.getElementById('products');
    productUl.innerHTML = '';
    products.forEach(product => {
        const li = document.createElement('li');
        li.innerHTML = `
            <div class="products-list">
                <div> Produto: ${product.type} </div>
                <div> Preço: $${product.price} </div>
                </div>
            <div> Quantity: ${product.quantity} </div>
            <button onclick="editProduct(${product.id})">Editar</button>
            <button onclick="deleteProduct(${product.id})">Excluir</button>
        `;
        productUl.appendChild(li);
    });
}

async function addProduct() {
    const type = document.getElementById('product-type').value;
    const price = document.getElementById('product-price').value;
    const quantity = document.getElementById('product-quantity').value;

    let body = {
        type: type,
        price: price,
        quantity: quantity
    };

    try{
        let response = await axios.post('http://localhost:8080/products', body);

        if (response.status === 200){
            document.getElementById('product-type').value = '';
            document.getElementById('product-price').value = '';
            document.getElementById('product-quantity').value = '';
        }
        else{
            alert("Um erro ocorreu no sistema, tente novamente mais tarde.");
        }
    }
    catch(error){
        console.error(error);
    }

}

async function editProduct(id) {
    try{
        let response = await axios.get(`http://localhost:8080/products/${id}`);
        let product = response.data;

        if (response.status === 200) {
            document.getElementById('product-id').value = product.id;
            document.getElementById('product-type').value = product.type;
            document.getElementById('product-price').value = product.price;
            document.getElementById('product-quantity').value = product.quantity;

            document.getElementById('add-product').style.display = 'none';
            document.getElementById('update-product').style.display = 'block';
        }
        else{
            alert("Um erro ocorreu no sistema, tente novamente mais tarde.");
        }
    }
    catch(error){
        console.error(error);
    }
}

async function updateProduct() {
    const id = document.getElementById('product-id').value;
    const type = document.getElementById('product-type').value;
    const price = document.getElementById('product-price').value;
    const quantity = document.getElementById('product-quantity').value;

    let body = {
        type: type,
        price: price,
        quantity: quantity
    };

    try{
        let response = await axios.put(`http://localhost:8080/products/${id}`, body);

        if (response.status === 200){
            document.getElementById('product-id').value = '';
            document.getElementById('product-type').value = '';
            document.getElementById('product-price').value = '';
            document.getElementById('product-quantity').value = '';

            document.getElementById('add-product').style.display = 'block';
            document.getElementById('update-product').style.display = 'none';

            getProducts();
        }
        else{
            alert("Um erro ocorreu no sistema, tente novamente mais tarde.");
        }
    }
    catch(error){
        console.error();
    }
}

async function deleteProduct(id) {
    try{
        let response = await axios.delete(`http://localhost:8080/products/${id}`);
        if (response.status === 200){
            getProducts();
        }
        else{
            alert("Um erro ocorreu no sistema, tente novamente mais tarde.");
        }
    }
    catch(error){
        console.error();
    }

}

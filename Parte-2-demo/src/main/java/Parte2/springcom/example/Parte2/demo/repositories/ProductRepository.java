package Parte2.springcom.example.Parte2.demo.repositories;

import Parte2.springcom.example.Parte2.demo.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {
    //La capa Repository es la capa de acceso a datos
    private List<Product> data;

    public ProductRepository() {
        this.data= Arrays.asList(new Product(1L,"Memoria Corsair",300L),
                new Product(2L,"CPU Intel",400L),
                new Product(3L,"Celular Redmi",500L)
                );
    }

    public List<Product> findAll(){
        return data;
    }

    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow();
    }

}

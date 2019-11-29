package di.yang.service.impl.product;

import di.yang.Dao.product.ProductDao;
import di.yang.module.product.Product;
import di.yang.service.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.List;

@Repository
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public boolean addProductInfo(Product product) {
        boolean data = productDao.addProductInfo(product);
        return data;
    }

    @Override
    public boolean updataProudctData(Product product) {
        boolean data = productDao.updataProudctData(product);
        return data;
    }

    @Override
    public List<Product> selectProudctData(Product product) {
        product.setPagenum((product.getPagenum()-1)*product.getPagesize());
        return productDao.selectProudctData(product);
    }
}

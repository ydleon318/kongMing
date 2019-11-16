package di.yang.service.productService;

import di.yang.module.product.Product;

import java.util.List;

public interface ProductService {
    /**
     * 添加产品
     * @param product
     * @return
     */
    boolean addProductInfo(Product product);

    /**
     * 修改产品列表
     * @param product
     * @return
     */
    boolean updataProudctData(Product product);

    /**
     * 选择产品列表
     * @param product
     * @return
     */
    List<Product> selectProudctData(Product product);
}

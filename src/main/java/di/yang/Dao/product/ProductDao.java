package di.yang.Dao.product;

import di.yang.module.product.Product;
import java.util.List;


public interface ProductDao {
    /**
     * 添加产品信息
     * @param product
     * @return
     */
    boolean addProductInfo(Product product);

    /**
     * 修改产品信息
     * @param product
     * @return
     */
    boolean updataProudctData(Product product);

    /**
     * 选择产品信息
     * @param product
     * @return
     */
    List<Product> selectProudctData(Product product);
}

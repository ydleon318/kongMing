package di.yang.Dao.impl.productImpl;

import di.yang.Dao.BaseGetData;
import di.yang.Dao.product.ProductDao;
import di.yang.module.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDaoImpl extends BaseGetData implements ProductDao {
    String dataBasexml = "KongmingDB_config.xml";

    @Override
    public boolean addProductInfo(Product product) {
        boolean flag = addDataBaseInfo(dataBasexml,"addProductInfo",product);
        return flag;
    }

    @Override
    public boolean updataProudctData(Product product) {
        boolean data = upDataBaseInfo(dataBasexml,"updataProudctData",product);
        return data;
    }

    @Override
    public List<Product> selectProudctData(Product product) {
        List<Product> products = getDataBaseListInfo(dataBasexml,"selectProudctData",product);
        return products;
    }
}

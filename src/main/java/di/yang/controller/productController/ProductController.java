package di.yang.controller.productController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import di.yang.controller.BaseController;
import di.yang.module.product.Product;
import di.yang.service.productService.ProductService;
import di.yang.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/addProduct")
    public ResponseEntity<?> addProductInfo(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("addProductInfo param is--->"+param);
        Product product = JSON.toJavaObject(param, Product.class);
        boolean flag = productService.addProductInfo(product);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("addProductInfoResponse is----->"+result);
        return result;
    }

    @PostMapping(value = "/updataProudctData")
    public ResponseEntity<?> updataProudctData(@RequestBody JSONObject param){
        ResponseEntity<?> result = null;
        Tools.step("updataProudctData param is--->"+param);
        Product product = JSON.toJavaObject(param, Product.class);
        boolean flag = productService.updataProudctData(product);
        if (flag){
            result = buildSuccessResponse(flag);
        }else {
            result = buildErrorResponse(flag);
        }
        Tools.step("updataProudctData is----->"+result);
        return result;
    }

    @PostMapping(value = "/selectProudctData")
    public JSONObject selectProudctData(@RequestBody JSONObject param){
        JSONObject reponse = new JSONObject();
        Tools.step("selectProudctData param is--->"+param);
        Product product = JSON.toJavaObject(param, Product.class);
        reponse.put("data",productService.selectProudctData(product));
        Tools.step("selectProudctData response is--->"+reponse);
        return reponse;
    }
}

package di.yang.service.impl.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import di.yang.Dao.impl.web.WebProcessStepDaoImpl;
import di.yang.Dao.web.WebProcessStepDao;
import di.yang.enumList.WebOptMethod;
import di.yang.module.web.WebProcessStep;
import di.yang.service.webService.WebProcessStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by yangdi on 2019/12/7
 */
@Service
@Repository
public class WebProcessStepServiceImpl implements WebProcessStepService {
//    @Autowired
    private WebProcessStepDao webProcessStepDao = new WebProcessStepDaoImpl();

    @Override
    public boolean addWebProcessStep(WebProcessStep webProcessStep) {
        return webProcessStepDao.addWebProcessStep(webProcessStep);
    }

    @Override
    public boolean updataWebProcessStep(WebProcessStep webProcessStep) {
        return webProcessStepDao.updataWebProcessStep(webProcessStep);
    }

    @Override
    public List<WebProcessStep> selectWebProcessStep(WebProcessStep webProcessStep) {
        webProcessStep.setPagenum((webProcessStep.getPagenum()-1)*webProcessStep.getPagesize());
        return webProcessStepDao.selectWebProcessStep(webProcessStep);
    }


    /**
     * 获取表中weboptmethod的值
     * @param webcaseid
     * @return
     */
    public String getWebOptMethodInfo(int webcaseid) {
       List<WebProcessStep> steps = webProcessStepDao.selectWebProcessStepByWebcaseId(webcaseid);
       Map optmethods = new HashMap();
        for (int i=0;i<steps.size();i++){
            if (null==steps.get(i).getWebfindmethod()){
                continue;
            }else {
                optmethods.put(String.valueOf(i+1),steps.get(i).getWeboptmethod());
            }
        }
        for (Map.Entry<String, Object> methods : new JSONObject(optmethods).entrySet()){
        //将获取到的method通过枚举转换
        }
        return null;
    }

}

package di.yang.Dao;


import di.yang.utils.DataBaseUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseGetData {

    public <T> T getDataBaseInfo(String DataBasexml,String statement,Object ...objects){
        SqlSession sqlSession = null;
        try {
            sqlSession = DataBaseUtil.getSqlSession(DataBasexml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(objects.length == 1){
            return sqlSession.selectOne(statement,objects[0]);
        }else{
            //输入的参数依次为key0 key1 …… keyn
            Map map = new HashMap();
            for(int i=0;i<objects.length;i++) {
                map.put("key"+i, objects[i]);
            }
            return sqlSession.selectOne(statement,map);
        }
    }


    public <T> List<T> getDataBaseListInfo(String DataBasexml, String statement, Object  ...objects){
        SqlSession sqlSession = null;
        try {
            sqlSession = DataBaseUtil.getSqlSession(DataBasexml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(objects.length == 1){
            return sqlSession.selectList(statement,objects[0]);
        }else{
            //输入的参数依次为key0 key1 …… keyn
            Map map = new HashMap();
            for(int i=0;i<objects.length;i++) {
                map.put("key"+i, objects[i]);
            }
            return sqlSession.selectList(statement,map);
        }
    }


    public boolean addDataBaseInfo(String DataBasexml,String statement,Object object){
        SqlSession sqlSession = null;
        try {
            sqlSession = DataBaseUtil.getSqlSession(DataBasexml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = sqlSession.insert(statement,object);

        if(i != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean upDataBaseInfo(String DataBasexml,String statement,Object object){
        SqlSession sqlSession = null;
        try {
            sqlSession = DataBaseUtil.getSqlSession(DataBasexml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = sqlSession.update(statement,object);

        if(i != 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean upDataBaseInfo(String DataBasexml,String environment,String statement,Object object){
        SqlSession sqlSession = null;
        try {
            sqlSession = DataBaseUtil.getSqlSession(DataBasexml,environment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = sqlSession.update(statement,object);

        if(i != 0){
            return true;
        }else{
            return false;
        }
    }
}

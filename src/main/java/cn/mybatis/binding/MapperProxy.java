package cn.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @program: mybatis-learning
 * @description: mapper接口的代理类
 * @author: wyn
 * @create: 2022-04-14 21:01
 **/
public class MapperProxy<T> implements InvocationHandler {

    /**
     * 对应的mapper接口
     */
    private Class<T> mapperInterface;
    /**
     * key mapper接口中的每个方法：mapper接口名.方法名
     * value 代理的逻辑
     */
    private Map<String,String> sqlSession;

    public MapperProxy(Map<String,String> sqlSession,Class<T> mapperInterface){
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            return method.invoke(args);
        }else{
            return "你的mapper被代理了:"+sqlSession.get(mapperInterface.getName()+"."+method.getName());
        }
    }

}

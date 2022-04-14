package cn.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @program: mybatis-learning
 * @description:创建MapperProxy的工厂
 * @author: wyn
 * @create: 2022-04-14 21:01
 **/
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String,String> sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface);
        return (T)Proxy.newProxyInstance(mapperProxy.getClass().getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}

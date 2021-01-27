package com.lpc.test.activity;

import android.view.View;

import com.lpc.test.base.BaseTextRecyclerViewActivity;
import com.lpc.test.bean.GeneratorBean;
import com.lpc.test.utils.LogUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：v_lipengcheng
 * @ Date       ：Created in 17:23 2019-08-08
 * @ Description：1.getDeclaredField是可以获取一个类的所有字段.
 * getField只能获取类的public 字段.
 */
public class ReflectTestActivity extends BaseTextRecyclerViewActivity {

    @Override
    protected void initRecyclerViewData() {

        addBeanToMList("Class", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                LogUtil.d("获取Class = " + bean.getClass().toString());

                try {
                    Class<?> aClass = Class.forName("com.lpc.test.bean.GeneratorBean");
                    LogUtil.d("获取Class2 = " + aClass.toString());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                LogUtil.d("获取Class的父类 = " + bean.getClass().getSuperclass().toString());
            }
        });

        addBeanToMList("Class的Constructor", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                Class<? extends GeneratorBean> aClass = bean.getClass();

                Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
                for (int i = 0; i < declaredConstructors.length; i++) {
                    LogUtil.d("遍历declaredConstructors = " + declaredConstructors[i].toString());
                }

                Constructor<? extends GeneratorBean> constructor = null;
                try {
                    constructor = aClass.getConstructor(Object.class, String.class);
                    constructor.setAccessible(true);
                    LogUtil.d("指定Constructor = " + constructor.toString());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                try {
                    GeneratorBean lipc = constructor.newInstance(1234, "lipc");
                    LogUtil.d("GeneratorBean = " + lipc.getId() + ";name = " + lipc.name);
                    // 子类也拥有父类private属性
                    LogUtil.d("GeneratorBean key = " + lipc.getKey());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("Class的Filed", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                Class<? extends GeneratorBean> aClass = bean.getClass();

                Field[] fields = aClass.getFields();
                for (int i = 0; i < fields.length; i++) {
                    LogUtil.d("遍历getFields = " + fields[i].toString());
                }

                Field[] fields2 = aClass.getDeclaredFields();
                for (int i = 0; i < fields2.length; i++) {
                    LogUtil.d("遍历getDeclaredFields = " + fields2[i].toString());
                }

                Field idField = null;
                try {
                    idField = aClass.getDeclaredField("id");
                    idField.setAccessible(true);
                    LogUtil.d("指定field = " + idField.toString());
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }

                try {
                    LogUtil.d("设置前id = " + bean.getId());
                    idField.set(bean, 456);
                    LogUtil.d("设置后id = " + bean.getId());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("Class的Method", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratorBean bean = new GeneratorBean(123);
                Class<? extends GeneratorBean> aClass = bean.getClass();

                Method[] declaredMethods = aClass.getDeclaredMethods();
                for (int i = 0; i < declaredMethods.length; i++) {
                    LogUtil.d("遍历declaredMethods = " + declaredMethods[i].toString());
                }

                Method declaredMethod = null;
                try {
                    declaredMethod = aClass.getDeclaredMethod("setId", int.class);
                    declaredMethod.setAccessible(true);
                    LogUtil.d("指定declaredMethod = " + declaredMethod.toString());
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }

                try {
                    LogUtil.d("设置前id = " + bean.getId());
                    declaredMethod.invoke(bean, 678);
                    LogUtil.d("设置后id = " + bean.getId());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });

        addBeanToMList("Class的Type", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Class<?> aClass = Class.forName("com.lpc.test.bean.GeneratorBean");
                    Constructor<?> constructor = aClass.getConstructor(Object.class, String.class);
                    constructor.setAccessible(true);
                    GeneratorBean<Integer> bean = (GeneratorBean) constructor.newInstance(123, "lipc");
                    LogUtil.d("指定Constructor = " + constructor.toString());

                    // T
                    TypeVariable<? extends Class<?>>[] typeParameters = bean.getClass().getTypeParameters();
                    for (int i = 0; i < typeParameters.length; i++) {
                        TypeVariable<? extends Class<?>> typeParameter = typeParameters[i];
                        LogUtil.d("typeParameters " + i + " = " + typeParameter.toString());
                    }

                    // com.lpc.test.listener.TestListener<T>
                    Type[] genericInterfaces = bean.getClass().getGenericInterfaces();
                    for (int i = 0; i < genericInterfaces.length; i++) {
                        LogUtil.d("genericInterfaces " + i + " = " + genericInterfaces[i].toString());
                    }

                    // interface com.lpc.test.listener.TestListener
                    Class<?>[] interfaces = bean.getClass().getInterfaces();
                    for (int i = 0; i < interfaces.length; i++) {
                        LogUtil.d("interfaces " + i + " = " + interfaces[i].toString());
                    }

                    // class java.lang.String
                    Field list1 = bean.getClass().getDeclaredField("mList");
                    list1.setAccessible(true);
                    Type genericType = list1.getGenericType();
                    Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                    LogUtil.d("listTypeParameters " + 0 + " = " + actualTypeArguments[0]);

                    // T
                    Field list2 = bean.getClass().getDeclaredField("mList2");
                    list1.setAccessible(true);
                    Type genericType2 = list2.getGenericType();
                    Type[] actualTypeArguments2 = ((ParameterizedType) genericType2).getActualTypeArguments();
                    LogUtil.d("listTypeParameters2 " + 0 + " = " + actualTypeArguments2[0]);

                    List<GeneratorBean> list = new ArrayList<GeneratorBean>();
                    list.add(bean);

                    // E
                    TypeVariable<? extends Class<? extends List>>[] typeParameters1 = list.getClass().getTypeParameters();
                    for (int i = 0; i < typeParameters1.length; i++) {
                        LogUtil.d("typeParameters1 " + i + " = " + typeParameters1[i].toString());
                    }

                    // List<E>、Serializable等接口
                    Type[] listGenericInterfaces = list.getClass().getGenericInterfaces();
                    for (int i = 0; i < listGenericInterfaces.length; i++) {
                        LogUtil.d("listGenericInterfaces " + i + " = " + listGenericInterfaces[i].toString());
                    }

                    Field strs = bean.getClass().getDeclaredField("strs");
                    strs.setAccessible(true);
                    Type genericType1 = strs.getGenericType();
                    GenericArrayType genericType11 = (GenericArrayType) genericType1;
                    Type genericComponentType = genericType11.getGenericComponentType();
                    Type[] actualTypeArguments1 = ((ParameterizedType) genericComponentType).getActualTypeArguments();
                    LogUtil.d("actualTypeArguments1 " + 0 + " = " + actualTypeArguments1[0]);

                    Method test = bean.getClass().getDeclaredMethod("test", Object.class);
                    Type[] genericParameterTypes = test.getGenericParameterTypes();
                    for (int i = 0; i < genericParameterTypes.length; i++) {
                        LogUtil.d("genericParameterTypes " + i + " = " + genericParameterTypes[0]);
                        if(genericParameterTypes[i] instanceof ParameterizedType){
                            ParameterizedType genericParameterType = (ParameterizedType) genericParameterTypes[i];
                            Type[] actualTypeArguments3 = genericParameterType.getActualTypeArguments();
                            if(actualTypeArguments3 != null && actualTypeArguments3.length > 0){
                                LogUtil.d("actualTypeArguments3 " + i + " = " + actualTypeArguments3[0]);
                            }
                        } else {
                            LogUtil.d("actualTypeArguments33 " + i + " = " + genericParameterTypes[i]);
                            LogUtil.d("actualTypeArguments33 " + i + " = " + genericParameterTypes[i].getClass());
                            LogUtil.d("actualTypeArguments33 " + i + " = " + genericParameterTypes[i].getTypeName());
//                            LogUtil.d("actualTypeArguments33 " + i + " = " + (Class)genericParameterTypes[i]);
                        }
                    }

                    LogUtil.d("-------------");

                    Method test2 = bean.getClass().getDeclaredMethod("test2", List.class, Object.class, int.class);
                    Type[] genericParameterTypes2 = test2.getGenericParameterTypes();
                    for (int i = 0; i < genericParameterTypes2.length; i++) {
                        LogUtil.d("genericParameterTypes " + i + " = " + genericParameterTypes2[i]);
                        if(genericParameterTypes2[i] instanceof ParameterizedType){
                            ParameterizedType genericParameterType = (ParameterizedType) genericParameterTypes2[i];
                            Type[] actualTypeArguments3 = genericParameterType.getActualTypeArguments();
                            LogUtil.d("actualTypeArguments3 " + i + " = " + actualTypeArguments3[0]);
                        } else {
                            LogUtil.d("actualTypeArguments33 " + i + " = " + genericParameterTypes2[i]);
                            LogUtil.d("actualTypeArguments33 " + i + " = " + genericParameterTypes2[i].getClass());
                            LogUtil.d("actualTypeArguments33 " + i + " = " + genericParameterTypes2[i].getTypeName());
//                            LogUtil.d("actualTypeArguments33 " + i + " = " + (Class)genericParameterTypes[i]);
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

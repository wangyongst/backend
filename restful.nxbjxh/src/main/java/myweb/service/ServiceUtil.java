package myweb.service;

import com.framework.utils.NumberUtil;
import com.framework.utils.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by BHWL on 2016-11-30.
 */
public class ServiceUtil {

    //status说明
    //0，未选择
    //1，正常结果或对象结果
    //2，非正常结果
    //3，选择了多条记录
    //4，保存条件己存在
    //5，必须值不能为空
    //6，查询结果为空
    //7，List结果
    //9-20, 其它情况

    public static void isNotSelect(Result result) {
        result.setStatus(0);
        result.setMessage("您未选择记录，请先至少选择一条记录！");
    }

    public static void isNotOK(Result result) {
        result.setStatus(2);
        result.setMessage("操作失败，请检查您的输入，如有问题请联系管理员,电话:4006969296 ！");
    }

    public static void isMultiSelect(Result result) {
        result.setStatus(3);
        result.setMessage("本操作只可选择一条记录，您选择了多条记录！");
    }

    public static void isExist(Result result) {
        result.setStatus(4);
        result.setMessage("必须值不唯一！请重新填写表单的必须项！");
    }

    public static void isBlank(Result result) {
        result.setStatus(5);
        result.setMessage("必须值不能为空！请重新填写表单的必须项！");
    }

    public static void isZero(Result result) {
        result.setStatus(6);
        result.setMessage("没有查询到相关记录，请重试！");
    }


    public static void isListResult(Result result) {
        result.setStatus(7);
    }

    public static boolean isOnlyOneId(Result result, String id) {
        if (isIds(result, id)) {
            TreeSet<String> set = (TreeSet<String>) result.getData();
            if (set.size() < 1) {
                isNotSelect(result);
            } else if (set.size() > 1) {
                isMultiSelect(result);
            } else {
                result.setData(Integer.parseInt(set.first()));
                return true;
            }
        }
        return false;
    }


    public static boolean isBlankValue(Result result, String value) {
        if (StringUtils.isBlank(value)) {
            isBlank(result);
            return true;
        }
        return false;
    }

    public static boolean isNotUnique(Result result, int size) {
        if (size > 0) {
            isExist(result);
            return true;
        }
        return false;
    }

    public static boolean isIds(Result result, String id) {
        if (StringUtils.isBlank(id)) {
            isNotSelect(result);
        } else {
            TreeSet<String> treeSet = new TreeSet<String>(Arrays.asList(id.split(",")));
            treeSet.remove("");
            if (treeSet.size() > 0) {
                result.setData(treeSet);
                return true;
            }
        }
        return false;
    }

    public static Result isCRUDOK(String crud, Result result, int count) {
        if (crud.equals("delete")) {
            isDeleteOK(result, count);
        } else if (crud.equals("update")) {
            isUpdateOK(result, count);
        } else if (crud.equals("create")) {
            isCreateOK(result, count);
        } else {
            isNotOK(result);
        }
        return result;
    }


    public static boolean isUpdateOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您修改/更新了" + NumberUtil.formatInteger(count) + "条记录");
        } else {
            isNotOK(result);
            return false;
        }
        return true;
    }

    public static boolean isCreateOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您添加/创建了" + NumberUtil.formatInteger(count) + "条记录");
        } else {
            isNotOK(result);
            return false;
        }
        return true;
    }

    public static boolean isDeleteOK(Result result, int count) {
        if (count != 0) {
            result.setMessage("您删除了" + NumberUtil.formatInteger(count) + "条记录");
        } else {
            isNotOK(result);
            return false;
        }
        return true;
    }


    public static boolean isReseachOK(Result result, Object object) {
        if (object == null) {
            isNotOK(result);
        } else {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                try {
                    if (f.getName().equals("id") && (Integer) f.get(object) != 0) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                        result.setData(object);
                        return true;
                    }
                } catch (IllegalAccessException e) {
                    isNotOK(result);
                }
            }
            isZero(result);
        }
        return false;
    }


    public static boolean isReseachListOK(Result result, List list) {
        if (list == null) {
            isNotOK(result);
        } else if (list.size() == 0) {
            isZero(result);
        } else if (list.size() == 1) {
            return isReseachOK(result, list.get(0));
        } else {
            result.setData(list);
            isListResult(result);
            return true;
        }
        return false;
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static Object copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
        return target;
    }
}

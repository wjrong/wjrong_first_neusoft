package com.wjrong.model;

/** 
 * 使用threadLocal简化API 接收页面的信息
 * 由于封装的分页类AbstractPageManager，中的方法参数offSet和pageSize必要但是每个方法都必须写 
 * 所以使用threadLocal简化 
 * @author wjrong
 * @data 2013-10-20
 */  
public class SystemContext {  
    //定义两个threadLocal变量：offSet和pageSize  
    private static ThreadLocal<Integer> offSet = new ThreadLocal<Integer>();  
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> categoryid = new ThreadLocal<Integer>();
    /* 
     * offset ：get、set、remove 
     */  
    public static int getOffSet() {  
        Integer os =offSet.get();  
        if (os == null) {  
            return 0;  
        }  
        return os;  
    }  
    public static void setOffSet(int offSetValue) {  
        offSet.set(offSetValue);  
    }  
    public static void removeOffSet(){  
        offSet.remove();  
    }   
    /* 
     * pageSize ：get、set、remove 
     */  
    public static int getPageSize() {  
        Integer ps = pageSize.get();  
        if (ps == null) {  
            return 0;  
        }  
        return ps;  
    }  
    public static void setPageSize(int pageSizeValue) {  
        pageSize.set(pageSizeValue);  
    }  
    public static void removePageSize(){  
        pageSize.remove();  
    }  
    /* 
     * categoryid ：get、set、remove 
     */  
    public static int getcategoryid() {  
        Integer os =categoryid.get();  
        if (os == null) {  
            return 0;  
        }  
        return os;  
    }  
    public static void setcategoryid(int categoryidValue) {  
    	categoryid.set(categoryidValue);  
    }  
    public static void removecategoryid(){  
        offSet.remove();  
    }
}  

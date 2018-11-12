package com.george.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: <p>BigDecimal处理工具类，对于金额的计算应用BigDecimal而不是
 * 用double，皆保留两位小数，后续可扩展其他格式</p>
 * User: GeorgeChin
 * Date: 2018-10-25
 * Time: 16:11
 */
public class BigDecimalUtils {

//    public static DecimalFormat DEC_FORMAT = new DecimalFormat("#0.00");

    /**
     * 将object对象转成BigDecimal对象，支持null和""等
     *
     * @param object 需要转换的对象
     * @return BigDecimal
     */
    public static BigDecimal toBigDecimal(Object object) {
        BigDecimal result = new BigDecimal(0);
        if (object != null) {
            if (object instanceof BigDecimal) {
                result = (BigDecimal) object;
            } else if (object instanceof String) {
                if (!"".equals(object) && !"null".equals(object)) {
                    result = new BigDecimal((String) object);
                }
            } else if (object instanceof BigInteger) {
                result = new BigDecimal((BigInteger) object);
            } else if (object instanceof Number) {
                result = new BigDecimal(((Number) object).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + object + "] from class " + object.getClass() + " into a BigDecimal.");
            }
        }
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * String格式化为BigDecimal
     *
     * @param valueStr 字符串
     * @return BigDecimal
     */
    public static BigDecimal toBigDecimal(String valueStr) {
        if (valueStr == null || "".equals(valueStr)) {
            valueStr = "0.00";
        }
        BigDecimal result = new BigDecimal(valueStr);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相加
     *
     * @param value  基础值
     * @param augend 被加数
     * @return
     */
    public static BigDecimal add(BigDecimal value, BigDecimal augend) {
        BigDecimal result = value.add(augend);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相加
     *
     * @param value     基础值
     * @param augendObj 被加数
     * @return
     */
    public static BigDecimal add(BigDecimal value, Object augendObj) {
        BigDecimal augend = toBigDecimal(augendObj);
        BigDecimal result = value.add(augend);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘
     *
     * @param value        基础值
     * @param multiplicand 被乘数
     * @return
     */
    public static BigDecimal mul(BigDecimal value, BigDecimal multiplicand) {
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘
     *
     * @param valueStr        基础值
     * @param multiplicandStr 被乘数
     * @return
     */
    public static BigDecimal mul(String valueStr, String multiplicandStr) {
        BigDecimal value = new BigDecimal(valueStr);
        BigDecimal multiplicand = new BigDecimal(multiplicandStr);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘
     *
     * @param multiplicandStr 被乘数
     * @param value           基础值
     * @return
     */
    public static BigDecimal mul(BigDecimal value, String multiplicandStr) {
        BigDecimal multiplicand = new BigDecimal(multiplicandStr);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘
     *
     * @param value           基础值
     * @param multiplicandInt 被乘数
     * @return
     */
    public static BigDecimal mul(BigDecimal value, int multiplicandInt) {
        BigDecimal multiplicand = new BigDecimal(multiplicandInt);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相乘
     *
     * @param valueObj        基础值
     * @param multiplicandObj 被乘数
     * @return
     */
    public static BigDecimal mul(Object valueObj, Object multiplicandObj) {
        BigDecimal multiplicand = toBigDecimal(multiplicandObj);
        BigDecimal value = toBigDecimal(valueObj);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相除
     * 精确小位小数
     *
     * @param value    基础值
     * @param dividend 被除数
     * @return
     */
    public static BigDecimal div(BigDecimal value, BigDecimal dividend) {
        return value.divide(dividend, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 相除
     * 精确小位小数
     *
     * @param value       基础值
     * @param dividendInt 被除数
     * @return
     */
    public static BigDecimal div(BigDecimal value, int dividendInt) {
        BigDecimal divideValue = new BigDecimal(dividendInt);
        return value.divide(divideValue, 2, BigDecimal.ROUND_HALF_UP);
    }
}

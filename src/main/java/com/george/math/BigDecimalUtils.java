package com.george.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: <p>BigDecimal�������࣬���ڽ��ļ���Ӧ��BigDecimal������
 * ��double���Ա�����λС������������չ������ʽ</p>
 * User: GeorgeChin
 * Date: 2018-10-25
 * Time: 16:11
 */
public class BigDecimalUtils {

//    public static DecimalFormat DEC_FORMAT = new DecimalFormat("#0.00");

    /**
     * ��object����ת��BigDecimal����֧��null��""��
     *
     * @param object ��Ҫת���Ķ���
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
     * String��ʽ��ΪBigDecimal
     *
     * @param valueStr �ַ���
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
     * ���
     *
     * @param value  ����ֵ
     * @param augend ������
     * @return
     */
    public static BigDecimal add(BigDecimal value, BigDecimal augend) {
        BigDecimal result = value.add(augend);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     *
     * @param value     ����ֵ
     * @param augendObj ������
     * @return
     */
    public static BigDecimal add(BigDecimal value, Object augendObj) {
        BigDecimal augend = toBigDecimal(augendObj);
        BigDecimal result = value.add(augend);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     *
     * @param value        ����ֵ
     * @param multiplicand ������
     * @return
     */
    public static BigDecimal mul(BigDecimal value, BigDecimal multiplicand) {
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     *
     * @param valueStr        ����ֵ
     * @param multiplicandStr ������
     * @return
     */
    public static BigDecimal mul(String valueStr, String multiplicandStr) {
        BigDecimal value = new BigDecimal(valueStr);
        BigDecimal multiplicand = new BigDecimal(multiplicandStr);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     *
     * @param multiplicandStr ������
     * @param value           ����ֵ
     * @return
     */
    public static BigDecimal mul(BigDecimal value, String multiplicandStr) {
        BigDecimal multiplicand = new BigDecimal(multiplicandStr);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     *
     * @param value           ����ֵ
     * @param multiplicandInt ������
     * @return
     */
    public static BigDecimal mul(BigDecimal value, int multiplicandInt) {
        BigDecimal multiplicand = new BigDecimal(multiplicandInt);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     *
     * @param valueObj        ����ֵ
     * @param multiplicandObj ������
     * @return
     */
    public static BigDecimal mul(Object valueObj, Object multiplicandObj) {
        BigDecimal multiplicand = toBigDecimal(multiplicandObj);
        BigDecimal value = toBigDecimal(valueObj);
        BigDecimal result = value.multiply(multiplicand);
        return result.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     * ��ȷСλС��
     *
     * @param value    ����ֵ
     * @param dividend ������
     * @return
     */
    public static BigDecimal div(BigDecimal value, BigDecimal dividend) {
        return value.divide(dividend, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * ���
     * ��ȷСλС��
     *
     * @param value       ����ֵ
     * @param dividendInt ������
     * @return
     */
    public static BigDecimal div(BigDecimal value, int dividendInt) {
        BigDecimal divideValue = new BigDecimal(dividendInt);
        return value.divide(divideValue, 2, BigDecimal.ROUND_HALF_UP);
    }
}

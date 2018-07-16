package com.dt.core.norm;

import com.dt.core.bean.ComparisonRule;

import java.util.Collection;

/**
 * 比较运算符
 *
 * @author 白超
 * @version 1.0
 * @since 2018/7/10
 */
public interface ComparisonOperator<T> {

    T isNull();

    T isNotNull();

    T equalToValue(Object value, ComparisonRule comparisonRule);

    default T equalTo(String value) {
        return equalToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T equalTo(Integer value) {
        return equalToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T equalTo(Long value) {
        return equalToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T equalTo(Double value) {
        return equalToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T equalTo(String value, ComparisonRule comparisonRule) {
        return equalToValue(value, comparisonRule);
    }

    default T equalTo(Integer value, ComparisonRule comparisonRule) {
        return equalToValue(value, comparisonRule);
    }

    default T equalTo(Long value, ComparisonRule comparisonRule) {
        return equalToValue(value, comparisonRule);
    }

    default T equalTo(Double value, ComparisonRule comparisonRule) {
        return equalToValue(value, comparisonRule);
    }

    T notEqualToValue(Object value, ComparisonRule comparisonRule);

    default T notEqualTo(String value) {
        return notEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T notEqualTo(Integer value) {
        return notEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T notEqualTo(Long value) {
        return notEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T notEqualTo(Double value) {
        return notEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T notEqualTo(String value, ComparisonRule comparisonRule) {
        return notEqualToValue(value, comparisonRule);
    }

    default T notEqualTo(Integer value, ComparisonRule comparisonRule) {
        return notEqualToValue(value, comparisonRule);
    }

    default T notEqualTo(Long value, ComparisonRule comparisonRule) {
        return notEqualToValue(value, comparisonRule);
    }

    default T notEqualTo(Double value, ComparisonRule comparisonRule) {
        return notEqualToValue(value, comparisonRule);
    }

    T greaterThanValue(Object value, ComparisonRule comparisonRule);

    default T greaterThan(String value) {
        return greaterThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThan(Integer value) {
        return greaterThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThan(Long value) {
        return greaterThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThan(Double value) {
        return greaterThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThan(String value, ComparisonRule comparisonRule) {
        return greaterThanValue(value, comparisonRule);
    }

    default T greaterThan(Integer value, ComparisonRule comparisonRule) {
        return greaterThanValue(value, comparisonRule);
    }

    default T greaterThan(Long value, ComparisonRule comparisonRule) {
        return greaterThanValue(value, comparisonRule);
    }

    default T greaterThan(Double value, ComparisonRule comparisonRule) {
        return greaterThanValue(value, comparisonRule);
    }

    T greaterThanAndEqualToValue(Object value, ComparisonRule comparisonRule);

    default T greaterThanAndEqualTo(String value) {
        return greaterThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThanAndEqualTo(Integer value) {
        return greaterThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThanAndEqualTo(Long value) {
        return greaterThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThanAndEqualTo(Double value) {
        return greaterThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T greaterThanAndEqualTo(String value, ComparisonRule comparisonRule) {
        return greaterThanAndEqualToValue(value, comparisonRule);
    }

    default T greaterThanAndEqualTo(Integer value, ComparisonRule comparisonRule) {
        return greaterThanAndEqualToValue(value, comparisonRule);
    }

    default T greaterThanAndEqualTo(Long value, ComparisonRule comparisonRule) {
        return greaterThanAndEqualToValue(value, comparisonRule);
    }

    default T greaterThanAndEqualTo(Double value, ComparisonRule comparisonRule) {
        return greaterThanAndEqualToValue(value, comparisonRule);
    }

    T lessThanValue(Object value, ComparisonRule comparisonRule);

    default T lessThan(String value) {
        return lessThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThan(Integer value) {
        return lessThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThan(Long value) {
        return lessThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThan(Double value) {
        return lessThanValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThan(String value, ComparisonRule comparisonRule) {
        return lessThanValue(value, comparisonRule);
    }

    default T lessThan(Integer value, ComparisonRule comparisonRule) {
        return lessThanValue(value, comparisonRule);
    }

    default T lessThan(Long value, ComparisonRule comparisonRule) {
        return lessThanValue(value, comparisonRule);
    }

    default T lessThan(Double value, ComparisonRule comparisonRule) {
        return lessThanValue(value, comparisonRule);
    }

    T lessThanAndEqualToValue(Object value, ComparisonRule comparisonRule);

    default T lessThanAndEqualTo(String value) {
        return lessThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThanAndEqualTo(Integer value) {
        return lessThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThanAndEqualTo(Long value) {
        return lessThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThanAndEqualTo(Double value) {
        return lessThanAndEqualToValue(value, ComparisonRule.NULL_SKIP);
    }

    default T lessThanAndEqualTo(String value, ComparisonRule comparisonRule) {
        return lessThanAndEqualToValue(value, comparisonRule);
    }

    default T lessThanAndEqualTo(Integer value, ComparisonRule comparisonRule) {
        return lessThanAndEqualToValue(value, comparisonRule);
    }

    default T lessThanAndEqualTo(Long value, ComparisonRule comparisonRule) {
        return lessThanAndEqualToValue(value, comparisonRule);
    }

    default T lessThanAndEqualTo(Double value, ComparisonRule comparisonRule) {
        return lessThanAndEqualToValue(value, comparisonRule);
    }

    T betweenValue(Object value, Object secondValue, ComparisonRule comparisonRule);

    default T between(String value, String secondValue) {
        return betweenValue(value, secondValue, ComparisonRule.NULL_SKIP);
    }

    default T between(Integer value, Integer secondValue) {
        return betweenValue(value, secondValue, ComparisonRule.NULL_SKIP);
    }

    default T between(Long value, Long secondValue) {
        return betweenValue(value, secondValue, ComparisonRule.NULL_SKIP);
    }

    default T between(Double value, Double secondValue) {
        return betweenValue(value, secondValue, ComparisonRule.NULL_SKIP);
    }

    default T between(String value, String secondValue, ComparisonRule comparisonRule) {
        return betweenValue(value, secondValue, comparisonRule);
    }

    default T between(Integer value, Integer secondValue, ComparisonRule comparisonRule) {
        return betweenValue(value, secondValue, comparisonRule);
    }

    default T between(Long value, Long secondValue, ComparisonRule comparisonRule) {
        return betweenValue(value, secondValue, comparisonRule);
    }

    default T between(Double value, Double secondValue, ComparisonRule comparisonRule) {
        return betweenValue(value, secondValue, comparisonRule);
    }

    T likeValue(Object value, ComparisonRule comparisonRule);

    default T like(String value) {
        return likeValue(value, ComparisonRule.NULL_SKIP);
    }

    default T like(Integer value) {
        return likeValue(value, ComparisonRule.NULL_SKIP);
    }

    default T like(Long value) {
        return likeValue(value, ComparisonRule.NULL_SKIP);
    }

    default T like(Double value) {
        return likeValue(value, ComparisonRule.NULL_SKIP);
    }

    default T like(String value, ComparisonRule comparisonRule) {
        return likeValue(value, comparisonRule);
    }

    default T like(Integer value, ComparisonRule comparisonRule) {
        return likeValue(value, comparisonRule);
    }

    default T like(Long value, ComparisonRule comparisonRule) {
        return likeValue(value, comparisonRule);
    }

    default T like(Double value, ComparisonRule comparisonRule) {
        return likeValue(value, comparisonRule);
    }

    T inValue(Object[] values, ComparisonRule comparisonRule);

    default T in(String[] values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T in(Integer[] values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T in(Long[] values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T in(Double[] values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T in(String[] values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T in(Integer[] values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T in(Long[] values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T in(Double[] values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T in(ComparisonRule comparisonRule, String... values) {
        return inValue(values, comparisonRule);
    }

    default T in(ComparisonRule comparisonRule, Integer... values) {
        return inValue(values, comparisonRule);
    }

    default T in(ComparisonRule comparisonRule, Long... values) {
        return inValue(values, comparisonRule);
    }

    default T in(ComparisonRule comparisonRule, Double... values) {
        return inValue(values, comparisonRule);
    }

    T inValue(Collection<?> values, ComparisonRule comparisonRule);

    default T inS(Collection<String> values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T inI(Collection<Integer> values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T inL(Collection<Long> values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T inD(Collection<Double> values) {
        return inValue(values, ComparisonRule.NULL_SKIP);
    }

    default T inS(Collection<String> values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T inI(Collection<Integer> values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T inL(Collection<Long> values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }

    default T inD(Collection<Double> values, ComparisonRule comparisonRule) {
        return inValue(values, comparisonRule);
    }
}

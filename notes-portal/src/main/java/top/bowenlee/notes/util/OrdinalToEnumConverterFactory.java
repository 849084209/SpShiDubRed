package top.bowenlee.notes.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

public class OrdinalToEnumConverterFactory implements ConverterFactory<String, Enum<?>> {

    @Override
    public <T extends Enum<?>> Converter<String, T> getConverter(Class<T> targetType) {
        return new OrdinalToEnum<T>(targetType);
    }

    private class OrdinalToEnum<T extends Enum<?>> implements Converter<String, T> {

        private final Class<T> enumType;

        public OrdinalToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }

        @SuppressWarnings("unchecked")
		@Override
        public T convert(String source) {
            // 转换成数字
            int ordinal = Integer.valueOf(source);
            if (ordinal == Integer.MIN_VALUE) {
                return null;
            }
            Object temp = null;
            try {
                Method getCode = enumType.getMethod("getCode");

                Object[] objects = enumType.getEnumConstants();
                for (Object ob : objects) {
                    Integer temps = (Integer) getCode.invoke(ob);
                    if (temps == ordinal) {
                        temp = ob;
                        break;
                    }

                }

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return (T) temp;
        }

    }
}
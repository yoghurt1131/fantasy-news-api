package dev.yoghurt1131.fantasynewsapi.adapter.resolver.scalar;

import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeScalar {

    public static class LocalDateTimeCoercing implements Coercing<LocalDateTime, String> {

        private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public String serialize(Object object) throws CoercingSerializeException {
            LocalDateTime localDateTime = (LocalDateTime) object;
            return localDateTime.format(formatter);
        }

        @Override
        public LocalDateTime parseValue(Object object) throws CoercingParseValueException {
            String stringObject = object.toString();
            try {
                return LocalDateTime.parse(stringObject, formatter);
            } catch (DateTimeParseException exception) {
                throw new CoercingParseValueException("LocalDateTime format is 'yyyy-MM-dd HH:mm:ss', " + exception.getMessage(), exception);
            }
        }

        @Override
        public LocalDateTime parseLiteral(Object object) throws CoercingParseLiteralException {
            String stringObject = object.toString();
            try {
                return LocalDateTime.parse(stringObject, formatter);
            } catch (DateTimeParseException exception) {
                throw new CoercingParseValueException("LocalDateTime format is 'yyyy-MM-dd HH:mm:ss', " + exception.getMessage(), exception);
            }
        }
    }
}

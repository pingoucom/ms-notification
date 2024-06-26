package com.pingou.msnotification.domain.entity.generator;

import com.pingou.msnotification.domain.id.SnowflakeGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class Snowflake implements IdentifierGenerator {
    private final SnowflakeGenerator snowflakeGenerator;

    public Snowflake(SnowflakeGenerator snowflakeGenerator) {
        this.snowflakeGenerator = snowflakeGenerator;
    }

    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return snowflakeGenerator.generate();
    }
}

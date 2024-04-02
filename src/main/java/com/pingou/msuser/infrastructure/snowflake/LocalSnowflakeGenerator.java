package com.pingou.msuser.infrastructure.snowflake;

import cn.hutool.core.lang.Snowflake;
import com.pingou.msuser.domain.id.SnowflakeGenerator;
import org.springframework.stereotype.Component;

@Component
public class LocalSnowflakeGenerator implements SnowflakeGenerator {
    private final long dataCenterId = 1l;

    private final long workerId = 1l;

    private Snowflake snowflake = new Snowflake(dataCenterId, workerId);

    public long generate() {
        return snowflake.nextId();
    }
}
